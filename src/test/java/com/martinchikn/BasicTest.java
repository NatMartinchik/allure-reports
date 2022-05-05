package com.martinchikn;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BasicTest {
    @Test
    public void issueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("NatMartinchik/restful-booker-tests");
        $(".header-search-input").submit();

        $(By.linkText("NatMartinchik/restful-booker-tests")).click();
        $(By.partialLinkText("Issues")).click();
        $(withText("#1")).should(Condition.visible);
    }

}
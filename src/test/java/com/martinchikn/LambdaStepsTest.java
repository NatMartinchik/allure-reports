package com.martinchikn;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepsTest {

        private static final String REPOSITORY = "NatMartinchik/restful-booker-tests";
        private static final int ISSUE_NUMBER = 1;
        @Test
        public void testLambdaSteps() {

                step("Open the home page", () -> {
                        open("https://github.com");
                });
                step("Search for " + REPOSITORY + " repository",() -> {
                        $(".header-search-input").click();
                        $(".header-search-input").sendKeys(REPOSITORY);
                        $(".header-search-input").submit();
                } );

                step("Open the " + REPOSITORY + " repository", ()->{
                        $(By.linkText("NatMartinchik/restful-booker-tests")).click();
                });
                step("Click on Issue tab", () -> {
                        $(By.partialLinkText("Issues")).click();

                });
                step("Checking for Issue No." + ISSUE_NUMBER, () ->{
                        $(withText("#1")).should(Condition.visible);
                        Allure.getLifecycle().addAttachment(
                                "Исходники страницы",
                                "text/html",
                                "html",
                                WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8)
                        );
                });

        }


}
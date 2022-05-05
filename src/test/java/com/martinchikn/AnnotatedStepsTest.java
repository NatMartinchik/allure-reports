package com.martinchikn;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class AnnotatedStepsTest {

    public static final String REPOSITORY = "NatMartinchik/restful-booker-tests";
    public static final int ISSUE_NUMBER = 1;

    @Owner("NatMartinchik")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Tabs test")
    @Story("Issue tab check")

    @Test
    @DisplayName("Test with @Step annotations")
    public void testGithubIssue() {

        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openHomePage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.checkIssueNumber(ISSUE_NUMBER);

    }
}

package com.martinchikn;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class WebSteps {


        @Step("Open the home page")
        public void openHomePage() {

            open("https://github.com");
        }

        @Step("Search for {repository} repository")
        public void searchForRepository(String repository) {

            $(".header-search-input").click();
            $(".header-search-input").setValue(repository).pressEnter();
        }

        @Step("Open the {repository} repository")
        public void clickOnRepositoryLink(String repository) {

            $(By.linkText(repository)).click();
        }

        @Step("Click on Issue tab")
        public void openIssuesTab() {

            $(By.partialLinkText("Issues")).click();
        }

        @Step("Checking for Issue No. {number}")
        public void checkIssueNumber(int issueNumber) {
            $(withText("#" + issueNumber)).shouldBe(Condition.visible);
            attachScreenshot();
        }

        @Attachment(value = "Screenshot added", type = "image/png", fileExtension = "png")
        public byte[] attachScreenshot() {

            return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
        }

}


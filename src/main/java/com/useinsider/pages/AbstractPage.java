package com.useinsider.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static org.testng.Assert.assertEquals;

public class AbstractPage {
    public void checkPagesTitle(String titlesText) {
        assertEquals(title(), titlesText);
    }

    public static void jsClick(SelenideElement locator) {
        executeJavaScript("return arguments[0].click();", locator);
    }

    public static void waitUntilPagesIsLoaded() {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        boolean isJQuery = (boolean) js.executeScript("if (window.jQuery) { return true; } else { return false; }");

        await().atMost(15, SECONDS).pollInterval(1, SECONDS).until(() -> {
            if (js.executeScript("return document.readyState").toString().equals("complete")) {
                if (!isJQuery) {
                    return true;
                } else return (Long) js.executeScript("return jQuery.active") == 0;
            }
            return false;
        });
    }
}


package com.useinsider.core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.ScreenShooter;
import com.useinsider.utils.TestListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@Listeners({TestListener.class, ScreenShooter.class})
public class DriverBase {

    @BeforeClass(description = "Drivers initialization")
    @Parameters({"browserName"})
    public void setUp(@Optional String browserName) {
        if (browserName != null) {
            Configuration.browser = browserName;
        }
        Configuration.reportsFolder = "test-result/reports";
        Configuration.startMaximized = true;
    }

    @BeforeClass(description = "Close browser")
    public static void logout() {
        closeWebDriver();
    }
}

package com.useinsider;

import com.useinsider.core.DriverBase;
import com.useinsider.pages.ApplicationFormPage;
import com.useinsider.pages.CareerPage;
import com.useinsider.pages.HomePage;
import com.useinsider.pages.PositionPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.useinsider.core.TestData.ApplicationPage.*;
import static com.useinsider.core.TestData.CareerPage.*;
import static com.useinsider.core.TestData.General.BASE_URL;
import static com.useinsider.core.TestData.HomePage.HOME_PAGE_TITLE;
import static com.useinsider.core.TestData.PositionPage.*;
import static com.useinsider.pages.AbstractPage.waitUntilPagesIsLoaded;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckFilterAndApplicationFormTest extends DriverBase {
    @Test(description = "Open https://useinsider.com/, select “Career” and check blocks. Filter jobs and check actual jobs presence of jobs list. " +
            "Select one of the positions, check that correct position page is opened. " +
            "Click on “Apply for this job” button. Check that it is redirected on Application form page")
    public void checkFilterAndApplicationFormTest() {
        open(BASE_URL);
        HomePage homePage = new HomePage();
        homePage.checkPagesTitle(HOME_PAGE_TITLE);
        homePage.getCareerButton().shouldHave(text(CAREER_PAGE_TEXT)).click();

        CareerPage careerPage = new CareerPage();
        assertTrue(url().contains(CAREER_PAGE_TEXT.toLowerCase()));
        waitUntilPagesIsLoaded();
        careerPage.checkPagesTitle(CAREER_PAGE_TITLE);
        careerPage.checkInsiderBlocks();
        careerPage.getCareerOpportunitiesText().scrollTo();
        careerPage.getCareerOpportunitiesText().shouldBe(visible, text(CAREER_PAGE_OPPORTUNITIES));

        careerPage.selectOptionOnFilter(careerPage.getLocationFilter(), CAREER_PAGE_ISTANBUL_TURKEY);
        careerPage.selectOptionOnFilter(careerPage.getDepartmentFilter(), CAREER_PAGE_QUALITY_ASSURANCE);
        careerPage.checkJobsList(careerPage.getPositionsList(), CAREER_PAGE_QUALITY_ASSURANCE);
        careerPage.checkJobsList(careerPage.getDepartmentsList(), CAREER_PAGE_QUALITY_ASSURANCE);
        careerPage.checkJobsList(careerPage.getLocationsList(), CAREER_PAGE_ISTANBUL_TURKEY);
        String positionText = careerPage.getPositionsList().stream().findFirst().get().getText();
        careerPage.getPositionsList().stream().findFirst().get().click();

        PositionPage positionPage = new PositionPage();
        positionPage.checkPagesTitle(POSITION_PAGE_TITLE);
        assertTrue(positionPage.getApplyForThisJobButtons().stream().allMatch(el -> el.getText().equals(POSITION_PAGE_APPLY_THIS_JOB_BUTTON)));
        positionPage.getPositionsText().shouldHave(text(positionText)).shouldBe(visible);
        positionPage.getJobsDescriptionBlock().shouldBe(visible).shouldNotBe(empty);
        positionPage.getRequirementsBlock().scrollTo().shouldBe(visible).shouldNotBe(empty);
        assertEquals(positionPage.getRequirementsBlock().parent().find("h3").getText(), POSITION_PAGE_REQUIREMENTS);
        positionPage.getRequirementsBlock().parent().find("ul").parent().find("ul").parent().findAll("li").shouldHave(sizeGreaterThan(3));
        positionPage.clickApplyForThisJobButton();

        ApplicationFormPage applicationFormPage = new ApplicationFormPage();
        applicationFormPage.checkPagesTitle(APPLICATION_FORM_PAGE_TITLE);
        assertEquals(applicationFormPage.getLocation().getText(), APPLICATION_FORM_PAGE_ISTANBUL_TURKEY.toUpperCase() + " /");
        assertEquals(applicationFormPage.getPosition().getText(), APPLICATION_FORM_PAGE_QUALITY_ASSURANCE.toUpperCase() + " /");
    }
}

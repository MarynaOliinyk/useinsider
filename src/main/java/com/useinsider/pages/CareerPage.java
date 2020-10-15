package com.useinsider.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertTrue;

@Getter
public class CareerPage extends AbstractPage {
    private SelenideElement title = $(byTitle("Insider - Growth Management Platform for Digital Marketers")),
            careerOpportunitiesText = $(byText("CAREER OPPORTUNITIES")),
            locationFilter = $(byClassName("jobs-locations")),
            departmentFilter = $(byClassName("jobs-teams"));

    private ElementsCollection listOfBlocks = $$x("//div[1]/h4/a"),
            positionsList = $$(byClassName("job-title")),
            departmentsList = $$x("//span[2][@class='tag']"),
            locationsList = $$x("//span[3][@class='tag']"),
            departmentFilterValues = $$x("//div[2]/select/option"),
            locationFilterValues = $$x("//div[3]/select/option");


    public void checkInsiderBlocks() {
        assertTrue(listOfBlocks.stream().allMatch(SelenideElement::isDisplayed));
        assertTrue(listOfBlocks.stream().allMatch(el -> el.getText().equals("CULTURE")
                || el.getText().equals("LOCATIONS")
                || el.getText().equals("TEAMS")
                || el.getText().equals("JOBS")
                || el.getText().equals("LIFE AT INSIDER")));
    }

    public void selectOptionOnFilter(SelenideElement filter, String value) {
        Select select = new Select(filter);
        filter.click();
        waitUntilPagesIsLoaded();
        select.selectByVisibleText(value);
        waitUntilPagesIsLoaded();
    }

    public void checkJobsList(ElementsCollection elementsList, String text) {
        assertTrue(elementsList.stream().allMatch(element -> element.getText().contains(text)));
    }
}

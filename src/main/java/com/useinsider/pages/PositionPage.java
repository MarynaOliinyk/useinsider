package com.useinsider.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class PositionPage extends AbstractPage {
    private SelenideElement positionsText = $x("//div[@class='posting-headline']/h2"),
            jobsDescriptionBlock = $x("//div[1][@class='section page-centered']/div"),
            requirementsBlock = $x("//div[3][@class='section page-centered']/div");
    private ElementsCollection applyForThisJobButtons = $$x("//a[contains(@class,'postings-btn')]");

    public void clickApplyForThisJobButton() {
        SelenideElement element = applyForThisJobButtons.shouldHaveSize(2).stream().findFirst().get().scrollTo();
        jsClick(element);
    }
}

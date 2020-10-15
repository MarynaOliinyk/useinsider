package com.useinsider.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class HomePage extends AbstractPage {
    private SelenideElement textOnHomePage = $x("//h2[contains(text(),'We help marketers')]"),
            careerButton = $x("//li[@id='menu-item-21643']/a/span");
}

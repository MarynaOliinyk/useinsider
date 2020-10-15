package com.useinsider.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class ApplicationFormPage extends AbstractPage{
    private SelenideElement location = $x("//div[@class='posting-categories']/div[1]"),
            position = $x("//div[1][@class='posting-categories']/div[2]");
}

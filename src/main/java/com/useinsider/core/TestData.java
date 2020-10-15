package com.useinsider.core;

import static com.useinsider.utils.PropertiesCache.getProperty;

public class TestData {

    public static class General {
        public static final String BASE_URL = getProperty("base.url");
    }

    public static class HomePage {
        public static final String HOME_PAGE_TITLE = getProperty("home.page.title");
    }

    public static class CareerPage {
        public static final String CAREER_PAGE_TEXT = getProperty("career.page.text"),
                CAREER_PAGE_TITLE = getProperty("career.page.title"),
                CAREER_PAGE_OPPORTUNITIES = getProperty("career.page.opportunities"),
                CAREER_PAGE_ISTANBUL_TURKEY = getProperty("career.page.istanbul.turkey"),
                CAREER_PAGE_QUALITY_ASSURANCE = getProperty("career.page.quality.assurance");
    }

    public static class PositionPage {
        public static final String POSITION_PAGE_TITLE = getProperty("position.page.title"),
                POSITION_PAGE_APPLY_THIS_JOB_BUTTON = getProperty("position.page.apply.this.job.button"),
                POSITION_PAGE_REQUIREMENTS = getProperty("position.page.requirements");
    }

    public static class ApplicationPage {
        public static final String APPLICATION_FORM_PAGE_TITLE = getProperty("application.form.page.title"),
                APPLICATION_FORM_PAGE_ISTANBUL_TURKEY = getProperty("career.page.istanbul.turkey"),
                APPLICATION_FORM_PAGE_QUALITY_ASSURANCE = getProperty("career.page.quality.assurance");
    }
}
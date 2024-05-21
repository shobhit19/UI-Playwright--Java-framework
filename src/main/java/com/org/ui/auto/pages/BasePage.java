package com.org.ui.auto.pages;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public  class BasePage {


    protected static void enterText(Page page, String locator, String text) {

        page.locator(locator).type(text);
    }

    protected static void enterText(Locator locator, String text) {
        locator.type(text);
    }

    protected static void doClick(Page page, String locator) {
        page.locator(locator).click();
    }

    protected static void doClick(Locator locator) {
        locator.click();
    }

    protected static String getText(Page page, String locator) {
        return page.locator(locator).textContent();
    }

    public static String getPageTitle(Page page) {
        return page.title();
    }
    public static void moveTo(Page page, String locator) {
        page.hover(locator);
        doClick(page, locator);
    }
}

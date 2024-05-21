package com.org.ui.auto.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage extends BasePage {

    private Page page;
    private final Locator txtSearch;

    private static String txtSearched = "//h1";
    private static String imgBtn = "//button[contains(@class,'btn btn-default')]";
    public HomePage(Page page){
        this.page=page;
        this.txtSearch = page.getByPlaceholder("Search");
    }


    public String getHomePageTitle(Page page){
       return page.title();
    }

    public void clickOnSearchSection(){
        doClick(this.txtSearch);
    }
    public void enterTextInSearchSection(String text){
        enterText(this.txtSearch,text);
    }
    public String getSearchedText(Page page){
        return getText(this.page,txtSearched);
    }
    public void clickOnSearchIcon(Page page){
        moveTo(page,imgBtn);
    }

}

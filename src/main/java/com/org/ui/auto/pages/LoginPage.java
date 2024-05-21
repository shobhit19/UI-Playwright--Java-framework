package com.org.ui.auto.pages;

import com.microsoft.playwright.Page;

public final class LoginPage extends BasePage {
    private Page page;
    public LoginPage(Page page){
        this.page=page;
    }
    private static String txtUsername = "input[name='email']";
    private static String txtPassword = "input[name='password']";
    private static String btnLogin = "input[type='submit']";
    private static String txtErrMsg = "//div[text()=' Warning: No match for E-Mail Address and/or Password.']";

    public  void enterCredentials(String username,String password){
        enterText(this.page,txtUsername,username);
        enterText(this.page,txtPassword,password);
    }
    public HomePage clickOnLogin(){
        doClick(this.page,btnLogin);
        return new HomePage(this.page);
    }
    public String getErrorMessage(){
        return getText(this.page,txtErrMsg);
    }




}

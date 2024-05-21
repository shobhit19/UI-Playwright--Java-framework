package com.org.ui.auto.drivermanager;

import com.microsoft.playwright.*;
import com.org.ui.auto.enums.ConfigProperties;
import com.org.ui.auto.exceptions.InvalidBrowserInvocationException;
import com.org.ui.auto.utils.PropertyUtil;

import java.util.Objects;


public final class PlaywrightDriverFactory {

    Browser browser;

     BrowserContext browserContext;
     Page page;



    public  Page initLaunchOptions(){

        String browserName = PropertyUtil.getValue(ConfigProperties.BROWSER);
        boolean mode = Boolean.parseBoolean(PropertyUtil.getValue(ConfigProperties.HEADLESS));

//         String browserNameRuntime = System.getProperty("env");
//         String isheadless = System.getProperty("headless");


        switch(browserName.toLowerCase()){
            case "chrome":
                browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setChannel(browserName.toLowerCase()).setHeadless(mode));
                break;
            case "edge":
                browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setChannel(browserName.toLowerCase()).setHeadless(mode));
                break;
            default:
                System.out.println("please provide a valid browser");
                break;
        }
        if(Objects.isNull(browserName)){
            throw new InvalidBrowserInvocationException("**** Could not launch browser for type "+browserName);
        }

        browserContext=browser.newContext();
        page = browserContext.newPage();
        PlaywrightThreadLocalPage.setPage(page);
        PlaywrightThreadLocalContext.setContext(browserContext);
        return page;

    }


}



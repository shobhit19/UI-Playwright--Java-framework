package com.org.ui.auto.hooks;

import com.microsoft.playwright.Page;
import com.org.ui.auto.drivermanager.PlaywrightThreadLocalContext;
import com.org.ui.auto.enums.ConfigProperties;
import com.org.ui.auto.utils.PropertyUtil;
import com.org.ui.auto.drivermanager.PlaywrightDriverFactory;
import com.org.ui.auto.drivermanager.PlaywrightThreadLocalPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks {

    private Page page;

    @Before
    public void launchUrl(){
        page = new PlaywrightDriverFactory().initLaunchOptions();
        page.navigate(PropertyUtil.getValue(ConfigProperties.URL));
    }
    @After(order=0)
    public void quitBrowser(){
        PlaywrightThreadLocalContext.unloadContext();
        PlaywrightThreadLocalPage.unloadPage();
        page.close();
    }
    @After(order=1)
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            String screenshotName = scenario.getName().replaceAll(" ","_");
            byte[] sourcePath = page.screenshot();
            scenario.attach(sourcePath,"image/png",screenshotName);

        }
    }


}

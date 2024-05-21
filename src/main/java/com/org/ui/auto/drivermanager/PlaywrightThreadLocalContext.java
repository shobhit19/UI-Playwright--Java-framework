package com.org.ui.auto.drivermanager;

import com.microsoft.playwright.BrowserContext;

public class PlaywrightThreadLocalContext {

    private static ThreadLocal<BrowserContext> threadLocalContext = new ThreadLocal<>();

    public static BrowserContext getContext(){
        return threadLocalContext.get();
    }
    public static void setContext(BrowserContext context){
        threadLocalContext.set(context);
    }
    public static void unloadContext(){
        threadLocalContext.remove();
    }
}

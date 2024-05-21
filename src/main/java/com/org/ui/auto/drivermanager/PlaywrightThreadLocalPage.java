package com.org.ui.auto.drivermanager;

import com.microsoft.playwright.Page;

public final class PlaywrightThreadLocalPage {

    private PlaywrightThreadLocalPage(){}

    private static  ThreadLocal<Page> threadLocalPage = new ThreadLocal<>();

    public static Page getPage(){
        return threadLocalPage.get();
    }
    public static void setPage(Page page){
        threadLocalPage.set(page);
    }
    public static void unloadPage(){
        threadLocalPage.remove();
    }
}

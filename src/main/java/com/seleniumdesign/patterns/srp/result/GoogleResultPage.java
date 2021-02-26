package com.seleniumdesign.patterns.srp.result;

import com.seleniumdesign.patterns.srp.main.GoogleMainPage;
import com.seleniumdesign.patterns.srp.common.SearchSuggestion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleResultPage {
    private WebDriver driver;
    private GoogleMainPage.SearchWidget searchWidget;
    private SearchSuggestion searchSuggestion;
    private NavigationBar navigationBar;
    private ResultStat resultStat;

    public GoogleResultPage(WebDriver driver){
        this.driver=driver;
        this.searchWidget= PageFactory.initElements(driver, GoogleMainPage.SearchWidget.class);
        this.searchSuggestion=PageFactory.initElements(driver,SearchSuggestion.class);
        this.navigationBar=PageFactory.initElements(driver,NavigationBar.class);
        this.resultStat=PageFactory.initElements(driver,ResultStat.class);
    }
    public GoogleMainPage.SearchWidget getSearchWidget() {
        return searchWidget;
    }

    public SearchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }

    public NavigationBar getNavigationBar() {
        return navigationBar;
    }

    public ResultStat getResultStat() {
        return resultStat;
    }
}

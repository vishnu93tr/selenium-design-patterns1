package com.seleniumdesign.patterns.srp.main;

import com.google.common.util.concurrent.Uninterruptibles;
import com.seleniumdesign.patterns.srp.common.AbstractComponent;
import com.seleniumdesign.patterns.srp.common.SearchSuggestion;
import com.seleniumdesign.patterns.srp.common.SearchWidget;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class GoogleMainPage {
    private WebDriver driver;
    private SearchWidget searchWidget;
    private SearchSuggestion searchSuggestion;
    public GoogleMainPage(WebDriver driver){
        this.driver=driver;
        this.searchWidget= PageFactory.initElements(driver,SearchWidget.class);
        this.searchSuggestion=PageFactory.initElements(driver,SearchSuggestion.class);
    }
    public void goTo(){
        this.driver.get("https://www.google.com");
    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }

    public SearchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }


}

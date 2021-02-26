package com.seleniumdesign.patterns.srp.common;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class SearchWidget extends AbstractComponent{
    @FindBy(name = "q")
    private WebElement searchBox;

    public SearchWidget(final WebDriver driver) {
        super(driver);
    }
    public void enter(String word){
        this.searchBox.clear();
        for(char ch:word.toCharArray()){
            Uninterruptibles.sleepUninterruptibly(2, TimeUnit.MILLISECONDS);
            this.searchBox.sendKeys(ch+"");
        }
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until(driver -> this.searchBox.isDisplayed());
    }
}

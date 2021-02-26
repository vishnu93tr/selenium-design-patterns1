package com.seleniumdesign.patterns.test.srp;


import com.seleniumdesign.patterns.srp.main.GoogleMainPage;
import com.seleniumdesign.patterns.srp.result.GoogleResultPage;
import com.seleniumdesign.patterns.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

    private GoogleMainPage googleMainPage;
    private GoogleResultPage googleResultPage;

    @BeforeTest
    public void setupPages(){
        this.googleMainPage=new GoogleMainPage(driver);
        this.googleResultPage=new GoogleResultPage(driver);
    }
    @Test(dataProvider = "getData")
    public void googleWorkFlow(String keyword,int index){

        googleMainPage.goTo();
        Assert.assertTrue(googleMainPage.getSearchWidget().isDisplayed());

        googleMainPage.getSearchWidget().enter(keyword);
        Assert.assertTrue(googleMainPage.getSearchSuggestion().isDisplayed());

        googleMainPage.getSearchSuggestion().clickSuggestionByIndex(index);
        Assert.assertTrue(googleResultPage.getNavigationBar().isDisplayed());

        googleResultPage.getNavigationBar().goToNews();
        System.out.println(googleResultPage.getResultStat().getStat());
    }
    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {"selenium",3},
                {"docker",5}
        };
    }
}

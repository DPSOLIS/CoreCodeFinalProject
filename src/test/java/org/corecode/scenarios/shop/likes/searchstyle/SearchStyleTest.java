package org.corecode.scenarios.shop.likes.searchstyle;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchStyleTest {

    private SearchStylePage searchStylePage;

    @BeforeClass(alwaysRun = true)
    @Parameters({"BrowserType"})
    public void setup(String browserType){
        searchStylePage = new SearchStylePage(browserType);
        searchStylePage.visitPage();
    }

    @Test(priority = 1)
    public void searchWorkTest() throws InterruptedException {
        searchStylePage.startStyleQuiz();

        Thread.sleep(3000);
        Assert.assertTrue(searchStylePage.ensureSearchWorkTest());
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser(){
        this.searchStylePage.ensureCloseBrowser();
    }
}

package org.corecode.scenarios.index;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class IndexTest {
    private IndexPage indexPage;

    @BeforeClass(alwaysRun = true)
    @Parameters({"BrowserType"})
    public void setup(String browserType){
        this.indexPage = new IndexPage(browserType);
        this.indexPage.visitPage();
    }

    @Test(priority = 1)
    public void loadWelcomePageCardTest(){
        Assert.assertTrue(indexPage.ensureLoadWelcomePageCard());
    }

    @Test(priority = 2)
    public void displayedButtonStartStyleQuizTest(){
        Assert.assertTrue(indexPage.isDisplayedButtonStartStyleQuiz());
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser(){
        indexPage.ensureCloseBrowser();
    }
}

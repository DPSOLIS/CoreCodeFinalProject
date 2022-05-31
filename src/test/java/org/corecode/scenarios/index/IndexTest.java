package org.corecode.scenarios.index;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class IndexTest {
    private IndexPage indexPage;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        this.indexPage = new IndexPage();
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

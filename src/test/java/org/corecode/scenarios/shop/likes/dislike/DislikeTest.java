package org.corecode.scenarios.shop.likes.dislike;

import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class DislikeTest {

    private DislikePage dislikePage;

    @BeforeClass(alwaysRun = true)
    @Parameters({"BrowserType"})
    public void setup(String browserType){
        dislikePage = new DislikePage(browserType);
        dislikePage.visitPage();
    }

    @Test(priority = 1)
    public void runButtonDislike() throws InterruptedException {
        dislikePage.startStyleQuiz();
        Thread.sleep(2000);

        Assert.assertTrue(dislikePage.ensureWorkingDislike());
    }

    @Test(priority = 2)
    public void runButtonClearlikes() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(dislikePage.ensureWorkingClearLikes());
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser(){
        this.dislikePage.ensureCloseBrowser();
    }
}

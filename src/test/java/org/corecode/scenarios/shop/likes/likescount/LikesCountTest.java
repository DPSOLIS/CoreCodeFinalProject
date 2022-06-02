package org.corecode.scenarios.shop.likes.likescount;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LikesCountTest {

    private LikesCountPage likesCountPage;

    @BeforeClass(alwaysRun = true)
    @Parameters({"BrowserType"})
    public void setup(String browserType){
        this.likesCountPage = new LikesCountPage(browserType);
        this.likesCountPage.visitPage();
    }

    @Test(priority = 1)
    public void incrementItemsOfMyLikesTest() throws InterruptedException {
        this.likesCountPage.startStyleQuiz();

        Thread.sleep(2000);
        Assert.assertTrue(this.likesCountPage.ensureIncrementItemsOfMyLikes());
    }
    @Test(priority = 2)
    public void matchQuantityOfItemsWithLikesTest() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(this.likesCountPage.ensureMatchQuantityOfItemsWithLikes());
    }
    @AfterClass(alwaysRun = true)
    public void closeBrowser(){
        this.likesCountPage.ensureCloseBrowser();
    }
}

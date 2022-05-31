package org.corecode.scenarios.shop.likes.likescount;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class LikesCountTest {

    private LikesCountPage likesCountPage;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        this.likesCountPage = new LikesCountPage();
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

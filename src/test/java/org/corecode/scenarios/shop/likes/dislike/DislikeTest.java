package org.corecode.scenarios.shop.likes.dislike;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DislikeTest {

    private DislikePage dislikePage;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        dislikePage = new DislikePage();
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
        //Verificar funcionamiento del boton clearlike (with option undo)
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser(){
        this.dislikePage.ensureCloseBrowser();
    }
}

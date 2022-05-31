package org.corecode.scenarios.index;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class IndexTest {
    private IndexPage indexPage;

    @BeforeMethod(alwaysRun = true)
    public void setup(Method method){
        this.indexPage = new IndexPage(method);
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

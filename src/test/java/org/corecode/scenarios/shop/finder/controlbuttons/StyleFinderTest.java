package org.corecode.scenarios.shop.finder.controlbuttons;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class StyleFinderTest {
    private StyleFinderPage styleFinderPage;

    @BeforeMethod(alwaysRun = true)
    public void setup(Method method){
        this.styleFinderPage = new StyleFinderPage(method);
        this.styleFinderPage.visitPage();
    }

    @Test(priority = 1)
    public void changeRoomStyleOnLike() throws InterruptedException {
        styleFinderPage.startStyleQuiz();
        Thread.sleep(2000);
        Assert.assertFalse(styleFinderPage.ensureChangeRoomStyleOnLike());
    }

    @Test(priority = 2)
    public void changeRoomStyleOnDislike() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertFalse(styleFinderPage.ensureChangeRoomStyleOnDislike());
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser(){
        styleFinderPage.ensureCloseBrowser();
    }
}

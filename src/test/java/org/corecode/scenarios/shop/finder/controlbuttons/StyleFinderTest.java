package org.corecode.scenarios.shop.finder.controlbuttons;

import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class StyleFinderTest {
    private StyleFinderPage styleFinderPage;

    @BeforeClass(alwaysRun = true)
    @Parameters({"BrowserType"})
    public void setup(String browserType){
        this.styleFinderPage = new StyleFinderPage(browserType);
        this.styleFinderPage.visitPage();
    }

    @Test(priority = 1)
    public void changeRoomStyleOnLike() throws InterruptedException {
        styleFinderPage.startStyleQuiz();
        Thread.sleep(3000);
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

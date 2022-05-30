package org.corecode.scenarios.shop.finder.controlbuttons;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StyleFinderTest {
    private StyleFinderPage styleFinderPage;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        this.styleFinderPage = new StyleFinderPage();
        this.styleFinderPage.visitPage();
    }

    @Test(priority = 1)
    public void showRoomsTest() throws InterruptedException {
        styleFinderPage.startStyleQuiz();
        Thread.sleep(1000);
        styleFinderPage.showOptionsRooms();
        styleFinderPage.getOptionsRooms();
        styleFinderPage.showOptionsLevelGround();
        styleFinderPage.getOptionsLevelGround();

        Thread.sleep(2000);
        Assert.assertTrue(styleFinderPage.isDisplayingCatalog());
    }

    @Test(priority = 2)
    public void changeRoomStyleOnLike() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertFalse(styleFinderPage.ensureChangeRoomStyleOnLike());
    }

    @Test(priority = 3)
    public void changeRoomStyleOnDislike() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertFalse(styleFinderPage.ensureChangeRoomStyleOnDislike());
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser(){
        styleFinderPage.ensureCloseBrowser();
    }
}

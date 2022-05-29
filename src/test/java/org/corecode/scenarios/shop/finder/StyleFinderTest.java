package org.corecode.scenarios.shop.finder;

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
    }

    //@Test(priority = 2)
   /*@AfterClass(alwaysRun = true)
    public void closeBrowser(){
        styleFinderPage.ensureCloseBrowser();
    }*/
}

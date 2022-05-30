package org.corecode.scenarios.shop.finder.loadgallery;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoadGalleryTest {

    private LoadGalleryPage loadGalleryPage;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        this.loadGalleryPage = new LoadGalleryPage();
        this.loadGalleryPage.visitPage();
    }

    @Test(priority = 1)
    public void loadGalleryPrincipalTest() throws InterruptedException {
        loadGalleryPage.startStyleQuiz();
        Thread.sleep(2000);

        Assert.assertTrue(loadGalleryPage.ensureLoadGalleryPrincipalTest());
    }

    @Test(priority = 2)
    public void loadGalleryWithFiltersTest() throws InterruptedException {
        Thread.sleep(2000);

        this.loadGalleryPage.showOptionsRooms();
        this.loadGalleryPage.getOptionsRooms();
        this.loadGalleryPage.showOptionsLevelGround();
        this.loadGalleryPage.getOptionsLevelGround();

        Thread.sleep(2000);
        Assert.assertTrue(loadGalleryPage.ensureLoadGalleryWithFiltersTest());
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser(){
        this.loadGalleryPage.ensureCloseBrowser();
    }
}

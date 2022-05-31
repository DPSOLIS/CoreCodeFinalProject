package org.corecode.scenarios.shop.finder.loadgallery;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class LoadGalleryTest {

    private LoadGalleryPage loadGalleryPage;

    @BeforeMethod(alwaysRun = true)
    public void setup(Method method){
        this.loadGalleryPage = new LoadGalleryPage(method);
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

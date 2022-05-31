package org.corecode.scenarios.shop.finder.controlbuttons;

import org.corecode.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class StyleFinderPage extends BaseTest {
    private static final String ROUTE_INDEX_RESOURCE = "/challenge/index.html";
    private static final String BUTTON_START_STYLE_QUIZ = "//button[@class='cfl740-welcome-page__card__continue-button']";
    private static final String OPTIONS_PHOTO_GRID = "//div[@class='cfl740-style-grid']";
    private static final String LIST_OF_OPTIONS_CATALOG = "div[@class='cfl740-style']";
    private static final String DIV_STYLE_IMAGE_WRAPPER = "//div[@class='cfl740-style__image-wrapper']";
    private static final String BUTTON_CLASS_STYLE_INTERACTION_BUTTON_LOVE = "//button[@class='cfl740-style__interaction-button cfl740-style__interaction-button--love']";
    private static final String BUTTON_CLASS_STYLE_INTERACTION_BUTTON_HATE = "//button[@class='cfl740-style__interaction-button cfl740-style__interaction-button--hate']";
    private static final String DIV_CLASS_STYLE_CONTROLS = "//div[@class='cfl740-style__controls']";
    private static final String DIV_CLASS_STYLE_IMAGE = "//div[@class='cfl740-style__image']";

    private List<WebElement> optionsCatalog;

    public void startStyleQuiz(){
        click(By.xpath(BUTTON_START_STYLE_QUIZ));
    }

    public boolean ensureChangeRoomStyleOnLike() throws InterruptedException {
        optionsCatalog = getWebElements();

        if(optionsCatalog == null){
            return false;
        }

        WebElement imageWrapperPrevious = getWebElementImageWrapper();
        WebElement divImage = imageWrapperPrevious.findElement(By.xpath(DIV_CLASS_STYLE_IMAGE));
        String previousImage = divImage.getAttribute("style");

        WebElement likeButton = getActionButton(imageWrapperPrevious, BUTTON_CLASS_STYLE_INTERACTION_BUTTON_LOVE);

        click(likeButton);
        Thread.sleep(2000);

        optionsCatalog = getWebElements();

        if(optionsCatalog == null){
            return  false;
        }
        WebElement imageWrapperNext = getWebElementImageWrapper();
        WebElement divImageNext = imageWrapperNext.findElement(By.xpath(DIV_CLASS_STYLE_IMAGE));
        String nextImage = divImageNext.getAttribute("style");

        return nextImage.equals(previousImage);
    }

    public boolean ensureChangeRoomStyleOnDislike() throws InterruptedException {
        optionsCatalog = getWebElements();

        if(optionsCatalog == null){
            return false;
        }

        WebElement imageWrapperPrevious = getWebElementImageWrapper();
        WebElement divImage = imageWrapperPrevious.findElement(By.xpath(DIV_CLASS_STYLE_IMAGE));
        String previousImage = divImage.getAttribute("style");

        WebElement likeButton = getActionButton(imageWrapperPrevious, BUTTON_CLASS_STYLE_INTERACTION_BUTTON_HATE);

        click(likeButton);
        Thread.sleep(2000);

        optionsCatalog = getWebElements();

        if(optionsCatalog == null){
            return  false;
        }
        WebElement imageWrapperNext = getWebElementImageWrapper();
        WebElement divImageNext = imageWrapperNext.findElement(By.xpath(DIV_CLASS_STYLE_IMAGE));
        String nextImage = divImageNext.getAttribute("style");

        return nextImage.equals(previousImage);
    }

    private WebElement getActionButton(WebElement imageWrapper, String classButton) {
        WebElement controlsButton = imageWrapper.findElement(By.xpath(DIV_CLASS_STYLE_CONTROLS));
        WebElement actionButton = controlsButton.findElement(By.xpath(classButton));
        return actionButton;
    }

    private WebElement getWebElementImageWrapper() {
        WebElement option = optionsCatalog.get(0);
        WebElement imageWrapper = option.findElement(By.xpath(DIV_STYLE_IMAGE_WRAPPER));
        return imageWrapper;
    }

    private List<WebElement> getWebElements() {
        WebElement catalog = findElement(By.xpath(OPTIONS_PHOTO_GRID));
        List<WebElement> optionsCatalog = catalog.findElements(By.xpath(LIST_OF_OPTIONS_CATALOG));
        return optionsCatalog;
    }

    public void visitPage(){
        this.visit(ROUTE_INDEX_RESOURCE);
    }

    public void ensureCloseBrowser(){
        this.tearDown();
    }
}

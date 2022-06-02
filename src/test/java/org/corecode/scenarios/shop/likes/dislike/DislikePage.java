package org.corecode.scenarios.shop.likes.dislike;

import org.corecode.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Method;
import java.util.List;

public class DislikePage extends BaseTest {

    private static final String ROUTE_INDEX_RESOURCE = "/challenge/index.html";
    private static final String LIST_BY_XPATH = "//ul[@class='cfl740-tabs']";
    private static final String OPTIONS_BY_TAGNAME = "li";
    private static final String BUTTON_START_STYLE_QUIZ = "//button[@class='cfl740-welcome-page__card__continue-button']";
    private static final String LOVED_GRID_BY_XPATH = "//div[@class='cfl740-loved-styles__grid']";
    private static final String ITEM_LOVED_GRID_BY_XPATH = "//div[@class='cfl740-loved-styles__style']";
    private static final String IMAGE_WRAPPER_BY_XPATH = "//div[@class='cfl740-loved-styles__style__image-wrapper']";
    private static final String DISLIKE_BUTTON_BY_XPATH = "//button[@class='cfl740-loved-styles__style__interaction cfl740-loved-styles__style__interaction__love']";
    private static final String STYLE_GRID_BY_XPATH = "//div[@class='cfl740-style-grid']";
    private static final String LIST_OF_OPTIONS_BY_XPATH = "//div[@class='cfl740-style']";
    private static final String DIV_STYLE_IMAGE_WRAPPER = "//div[@class='cfl740-style__image-wrapper']";
    private static final String DIV_CONTROL_BUTTON_BY_XPATH = "//div[@class='cfl740-style__controls']";
    private static final String LOVED_BUTTON_BY_XPATH = "//button[@class='cfl740-style__interaction-button cfl740-style__interaction-button--love']";
    private static final String IMAGE_LIKES_EMPTY_BY_XPATH = "//div[@class='cfl740-style-grid__no-saved']";
    private static final String EMPTY_LIKE_BY_TEXT = "Start Liking your favorite styles";
    private static final String H1_BY_TAGNAME = "h1";
    public static final String CLEARLIKES_BUTTON_BY_XPATH = "//button[@class='cfl740-loved-styles__filters__button']";

    public DislikePage() {

    }

    public void startStyleQuiz(){
        click(By.xpath(BUTTON_START_STYLE_QUIZ));
    }

    public void visitPage(){
        this.visit(ROUTE_INDEX_RESOURCE);
    }

    public boolean ensureWorkingDislike() throws InterruptedException {
        this.changeTab(0);
        this.doLikeFromImage();
        Thread.sleep(2000);

        this.changeTab(1);
        WebElement generalGrid = findElement(By.xpath(LOVED_GRID_BY_XPATH));
        List<WebElement> photoLikes = generalGrid.findElements(By.xpath(ITEM_LOVED_GRID_BY_XPATH));

        if(photoLikes == null){
            return  false;
        }

        WebElement onePhotoLike = photoLikes.get(0);
        WebElement imageWrapper = onePhotoLike.findElement(By.xpath(IMAGE_WRAPPER_BY_XPATH));
        WebElement dislikeButton = imageWrapper.findElement(By.xpath(DISLIKE_BUTTON_BY_XPATH));

        scrollPage();
        click(dislikeButton);
        Thread.sleep(2000);

        WebElement imageEmptyLike = findElement(By.xpath(IMAGE_LIKES_EMPTY_BY_XPATH));
        WebElement descriptionEmptyLike = imageEmptyLike.findElement(By.tagName(H1_BY_TAGNAME));
        String matchText = descriptionEmptyLike.getText();

        return matchText.equals(EMPTY_LIKE_BY_TEXT);
    }
    public boolean ensureWorkingClearLikes() throws InterruptedException {
        this.changeTab(0);
        this.doLikeFromImage();
        Thread.sleep(2000);

        this.changeTab(1);
        WebElement clearButton = findElement(By.xpath(CLEARLIKES_BUTTON_BY_XPATH));
        click(clearButton);

        Thread.sleep(2000);
        WebElement imageEmptyLike = findElement(By.xpath(IMAGE_LIKES_EMPTY_BY_XPATH));
        WebElement descriptionEmptyLike = imageEmptyLike.findElement(By.tagName(H1_BY_TAGNAME));
        String matchText = descriptionEmptyLike.getText();

        return matchText.equals(EMPTY_LIKE_BY_TEXT);
    }

    public void doLikeFromImage(){
        WebElement grid = findElement(By.xpath(STYLE_GRID_BY_XPATH));
        List<WebElement> options = grid.findElements(By.xpath(LIST_OF_OPTIONS_BY_XPATH));

        if(options == null){
            return;
        }

        WebElement option = options.get(0);
        WebElement imageWrapper = option.findElement(By.xpath(DIV_STYLE_IMAGE_WRAPPER));
        WebElement divControl = imageWrapper.findElement(By.xpath(DIV_CONTROL_BUTTON_BY_XPATH));
        WebElement loveButton = divControl.findElement(By.xpath(LOVED_BUTTON_BY_XPATH));
        click(loveButton);

        return;
    }

    private void changeTab(int position){
        WebElement tab = findElement(By.xpath(LIST_BY_XPATH));
        List<WebElement> options = tab.findElements(By.tagName(OPTIONS_BY_TAGNAME));

        if(options == null){
            return;
        }

        click(options.get(position));
    }

    public void ensureCloseBrowser(){
        this.tearDown();
    }
}

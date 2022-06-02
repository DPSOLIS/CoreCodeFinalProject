package org.corecode.scenarios.shop.likes.searchstyle;

import org.corecode.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchStylePage extends BaseTest {

    private static final String BUTTON_START_STYLE_QUIZ = "//button[@class='cfl740-welcome-page__card__continue-button']";
    private static final String ROUTE_INDEX_RESOURCE = "/challenge/index.html";
    private static final String LIST_BY_XPATH = "//ul[@class='cfl740-tabs']";
    private static final String OPTIONS_BY_TAGNAME = "li";
    private static final String STYLE_GRID_BY_XPATH = "//div[@class='cfl740-style-grid']";
    private static final String LIST_OF_OPTIONS_BY_XPATH = "//div[@class='cfl740-style']";
    private static final String DIV_STYLE_IMAGE_WRAPPER = "//div[@class='cfl740-style__image-wrapper']";
    private static final String DIV_CONTROL_BUTTON_BY_XPATH = "//div[@class='cfl740-style__controls']";
    private static final String LOVED_BUTTON_BY_XPATH = "//button[@class='cfl740-style__interaction-button cfl740-style__interaction-button--love']";
    private static final String LOVED_GRID_BY_XPATH = "//div[@class='cfl740-loved-styles__grid']";
    private static final String ITEM_LOVED_GRID_BY_XPATH = "//div[@class='cfl740-loved-styles__style']";
    private static final String SEARCH_BOX_BY_XPATH = "//input[@class='cfl740-input__input cfl740-input__input--icon']";
    private static final String STYLE_INFO_BY_XPATH = "//div[@class='cfl740-loved-styles__style__info']";
    public static final String STYLE_INFO_NAME_BY_XPATH = "//p[@class='cfl740-loved-styles__style__name']";

    public void startStyleQuiz(){
        click(By.xpath(BUTTON_START_STYLE_QUIZ));
    }

    public boolean ensureSearchWorkTest() throws InterruptedException {
        this.changeTab(0);
        this.doLikeFromImage();
        Thread.sleep(2000);
        this.doLikeFromImage();

        Thread.sleep(2000);
        this.changeTab(1);
        WebElement generalGrid = findElement(By.xpath(LOVED_GRID_BY_XPATH));
        List<WebElement> photoLikes = generalGrid.findElements(By.xpath(ITEM_LOVED_GRID_BY_XPATH));

        if(photoLikes == null){
            return  false;
        }

        WebElement onePhotoLike = photoLikes.get(0);
        WebElement infoWrapper = onePhotoLike.findElement(By.xpath(STYLE_INFO_BY_XPATH));
        WebElement itemName = infoWrapper.findElement(By.xpath(STYLE_INFO_NAME_BY_XPATH));

        String textItemName = itemName.getText();
        String[] dividedText = textItemName.split(" ");

        type(dividedText[0].substring(0,4),findElement(By.xpath(SEARCH_BOX_BY_XPATH)));
        Thread.sleep(2000);

        WebElement generalGridAssert = findElement(By.xpath(LOVED_GRID_BY_XPATH));
        List<WebElement> photoLikesAssert = generalGridAssert.findElements(By.xpath(ITEM_LOVED_GRID_BY_XPATH));

        if(photoLikesAssert == null){
            return  false;
        }

        return photoLikesAssert.size() > 0;
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

    public void visitPage(){
        this.visit(ROUTE_INDEX_RESOURCE);
    }

    public void ensureCloseBrowser(){
        this.tearDown();
    }
}

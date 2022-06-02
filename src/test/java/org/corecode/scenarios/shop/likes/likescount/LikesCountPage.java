package org.corecode.scenarios.shop.likes.likescount;

import org.corecode.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Method;
import java.util.List;

public class LikesCountPage extends BaseTest {
    private static final String ROUTE_INDEX_RESOURCE = "/challenge/index.html";
    private static final String BUTTON_START_STYLE_QUIZ = "//button[@class='cfl740-welcome-page__card__continue-button']";
    private static final String LIST_BY_XPATH = "//ul[@class='cfl740-tabs']";
    private static final String LIST_OF_OPTIONS_BY_XPATH = "//div[@class='cfl740-style']";
    private static final String LOVED_STYLES_GRID_BY_XPATH = "//div[@class='cfl740-loved-styles__grid']";
    private static final String LOVED_STYLES_ITEM_BY_XPATH = "//div[@class='cfl740-loved-styles__style']";
    private static final String OPTIONS_BY_TAGNAME = "li";
    private static final String STYLE_GRID_BY_XPATH = "//div[@class='cfl740-style-grid']";
    private static final String DIV_STYLE_IMAGE_WRAPPER = "//div[@class='cfl740-style__image-wrapper']";
    public static final String DIV_CONTROL_BUTTON_BY_XPATH = "//div[@class='cfl740-style__controls']";
    public static final String LOVED_BUTTON_BY_XPATH = "//button[@class='cfl740-style__interaction-button cfl740-style__interaction-button--love']";
    public static final String TITLE_OF_LIKE_BY_XPATH = "//span[@class='cfl740-tabs__tab__label']";

    public LikesCountPage(String browserType) {
        super(browserType);
    }

    public void visitPage(){
        this.visit(ROUTE_INDEX_RESOURCE);
    }

    public void startStyleQuiz(){
        click(By.xpath(BUTTON_START_STYLE_QUIZ));
    }

    public boolean ensureIncrementItemsOfMyLikes(){
        this.changeTab(1);
        int previousLovedQuantity = getQuantityLovedItems();
        this.changeTab(0);

        this.doLikeFromImage();
        this.changeTab(1);
        int nextLovedQuantity = getQuantityLovedItems();

        return (previousLovedQuantity + 1) == nextLovedQuantity;
    }

    public boolean ensureMatchQuantityOfItemsWithLikes() throws InterruptedException {
        this.changeTab(0);
        this.doLikeFromImage();

        this.changeTab(1);
        int lovedQuantity = getQuantityLovedItems();

        WebElement tab = findElement(By.xpath(LIST_BY_XPATH));
        List<WebElement> options = tab.findElements(By.tagName(OPTIONS_BY_TAGNAME));

        String textOfTitleTabLike = options.get(1).getText();
        String[] dividedText = textOfTitleTabLike.split(" ");

        return  dividedText[2].equals("("+lovedQuantity+")");
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

    private int getQuantityLovedItems() {
        try{
            WebElement lovedGrid = findElement(By.xpath(LOVED_STYLES_GRID_BY_XPATH));
            List<WebElement> lovedItems = lovedGrid.findElements(By.xpath(LOVED_STYLES_ITEM_BY_XPATH));

            if(lovedItems != null){
                return lovedItems.size();
            }

            return 0;
        }
        catch(org.openqa.selenium.NoSuchElementException e){
            return 0;
        }
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

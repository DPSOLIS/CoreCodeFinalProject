package org.corecode.scenarios.shop.finder.loadgallery;

import org.corecode.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Method;
import java.util.List;

public class LoadGalleryPage extends BaseTest {

    private static final String ROUTE_INDEX_RESOURCE = "/challenge/index.html";
    private static final String BUTTON_START_STYLE_QUIZ = "//button[@class='cfl740-welcome-page__card__continue-button']";
    public static final String PRINCIPAL_GRID_BY_XPATH = "//div[@class='cfl740-style-grid-scroll cfl740-style-grid-scroll--finder']";
    public static final String STYLE_GRID_BY_XPATH = "//div[@class='cfl740-style-grid']";
    public static final String OPTIONS_ROOMS_BY_XPATH = "div[@class='cfl740-style']";
    private static final String DROPDOWN_ROOM = "//div[@data-id='6426']";
    private static final String DROPDOWN_LEVEL_GROUND = "//div[@data-id='6427']";
    private static final String QUESTION_LIST = "div[@class='cfl740-popup cfl740-popup--no-arrow']";
    private static final String ANSWERS_LIST = "div[@class='cfl740-answer-list']";
    private static final String OPTIONS_LIST = "div[@class='cfl740-answer-item cfl740-answer-image-box cfl740-group-null']";

    public LoadGalleryPage(String browserType) {
        super(browserType);
    }

    public void startStyleQuiz(){
        click(By.xpath(BUTTON_START_STYLE_QUIZ));
    }
    public void showOptionsRooms(){
        click(By.xpath(DROPDOWN_ROOM));
    }
    public void showOptionsLevelGround(){
        click(By.xpath(DROPDOWN_LEVEL_GROUND));
    }

    public void getOptionsRooms(){
        scrollPage();
        WebElement question = findElement(By.xpath(DROPDOWN_ROOM));
        WebElement listQuestion = question.findElement(By.xpath(QUESTION_LIST));
        WebElement answerList = listQuestion.findElement(By.xpath(ANSWERS_LIST));
        List<WebElement> options = answerList.findElements(By.xpath(OPTIONS_LIST));

        if(options != null && options.size() > 0){
            click(options.get(1));
        }
    }

    public void getOptionsLevelGround(){
        WebElement question = findElement(By.xpath(DROPDOWN_LEVEL_GROUND));
        WebElement listQuestion = question.findElement(By.xpath(QUESTION_LIST));
        WebElement answerList = listQuestion.findElement(By.xpath(ANSWERS_LIST));
        List<WebElement> options = answerList.findElements(By.xpath(OPTIONS_LIST));

        if(options != null && options.size() > 0){
            click(options.get(1));
        }
        this.showOptionsLevelGround();
    }
    public boolean ensureLoadGalleryPrincipalTest(){
        WebElement principalGrid = findElement(By.xpath(PRINCIPAL_GRID_BY_XPATH));
        WebElement styleGrid = principalGrid.findElement(By.xpath(STYLE_GRID_BY_XPATH));
        List<WebElement> options = styleGrid.findElements(By.xpath(OPTIONS_ROOMS_BY_XPATH));

        if(options != null && options.size() > 0) {
            return true;
        }

        return false;
    }

    public boolean ensureLoadGalleryWithFiltersTest(){
        WebElement principalGrid = findElement(By.xpath(PRINCIPAL_GRID_BY_XPATH));
        WebElement styleGrid = principalGrid.findElement(By.xpath(STYLE_GRID_BY_XPATH));
        List<WebElement> options = styleGrid.findElements(By.xpath(OPTIONS_ROOMS_BY_XPATH));

        if(options != null && options.size() > 0) {
            return true;
        }

        return false;
    }

    public void visitPage(){
        this.visit(ROUTE_INDEX_RESOURCE);
    }

    public void ensureCloseBrowser(){
        this.tearDown();
    }
}

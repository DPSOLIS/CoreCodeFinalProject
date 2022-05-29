package org.corecode.scenarios.shop.finder;

import org.corecode.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class StyleFinderPage extends BaseTest {
    private static final String ROUTE_INDEX_RESOURCE = "/challenge/index.html";
    private static final String BUTTON_START_STYLE_QUIZ = "//button[@class='cfl740-welcome-page__card__continue-button']";
    public static final String DROPDOWN_ROOM = "//div[@data-id='6426']";
    public static final String DROPDOWN_LEVEL_GROUND = "//div[@data-id='6427']";
    public static final String QUESTION_LIST = "div[@class='cfl740-popup cfl740-popup--no-arrow']";
    public static final String ANSWERS_LIST = "div[@class='cfl740-answer-list']";
    public static final String OPTIONS_LIST = "div[@class='cfl740-answer-item cfl740-answer-image-box cfl740-group-null']";

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

        for (int i = 0; i < options.size(); i++){
            click(options.get(i));
        }
    }

    public void getOptionsLevelGround(){
        WebElement question = findElement(By.xpath(DROPDOWN_LEVEL_GROUND));
        WebElement listQuestion = question.findElement(By.xpath(QUESTION_LIST));
        WebElement answerList = listQuestion.findElement(By.xpath(ANSWERS_LIST));
        List<WebElement> options = answerList.findElements(By.xpath(OPTIONS_LIST));

        for (int i = 0; i < options.size(); i++){
            click(options.get(i));
        }
    }
    public void visitPage(){
        this.visit(ROUTE_INDEX_RESOURCE);
    }

    public void ensureCloseBrowser(){
        this.tearDown();
    }
}

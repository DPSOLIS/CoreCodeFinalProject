package org.corecode.scenarios.index;

import org.corecode.base.BaseTest;
import org.openqa.selenium.By;

import java.lang.reflect.Method;

public class IndexPage extends BaseTest {
    private static final String ROUTE_INDEX_RESOURCE = "/challenge/index.html";
    private static final String PRINCIPAL_CARD_CLASSNAME = "//div[@class='cfl740-welcome-page__card']";
    private static final String BUTTON_START_STYLE_QUIZ = "//button[@class='cfl740-welcome-page__card__continue-button']";

    public IndexPage() {}

    public boolean ensureLoadWelcomePageCard(){
        return isDisplayed(By.xpath(PRINCIPAL_CARD_CLASSNAME));
    }

    public boolean isDisplayedButtonStartStyleQuiz(){
        return isDisplayed(By.xpath(BUTTON_START_STYLE_QUIZ));
    }

    public void visitPage(){
        this.visit(ROUTE_INDEX_RESOURCE);
    }

    public void ensureCloseBrowser(){
        this.tearDown();
    }
}

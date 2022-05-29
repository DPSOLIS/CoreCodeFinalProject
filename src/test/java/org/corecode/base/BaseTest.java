package org.corecode.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BaseTest {
    private WebDriver driver;
    private JavascriptExecutor js;
    private static  final String BASE_URL_PROJECT = "https://test-sites-qa.s3.us-west-1.amazonaws.com";

    public BaseTest() {
        this.WebDriverConnection();
    }

    public void WebDriverConnection(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.js = (JavascriptExecutor) driver;
        return;
    }

    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public void type(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void click(WebElement element){
        element.click();
    }
    public boolean isDisplayed(By locator){
        try {
            return driver.findElement(locator).isDisplayed();
        }catch(org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }
    public boolean isDisplayed(By locator, String text){
        try {
            System.out.println(driver.findElement(locator).getText());
            System.out.println(text);

            return text.equals(driver.findElement(locator).getText());
        }catch(org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    public void scrollPage(){
        js.executeScript("window.scrollBy(0,350)");
    }

    public void visit(String url){
        driver.get(BASE_URL_PROJECT + url);
    }

    public void tearDown(){
        if(driver != null){
            this.driver.quit();
        }
    }
}

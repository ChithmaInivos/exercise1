package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class App {
    WebDriver driver;

    public App(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }
    public void getHomePage() {
        driver.get("https://amazon.com");
    }

    @FindBy(id = "twotabsearchtextbox")
    WebElement searchTab;

    @FindBy(id = "nav-search-submit-button")
    WebElement searchBtn;

    @FindBy(xpath = "//span[text()='Apple']")
    WebElement brandBox;

    @FindBy(id = "low-price")
    WebElement minPriceBox;

    @FindBy(id = "high-price")
    WebElement maxPriceBox;

    @FindBy(xpath = "//input[@class='a-button-input']")
    WebElement goBtn;

    @FindBy(xpath =  "//*[@id='p_n_feature_twelve_browse-bin/14674910011']/span/a/div/label/i")
    WebElement memoBox;

    @FindBy(xpath = "//*[@id='p_n_feature_nine_browse-bin/18778665011']/span/a/div/label/i")
    WebElement yearBox;

    @FindBy(xpath = "//span[text()='Apple iPhone SE (2nd Generation), US Version, 64GB, White - Unlocked (Renewed)']")
    WebElement productName;


    public void search(String keywords){
        searchTab.sendKeys(keywords);
        searchBtn.click();
    }

    public void filter() {
        minPriceBox.sendKeys("20");
        maxPriceBox.sendKeys("150");
        memoBox.click();
        yearBox.click();
    }

    public void product(){
        String productNameActual = productName.getText();
        String productNameExpected = "Apple iPhone SE (2nd Generation), US Version, 64GB, White - Unlocked (Renewed)";
        Assert.assertEquals(productNameActual,productNameExpected);
        productName.click();

        System.out.println("Hello World !");
    }

}

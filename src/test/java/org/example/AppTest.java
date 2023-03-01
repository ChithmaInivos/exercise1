package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {
    WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test() {
        App app = new App(driver);
        app.getHomePage();
        app.search("Apple iPhone SE (2nd Generation), US Version, 64GB, White - Unlocked (Renewed)");
        app.filter();
        app.product();
    }
}

package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Typostest {
    public WebDriver driver;

    @BeforeClass
    public void TyPos() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void Typos() {
        driver.get("http://the-internet.herokuapp.com/typos");
        String text = driver.findElement(By.cssSelector("div[class ='example']")).getText();
         Assert.assertEquals(text, "This example demonstrates a typo being introduced. It does it randomly on each page load.\n" +
                 "Sometimes you'll see a typo, other times you won't.");

    }
        @AfterClass
        public void endTest () {
            driver.quit();

        }
    }


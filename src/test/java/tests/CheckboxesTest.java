package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckboxesTest {
    public WebDriver driver;

    WebElement checkBox1;
    WebElement checkBox2;

    @BeforeClass
    public void CheckBoxes() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void Checkboxes() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        {
            checkBox1 = driver.findElement(By.cssSelector("[type=checkbox]:first-child"));
            checkBox2 = driver.findElement(By.cssSelector("[type=checkbox]:last-child"));
            if(!checkBox1.isSelected()){
                checkBox1.click();
            }
            if(checkBox2.isSelected()){
                checkBox2.click();
            }

            Assert.assertTrue(checkBox1.isSelected());
            Assert.assertTrue(!checkBox2.isSelected());

        }
    }
    @AfterClass
    public void endTest() {
        driver.quit();
    }
}

package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class InputsTest {
    public WebDriver driver;

    @BeforeClass
    public void Inputs() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void InputswithNumericvalues() {
        driver.get("http://the-internet.herokuapp.com/inputs");
        driver.findElement(By.xpath("//input= [@type='number']")).sendKeys("123");
        driver.findElement(By.xpath("//input= [@type='number']")).click();
        driver.findElement(By.xpath("//input= [@type='number']")).sendKeys("-1");
        String number= driver.findElement(By.xpath("//input= [@type='number']")).getAttribute("число");
        Assert.assertEquals(number,-1);
    }
    @AfterClass
    public void endTest() {
        driver.quit();
    }
}

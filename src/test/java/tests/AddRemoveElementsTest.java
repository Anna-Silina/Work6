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

public class AddRemoveElementsTest {
    public WebDriver driver;
    WebElement factual;


    @BeforeClass
    public void AddRe_move_Elements() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void AddRemoveElements() {
        driver.get("http://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Delete']")).click();
        WebElement factualOElement = driver.findElement(By.xpath("//button[text()='Delete']"));
        Assert.assertEquals(factualOElement,factual) ;
    }
    @AfterClass
    public void endTest() {
        driver.quit();
    }
}





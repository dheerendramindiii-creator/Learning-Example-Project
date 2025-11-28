package paralleltesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ParallelTest {

    WebDriver driver;

    @Test
    void logoTest() throws InterruptedException
    {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(5000);
        WebElement logo= driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[1]/img"));
        Assert.assertTrue(logo.isDisplayed());
        Thread.sleep(5000);

    }
    @Test
    void homePageTitle() throws InterruptedException
    {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
        Thread.sleep(5000);
    }
    @AfterMethod
    void tearDown()
    {
        driver.quit();
    }

}

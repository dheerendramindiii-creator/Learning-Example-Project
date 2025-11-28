package Listeners;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class ListenerTest {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @Test(priority=1)
    void logoTest() {
        WebElement logo = driver.findElement(By.xpath("//html/body/div/div/div[1]/div/div[1]/div/div[1]/img"));
        Assert.assertTrue(logo.isDisplayed());
    }
    @Test(priority=2)
    void homePageTitle(){
        String title = driver.getTitle();
        Assert.assertEquals(title, "OrangeHRM");

    }
    @Test(priority=3)
    void test1() {
        System.out.println("This is test1");
        Assert.assertEquals("A", "A");
    }

    @Test(priority=4)
    void test2() {
        System.out.println("This is test2");
        Assert.assertEquals("A", "A");
    }

    @Test(priority=5)
    void test3() {
        System.out.println("This is test3");
        throw new SkipException("This is skip exception");
    }
    @AfterClass
    void tearDown()
    {
        driver.quit();
    }

}
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.Locale;

public class HomePage {

    WebDriver driver;

    public void login(){
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();
    }

    @BeforeMethod
    public void SetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void TearDown(){
        driver.quit();
    }

    @Test
    public void TestLaunchLoginPage() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }

    @Test
    public void TestViewProductsList() throws InterruptedException {
        login();
        Thread.sleep(5000);
        Assert.assertTrue(driver.getPageSource().toLowerCase().contains("products"));
    }

    @Test
    public void TestViewProductDetails() throws InterruptedException {
        login();
        List<WebElement> productNames = driver.findElements(By.cssSelector(".inventory_item_name"));
        productNames.get(0).click();
        Thread.sleep(5000);
        Assert.assertTrue(driver.getPageSource().toLowerCase(Locale.ROOT).contains("back to products"),
                "Not as expected");
    }

}

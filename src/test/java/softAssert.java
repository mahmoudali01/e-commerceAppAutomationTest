import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softAssert {


        WebDriver driver = null;
        SoftAssert soft = new SoftAssert();
        @BeforeTest
        void openBrowser() throws InterruptedException {
            String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromePath);
            driver = new ChromeDriver();
            driver.navigate().to("https://the-internet.herokuapp.com/login");
            driver.manage().window().maximize();
            Thread.sleep(3000);

        }
        @Test
        void vaildData() throws InterruptedException {
            driver.navigate().to("https://the-internet.herokuapp.com/login");
            driver.findElement(By.id("username")).clear();
            driver.findElement(By.id("username")).sendKeys("tomsmith");
            driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
            driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
            String er ="you logged into a secure area";

            String ar = driver.findElement(By.id("flash")).getText();
            soft.assertEquals(ar.contains(er),true);
            soft.assertTrue(ar.contains(er));
            driver.findElement(By.cssSelector("a[href=\"/logout\"]"));
            soft.assertAll();
            Thread.sleep(3000);
        }
        @Test
        void invaildData() throws InterruptedException {
            driver.navigate().to("https://the-internet.herokuapp.com/login");

            driver.findElement(By.id("username")).clear();

            driver.findElement(By.id("username")).sendKeys("wrong");
            driver.findElement(By.id("password")).sendKeys("wrong!");
            driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
            String er ="Your username is invalid!";
            String ar = driver.findElement(By.id("flash")).getText();
            soft.assertEquals(ar.contains(er),true);
            soft.assertTrue(ar.contains(er));
            soft.assertAll();

            Thread.sleep(3000);
        }
        @AfterTest
        void closeDriver(){
            driver.quit();
        }



}

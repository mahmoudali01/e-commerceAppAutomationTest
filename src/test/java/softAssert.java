import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softAssert {


        WebDriver driver = null;
        SoftAssert soft = new SoftAssert();
    loginPage login;

//    public void loginSteps(String username , String password){
//        login.usernameElementPOM(driver).clear();
//        login.usernameElementPOM(driver).sendKeys(username);
//        login.passElementPOM(driver).sendKeys(password);
//        login.passElementPOM(driver).sendKeys(Keys.ENTER);
//
//    }
        @BeforeTest
        void openBrowser() throws InterruptedException {
            String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromePath);
            driver = new ChromeDriver();
            driver.navigate().to("https://the-internet.herokuapp.com/login");
            driver.manage().window().maximize();
            Thread.sleep(3000);
             login =new loginPage(driver);

        }

        @Test
        void vaildData() throws InterruptedException {
         //   driver.navigate().to("https://the-internet.herokuapp.com/login");
//            By username = By.id("username");
//            WebElement usernameEle = driver.findElement(username);
           // driver.findElement(By.id("username")).clear();
     login.loginSteps( "tomsmith", "SuperSecretPassword!");
//            driver.findElement(By.id("username")).sendKeys("tomsmith");
//            driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
//            driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
            String er ="You logged into a secure area!";

            String ar = login.flashPOM().getText();
            soft.assertEquals(ar.contains(er),true);
            soft.assertTrue(ar.contains(er));
           // driver.findElement(By.cssSelector("a[href=\"/logout\"]"));
            soft.assertAll();
            Thread.sleep(3000);
        }
        @Test
        void invaildData() throws InterruptedException {
           // driver.navigate().to("https://the-internet.herokuapp.com/login");
            login.loginSteps( "invalid", "invalid!");

//            driver.findElement(By.id("username")).clear();
//
//            driver.findElement(By.id("username")).sendKeys("wrong");
//            driver.findElement(By.id("password")).sendKeys("wrong!");
//            driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
            String er ="Your username is invalid!";
            String ar =  login.flashPOM().getText();
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

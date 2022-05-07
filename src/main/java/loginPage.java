import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
    private WebDriver driver;
    public loginPage(WebDriver driver) {
        this.driver = driver;
    }

    WebElement usernameElementPOM(){
//        By username = By.id("username");
//        WebElement usernameEle = driver.findElement(username);
//        return  usernameEle;
        return this.driver.findElement(By.id("username"));
    }
    WebElement passElementPOM(){
//        By pass = By.name("password");
//        WebElement passEle = driver.findElement(pass);
//        return  passEle;
        return this.driver.findElement(By.name("password"));
    }
    WebElement flashPOM(){
//        By flashMSG = By.id("flash");
//        WebElement flash = driver.findElement(flashMSG);
//        return  flash;
        return this.driver.findElement(By.id("flash"));
    }
    public void loginSteps(String username , String password){
        this.driver.navigate().to("https://the-internet.herokuapp.com/login");

        usernameElementPOM().clear();
        usernameElementPOM().sendKeys(username);
        passElementPOM().sendKeys(password);
        passElementPOM().sendKeys(Keys.ENTER);

    }
}

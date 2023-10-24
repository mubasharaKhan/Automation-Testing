import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

public class SwagLabTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://saucedemo.com/");

        //intializing parameterized class containing  all the strings saved in variables
        Parameterized parameter = new Parameterized();

        //testing website Title
        System.out.println("Web Title test Case:");
        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();
        if(actualTitle.equals(expectedTitle)) {
            System.out.println("Title test passed");
        }else{
            System.out.println("Title test failed");
        }

        //test cases
        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");

        WebElement userPassword = driver.findElement(By.xpath("//input[@id='password']"));
        userPassword.sendKeys("secret_sauce");

        WebElement loginBtn = driver.findElement(By.className("submit-button"));
        loginBtn.click();

        // URL test case
        System.out.println("URL test Case:");
        if (driver.getCurrentUrl().contains("inventory.html")){
            System.out.println("Login Successfull.");
        } else{
            System.out.println("Login UnSuccessfull.");
        };

        // Close the browser.
        driver.quit();
    }
}

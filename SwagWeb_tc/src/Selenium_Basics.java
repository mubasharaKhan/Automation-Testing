import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_Basics {
    public static String chromedriver = "webdriver.chrome.driver";
    public static String driverPath = "src/driver/chromedriver.exe";
    public static WebDriver driver;


    public static void waitforTime(int ms) throws Exception {
        Thread.sleep(ms);

    }

    public static void initializeWindow() {
        try {

            System.setProperty(chromedriver, driverPath);
            driver = new ChromeDriver();
            driver.manage().window().maximize();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void navigatetoURL(String URL) {
        try {
            driver.get(URL);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void assertTitle(String expectedMainTitle) {
        try {
            String actualTitle = Selenium_Basics.driver.getTitle();

            if (actualTitle.equals(expectedMainTitle)) {
                System.out.println("Test Passed" + ":\t" + expectedMainTitle);
            } else {
                System.out.println("Test Failed"+ ":\t" + expectedMainTitle);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void EnterText(String xpath, String data) {
        try {

            WebElement usernameField = driver.findElement(By.xpath(xpath));
            usernameField.sendKeys(data);
            waitforTime(500);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void clickOnElement(String xpath){
        try {

            WebElement element = driver.findElement(By.xpath(xpath));
            element.click();
            waitforTime(500);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void getElementText(String textXpath){
        try {
            WebElement element = driver.findElement(By.xpath(textXpath));
            element.getText();
            System.out.println(element.getText());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void assertionOfText(String textXpath, String expectedData) {
        try {
            WebElement pageTitle = driver.findElement(By.xpath(textXpath));
            String actualPgTitle = pageTitle.getText();

            if (actualPgTitle.equals(expectedData)) {
                System.out.println("Test Passed"+ ":\t" + actualPgTitle);
            } else {
                System.out.println("Test Failed"+ ":\t" +actualPgTitle);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

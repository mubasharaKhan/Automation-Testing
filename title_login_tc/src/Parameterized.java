import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parameterized {
    public static String url = "https://www.saucedemo.com/";
    public static String expectedTitle = "Swag Labs";

    public static String UserNameID = "user-name";
    public static String userName = "standard_user";
    public static String passWordID = "password";
    public static String userPassWord = "secret_sauce";
    public static String loginBtn = "login-button";

    public static String expectedResultPath = "//*[@id=\"header_container\"]/div[2]/span";
    public static String expectedResult = "Products";

    public static int time = 2000;
    public static WebDriver driver;

    public static void main(String[] args) {
        try{
            initiateWebBrowserSession();
            navigateToURL(url);
            verifyTitle(expectedTitle);
            enterText(UserNameID, userName);
            enterText(passWordID, userPassWord);
            clickElement(loginBtn);
            waitforTime(time);
            verifyElementExpectedText(expectedResultPath, expectedResult);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    //navigate to URL
    public static void navigateToURL(String url) throws Exception {
        try {
            driver.get(url);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Verify title
    public static void verifyTitle(String Title) throws Exception {
        try {
            String expectedTitle = "Swag Labs";
            String actualTitle = driver.getTitle();
            if (actualTitle.equals(expectedTitle)) {
                System.out.println(
                        "Title Verification Passed:\n" +
                                "Expected Title: " + expectedTitle + "\n" +
                                "Actual Title: " + actualTitle + "\n");
            } else {
                System.out.println(
                        "Title Verification Failed:\n" +
                                "Expected Title: " + expectedTitle + "\n" +
                                "Actual Title: " + actualTitle + "\n");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //enter text
    public static void enterText(String identifier, String testData) throws Exception {
        try {
            WebElement element = driver.findElement(By.id(identifier));
            element.sendKeys(testData);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    //initiate web browser session
    public static void initiateWebBrowserSession() throws Exception {
        try {
            System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //wait for time
    public static void waitforTime(int ms) throws Exception {
        Thread.sleep(ms);
    }

    public static void clickElement(String identifier) throws Exception {
        WebElement loginBtn = driver.findElement(By.className("submit-button"));
        loginBtn.click();
    }

    public static void verifyElementExpectedText(String identifier, String expextedResult) throws Exception {
        try {
            WebElement element = driver.findElement(By.xpath(identifier));
            String actualResult = element.getText();
            if (actualResult.equals(expextedResult)) {
                System.out.println(
                        "Title Verification Passed:\n" +
                                "Expected Title: " + expextedResult + "\n" +
                                "Actual Title: " + actualResult);
            } else {
                System.out.println(
                        "Title Verification Failed:\n" +
                                "Expected Title: " + expextedResult + "\n" +
                                "Actual Title: " + actualResult);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
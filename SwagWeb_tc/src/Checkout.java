import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Checkout {

    public static String CartTitle= "//div[@id='header_container']/div[2]/span";
    public static String expectedCartPage = "Your Cart";

    public static String expectedPage = "Checkout: Overview";
    public static String expectedPagexpath = "//div[@id='header_container']/div[2]/span";
    public static String checkoutButton = "//button[@id='checkout']";

    public static String expectedCheckoutInfo = "Checkout: Your Information";
    public static String expectedCheckoutInfoXpath = "//div[@id='header_container']/div[2]/span";

    public static String fnameXpath =  "//input[@id='first-name']";
    public static String fnameData =  "Mubashara";

    public static String lastnameXpath = "//input[@id='last-name']";
    public static String lastnameData = "Khan";

    public static String zipcodeXpath = "//input[@id='postal-code']";
    public static String zipcodeData = "7406";
    public static String continueButton = "//input[@id='continue']";
    public static String finishButton = "//button[@id='finish']";
    public static String msgXpath = "//div[@id='checkout_complete_container']/h2";
    public static String expectedMsg = "Thank you for your order!";
    public static String totalPrice = "//div[@id='checkout_summary_container']/div/div[2]/div[6]";


    Checkout(){
        Selenium_Basics.assertionOfText(CartTitle, expectedCartPage);
        Selenium_Basics.clickOnElement(checkoutButton);

        Selenium_Basics.assertionOfText(expectedCheckoutInfoXpath, expectedCheckoutInfo);
        Selenium_Basics.EnterText(fnameXpath, fnameData);
        Selenium_Basics.EnterText(lastnameXpath, lastnameData);
        Selenium_Basics.EnterText(zipcodeXpath, zipcodeData);
        Selenium_Basics.clickOnElement(continueButton);

        assertTotal(totalPrice, ProductListing.getSum());

        Selenium_Basics.assertionOfText(expectedPagexpath, expectedPage);
        Selenium_Basics.clickOnElement(finishButton);

        Selenium_Basics.assertionOfText(msgXpath, expectedMsg);


    }

    public static void assertTotal(String textXpath, double expectedData) {
        try {
            WebElement TotalPrice = Selenium_Basics.driver.findElement(By.xpath(textXpath));
            String actualPrice = TotalPrice.getText().substring(13);
            double actualPriceValue = Double.parseDouble(actualPrice);

            if (actualPriceValue == expectedData) {
                System.out.println("Test Passed"+ ":\t" +"Total Price: "+ expectedData);
            } else {
                System.out.println("Test Failed"+ ":\t" +"Total Price: "+expectedData);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

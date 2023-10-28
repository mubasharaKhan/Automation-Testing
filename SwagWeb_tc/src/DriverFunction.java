public class DriverFunction {
    public static String URL = "https://www.saucedemo.com";

    public static void LaunchDriver(){
        Selenium_Basics.initializeWindow();
        Selenium_Basics.navigatetoURL(URL);
    }
}

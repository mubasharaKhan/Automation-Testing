public class Login {

    public static String userxpath = "//*[@id='user-name']";
    public static String passwordxpath = "//*[@id='password']";
    public static String userName = "standard_user";
    public static String userPassword = "secret_sauce";

    public static String loginxpath = "//*[@id='login-button']";

    public static String title = "Swag Labs";


    Login(){
        Selenium_Basics.EnterText(userxpath, userName);
        Selenium_Basics.EnterText(passwordxpath, userPassword);
        Selenium_Basics.clickOnElement(loginxpath);
        Selenium_Basics.assertTitle(title);

    }
}

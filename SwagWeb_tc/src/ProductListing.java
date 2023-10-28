import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Random;

public class ProductListing{
    public static String ProductTitlexpath = "//span[@class='title']";
    public static String expectedProductTitle = "Products";
    public static String addToCartBtn1 = "//button[@id='add-to-cart-sauce-labs-backpack']";
    public static String addToCartBtn2 = "//button[@id='add-to-cart-sauce-labs-bike-light']";
    public static String addToCartBtn3 = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']";
    public static String addToCartBtn4 = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']";
    public static String addToCartBtn5 = "//button[@id='add-to-cart-sauce-labs-onesie']";
    public static String addToCartBtn6 = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']";

    public static String[] addToCartproductArray = new String[]{addToCartBtn1, addToCartBtn2, addToCartBtn3,
                                                        addToCartBtn4, addToCartBtn5, addToCartBtn6};
    public static String selectedProductName = "((//div[@class='inventory_item_name '])[%s])";
    public static int count = 0;
    public static int noOfProduct = 3;
    public static int totalNumOfProduct = 6;

    public static ArrayList<String> productArray = new ArrayList<String>();
    public static ArrayList<String> priceArray = new ArrayList<String>();

    public static String addToCartIcon = "//div[@id='shopping_cart_container']/a";
    public static String selectedProductPrice = "((//div[@class='inventory_item_price'])[%s])";
    public static String expectedQty = "3";
    public static String cartIconQuantity = "//*[@id='shopping_cart_container']/a/span";

    ProductListing(){
        Selenium_Basics.assertionOfText(ProductTitlexpath, expectedProductTitle);
        RandomProductSelection(noOfProduct, totalNumOfProduct);
        System.out.println("\nSelected Product Name List:\t"+ productArray);
        System.out.println("Selected Product Price List:\t"+ priceArray+"\n");
        CartVerification(cartIconQuantity, expectedQty);
        Selenium_Basics.clickOnElement(addToCartIcon);
        getSum();

    }

    public static double sumPriceArray(ArrayList<String> priceArray) {
        double sum = 0.0;

        for (String price : priceArray) {
            try {
                double priceValue = Double.parseDouble(price);
                sum += priceValue;
            } catch (NumberFormatException e) {
                System.err.println("Invalid price: " + price);
            }
        }

        return sum;
    }

    public static double getSum() {

        double sum = 0;
        try {
            sum = sumPriceArray(priceArray);

        } catch (Exception e) {
            System.out.println(e);
        }

        return sum;
    }

    public static void RandomProductSelection(int numOfProduct, int bound){

        Random selectItem = new Random();
        try {
            for (int i = 0; i < numOfProduct; i++) {
                int randomProduct = selectItem.nextInt(bound);
                if (count != randomProduct){

                    count = randomProduct;
                    Selenium_Basics.clickOnElement(addToCartproductArray[randomProduct]);
                    WebElement productPrice = Selenium_Basics.driver.findElement(By.xpath(String.format(selectedProductPrice,randomProduct+1)));
                    String finalPrice = productPrice.getText().substring(1);
                    priceArray.add(finalPrice);

                    WebElement productNAme = Selenium_Basics.driver.findElement(By.xpath(String.format(selectedProductName,randomProduct+1)));
                    String finalProdName = productNAme.getText();
                    productArray.add(finalProdName);

                } else if (i == 0) {
                    System.out.println("No Product left! Try Again");
                } else {
                    i--;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void CartVerification(String qtyXpath, String expectedQty ){
        try {
            WebElement pageTitle = Selenium_Basics.driver.findElement(By.xpath(qtyXpath));
            String actualPgTitle = pageTitle.getText();

            if (actualPgTitle.equals(expectedQty)) {
                System.out.println("Test Passed"+ ":\tQuantity: " + actualPgTitle);
            } else {
                System.out.println("Test Failed"+ ":\tQuantity: " + actualPgTitle);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

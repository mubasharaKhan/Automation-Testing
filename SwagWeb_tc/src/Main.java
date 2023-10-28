public class Main {
    public static void main(String[] args) {
        try {
            DriverFunction.LaunchDriver();
            new Login();
            new ProductListing();
            new Checkout();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
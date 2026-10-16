import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondTestCase {

    @Test(priority = 1)
    public void setup(){
        System.out.println("Open Browser method.");
    }

    @Test(priority = 3)
    public void searchCustomer(){
        System.out.println("Search customer method.");
        Assert.assertEquals(5,5);
    }


    @Test(priority = 2)
    public void addCustomerTest(){
        System.out.println("Add customer method.");
    }

    @Test(priority = 4)
    public void tearDown(){
        System.out.println("Close Browser method.");
    }
}

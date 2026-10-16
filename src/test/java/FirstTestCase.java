import org.testng.annotations.Test;

public class FirstTestCase {

    @Test(priority = 1)
    public void openBrowser(){
        System.out.println("This is open browser method.");
    }


    @Test(priority = 2)
    public void login(){
        System.out.println("This is login method.");
    }


    @Test(priority = 3)
    public void closeBrowser(){
        System.out.println("This is close browser method.");
    }
}

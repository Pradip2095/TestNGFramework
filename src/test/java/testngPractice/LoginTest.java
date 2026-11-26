package testngPractice;

import org.testng.annotations.Test;

public class LoginTest {


    @Test(groups = {"smoke"})
    public void validLoginTest() {
        System.out.println("Valid login test");
    }

    @Test(groups = {"regression"})
    public void invalidLoginTest() {
        System.out.println("Invalid login test");
    }
}

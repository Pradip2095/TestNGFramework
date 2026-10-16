import org.testng.annotations.*;
import org.testng.internal.annotations.IBeforeMethod;

public class TC1 {

    @BeforeTest
    void beforeTest(){
        System.out.println("this is before test");
    }

    @AfterTest
    void afterTest(){
        System.out.println("this is after test");
    }

    @BeforeClass
   void beforeClass(){
        System.out.println("this is before class");
    }

    @AfterClass
    void afterClass(){
        System.out.println("this is after class");
    }

    @BeforeMethod()
    void beforeMethod(){
        System.out.println("this is before method");
    }

    @AfterMethod()
    void afterMethod(){
        System.out.println("this is after method");
    }

    @Test
    public void test1(){
        System.out.println("this is test 1");
    }

    @Test
    public void test2(){
        System.out.println("this is test 2");
    }
}

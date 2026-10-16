import org.testng.annotations.*;

public class TC2 {

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
    public void test3(){
        System.out.println("this is test 3");
    }

    @Test
    public void test4(){
        System.out.println("this is test 4");
    }


    @BeforeSuite
    void beforeSuit(){
        System.out.println("this is before suit method");
    }

    @AfterSuite
    void afterSuit(){
        System.out.println("this is before suit method");
    }
}

import org.testng.annotations.Test;

public class PriorityTestCases {

    @Test(priority = 1)
    public void testOne(){
        System.out.println("Test One");
    }

    @Test(priority = 2)
    public void testTwo(){
        System.out.println("Test Two");
    }

    @Test(priority = 3, enabled = false)
    public void testThree(){
        System.out.println("Test Three");
    }

    @Test(priority = 4)
    public void testFour(){
        System.out.println("Test Four");
    }

}

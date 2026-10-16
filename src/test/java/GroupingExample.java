import org.testng.annotations.Test;

public class GroupingExample {

    @Test(groups = {"sanity"})
    public void test1(){
        System.out.println("test 1");
    }

    @Test(groups = {"sanity"})
    public void test2(){
        System.out.println("test 2");
    }

    @Test(groups = {"regression"})
    public void test3(){
        System.out.println("test 3");
    }

    @Test(groups = {"regression"})
    public void test4(){
        System.out.println("test 4");
    }

    @Test(groups = {"sanity", "regression"})
    public void test5(){
        System.out.println("test 5");
    }
}

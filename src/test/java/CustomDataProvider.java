import org.testng.annotations.DataProvider;

public class CustomDataProvider {
    @DataProvider(name = "ProvideLoginData")
    public Object[][] loginData() {
        Object[][] data = {{"abccompany@gmail.com", "abc"}, {"pqrcompany@gmail.com", "pqr"}, {"xyzcompany@gmail.com", "xyz"}};
        return data;
    }
}

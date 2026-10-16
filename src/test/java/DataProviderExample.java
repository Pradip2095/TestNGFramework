import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {

    @Test(dataProvider = "ProvideLoginData", dataProviderClass = CustomDataProvider.class)
    public void login(String email, String password) {
        System.out.println(email + " " + password);
    }

}

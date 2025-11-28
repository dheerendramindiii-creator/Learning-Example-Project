package paralleltesting;

import org.testng.annotations.Test;

public class DataProviderExample {

    @Test(dataProvider ="LoginDataProvider",dataProviderClass = CustomDataProvider.class)
    void loginTest(String email, String password) {
        System.out.println(email+"    "+password);

    }
}

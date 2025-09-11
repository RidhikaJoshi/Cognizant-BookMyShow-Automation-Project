package tests;

import base.DriverSetup;
import org.testng.annotations.*;
import pages.CityPage;
import pages.LoginPage;
import utils.ExcelUtils;

public class LoginTest extends DriverSetup {

    private CityPage city;
    private LoginPage login;

    @BeforeMethod
    public void setupPagesAndSelectCity() {
        // Driver is already initialized by DriverSetup's @BeforeMethod
        city = new CityPage();
        login = new LoginPage();

        // Select city before every test
        city.selectCity();
    }
    
 // DataProvider that fetches mobile + OTP from Excel
    @DataProvider(name = "loginData")
    public Object[][] getData() {
        String filePath = "resources/testdata/DataSource.xlsx";
        return ExcelUtils.getSheetData(filePath, "Login");
    }

    
    // Test that runs for every row in Excel
    @Test(dataProvider = "loginData")
    public void testLoginWithValidMobile(String mobileNumber, String otp) {
        login.validSignIn(mobileNumber, otp);
    }

    @Test
    public void testLoginWithInvalidMobile() {
        login.signInInvalid();
    }

 // Test that runs for every row in Excel
    @Test(dataProvider = "loginData")
    public void testLoginUIElements(String mobileNumber, String otp) {
        login.verifySignInUI(mobileNumber, otp);
    }
    
}

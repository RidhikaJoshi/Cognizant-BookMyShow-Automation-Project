package pages;

import base.DriverSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import base.ConfigLoader;
import locators.LocatorRepository;
import utils.WaitUtils;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage() {
        this.driver = DriverSetup.getDriver();
        PageFactory.initElements(driver, this);
        System.out.println("LoginPage initialized with WebDriver instance: " + driver.getClass().getSimpleName());
    }

    public void signInInvalid() {
        System.out.println("Starting invalid login attempt.");

        WebElement signInBtn = WaitUtils.visible(LocatorRepository.get("signInBtn"), 10);
        Assert.assertNotNull(signInBtn, "'Sign In' button not found");
        signInBtn.click();

        WebElement mobileBox = WaitUtils.visible(LocatorRepository.get("mobileNumberBox"), 10);
        Assert.assertNotNull(mobileBox, "Invalid mobile number input box not found");
        mobileBox.clear();
        mobileBox.sendKeys("1234567891");
       
        WebElement errorMsg = WaitUtils.visible(LocatorRepository.get("invalidErrorMsg"), 20);
        Assert.assertTrue(errorMsg.isDisplayed(), "No error for invalid mobile number");
        System.out.println("Error Message displayed: " + errorMsg.getText());
    }

    public boolean validSignIn(String mobileNumber, String otp) {
        System.out.println("Starting valid login attempt.");

        try {
            WebElement signInBtn = WaitUtils.visible(LocatorRepository.get("signInBtn"), 10);
            signInBtn.click();

            WebElement mobileBox = WaitUtils.visible(LocatorRepository.get("mobileNumberBox"), 10);
            Assert.assertNotNull(mobileBox, "Mobile number input box not found");
            mobileBox.clear();
            mobileBox.sendKeys(mobileNumber);

            WebElement continueBtn = WaitUtils.visible(LocatorRepository.get("continueBtn"), 10);
            continueBtn.click();

            WebElement otpfield = WaitUtils.visible(LocatorRepository.get("otp"), 10);
            otpfield.sendKeys(otp);
            
            WebElement back = WaitUtils.visible(LocatorRepository.get("backBtn"), 10);
            back.click();
            
            WebElement cross = WaitUtils.visible(LocatorRepository.get("crossBtn"), 10);
            cross.click();
            
            System.out.println("Login attempted with Mobile: " + mobileNumber + " | OTP: " + otp);
            
            System.out.println("Valid login flow executed successfully.");
            return true;
            
        } catch (Exception e) {
            System.err.println("Valid login failed: " + e.getMessage());
            return false;
        }
    }

    public void verifySignInUI(String mobileNumber, String otp) {
        System.out.println("Verifying Sign In UI elements via validSignIn() flow...");
        boolean loginSuccess = validSignIn(mobileNumber,otp);
        Assert.assertTrue(loginSuccess, "Sign In UI elements verification failed.");
        System.out.println("Sign In UI elements are functional.");
    }
}

package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.appium.java_client.AppiumDriver;
import junit.framework.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class iOSsteps {


    private AppiumDriver appiumDriver;

    @Given("^I launch iOS App$")
    public void iLaunchQuikrApp() throws Throwable {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium version", "1.7.2");
        capabilities.setCapability("app", System.getProperty("user.dir") + "/app/TestApp-iphonesimulator.app");
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "11.4");
        capabilities.setCapability("deviceName", "iPhone 7");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("clearSystemFiles", true);
        appiumDriver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        appiumDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @And("^I Choose to enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iChooseTOEnter(String num1, String num2) throws Throwable{
        appiumDriver.findElementByAccessibilityId("IntegerA").sendKeys(num1);
        appiumDriver.findElementByAccessibilityId("IntegerB").sendKeys(num2);
    }

    @And("^I tap on Compute sum$")
    public void iTapOnComputeSum() throws Throwable {
        appiumDriver.findElementByAccessibilityId("ComputeSumButton").click();
    }

    @Then("^I should see the Result \"([^\"]*)\"$")
    public void iShouldSeeTheResult(String result) throws Throwable{
        Assert.assertEquals(result,appiumDriver.findElementByAccessibilityId("Answer").getText());
    }
}





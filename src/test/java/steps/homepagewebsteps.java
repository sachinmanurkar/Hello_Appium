package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import jdk.jfr.events.ThrowablesEvent;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.Set;

public class homepagewebsteps {


    private AppiumDriver appiumDriver;


    @Given("^I launch Quikr mobile web")
    public void iLaunchQuikrApp() throws Throwable {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium version", "6.1");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "moto");
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("locationServicesAuthorized", true);
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("autoAcceptAlerts", true);
         URL url = new URL("http://0.0.0.0:4723/wd/hub");
        appiumDriver = new AppiumDriver(url, capabilities);
        appiumDriver.get("http://www.quikr.com");

    }

    @When("^Click Allow to use your device location$")
    public void clickAllowToUseDeviceLocation() throws Throwable {
        Thread.sleep(2000);
        Set<String> contextNames = appiumDriver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }
    }

    @And("^I Choose to Register$")
    public void choose_to_login_using_google_account() throws Throwable {
        Thread.sleep(5000);
        appiumDriver.findElement(By.id("menu")).click();
        Thread.sleep(5000);
        appiumDriver.findElement(By.cssSelector(".details")).click();
    }

    @Then("^I Should see an option to Register using Facebook$")
    public void iShouldseeOptionToRegisterUsingFB() throws Throwable {
        Thread.sleep(2000);
        appiumDriver.findElement(By.id("signup_tab")).click();
        Thread.sleep(3000);
        Assert.assertTrue(appiumDriver.findElement(By.className("icon-facebook")).isDisplayed());
    }
}

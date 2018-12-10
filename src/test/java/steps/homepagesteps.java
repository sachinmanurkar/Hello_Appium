package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class homepagesteps {

    private AppiumDriver appiumDriver;

    @Given("^I launch Quikr App$")
    public void iLaunchQuikrApp() throws Throwable {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium version", "6.1");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Lenovo");
        capabilities.setCapability("app", System.getProperty("user.dir") + "/app/Quikr.apk");
        capabilities.setCapability("appPackage", "com.quikr");
        capabilities.setCapability("automationName", "UiAutomator2");
        appiumDriver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        appiumDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @When("^I launch application click continue to proceed to homepage$")
    public void whenIlaunchApplicationClickContinueToProcees() throws Throwable {
        Thread.sleep(2000);
        Set<String> contextNames = appiumDriver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
            appiumDriver.findElement(By.id("android:id/button1")).click();
        }

    }

    @And("^I choose to login using Google Account$")
    public void choose_to_login_using_google_account() throws Throwable {
        appiumDriver.findElement(By.id("sign_in_button")).click();
    }

    @Then("^I see my account picker screen with email address \"(.*)\"$")
    public void iSeeMyAccountPickerWithEmailAddress(String expected) throws Throwable {
        Thread.sleep(5000);
        Assert.assertEquals("Email Id matches", expected, appiumDriver.findElement(By.id("com.google.android.gms:id/account_name")).getText());
        appiumDriver.quit();
    }

    @Then("^click on Cancel$")
    public void clickOnCancel() throws Throwable {
        Thread.sleep(2000);
        appiumDriver.findElement(By.id("android:id/button1")).click();
    }

    @Then("^Click on the SKIP link on Homepage$")
    public void clickOnHomePage() throws Throwable {
        TimeUnit.SECONDS.sleep(10);
        appiumDriver.findElement(By.id("com.quikr:id/skip")).click();
    }

    @Then("^Click allow Quikr to access the device location$")
    public void clickAllowQuickrToAllowDeviceLocation() throws Throwable {
        appiumDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        appiumDriver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
    }

    @Then("^Tap on Cars category")
    public void tapOnCarsCategory() throws Throwable {
        TimeUnit.SECONDS.sleep(5);
        List<WebElement> options = appiumDriver.findElements(By.id("com.quikr:id/content_layout"));
        System.out.println(" CLASS  Elements size " + options.size());
        WebElement element = options.stream().filter(e -> e.findElement(By.className("android.widget.TextView")).getText().contains("Cars")).findFirst().orElse(null);
        assert element != null;
        element.click();
    }

    @And("^I search for \"([^\"]*)\" under used cars$")
    public void iSearchForCarUnderUsedCars(String carName) throws Throwable {
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        appiumDriver.findElement(By.id("cnb_hp_choose_et")).click();
        appiumDriver.findElement(By.id("cnb_search_text_et")).sendKeys("Honda city");
        List<WebElement> element = appiumDriver.findElements(By.id("recentSearchtText1"));
        for (WebElement result : element) {
            if (result.getText().contains(carName)) {
                result.click();
                break;
            }
        }
        //appiumDriver.findElement(By.id("cnb_search_button")).click();
    }

    @Then("^I Should see the the first car search result with \"([^\"]*)\"$")
    public void iShouldSeeTheFirstCarResultWith(String arg0) throws Throwable{

        List<WebElement> elements = appiumDriver.findElements(By.id("com.quikr:id/cars_ad_list_title_tv"));
        Assert.assertTrue("Verified first result contains Honda", elements.get(0).getText().startsWith(arg0));
    }
}


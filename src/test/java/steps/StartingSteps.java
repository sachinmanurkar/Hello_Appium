package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.io.IOException;

public class StartingSteps {


    private AppiumDriverLocalService appiumservice;

    @Before
    public void StartAppiumServer() throws IOException {
        //Code to start appium server
//        int port= 4723;
//        appiumservice = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
//                .usingDriverExecutable(new File("/usr/local/bin/node"))
//                .withAppiumJS(new File("/usr/local/bin/appium"))
//                .withIPAddress("0.0.0.0")
//                .usingPort(port)
//                .withArgument(GeneralServerFlag.SESSION_OVERRIDE));

        appiumservice = AppiumDriverLocalService.buildService(
                new AppiumServiceBuilder()
                        .withAppiumJS(new File("/usr/local/bin/appium"))
                        .usingDriverExecutable(new File("/usr/local/bin/node"))
                        .usingPort(4723)
                        .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
        );
        appiumservice.start();
    }

    @After
    public void StopAppiumServer() {
        //Code to Stop Appium Server
        appiumservice.stop();
    }


}


package cucumber.spike;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import cucumber.annotation.After;

public class MyWebDriver extends EventFiringWebDriver {

    public MyWebDriver() throws MalformedURLException {
        super(
                System.getProperty("selenium.grid") == null
                    ? new FirefoxDriver()
                    : new RemoteWebDriver(new URL(System.getProperty("selenium.grid")), DesiredCapabilities.firefox()));
    }

    @After
    public void closeWebDriver() {
      close();
    }
    
    @Override
    public String toString() {
    	return getWrappedDriver().toString();
    }

}

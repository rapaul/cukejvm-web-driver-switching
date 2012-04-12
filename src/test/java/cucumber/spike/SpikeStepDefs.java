package cucumber.spike;

import cucumber.annotation.en.*;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;

public class SpikeStepDefs {

    private MyWebDriver webDriver;

    public SpikeStepDefs(MyWebDriver myWebDriver) {
        this.webDriver = myWebDriver;
    }

    @Given("I am running Cucumber on my local machine")
    public void localMachine() {
    	if (System.getProperty("selenium.grid") != null) {
    		throw new IllegalStateException("We are trying to test local, but selenium.grid has been set");
    	}
    }
    
    @Given("I am running Cucumber on my CI machine")
    public void ciMachine() {
    	if (System.getProperty("selenium.grid") == null) {
    		throw new IllegalStateException("We are trying to test remote, but selenium.grid has not been set");
    	}
    }
    
    @When("I run browser based tests")
    public void runTests() {
    	webDriver.navigate().to("http://www.google.com");
    }
    
    @Then("they should run with (.+)")
    public void runWith(String driverName) {
    	assertThat(webDriver.toString(), containsString(driverName));
    }



}

package se.telenor.cucumber.steps;

import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;
import se.telenor.taf.beans.WebDriverFacade;

public class WebSteps {

    @Autowired
    private WebDriverFacade webDriverFacade;

    @Given("Test facade")
    public void testFacade() {
        webDriverFacade.loadPage("https://google.com/");
    }
}

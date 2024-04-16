package se.telenor.cucumber.steps;

import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;
import se.telenor.taf.beans.WebDriverFacade;
import se.telenor.taf.util.DataHolder;

public class WebSteps {

    @Autowired
    private DataHolder dataHolder;

    @Autowired
    private WebDriverFacade webDriverFacade;

    @Given("Test facade")
    public void testFacade() {
        webDriverFacade.loadPage("https://google.com/");
    }
}

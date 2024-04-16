package se.telenor.cucumber.steps;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import org.springframework.beans.factory.annotation.Autowired;
import se.telenor.taf.util.DataHolder;

public class RestSteps {

    @Autowired
    private DataHolder dataHolder;

    @Given("Rest Step")
    public void restStep() {
        RestAssured.get("https://google.com/").prettyPrint();
    }
}

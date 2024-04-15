package se.telenor.cucumber.steps;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;

public class RestSteps {

    @Given("Rest Step")
    public void restStep() {
        RestAssured.get("https://google.com/").prettyPrint();
    }
}

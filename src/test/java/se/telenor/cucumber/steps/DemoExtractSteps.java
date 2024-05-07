package se.telenor.cucumber.steps;

import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;
import se.telenor.taf.beans.SomeClassName;
import se.telenor.taf.util.DataHolder;

public class DemoExtractSteps {

    @Autowired
    private SomeClassName someClassName;

    @Autowired
    private DataHolder dataHolder;

    @Given("I extract object {string} as SomeObject")
    public void storeObject(String alias) {
        SomeClassName someClassName = dataHolder.get(alias, SomeClassName.class);
        System.out.println(someClassName.value);
    }

    @Given("I can still extract {string} as String")
    public void storeString(String alias) {
        String s = dataHolder.get(alias, String.class);
        System.out.println(s);
    }
}

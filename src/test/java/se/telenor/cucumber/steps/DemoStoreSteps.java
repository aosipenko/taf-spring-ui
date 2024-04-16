package se.telenor.cucumber.steps;

import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;
import se.telenor.taf.beans.SomeClassName;
import se.telenor.taf.util.DataHolder;

public class DemoStoreSteps {

    @Autowired
    private DataHolder dataHolder;

    @Given("I store SomeObject as {string}")
    public void storeObject(String alias){
        SomeClassName someClassName = new SomeClassName();
        someClassName.value = "test object field";
        dataHolder.put(alias, someClassName);
    }

    @Given("I store String as {string}")
    public void storeString(String alias){
        String s = "test string";
        dataHolder.put(alias, s);
    }
}

package se.telenor.cucumber;

import io.cucumber.testng.CucumberOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import se.telenor.taf.util.DataHolder;
import se.telenor.taf.util.UserCatalog;
import se.telenor.taf.util.UserType;

@CucumberOptions(
        tags = "@mobileCancel"
)
public class CucumberMobileCancelTestRunner extends CucumberParentRunner {

    @BeforeTest
    public void checkUser(){
        Assert.assertTrue(UserCatalog.LIST.containsKey(UserType.MOBILE_SUBSCRIPTION_USER));
    }

    @AfterMethod
    public void clearHolder() {
        DataHolder.reset();
    }
}

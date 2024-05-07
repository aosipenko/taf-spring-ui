package se.telenor.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import se.telenor.taf.util.DataHolder;
import se.telenor.taf.util.UserCatalog;
import se.telenor.taf.util.UserType;

@EnableJpaRepositories("se.telenor.db")
@EnableTransactionManagement
@CucumberContextConfiguration
@ContextConfiguration(locations = "classpath*:spring/spring-context.xml")
@CucumberOptions(features = "src/test/resources/features",
        glue = "se.telenor",
        tags = "@broadbandUpdate",
        plugin = {"pretty",
                "json:target/cucumber-reports/Cucumber.json",
                "html:target/cucumber-report.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        })
public class CucumberBroadbandUpdateTestRunner extends AbstractTestNGCucumberTests {

    @BeforeTest
    public void checkUser(){
        Assert.assertTrue(UserCatalog.LIST.containsKey(UserType.BROADBAND_SUBSCRIPTION_USER));
    }

    @AfterMethod
    public void clearHolder() {
        DataHolder.reset();
    }
}

package se.telenor.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import se.telenor.taf.service.UserService;
import se.telenor.taf.util.DataHolder;
import se.telenor.taf.util.UserCatalog;
import se.telenor.taf.util.UserType;

@EnableJpaRepositories("se.telenor.db")
@EnableTransactionManagement
@CucumberContextConfiguration
@ContextConfiguration(locations = "classpath*:spring/spring-context.xml")
@CucumberOptions(features = "src/test/resources/features",
        glue = "se.telenor",
        plugin = {"pretty",
                "json:target/cucumber-reports/Cucumber.json",
                "html:target/cucumber-report.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        })
public class CucumberParentRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void setUpUsers() {
        for (UserType userType : UserType.values()) {
            try {
                UserCatalog.LIST.put(userType, UserService.setUpUser(userType));
            } catch (Exception e) {
                System.out.println("Something went wrong, skip this user");
            }
        }
    }

    @AfterMethod
    public void clearHolder() {
        DataHolder.reset();
    }

    @AfterSuite
    public void tearDown() {
        for (UserType userType : UserCatalog.LIST.keySet()) {
            UserService.clearUser(userType);
        }
    }
}

package se.telenor.taf.beans;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import se.telenor.taf.util.WebDriverFactory;

import javax.annotation.PreDestroy;
import java.time.Duration;
import java.util.List;

public class WebDriverFacade {

    private final WebDriver driver;
    private final long timeout;

    private final WebDriverWait wait;

    public WebDriverFacade(long timeout) {
        this.driver = WebDriverFactory.getDriver();
        this.timeout = timeout;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    public WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public List<WebElement> waitForElements(By locator) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    @PreDestroy
    public void quit() {
        this.driver.quit();
    }

    public void loadPage(String url) {
        driver.get(url);
    }
}

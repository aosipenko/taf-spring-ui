package se.telenor.taf.util;

import lombok.SneakyThrows;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;

public class WebDriverFactory {

    @SneakyThrows
    public static WebDriver getDriver() {
        DriverType driverType = DriverType.valueOf(System.getProperty("driver.type", "CHROME"));
        switch (driverType) {
            case EDGE:
                return new EdgeDriver(edgeOptions());
            case CHROME:
                return new ChromeDriver(chromeOptions());
            case FIREFOX:
                return new FirefoxDriver(firefoxOptions());
            case REMOTE:
                return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), remoteOptions());
            default:
                throw new RuntimeException("Unknown driver type. Please, add case for " + driverType + " to WebDriverFactory");
        }
    }

    private static EdgeOptions edgeOptions() {
        return new EdgeOptions();
    }

    private static ChromeOptions chromeOptions() {
        return new ChromeOptions();
    }

    private static FirefoxOptions firefoxOptions() {
        return new FirefoxOptions();
    }

    private static Capabilities remoteOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("enableVideo", true);
            put("enableVNC", true);
        }});
        return options;
    }
}

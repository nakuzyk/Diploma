package epam.com.patterns.design.drivers.impl;

import epam.com.patterns.design.drivers.WebDriverInvoker;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class RemoteFirefoxInvoker implements WebDriverInvoker {

    private final static String URL_NODE = "http://localhost:1234/wd/hub";

    @SneakyThrows
    public WebDriver invokeWebDriver() {
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
        desiredCapabilities.setCapability("appActivity", true);
        URL url = new URL(URL_NODE);
        return new RemoteWebDriver(url, desiredCapabilities);
    }
}
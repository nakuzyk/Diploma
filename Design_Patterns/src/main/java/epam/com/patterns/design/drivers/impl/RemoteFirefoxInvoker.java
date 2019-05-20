package epam.com.patterns.design.drivers.impl;

import epam.com.patterns.design.drivers.WebDriverInvoker;

import lombok.SneakyThrows;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class RemoteFirefoxInvoker implements WebDriverInvoker, PortFirefox {

    @SneakyThrows
    public WebDriver invokeWebDriver() {
        PortFirefox portFirefox = ConfigFactory.create(PortFirefox.class);
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
        desiredCapabilities.setCapability("appActivity", true);
        URL url = new URL(portFirefox.propertyFirefox());
        return new RemoteWebDriver(url, desiredCapabilities);
    }

    public String propertyFirefox() {
        return null;
    }
}
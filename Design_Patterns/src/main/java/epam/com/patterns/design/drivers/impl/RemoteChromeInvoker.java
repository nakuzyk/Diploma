package epam.com.patterns.design.drivers.impl;

import epam.com.patterns.design.drivers.WebDriverInvoker;

import lombok.SneakyThrows;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class RemoteChromeInvoker implements WebDriverInvoker {

    @SneakyThrows
    public WebDriver invokeWebDriver() {
        PortChrome portChrome = ConfigFactory.create(PortChrome.class);
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.setPlatform(Platform.WINDOWS);
        URL url = new URL(portChrome.propertyChrome());
        return new RemoteWebDriver(url, desiredCapabilities);
    }
}
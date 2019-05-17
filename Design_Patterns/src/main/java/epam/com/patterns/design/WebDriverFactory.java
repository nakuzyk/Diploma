package epam.com.patterns.design;

import lombok.SneakyThrows;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

    @SneakyThrows
    WebDriver newWebDriver() {
        Browsers browsers = ConfigFactory.create(Browsers.class);
        SupportedBrowsers supportedBrowsers = browsers.getBrowser();
        return supportedBrowsers.getWebDriver();
    }

}
package epam.com.patterns.design;

import epam.com.patterns.design.drivers.WebDriverInvoker;
import epam.com.patterns.design.drivers.impl.LocalChromeInvoker;
import epam.com.patterns.design.drivers.impl.RemoteChromeInvoker;
import epam.com.patterns.design.drivers.impl.RemoteFirefoxInvoker;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;

@AllArgsConstructor
enum SupportedBrowsers {
    REMOTE_CHROME(new RemoteChromeInvoker()),
    REMOTE_FIREFOX(new RemoteFirefoxInvoker()),
    LOCAL_CHROME(new LocalChromeInvoker());

    WebDriverInvoker driverInvoker;

    @SneakyThrows
    public WebDriver getWebDriver() {
        return driverInvoker.invokeWebDriver();
    }
}
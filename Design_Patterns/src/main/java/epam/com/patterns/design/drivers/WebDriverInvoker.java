package epam.com.patterns.design.drivers;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;

public interface WebDriverInvoker {
    @SneakyThrows
    WebDriver invokeWebDriver();
}
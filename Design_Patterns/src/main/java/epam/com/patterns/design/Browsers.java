package epam.com.patterns.design;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:browser.properties")
public interface Browsers extends Config {
    @Key("browser")
    @ConverterClass(SupportedBrowsersConverter.class)
    SupportedBrowsers getBrowser();
}
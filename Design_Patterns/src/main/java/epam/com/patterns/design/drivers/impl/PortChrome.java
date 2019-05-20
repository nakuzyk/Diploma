package epam.com.patterns.design.drivers.impl;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:browser.properties")
public interface PortChrome extends Config {

    @Key("chrome_port.property")
    String propertyChrome();

}
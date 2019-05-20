package epam.com.patterns.design.drivers.impl;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:browser.properties")
public interface PortFirefox extends Config {

    @Key("firefox_port.property")
    String propertyFirefox();

}
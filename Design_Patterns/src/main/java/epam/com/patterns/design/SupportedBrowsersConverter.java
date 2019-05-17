package epam.com.patterns.design;

import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

public class SupportedBrowsersConverter implements Converter {
    public Object convert(Method method, String s) {
        return SupportedBrowsers.valueOf(s.toUpperCase());
    }
}
package Anastasiia_Kuzyk.converters;

import org.apache.commons.lang3.StringUtils;

public class Converters {

    public String convert(String s) {
        return StringUtils.reverse(StringUtils.upperCase(s));
    }
}

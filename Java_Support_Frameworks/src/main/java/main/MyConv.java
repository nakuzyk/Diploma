package main;
import org.aeonbits.owner.Converter;
import java.lang.reflect.Method;
import enumerations.CuteLevel;

public class MyConv implements Converter<CuteLevel>{

    @Override
    public CuteLevel convert(Method method, String s) {
        return CuteLevel.valueOf(s);
    }
}

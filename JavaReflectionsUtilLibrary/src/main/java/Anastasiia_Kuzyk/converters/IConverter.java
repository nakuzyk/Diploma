package Anastasiia_Kuzyk.converters;

import Anastasiia_Kuzyk.anotation.PropertyConverter;
import org.aeonbits.owner.Config;

@Config.Sources("classpath:property.properties")
public interface IConverter extends Config{
    @Config.Key("first.property")
    //@ConverterClass(Converters.class)
    @PropertyConverter(converterClass = Converters.class, converterMethod = "convert")
    String getFirstValue(String s);

    @Config.Key("second.property")
    String getSecondValue(String s);

}

package main;
import enumerations.CuteLevel;
import org.aeonbits.owner.Config;

@Config.Sources("classpath:cute_levels\\cuteLevel.properties")
public interface ICuteLevel extends Config{
    @Key("one.property")
    @ConverterClass(MyConv.class)
    CuteLevel propertyOne();
    @Key("two.property")
    @ConverterClass(MyConv.class)
    CuteLevel propertyTwo();
    @Key("three.property")
    @ConverterClass(MyConv.class)
    CuteLevel propertyThree();
    @Key("four.property")
    @ConverterClass(MyConv.class)
    CuteLevel propertyFour();
    @Key("five.property")
    @ConverterClass(MyConv.class)
    CuteLevel propertyFive();
}
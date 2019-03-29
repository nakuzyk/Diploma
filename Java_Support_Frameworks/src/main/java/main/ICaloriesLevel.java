package main;
import org.aeonbits.owner.Config;
//C:\Users\Anastasiia_Kuzyk\IdeaProjects\Java_Support_Frameworks\src\main\resources\calories\
@Config.Sources("classpath:calories\\caloriesLevel.properties")
public interface ICaloriesLevel extends Config{

    @Key("one.property")
    String propertyOne();
    @Key("two.property")
    String propertyTwo();
    @Key("three.property")
    String propertyThree();
}

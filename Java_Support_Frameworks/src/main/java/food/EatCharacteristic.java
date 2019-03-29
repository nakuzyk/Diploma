package food;

import lombok.Builder;
import enumerations.CatPosition;
import enumerations.DayPart;
import lombok.Getter;

@Builder(builderClassName = "FoodCollector", buildMethodName = "createCharacteristic")
@Getter
public class EatCharacteristic {
    private int AmountFoodEaten;
    private DayPart dayPart;
    private CatPosition catPosition;
}
package animals.inheritons;

import animals.Animal;
import enumerations.CuteLevel;
import food.EatCharacteristic;
import food.KittyCat;
import humans.Owner;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

import java.io.IOException;

import static enumerations.CuteLevel.BAD_CAT;

@Setter
@Getter
@Log4j
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class Kitty extends Animal {

    @EqualsAndHashCode.Include
    private CuteLevel cuteLevel;
    @EqualsAndHashCode.Include
    private Owner owner;
    private KittyCat dailyFood;

    public Kitty(String name, Double weight) {
        super(name, weight);
        log.info("Котэ был рожден");
    }

    public void eatFood(EatCharacteristic eatCharacteristic) {
        if (dailyFood.getWeight() > 0.0) {
            dailyFood.setWeight(dailyFood.getWeight() - eatCharacteristic.getAmountFoodEaten());
            log.info("Кот поел");
        }
        if (dailyFood.getWeight() < 0) {
            log.warn("Bес ежедневной еды не ушел в минус");
        }
        if (dailyFood.getWeight() == 0.0) {
            log.warn("Кот обеспокоен нехваткой пищи");
        }
    }

    @SneakyThrows(InterruptedException.class)
    public void killCat() {
        log.error("Кот умер");
        if (cuteLevel != BAD_CAT) {
            log.info("Хозяин " + getOwner() + " в печали");
        }
        throw new InterruptedException();
    }
}
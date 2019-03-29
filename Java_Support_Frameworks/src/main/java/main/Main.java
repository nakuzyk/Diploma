package main;

import animals.inheritons.Kitty;
import enumerations.CatPosition;
import enumerations.DayPart;
import food.EatCharacteristic;
import food.KittyCat;
import humans.Owner;
import lombok.Cleanup;
import org.aeonbits.owner.ConfigFactory;

import static enumerations.CuteLevel.BAD_CAT;
import static enumerations.CuteLevel.FAT_CAT;

public class Main {

    public static void main (String args[]) {

        Owner owner = new Owner();
        owner.setFirstName("Nastya");
        owner.setLastName("Kuzyk");
        owner.setAge(23);

        System.out.println(owner);

        @Cleanup("killCat") Kitty cat = new Kitty("Musya", 7.5);
        EatCharacteristic eatCharacteristic = EatCharacteristic.builder().AmountFoodEaten(20).dayPart(DayPart.MORNING).catPosition(CatPosition.LIES).createCharacteristic();
        cat.setCuteLevel(BAD_CAT);
        cat.setOwner(owner);
        cat.setDailyFood(new KittyCat("wiskas", 100));
        System.out.println(cat);

        cat.eatFood(eatCharacteristic);

        ICuteLevel cuteLevel = ConfigFactory.create(ICuteLevel.class);
        System.out.println(cuteLevel.propertyOne());
        System.out.println(cuteLevel.propertyTwo());
        System.out.println(cuteLevel.propertyThree());
        System.out.println(cuteLevel.propertyFour());
        System.out.println(cuteLevel.propertyFive());

        ICaloriesLevel caloriesLevel = ConfigFactory.create(ICaloriesLevel.class);
        System.out.println(caloriesLevel.propertyOne());
        System.out.println(caloriesLevel.propertyTwo());
        System.out.println(caloriesLevel.propertyThree());

    }
}
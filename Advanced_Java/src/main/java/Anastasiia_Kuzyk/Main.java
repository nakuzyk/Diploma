package Anastasiia_Kuzyk;

public class Main {
    public static void main(String[] args) {

        Airplane.Ailerons ailerons = new Airplane(AirplaneColor.BLACK).new Ailerons();
        Airplane.Elevators elevators = new Airplane(AirplaneColor.WHITE).new Elevators();

        ailerons.setPosition(7);
        elevators.setPosition(2);
        ailerons.changePosition();
        elevators.changePosition();
        System.out.println(ailerons.getPosition());
        System.out.println(elevators.getPosition());

        Airplane.Engine<RuntimeException> engine = new Airplane.Engine<RuntimeException>(new RuntimeException("Engine is broken"));
        System.out.println(AirplaneColor.validateRGB("#0f0"));
        engine.turnOn();
    }
}
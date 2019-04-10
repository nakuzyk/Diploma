package Anastasiia_Kuzyk;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.lang3.RandomUtils;

@RequiredArgsConstructor
public class Airplane {
    private boolean autopilot;
    private @NonNull AirplaneColor airplaneColor;

    private void activeAutopilot() {
        autopilot = true;
    }

    @Getter
    public abstract class Position {
        private int position;

        public void setPosition(int position) {
            if (position >= 1 && position <= 4) {
                this.position = position;
            }
        }
    }

    public class Ailerons extends Position {
        AirplaneColor aileronsColor;

        public void changePosition() {
            activeAutopilot();
            if (getPosition() == 4) {
                setPosition(1);
            } else setPosition(getPosition() + 1);
        }

        public AirplaneColor installCollor(AirplaneColor airplaneColor) {
            return aileronsColor = airplaneColor;
        }
    }

    public class Elevators extends Position {
        AirplaneColor elevatorsColor;

        public void changePosition() {
            activeAutopilot();
            if (getPosition() == 4) {
                setPosition(1);
            } else setPosition(getPosition() + 1);
        }

        public AirplaneColor installCollor(AirplaneColor airplaneColor) {
            return elevatorsColor = airplaneColor;
        }
    }

    public static class Engine<T extends Exception> {
        private boolean activeEngine = false;
        private T exception;

        public Engine(T t) {
            exception = t;
        }

        @SneakyThrows
        public void turnOn() {
            activeEngine = true;
            if (RandomUtils.nextInt(0, 10) > 6) {
                throw exception;
            }
        }

        @SneakyThrows
        public void turnOff() {
            activeEngine = false;
            if (RandomUtils.nextInt(0, 10) > 6) {
                throw exception;
            }
        }
    }
}
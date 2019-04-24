package Anastasiia_Kuzyk;

import Anastasiia_Kuzyk.converters.IConverter;
import lombok.SneakyThrows;

public class Main {
    @SneakyThrows(Throwable.class)
    public static void main(String[] args) {
        IConverter m = PropertyFactory.createProperty(IConverter.class);
        System.out.println(m.getFirstValue("aytsan"));
        System.out.println(m.getSecondValue("slept through the deadline"));
    }
}
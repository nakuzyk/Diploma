package Anastasiia_Kuzyk.converters;

import Anastasiia_Kuzyk.RuntimeHandler;
import Anastasiia_Kuzyk.anotation.PropertyConverter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class PropertyConverterHandler implements RuntimeHandler {
    public PropertyConverterMetadata process(Object parameter) {

        Class clazz = (Class) parameter;
        Method[] method = clazz.getDeclaredMethods();
        Class converterClass;
        String converterMethodName;
        PropertyConverterMetadata prop = null;
        for (Method m : method)
            if (m.isAnnotationPresent(PropertyConverter.class)) {
                Annotation annotation = m.getAnnotation(PropertyConverter.class);
                converterMethodName = ((PropertyConverter) annotation).converterMethod();
                converterClass = ((PropertyConverter) annotation).converterClass();
                prop = new PropertyConverterMetadata(converterClass, converterMethodName);
            }
        return prop;
    }
}
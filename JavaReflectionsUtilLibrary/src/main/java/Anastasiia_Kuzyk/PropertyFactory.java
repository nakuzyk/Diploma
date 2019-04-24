package Anastasiia_Kuzyk;

import Anastasiia_Kuzyk.anotation.PropertyConverter;
import Anastasiia_Kuzyk.converters.PropertyConverterHandler;
import Anastasiia_Kuzyk.converters.PropertyConverterMetadata;
import lombok.SneakyThrows;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.aeonbits.owner.Converter;
import org.aeonbits.owner.Factory;
import org.aeonbits.owner.loaders.Loader;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.Properties;

public class PropertyFactory {

    public static Factory newInstance() {
        return ConfigFactory.newInstance();
    }

    public static <T extends Config> T create(Class<? extends T> clazz, Map<?, ?>... imports) {
        return ConfigFactory.create(clazz, imports);
    }

    public static String setProperty(String key, String value) {
        return ConfigFactory.setProperty(key, value);
    }

    public static Properties getProperties() {
        return ConfigFactory.getProperties();
    }

    public static void setProperties(Properties properties) {
        ConfigFactory.setProperties(properties);
    }

    public static String getProperty(String key) {
        return ConfigFactory.getProperty(key);
    }

    public static String clearProperty(String key) {
        return ConfigFactory.clearProperty(key);
    }

    public static void registerLoader(Loader loader) {
        ConfigFactory.registerLoader(loader);
    }

    public static void setTypeConverter(Class<?> type, Class<? extends Converter<?>> converter) {
        ConfigFactory.setTypeConverter(type, converter);
    }

    public static void removeTypeConverter(Class<?> type) {
        ConfigFactory.removeTypeConverter(type);
    }

    ConfigFactory factory;
    static PropertyConverterHandler propertyConverterHandler = new PropertyConverterHandler();

    @SneakyThrows
    public static <T extends Config> T createProperty(Class<? extends T> clazz) {

        Method[] allMethods = clazz.getDeclaredMethods();
        for (Method m : allMethods) {
            if (m.isAnnotationPresent(Config.ConverterClass.class)) {
                removeAnnotationFromMethod(m, Config.ConverterClass.class);
            }
        }
        final T forProxy = (T)create(clazz);
        final PropertyConverterMetadata propertyConverterMetadata = propertyConverterHandler.process(clazz);

        Object proxy = Proxy.newProxyInstance(forProxy.getClass().getClassLoader(), new Class<?>[]{clazz}, new InvocationHandler() {
                    @SneakyThrows
                    public Object invoke(Object proxyNew, Method method, Object[] args)  {
                        if (method.isAnnotationPresent(PropertyConverter.class)) {
                            Class converterClass = propertyConverterMetadata.getFirstInfo();
                            Method converterMethod = converterClass.getMethod(propertyConverterMetadata.getSecondInfo(),method.getReturnType());
                            converterMethod.setAccessible(true);
                            return converterMethod.invoke(converterClass.newInstance(), method.invoke(forProxy, args));
                        }
                        return  method.invoke(forProxy,args);
                    }
                }
        );


        return (T) proxy;
    }

    @SneakyThrows
    private static void removeAnnotationFromMethod(Method annotatedMethod, Class<? extends Annotation> annotationType) {
        boolean annotatedMethodAccessible;
        boolean annotationsFieldAccessible;

        annotatedMethodAccessible = annotatedMethod.isAccessible();
        annotatedMethod.setAccessible(true);
        annotatedMethod.getDeclaredAnnotations();

        Field annotations = annotatedMethod.getClass().getSuperclass().getDeclaredField("declaredAnnotations");
        annotationsFieldAccessible = annotations.isAccessible();
        annotations.setAccessible(true);

        ((Map<Class<? extends Annotation>, Annotation>) annotations.get(annotatedMethod)).remove(annotationType);

        annotations.setAccessible(annotationsFieldAccessible);
        annotatedMethod.setAccessible(annotatedMethodAccessible);
    }
}
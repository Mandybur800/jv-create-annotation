package core.basesyntax.lib;

import core.basesyntax.exceptions.AnnotationNotPresentException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor declaredConstructor = clazz.getDeclaredConstructor();
        Object instance = declaredConstructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                Object dao = Factory.getDao(field.getType());
                if (!dao.getClass().isAnnotationPresent(Dao.class)) {
                    throw new AnnotationNotPresentException("Annotation for "
                            + dao.getClass() + " does not exist");
                }
                field.set(instance, dao);
            }
        }
        return instance;
    }
}

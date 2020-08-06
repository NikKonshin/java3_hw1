package homework7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        start(MyTest.class);

    }

    public static void start(Class testClass) throws InvocationTargetException, IllegalAccessException {

// Массив методов, хранятся не по порядку.
        Method[] methods = testClass.getMethods();

        List<Method> listMethods = new ArrayList<>();

// Переносим методы в Аррай лист.
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)){
                listMethods.add(method);
            }
        }
// Сортируем методы по порядку с используем priority из аннотации @Test.
        Comparator<Method> comparator = Comparator.comparing(method -> method.getAnnotation(Test.class).priority());
        Collections.sort(listMethods,comparator);

//Проверяем условие задачи, а именно Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать в единственном экземпляре.
        if (!checkAnnotations(testClass, BeforeSuite.class, AfterSuite.class)) {
            throw new RuntimeException("Не должно быть более 1 метода с анотацией @BeforeSuite или @AfterSuite");
        }

// Цикл выполняет метод с аннотацией BeforeSuite.
        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                method.invoke(null);
            }
        }
// Цикл выполняет методы с аннотацией Test.
        for (Method method : listMethods) {
            if (method.isAnnotationPresent(Test.class)){
                method.invoke(null);
            }
        }
// Цикл выполняет метод с аннотацией AfterSuite.
        for (Method method : methods) {
            if (method.isAnnotationPresent(AfterSuite.class)) {
                method.invoke(null);
            }
        }
    }

    // метод проверяет количество методов с анотациями BeforeSuite и AfterSuite
    public static boolean checkAnnotations(Class testClass, Class a, Class b) {
        int beforeSuiteCount = 0;
        int afterSuiteCount = 0;
        Method[] methods = testClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                beforeSuiteCount++;
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                afterSuiteCount++;
            }

            if (beforeSuiteCount > 1) {
                return false;
            }
            if (afterSuiteCount > 1) {
                return false;
            }
        }
        return true;
    }

}




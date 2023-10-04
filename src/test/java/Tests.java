import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Tests
{
    @Test
    public void Test1()
    {
        Human human = new Human();
        Human human1 = new Human();
        Human human2 = new Human();
        Object object = new Object();
        LinkedList<Object> list = new LinkedList<>();
        list.add(human);
        list.add(human1);
        list.add(human2);
        list.add(object);
        int expected = 3;
        ReflectionService<Human> test = new ReflectionService<>();

        assertEquals(expected, test.getQuantityAllHumanClasses(list));
    }

    @Test
    public void Test2() throws NoSuchMethodException {
        Human human = new Human();
        Class<Human> analyzeHuman = (Class<Human>) human.getClass();
        HashSet<Method> set = new HashSet<>(Arrays.asList(analyzeHuman.getDeclaredMethods()));
        HashSet<Method> expected = new HashSet<>();

        ReflectionService<Human> test = new ReflectionService<>();

        expected.add(analyzeHuman.getMethod("getAge"));
        expected.add(analyzeHuman.getMethod("getFirstName"));
        expected.add(analyzeHuman.getMethod("getMiddleName"));
        expected.add(analyzeHuman.getMethod("getLastName"));
        expected.add(analyzeHuman.getMethod("equals", Object.class));
        expected.add(analyzeHuman.getMethod("hashCode"));
        assertTrue(expected.equals(new HashSet<Method>(test.getPublicMethodsOfClass(human))));
    }
    @Test
    public void Test3()
    {
        Child human = new Child();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("class Child");
        expected.add("class Human");
        expected.add("class java.lang.Object");
        ReflectionService<Child> test = new ReflectionService<>();

        assertTrue(expected.equals(test.getSuperClasses(human)));
    }
}

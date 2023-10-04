import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReflectionService<T>
{
    public int getQuantityAllHumanClasses(List<Object> classList)
    {
        int i = 0;
        for(Object l: classList)
        {
            if(l instanceof Human)
            {
                i++;
            }
        }
        return i;
    }

    public List<Method> getPublicMethodsOfClass(T clazz)
    {
        Class<T> analyze = (Class<T>) clazz.getClass();
        List<Method> retList = Arrays.asList(analyze.getDeclaredMethods());
        return retList;
    }

    public List<String> getSuperClasses(T clazz)
    {
        Class<?> clazz1 = clazz.getClass();
        List<String> retList = new ArrayList<>();

        while(clazz1 != null)
        {
            retList.add(clazz1.toString());
            clazz1 = clazz1.getSuperclass();
        }
        return retList;
    }

}

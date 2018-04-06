package cn.cecurio.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: Cecurio
 * @create: 2018-02-25 19:40
 **/
public class Test {


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
        InvocationTargetException, IllegalAccessException {

        Method subStringFunc = Class.forName("java.lang.String").getDeclaredMethod("substring", int.class,int.class);

        String a = new String("hello");

        String b = (String) subStringFunc.invoke(a,1,5);

        System.out.println(b);

    }
}

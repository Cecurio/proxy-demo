package cn.cecurio.proxy.dynamic.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: Cecurio
 * @create: 2018-02-26 17:17
 **/
public class Test {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        Enhancer enhancer = new Enhancer();

        // 设置对 哪个类 进行代理
        enhancer.setSuperclass(Foo.class);

        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("before invoke");
                Object result = methodProxy.invokeSuper(o,objects);
                System.out.println("after invoke");
                return result;
            }
        });

        // 生成 被代理的类 的子类
        Foo foo = (Foo) enhancer.create();

        foo.bar();
    }

    // 在类上加 final 修饰符, 报错 java.lang.IllegalArgumentException: Cannot subclass final class class cn.cecurio.proxy.dynamic.cglib.Test$Foo
    // 在方法上加 final 修饰符, 不报错, 但是只执行此类中原本的实现, 而不执行生成的代理类的 intercept() 方法
    static class Foo {
        public void bar() {
            System.out.println("执行Foo.bar方法");
        }
    }
}

package cn.cecurio.proxy.dynamic.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: Cecurio
 * @create: 2018-02-26 11:04
 **/
public class ProductServiceCglib implements MethodInterceptor {
    private Object target;

    public Object getInstance(Object target) {
        this.target = target;

        Enhancer enhancer = new Enhancer();

        // 设置要增强的类, cglib实际上是 继承委托类
        enhancer.setSuperclass(this.target.getClass());

        enhancer.setCallback(this);

        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method,
                            Object[] args, MethodProxy methodProxy)
        throws Throwable {

        System.out.println("===代理开始===");

        Object result = methodProxy.invokeSuper(obj, args);

        System.out.println("===代理结束===");
        return result;
    }
}

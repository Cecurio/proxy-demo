package cn.cecurio.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: Cecurio
 * @create: 2018-02-25 16:24
 **/
public class ServiceInvocationHandler implements InvocationHandler {

    private Object target;

    public ServiceInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * 创建代理实例
     *
     * @return
     * @throws Throwable
     */
    public Object getProxy() throws Throwable {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(), this);
    }

    /**
     * 实现 InvocationHandler 接口, 必须实现invoke方法
     * 执行目标对象的方法, 并进行增强
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;

        System.out.println("代理方法开始");

        System.out.println("被代理的方法是:" + method);

        System.out.print("参数:");

        for (int i=0; i<args.length; i++) {
            if (i != 0){
                System.out.print(" , ");
            }
            System.out.print(args[i]);
        }

        System.out.println();

        // 执行目标对象的方法
        result = method.invoke(target, args);

        System.out.println("代理方法结束");

        return result;
    }
}

package cn.cecurio.proxy.dynamic.jdk;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: Cecurio
 * @create: 2018-02-25 16:42
 **/
public class JdkProxyTest {
    public static void main(String[] args) throws Throwable {
        UserService userService = new UserServiceImpl();
        ServiceInvocationHandler handler = new ServiceInvocationHandler(userService);

        UserService userServiceProxy = (UserService) handler.getProxy();
        userServiceProxy.add("admin", "123456");

        OrderService orderService = new OrderServiceImpl();
        ServiceInvocationHandler orderServiceHandler = new ServiceInvocationHandler(orderService);

        OrderService orderServiceProxy = (OrderService) orderServiceHandler.getProxy();
        orderServiceProxy.order("苹果");

        Class[] interfaces = orderService.getClass().getInterfaces();

        System.out.println();

//        createProxyClassFile();
    }

    /**
     * 获取 接口的代理类 的字节码文件
     */
    private static void createProxyClassFile() {
        String name = "ProxyUserService";
        byte[] data = ProxyGenerator.generateProxyClass(name, new Class[]{UserService.class});
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(name + ".class");
            System.out.println((new File("hello")).getAbsolutePath());
            out.write(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != out) try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

package cn.cecurio.proxy.dynamic.jdk;

/**
 * @author: Cecurio
 * @create: 2018-02-25 17:16
 **/
public class OrderServiceImpl implements OrderService {

    public void order(String name) {
        System.out.println("OrderServiceImpl.order()");
        System.out.println("name = [" + name + "]");
    }
}

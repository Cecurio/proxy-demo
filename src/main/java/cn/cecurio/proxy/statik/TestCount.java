package cn.cecurio.proxy.statik;

/**
 * @author: Cecurio
 * @create: 2018-02-21 13:23
 **/
public class TestCount {
    public static void main(String[] args) {
        CountImpl countImpl = new CountImpl();
        CountProxy countProxy = new CountProxy(countImpl);
        countProxy.updateCount();
        countProxy.queryCount();
    }
}

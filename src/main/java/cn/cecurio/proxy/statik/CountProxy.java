package cn.cecurio.proxy.statik;

/**
 * @author: Cecurio
 * @create: 2018-02-21 13:23
 **/
public class CountProxy implements Count {
    // 代理类的委托, 委派它做一些事情
    private CountImpl countImpl;

    public CountProxy(CountImpl countImpl) {
        this.countImpl = countImpl;
    }

    public void queryCount() {
        before();
        // 调用委托类的方法;
        countImpl.queryCount();
        after();
    }

    public void updateCount() {
        before();
        // 调用委托类的方法;
        countImpl.updateCount();
        after();
    }

    private void before() {
        System.out.println("===事务处理之前===");
    }

    private void after() {
        System.out.println("===事务处理之后===");
    }
}
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
        System.out.println("事务处理之前");
        // 调用委托类的方法;
        countImpl.queryCount();
        System.out.println("事务处理之后");
    }

    public void updateCount() {
        System.out.println("事务处理之前");
        // 调用委托类的方法;
        countImpl.updateCount();
        System.out.println("事务处理之后");
    }
}
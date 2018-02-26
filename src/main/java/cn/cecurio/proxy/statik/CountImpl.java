package cn.cecurio.proxy.statik;

/**
 * @author: Cecurio
 * @create: 2018-02-21 13:21
 **/
public class CountImpl implements Count{
    public void queryCount() {
        System.out.println("查询账户信息。。。");
    }

    public void updateCount() {
        System.out.println("修改账户信息。。。");
    }
}
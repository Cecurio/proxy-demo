package cn.cecurio.proxy.dynamic.cglib;

/**
 * 因为此类要被 cglib 代理, 所以不能用 final 修饰
 * @author: Cecurio
 * @create: 2018-02-26 11:02
 **/
public class ProductServiceImpl {
    public void add() {
        System.out.println("增加一个产品。。。");
    }

    public void edit() {
        System.out.println("编辑一个产品。。。");
    }
}

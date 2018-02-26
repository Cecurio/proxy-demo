package cn.cecurio.proxy.dynamic.cglib;

/**
 * @author: Cecurio
 * @create: 2018-02-26 11:44
 **/
public class CglibTest {
    public static void main(String[] args) {
        ProductServiceCglib productServiceCglib = new ProductServiceCglib();

        ProductServiceImpl productServiceImpl =
            (ProductServiceImpl) productServiceCglib.getInstance(new ProductServiceImpl());

        productServiceImpl.add();

        productServiceImpl.edit();
    }
}

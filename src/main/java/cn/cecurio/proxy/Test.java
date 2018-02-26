package cn.cecurio.proxy;

/**
 * @author: Cecurio
 * @create: 2018-02-25 19:40
 **/
public class Test {
    void fun() {
        throw new RuntimeException("hello");
    }

    public static void main(String[] args) {
        Test test = new Test();

        test.fun();


        System.out.println("继续执行");
    }
}

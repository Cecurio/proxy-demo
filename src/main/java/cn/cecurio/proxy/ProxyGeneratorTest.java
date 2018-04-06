package cn.cecurio.proxy;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

interface Service {
    void add(String username,String password);
    void update(String username,String password);
}

/**
 * @author: Cecurio
 * @create: 2018-04-07 2:11
 **/
public class ProxyGeneratorTest {

    public static void main(String[] args) {
        String name = "ProxyService";
        byte[] data = ProxyGenerator.generateProxyClass(name, new Class[]{Service.class});
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(name + ".class");
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

package cn.cecurio.proxy.dynamic.jdk;

/**
 * @author: Cecurio
 * @create: 2018-02-25 16:22
 **/
public class UserServiceImpl implements UserService {

    public void add(String username, String password) {
//        System.out.println(String.format("%s---%s", username, password));
        System.out.println("UserServiceImpl.add()");
    }

    public void update(String username, String password) {
//        System.out.println(String.format("%s---%s", username, password));
        System.out.println("UserServiceImpl.update()");
    }
}

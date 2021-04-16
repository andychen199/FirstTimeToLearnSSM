package cn.cerny.dao.impl;

import cn.cerny.dao.UserDao;
import org.springframework.stereotype.Component;

//<bean id="userDao" class="cn.cerny.dao.impl.UserDaoImpl"></bean>
@Component("userDao")
public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("save running....");
    }
}

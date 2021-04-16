package cn.cerny.service.impl;

import cn.cerny.dao.UserDao;
import cn.cerny.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//<bean id="userService" class="cn.cerny.service.impl.UserServiceImpl">
@Component("userService")
public class UserServiceImpl implements UserService {
    //<property name="userDao" ref="userDao"></property>
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
    userDao.save();
    }
}

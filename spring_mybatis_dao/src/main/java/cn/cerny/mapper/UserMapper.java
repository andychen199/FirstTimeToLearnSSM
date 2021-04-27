package cn.cerny.mapper;

import cn.cerny.domain.User;

import java.util.List;

public interface UserMapper {
    public List<User> findAll();
    public List<User> findByCondition(User user);

    public List<User> findByIds(List<Integer> ids);

}

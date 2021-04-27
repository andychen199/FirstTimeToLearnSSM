package cn.cerny.test;

import cn.cerny.domain.User;
import cn.cerny.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MapperTest {
    private UserMapper mapper;
    private SqlSession sqlSession;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(UserMapper.class);
    }
    @Test
    public void test2(){

        PageHelper.startPage(2,1);
        List<User> userList = mapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
        PageInfo<User> userPageInfo = new PageInfo<>(userList);
        System.out.println("当前页："+userPageInfo.getPageNum());
    }
    @After
    public void after(){
        sqlSession.close();
    }
    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //模拟条件User
//        User condition = new User();
//        condition.setId(1);
//        condition.setUsername("安迪");
//        condition.setSex("男");
//        List<User> userList = mapper.findByCondition(condition);
//        System.out.println(userList);
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        List<User> userList = mapper.findByIds(ids);
        System.out.println(userList);

    }
}

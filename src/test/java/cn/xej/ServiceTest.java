package cn.xej;

import cn.xej.entity.User;
import cn.xej.mapper.UserMapper;
import cn.xej.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        List<User> userList = userMapper.selectList(null);

//        User user = userService.getById(1);
        System.out.println(userList);
        /*
        List<User> userList = userService.getAllUsers();
        for(User user:userList){
            System.out.println(user);
        }
        */
    }
}

package lynu.chaohl;

import com.sun.glass.ui.Application;
import lynu.chaohl.Demo2.Entity.User;
import lynu.chaohl.Demo2.Service.UserService;
import lynu.chaohl.Demo2.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

//@SpringBootTest(classes = Test.class) //只启动测试类
@SpringBootTest  //spingboot整体项目启动

//@RunWith(SpringRunner.class)
class Demo2ApplicationTests {

    @Autowired
    public UserService userService;

    @Autowired
    public UserMapper userMapper;

    @Test
    void contextLoads() {

        for (int i = 0; i < 1000000; i++) {

            User user = new User();
            user.id = i;
            user.username = "chaohl" + i;
            user.password = "password" + i;
            userMapper.addUser(user);
        }
    }


}

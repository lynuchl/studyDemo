package lynu.chaohl.Demo2.Service;

import lynu.chaohl.Demo2.Entity.User;
import lynu.chaohl.Demo2.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    public UserMapper userMapper;

    public List<User> queryAll(){

//        System.out.println(userMapper.toString());
//        userMapper.toString();
       return userMapper.queryAll();
    }

}

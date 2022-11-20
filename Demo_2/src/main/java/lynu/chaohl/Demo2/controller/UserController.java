package lynu.chaohl.Demo2.controller;

import lynu.chaohl.Demo2.Entity.User;
import lynu.chaohl.Demo2.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    public UserService userService;

@RequestMapping("/queryAll")
    public List<User> queryAll(){

        System.out.println("hello world");
        return userService.queryAll();
    }
}

package lynu.chaohl.SpringbootIntegration.ServerDruidDemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lynu.chaohl.SpringbootIntegration.ServerDruidDemo.domain.User;
import lynu.chaohl.SpringbootIntegration.ServerDruidDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制层
 *
 * Created by bysocket on 07/02/2017.
 */
@Api(tags = "Druid测试")
@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

    /**
     * 根据用户名获取用户信息，包括从库的地址信息
     *
     * @param userName
     * @return
     */
    @ApiOperation("根据用户名获取用户信息，包括从库的地址信息")
    @RequestMapping(value = "/api/user", method = RequestMethod.GET)
    public User findByName(@RequestParam(value = "userName", required = true) String userName) {
        return userService.findByName(userName);
    }

}

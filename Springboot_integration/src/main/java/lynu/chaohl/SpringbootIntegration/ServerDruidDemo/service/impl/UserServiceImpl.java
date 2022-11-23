package lynu.chaohl.SpringbootIntegration.ServerDruidDemo.service.impl;

import lynu.chaohl.SpringbootIntegration.ServerDruidDemo.dao.cluster.CityDao;
import lynu.chaohl.SpringbootIntegration.ServerDruidDemo.dao.master.UserDao;
import lynu.chaohl.SpringbootIntegration.ServerDruidDemo.domain.City;
import lynu.chaohl.SpringbootIntegration.ServerDruidDemo.domain.User;
import lynu.chaohl.SpringbootIntegration.ServerDruidDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务实现层
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao; // 主数据源

    @Autowired
    private CityDao cityDao; // 从数据源

    @Override
    public User findByName(String userName) {
        User user = userDao.findByName(userName);
        City city = cityDao.findByName("河南省");
        user.setCity(city);
        return user;
    }
}

package lynu.chaohl.SpringbootRedis.redisDemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lynu.chaohl.SpringbootRedis.redisDemo.domain.City;
import lynu.chaohl.SpringbootRedis.redisDemo.service.CityService;
//import org.spring.springboot.domain.City;
//import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by bysocket on 07/02/2017.
 */
@Api(tags = "Redis测试")
@RestController
public class CityRestController {

    @Autowired
    private CityService cityService;

    @ApiOperation("根据城市 ID,查询城市信息")
    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.GET)
    public City findOneCity(@PathVariable("id") Long id) {
        return cityService.findCityById(id);
    }

    @ApiOperation("新增城市信息")
    @RequestMapping(value = "/api/city", method = RequestMethod.POST)
    public void createCity(@RequestBody City city) {
        cityService.saveCity(city);
    }

    @ApiOperation("更新城市信息")
    @RequestMapping(value = "/api/city", method = RequestMethod.PUT)
    public void modifyCity(@RequestBody City city) {
        cityService.updateCity(city);
    }

    @ApiOperation("根据城市 ID,删除城市信息")
    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.DELETE)
    public void modifyCity(@PathVariable("id") Long id) {
        cityService.deleteCity(id);
    }
}

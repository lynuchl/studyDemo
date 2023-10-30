package lynu.chaohl.SpringbootIntegration.ServerBaseDemo.mapper.mybatisTest;

import lynu.chaohl.SpringbootIntegration.ServerBaseDemo.entity.mybatisTest.City;

public interface CityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
}
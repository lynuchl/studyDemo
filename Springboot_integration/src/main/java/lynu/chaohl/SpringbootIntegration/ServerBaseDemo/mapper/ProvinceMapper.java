package lynu.chaohl.SpringbootIntegration.ServerBaseDemo.mapper;

import lynu.chaohl.SpringbootIntegration.ServerBaseDemo.entity.Province;

import java.util.List;
import java.util.Map;

public interface ProvinceMapper {
    int deleteByPrimaryKey(Integer id);

    List<Province> divPage(Map<String,Integer>map);

    int insert(Province record);

    int insertSelective(Province record);

    Province selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Province record);

    int updateByPrimaryKey(Province record);
}
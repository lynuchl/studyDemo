package lynu.chaohl.SpringbootIntegration.ServerBaseDemo.mapper;

import lynu.chaohl.SpringbootIntegration.ServerBaseDemo.entity.Province;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface ProvinceAddMapper {
    int deleteByPrimaryKey(Integer id);

    List<Province> divPage(Map<String, Integer> map);

    int insert(Province record);

    int insertSelective(Province record);

    Province selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Province record);

    int updateByPrimaryKey(Province record);
}
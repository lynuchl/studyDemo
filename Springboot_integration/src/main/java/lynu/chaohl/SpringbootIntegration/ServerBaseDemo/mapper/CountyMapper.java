package lynu.chaohl.SpringbootIntegration.ServerBaseDemo.mapper;

import lynu.chaohl.SpringbootIntegration.ServerBaseDemo.entity.County;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//@Repository
//@Mapper
public interface CountyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(County record);

    int insertSelective(County record);

    County selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(County record);

    int updateByPrimaryKey(County record);
}
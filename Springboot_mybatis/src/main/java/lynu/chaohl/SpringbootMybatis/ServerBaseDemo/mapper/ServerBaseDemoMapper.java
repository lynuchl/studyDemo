package lynu.chaohl.SpringbootMybatis.ServerBaseDemo.mapper;

import lynu.chaohl.SpringbootMybatis.ServerBaseDemo.entity.ServerBaseDemo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ServerBaseDemoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ServerBaseDemo record);

    int insertSelective(ServerBaseDemo record);

    ServerBaseDemo selectByPrimaryKey(Integer id);

    ServerBaseDemo selectByName(String name);

    int updateByPrimaryKeySelective(ServerBaseDemo record);

    int updateByPrimaryKey(ServerBaseDemo record);
}
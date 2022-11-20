package lynu.chaohl.SpringbootRedis.ServerBaseDemo.mapper;

import lynu.chaohl.SpringbootRedis.ServerBaseDemo.entity.ServerBaseDemo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ServerBaseDemoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ServerBaseDemo record);

    int insertSelective(ServerBaseDemo record);

    ServerBaseDemo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ServerBaseDemo record);

    int updateByPrimaryKey(ServerBaseDemo record);
}
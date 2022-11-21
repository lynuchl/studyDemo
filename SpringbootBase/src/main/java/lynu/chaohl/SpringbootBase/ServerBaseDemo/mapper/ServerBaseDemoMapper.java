package lynu.chaohl.SpringbootBase.ServerBaseDemo.mapper;

import lynu.chaohl.SpringbootBase.ServerBaseDemo.entity.ServerBaseDemo;
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
package lynu.chaohl.Demo2.mapper;

import lynu.chaohl.Demo2.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

//@Mapper
@Repository
public interface UserMapper {


      List<User> queryAll();

      int addUser(User user);
}


package lynu.chaohl.SpringbootRedis.ServerBaseDemo.service;

import lombok.extern.slf4j.Slf4j;
import lynu.chaohl.SpringbootRedis.ServerBaseDemo.entity.ServerBaseDemo;
import lynu.chaohl.SpringbootRedis.ServerBaseDemo.mapper.ServerBaseDemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ServerBaseDemoService {

    @Autowired
    private ServerBaseDemoMapper serverBaseDemoMapper;
    public int insert(ServerBaseDemo serverBaseDemo){

       return serverBaseDemoMapper.insert(serverBaseDemo);

    }

}

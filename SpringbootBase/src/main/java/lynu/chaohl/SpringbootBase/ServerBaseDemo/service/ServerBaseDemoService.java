package lynu.chaohl.SpringbootBase.ServerBaseDemo.service;

import lombok.extern.slf4j.Slf4j;
import lynu.chaohl.SpringbootBase.ServerBaseDemo.entity.ServerBaseDemo;
import lynu.chaohl.SpringbootBase.ServerBaseDemo.mapper.ServerBaseDemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ServerBaseDemoService {

    @Autowired
    private ServerBaseDemoMapper serverBaseDemoMapper;

    public int insert(ServerBaseDemo serverBaseDemo){

        log.info(serverBaseDemo.toString());
        log.info(serverBaseDemoMapper.toString());

       return serverBaseDemoMapper.insert(serverBaseDemo);

    }

    public ServerBaseDemo selectByPrimaryKey(Integer key){

        return serverBaseDemoMapper.selectByPrimaryKey(key);
    }

    public ServerBaseDemo selectByName(String name){

        return serverBaseDemoMapper.selectByName(name);
    }

}

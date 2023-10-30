package lynu.chaohl.SpringbootIntegration.ServerBaseDemo.service.mybatisTest;

import lombok.extern.slf4j.Slf4j;
import lynu.chaohl.SpringbootIntegration.ServerBaseDemo.entity.County;
import lynu.chaohl.SpringbootIntegration.ServerBaseDemo.entity.Nation;
import lynu.chaohl.SpringbootIntegration.ServerBaseDemo.mapper.CountyMapper;
import lynu.chaohl.SpringbootIntegration.ServerBaseDemo.mapper.NationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PlaceService {

    @Autowired
    private CountyMapper countyMapper;

    @Autowired
    private NationMapper nationMapper;

    public int insertCounty(County record){

        return countyMapper.insert(record);
    }

    public List<Nation> getNations (){

        return nationMapper.getNations();
    }
}

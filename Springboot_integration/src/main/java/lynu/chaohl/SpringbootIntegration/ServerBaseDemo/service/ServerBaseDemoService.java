package lynu.chaohl.SpringbootIntegration.ServerBaseDemo.service;

import lombok.extern.slf4j.Slf4j;
import lynu.chaohl.SpringbootIntegration.ServerBaseDemo.entity.ServerBaseDemo;
import lynu.chaohl.SpringbootIntegration.ServerBaseDemo.entity.mybatisTest.City;
import lynu.chaohl.SpringbootIntegration.ServerBaseDemo.mapper.ServerBaseDemoMapper;
import lynu.chaohl.SpringbootIntegration.utils.CustomException;
import lynu.chaohl.SpringbootIntegration.utils.FileUtils;
import lynu.chaohl.SpringbootIntegration.utils.IdWorkerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@Slf4j
public class ServerBaseDemoService {

    private final String sep = File.separator;
    @Value("${file.size.limit}")
    private String maxFileSize;

//    @Autowired
//    private CityMapper cityMapper;

    @Autowired
    private ServerBaseDemoMapper serverBaseDemoMapper;


//    public List<City> divPage(Map<String,Integer> map){
//
//        return cityMapper.divPage(map);
//    }


    public int insert(ServerBaseDemo serverBaseDemo){

       return serverBaseDemoMapper.insert(serverBaseDemo);
    }

    public Long uploadImage(MultipartFile file) throws IOException {
        long size = file.getSize();
        if (size > FileUtils.getMaxFileSize(maxFileSize)) {
            throw new CustomException("文件大小不能超过" + maxFileSize);
        }
        String fileSize = FileUtils.getSize(size);
        // 生成文件ID
        Long fileId = IdWorkerUtils.getId();
        String path = new File("file" + sep + "expert" + sep).getAbsolutePath();
        File filePath = new File(path);
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        String fileName = Objects.requireNonNull(file.getOriginalFilename());
        int pointIndex = fileName.lastIndexOf(".");
        String extensionName = fileName.substring(pointIndex + 1);
        String newFileName = fileName.substring(0, pointIndex) + "_" + fileId + "." + extensionName;
        filePath = new File(path, newFileName);

//        Partner partner=new Partner();
//        partner.setLogo(filePath.getAbsolutePath());
//        partner.setFileId(fileId);
//        cache.put(fileId,partner);
        if (filePath.exists()) {
            filePath.delete();
        }
        try {
            file.transferTo(filePath);
        } catch (IOException e) {
            throw new CustomException("上传文件到服务器失败: " + e);
        }
        return fileId;
    }

}

package lynu.chaohl.SpringbootIntegration.utils;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Objects;

public class FileUtils {

    private static final String sep = File.separator;
    /**
     * 获取文件大小的字符串
     */
    public static String getSize(long size) {
        StringBuffer bytes = new StringBuffer();
        DecimalFormat format = new DecimalFormat("###.00");
        if (size >= 1024 * 1024 * 1024) {
            double i = (size / (1024.0 * 1024.0 * 1024.0));
            bytes.append(format.format(i)).append("GB");
        } else if (size >= 1024 * 1024) {
            double i = (size / (1024.0 * 1024.0));
            bytes.append(format.format(i)).append("MB");
        } else if (size >= 1024) {
            double i = (size / (1024.0));
            bytes.append(format.format(i)).append("KB");
        } else {
            if (size <= 0) {
                bytes.append("0B");
            } else {
                bytes.append((int) size).append("B");
            }
        }
        return bytes.toString();
    }

    /**
     * 获取文件大小
     *
     * @param maxFileSize 最大文件大小
     * @return Long 文件大小
     */
    public static Long getMaxFileSize(String maxFileSize) {
        maxFileSize = maxFileSize.toUpperCase();
        long maxSize = 0L;
        if (StringUtils.isNotBlank(maxFileSize)) {
            if (maxFileSize.endsWith("MB")) {
                maxSize = Long.parseLong(maxFileSize.substring(0, maxFileSize.length() - 2)) * 1024 * 1024;
            }
        }
        return maxSize;
    }

    public static String  createFile() throws IOException {
        String path = new File("file" + sep + "files" + sep).getAbsolutePath();
        File filePath = new File(path);
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        Long res = IdWorkerUtils.getId();
        path =  path +"/"+ res +".txt";
        File file = new File(path);
        if(file.createNewFile()) {
            return path;
        }else{
            return null;
        }
    }

    /**
    * 文件写入 ，修改时清空文件重新写入
    * @param filePath : 文件路径
    * @param  content : 文件内容
    * @param  flag : 0：新增，1：修改
    * @return
    * @Author xz
    * @Date 2022/10/29 09:50
    */
    public static void writerFile(String filePath,String content,String flag){
        FileWriter writer = new FileWriter(filePath);
        if(Objects.equals("1",filePath)){
            writer.write("");
        }
        writer.write(content);
    }

    /**
    * 文件读取
    * @param filePath : 文件路径
    * @return
    * @Author xz
    * @Date 2022/10/29 09:53
    */
    public static String readerFile(String filePath){
        FileReader fileReader = new FileReader(filePath);
        return fileReader.readString();
    }

}

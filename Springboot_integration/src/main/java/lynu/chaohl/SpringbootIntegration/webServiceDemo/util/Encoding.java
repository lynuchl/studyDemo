/**
 * @author:chaohl
 * @date:2021/3/2
 * @Description TODO
 */
package lynu.chaohl.SpringbootIntegration.webServiceDemo.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Encoding {

    public static String confirmEncodingWay(String resultString){

        try {
            if (resultString.equals(new String(resultString.getBytes("GB2312"),"GB2312"))){
                log.info("编码方法是:"+"GB2312");
                return "CB2312";
            }
            else if (resultString.equals(new String(resultString.getBytes("ISO-8859-1"),"ISO-8859-1"))){
                log.info("编码方法是:"+"ISO-8859-1");
                return "ISO-8859-1";
            }
            else if (resultString.equals(new String(resultString.getBytes("UTF-8"),"UTF-8"))){
                log.info("编码方法是:"+"UTF-8");
                return "UTF-8";
            }
            else if (resultString.equals(new String(resultString.getBytes("GBK"),"GBK"))){
                log.info("编码方法是:"+"GBK");
                return "GBK";
            }
            else if (resultString.equals(new String(resultString.getBytes("GB2312"),"GB2312"))){
                log.info("编码方法是:"+"GB2312");
                return "GB2312";
            }
            else if (resultString.equals(new String(resultString.getBytes("UTF-16"),"UTF-16"))){
                log.info("编码方法是:"+"UTF-16");
                return "UTF-16";
            }
            else if (resultString.equals(new String(resultString.getBytes("US-ASCII"),"US-ASCII"))){
                log.info("编码方法是:"+"US-ASCII");
                return "US-ASCII";
            }
            else {
                log.info("编码方法是:"+"以上都不是！！！");
                return "都错";
            }

        }catch (Exception e){

        }
        return "再来一次";

    }
}

/**@author:chaohl
 * @date:2021/2/20
 * @Description java调用.net编写的webservice服务,只局限于本次的信息科接口调用，不具备通用性。
 * 使用axis方式
 */

package lynu.chaohl.SpringbootIntegration.webServiceDemo.common;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import lynu.chaohl.SpringbootIntegration.webServiceDemo.util.Encoding;
import lynu.chaohl.SpringbootIntegration.webServiceDemo.util.Transition;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;
import java.util.Date;

@Slf4j
public class WebServiceCall {

    private static Long time=0l;

    public static String getWsResult(String url,String namespace,String methodName,String soapActionURI,String requestxml) throws Exception{

        Service service = new Service();
        Call call;
        JSONObject jsonObject;
        String jsonString="";
        try {
            call = (Call) service.createCall();
            call.setTargetEndpointAddress(url);
            call.setUseSOAPAction(true);
            call.setSOAPActionURI(soapActionURI);
            call.setOperationName(new QName(namespace, methodName));
            call.setEncodingStyle("UTF-8");
            call.addParameter(new QName(namespace, "requestXML"), javax.xml.rpc.encoding.XMLType.XSD_STRING,ParameterMode.IN);
            call.setReturnType(javax.xml.rpc.encoding.XMLType.XSD_STRING);
            Object[] objs = {requestxml};
            String resultString = (String)call.invoke(objs);
            String charset= Encoding.confirmEncodingWay(resultString);
            log.info("本次请求的url是:"+url+","+"namespace是:"+namespace+","+"methodName是:"+methodName+","+"请求参数是:"+requestxml);
//            log.info("返回的数据编码格式是:"+charset);
            try {
                byte[] b = resultString.getBytes(charset);
                resultString = new String(b, "UTF-8");
            } catch (Exception e) {
//                log.error("输入的内容不属于常见的编码格式,请再仔细核实", e);
            }
            jsonObject=Transition.xmltoJson(resultString);
             jsonString=jsonObject.toJSONString();
            log.info("返回的xml数据转换为jsonStrirng的内容是:"+jsonString);
//            Logging.getHisCallLoggingInfo(methodName,requestxml,charset,jsonString);
//            return jsonString ;
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    public static JSONObject getWsResultObj(String url,String namespace,String methodName,String soapActionURI,String requestxml) throws Exception{

        Date date=new Date();

        Service service = new Service();
        Call call;
        JSONObject jsonObject=new JSONObject();
//        String jsonString;
        try {
            call = (Call) service.createCall();
            call.setTargetEndpointAddress(url);
            call.setUseSOAPAction(true);
            call.setSOAPActionURI(soapActionURI);
            call.setOperationName(new QName(namespace, methodName));
            call.setEncodingStyle("UTF-8");
            call.addParameter(new QName(namespace, "requestXML"), javax.xml.rpc.encoding.XMLType.XSD_STRING,ParameterMode.IN);
            call.setReturnType(javax.xml.rpc.encoding.XMLType.XSD_STRING);
            Object[] objs = {requestxml};
            String resultString = (String)call.invoke(objs);
            log.info("resultString-xxxxxxxx:"+resultString);
            String charset= Encoding.confirmEncodingWay(resultString);
//            log.info("本次请求的url是:"+url+","+"namespace是:"+namespace+","+"methodName是:"+methodName+","+"请求参数是:"+requestxml);
            try {
                byte[] b = resultString.getBytes(charset);
                resultString = new String(b, "UTF-8");
            } catch (Exception e) {
//                log.error("输入的内容不属于常见的编码格式,请再仔细核实", e);
            }
            jsonObject=Transition.xmltoJson(resultString);
//            jsonString=jsonObject.toJSONString();
//            log.info("返回的xml数据转换为jsonStrirng的内容是:"+jsonObject.toJSONString());
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        Date date1=new Date();
         time +=(date1.getTime()-date.getTime());
        log.info("请求his，对方执行的时间为："+time);

        return jsonObject;
    }
}

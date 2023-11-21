package lynu.chaohl.SpringbootBaseTest.common.log;

//import com.wonders.AIWebApi.util.JacksonJsonUtils;
//import com.wonders.AIWebApi.util.StringUtils;
import lynu.chaohl.SpringbootBaseTest.utils.JacksonJsonUtils;
import lynu.chaohl.SpringbootBaseTest.utils.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.ibatis.session.SqlSession;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.Reader;
import java.io.StringReader;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * <p>
 *      记录日志, 打印控制台, 或记 log 文件
 * </p>
 * Date: 2021/6/22 <br>
 * Author: dingwei <br>
 */
@Aspect
@Component
public class OperationLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(OperationLogAspect.class);

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    //定义切点 @Pointcut
    //在注解的位置切入代码
    @Pointcut("@annotation(lynu.chaohl.SpringbootBaseTest.common.log.OperationLog)")
    public void logPointCut() {
    }

    //切面 配置通知
    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        OperationLog operationLog = methodSignature.getMethod().getAnnotation(OperationLog.class);
        String apiName = operationLog.apiName();

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        // 打印请求相关参数
        logger.info("================{}.{} Start ================", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        // 打印请求 url
        logger.info("URL            : {}", request.getRequestURL().toString());
        //备注
        logger.info("apiName        : {}", apiName);
        // 打印 Http method
        logger.info("HTTP Method    : {}", request.getMethod());
        // 打印调用 controller 的全路径以及执行方法
        logger.info("Class Method   : {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        // 打印请求入参
        logger.info("Request Args   : {}", JacksonJsonUtils.toJson(joinPoint.getArgs()));
    }

    /**
     * 环绕
     *
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
//    @Around("logPointCut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        OperationLog operationLog = methodSignature.getMethod().getAnnotation(OperationLog.class);
        String apiName = operationLog.apiName();

        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        // 打印请求 url
        logger.info("URL            : {}", request.getRequestURL().toString());
        // 打印 Http method
        logger.info("HTTP Method    : {}", request.getMethod());
        // 打印出参
        logger.info("Response Args  : {}", JacksonJsonUtils.toJson(result));
        //备注
        logger.info("apiName        : {}", apiName);
        // 执行耗时
        logger.info("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
        if(StringUtils.isNotBlank(apiName) && StringUtils.isNotNull(apiName)){
            Connection conn = null;
            Statement cs = null;
            try{
                String ipAddr = getIpAddr(request);
                SqlSession os = sqlSessionTemplate.getSqlSessionFactory().openSession();
                conn = os.getConnection();
                cs = conn.createStatement();
                String sql = "";
                sql ="insert into ope_log(url,chinese_remarks,request_way,param_in,ope_date,param_out,client_ip,user_name)values(?,?,?,?,NOW(),?,?,?)";
//                sql ="insert into ope_log(url,chinese_remarks,request_way,param_in,ope_date,param_out,client_ip)values(?,?,?,'default',NOW(),?,?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1,request.getRequestURL()+"");
                ps.setString(2,apiName);
                ps.setString(3,request.getMethod());
                Reader reader1 = new StringReader(JacksonJsonUtils.toJson(proceedingJoinPoint.getArgs()));
                ps.setCharacterStream(4,reader1);
                Reader reader2 = new StringReader(JacksonJsonUtils.toJson(result));
                ps.setCharacterStream(5,reader2);
                ps.setString(6,ipAddr);
                Object current_username= request.getSession().getAttribute("username");
                if (current_username!=null){
                    ps.setString(7,(String) current_username);
                }else {
                    ps.setString(7,"游客");
                }
//                if (request.getSession().getAttribute("current_username"))
//                ps.setString(7,request.getSession().getAttribute("loginId"));
//                HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
                System.out.println("request.getSession().getId():" + request.getSession().getId());
                System.out.println("request.getSession().loginId:" + request.getSession().getAttribute("loginId"));

                System.out.println(sql);
                ps.executeUpdate();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                cs.close();
                conn.close();
            }
        }
        return result;
    }

    /**
     * 后置
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
//    @AfterReturning("logPointCut()")
    public void doAfter(JoinPoint joinPoint) {
        logger.info("================{}.{} End ================", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
    }

    /**
     * 异常
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @AfterThrowing(value = "logPointCut()", throwing = "ex")
    public void exceptionLog(JoinPoint joinPoint, Exception ex) {
        logger.info("The method {}.{} occurs exception {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                ExceptionUtils.getStackTrace(ex));
    }


    public String getIpAddr(HttpServletRequest request){
        String ipAddress = request.getHeader("x-forwarded-for");
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){
                //根据网卡取本机配置的IP
                InetAddress inet=null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ipAddress= inet.getHostAddress();
            }
        }
        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if(ipAddress!=null && ipAddress.length()>15){
            if(ipAddress.indexOf(",")>0){
                ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }

}


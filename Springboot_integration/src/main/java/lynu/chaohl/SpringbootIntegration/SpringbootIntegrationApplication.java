package lynu.chaohl.SpringbootIntegration;

//import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
//@MapperScan("lynu.chaohl.SpringbootIntegration.ServerBaseDemo.mapper.**")
public class  SpringbootIntegrationApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootIntegrationApplication.class, args);
    }

}

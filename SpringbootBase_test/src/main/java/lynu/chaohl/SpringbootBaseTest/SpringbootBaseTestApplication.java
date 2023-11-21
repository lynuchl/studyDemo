package lynu.chaohl.SpringbootBaseTest;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class SpringbootBaseTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBaseTestApplication.class, args);
    }

}

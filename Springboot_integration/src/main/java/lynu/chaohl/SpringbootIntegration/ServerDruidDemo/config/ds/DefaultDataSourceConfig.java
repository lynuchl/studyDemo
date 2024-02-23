package lynu.chaohl.SpringbootIntegration.ServerDruidDemo.config.ds;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages ={DefaultDataSourceConfig.PACKAGE},   sqlSessionFactoryRef  = "defaultSqlSessionFactory")
public class DefaultDataSourceConfig {

    // 精确到 master 目录，以便跟其他数据源隔离
    static final String PACKAGE = "lynu.chaohl.SpringbootIntegration.ServerBaseDemo.**.mapper";
    static final String MAPPER_LOCATION = "classpath:mybatis/mapper/testMapper/*.xml";

//    @Value("${spring.datasource.default.url}")
//    private String url;
//
//    @Value("${spring.datasource.default.username}")
//    private String user;
//
//    @Value("${spring.datasource.default.password}")
//    private String password;
//
//    @Value("${spring.datasource.default.driverClassName}")
//    private String driverClass;

    @Bean(name = "defaultDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.default")
    public DataSource defaultDataSource() {

//        使用DruidDataSourceBuilder 启用druid连接池
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "defaultTransactionManager")
    @Primary
    public DataSourceTransactionManager defaultTransactionManager() {
        return new DataSourceTransactionManager(defaultDataSource());
    }

    @Bean(name = "defaultSqlSessionFactory")
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("defaultDataSource") DataSource defaultDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(defaultDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(DefaultDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }

    @Primary
    @Bean(name = "defaultSqlSessionTemplate")
    public SqlSessionTemplate ds1SqlSessionTemplate(@Qualifier("defaultSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }



}

package db;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Administrator on 2018/1/4.
 */
@Configuration //配置类
@MapperScan(basePackages = "com.test.dao") //指定dao层包地址
public class MybatisConfig {

    @Autowired
    private Environment environment;

    /**
     * 创建数据源
     */
    @Primary
    @Bean
    public DataSource createDateSource() throws Exception {
        Properties properties = new Properties();
        properties.put("driverClassName", environment.getProperty("jdbc.driverClassName"));
        properties.put("url", environment.getProperty("jdbc.url"));
        properties.put("username", environment.getProperty("jdbc.username"));
        properties.put("password", environment.getProperty("jdbc.password"));
        return DruidDataSourceFactory.createDataSource(properties);
    }

    @Bean
    public SqlSessionFactory sessionFactory(DataSource ds) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(ds);

        bean.setTypeAliasesPackage(environment.getProperty("mybatis.type-aliases-package"));
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(environment.getProperty("mybatis.mapper-locations")));

        return bean.getObject();
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }
}

package com.tdzx.user.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;


@Configuration
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
@MapperScan(basePackages = "user.dao",sqlSessionFactoryRef = "sqlSessionFactory" )
public class DataSourceConfig {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Environment environment;

    @Bean
    @Qualifier("dataSource")
    @Primary
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(environment.getProperty("druid.url"));
        dataSource.setUsername(environment.getProperty("druid.username"));
        dataSource.setPassword(environment.getProperty("druid.password"));
        dataSource.setInitialSize(Integer.parseInt(environment.getProperty("druid.initialSize")));
        dataSource.setMinIdle(Integer.parseInt(environment.getProperty("druid.minIdle")));
        dataSource.setMaxActive(Integer.parseInt(environment.getProperty("druid.maxActive")));
        dataSource.setTestOnBorrow(Boolean.parseBoolean(environment.getProperty("druid.testOnBorrow")));
        try {
            dataSource.init();
        } catch (SQLException e) {
            log.info("数据源创建出现异常!!!");
            throw new RuntimeException(e);
        }
        log.info("数据源创建成功!");
        return dataSource;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory primarySqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));
        factoryBean.setTypeAliasesPackage("com.szys.model");
        //factoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml"));
        //设置数据源分页插件
        final PaginationInterceptor pageInterceptor = new PaginationInterceptor();
        pageInterceptor.setDialectType("mysql");
        factoryBean.setPlugins(new Interceptor[]{pageInterceptor});
        log.info("sqlsession工厂创建成功!");
        return factoryBean.getObject();
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager primaryDataSourceTransactionManager(@Qualifier("dataSource") DataSource dataSource) {
        DataSourceTransactionManager tm = new DataSourceTransactionManager(dataSource);
        log.info("事务管理创建成功!");
        return tm;
    }


}

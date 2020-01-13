package com.shangde.uuid_job.executor.config.datasource;

//import com.alibaba.druid.pool.DruidDataSource;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.SimpleDbInterface;
import com.shawn.ss.lib.tools.db.impl.DbManager;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

/**
 * 功能描述：ent 主库
 *
 * @param
 * @author
 * @return
 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
 * @since 2018-11-08 10:33
 */
@Configuration
@EnableConfigurationProperties(ModelDbConfig.class)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class})
//@AutoConfigureAfter(ModelDbConfig.class)
public class DataSourceConfig {

    //    @Autowired
//    @Qualifier("dbModel")
    final ModelDbConfig config;
    //    DbManager userMaster;
    final GenericApplicationContext context;
    final ConfigurableListableBeanFactory beanFactory;

    public DataSourceConfig(ModelDbConfig config, GenericApplicationContext context) {
        this.config = config;
        this.context = context;
        beanFactory = context.getBeanFactory();
//        context.
        init();
    }

    //    @Bean
//    @ConfigurationProperties(prefix = "db.dbs")
//    public List<ModelCommonDbConnectionConfig> dbs() {
//        return new ArrayList<>();
//    }

    private void dataSourceCommonSetting(HikariConfig conf) {
        conf.setAutoCommit(true);
        final ModelCommonDbConfig cc = config.getConfig();
        conf.setConnectionTestQuery(cc.getConnectionTestQuery());
        conf.setDataSourceClassName(cc.getDataSouceClassName());
        conf.setIdleTimeout(cc.getIdleTimeout());
        conf.setConnectionTimeout(cc.getTimeout());
        conf.setMaximumPoolSize(cc.getMaximumPoolSize());
        conf.setMaxLifetime(cc.getMaxLifetime());
//        conf.setPoolName(cc.get);
    }

    //    @PostConstruct
    public void init() {
        final List<ModelCommonDbConnectionConfig> dbs = config.getDbs();
        for (ModelCommonDbConnectionConfig db : dbs) {
            HikariConfig conf = new HikariConfig();
            dataSourceCommonSetting(conf);
            conf.setDataSourceProperties(db.toProperties());
            conf.setPoolName(db.getName());
            HikariDataSource dataSource = new HikariDataSource(conf);
//            beanFactory.createBean()
            beanFactory.registerSingleton(db.getName() + "-ds", dataSource);
            beanFactory.registerSingleton(db.getName(), new DbManager(dataSource));
//            final BeanFactory parentBeanFactory = context.getParentBeanFactory();
//            parentBeanFactory
        }
//        Gson gson= new GsonBuilder()
//                .setDateFormat(DateTimeHelper.DEFUALT_FORMAT.getFormat())
//                .disableHtmlEscaping().create();
//        config=gson.fromJson(new InputStreamReader(this.getClass().getResourceAsStream("/dbConfig.json")), ModelDbConfig.class);
    }

    /**
     * 配置数据数据源 master
     *
     * @return
     */
//    @Bean(name = "entUserMasterDatasource")
//    @Primary
//    public DataSource userMasterDatasource() {
//        HikariConfig conf=new HikariConfig();
//        dataSourceCommonSetting(conf);
//        ModelCommonDbConnectionConfig connectionConfig = config.getDbs().get(0);
//        conf.setDataSourceProperties(connectionConfig.toProperties());
//        conf.setPoolName(connectionConfig.getName());
//        HikariDataSource dataSource=new HikariDataSource(conf);
//        return dataSource;
//    }
//
////    @Bean(name = "entUserSlaveDatasource")
////    @Primary
//    public DataSource shoppingMasterDatasource() {
//        HikariConfig conf=new HikariConfig();
//        dataSourceCommonSetting(conf);
//        ModelCommonDbConnectionConfig connectionConfig = config.getDbs().get(1);
//        conf.setDataSourceProperties(connectionConfig.toProperties());
//        conf.setPoolName(connectionConfig.getName());
//        HikariDataSource dataSource=new HikariDataSource(conf);
//        return dataSource;
//    }
//
////    @Bean(name = "entLogMasterDatasource")
////    @Primary
//    public DataSource logMasterDatasource() {
//        HikariConfig conf=new HikariConfig();
//        dataSourceCommonSetting(conf);
//        ModelCommonDbConnectionConfig connectionConfig = config.getDbs().get(2);
//        conf.setDataSourceProperties(connectionConfig.toProperties());
//        conf.setPoolName(connectionConfig.getName());
//        HikariDataSource dataSource=new HikariDataSource(conf);
//        return dataSource;
//    }

//    @Bean(name="ucenter_statistic")
//    @Primary
//    public SimpleDbInterface userDBInterface(@Qualifier("entLogMasterDatasource") DataSource dataSource){
//        return new DbManager(dataSource);
//    }
//
//    @Bean(name="ent_portal_slave")
//    @Primary
//    public SimpleDbInterface shoppingDBInterface(@Qualifier("entUserSlaveDatasource") DataSource dataSource){
//        return new DbManager(dataSource);
//    }
//
//    @Bean(name="ent_portal")
//    @Primary
//    public SimpleDbInterface logDbInterface(@Qualifier("entUserMasterDatasource") DataSource dataSource){
//        return new DbManager(dataSource);
//    }

    /**
     * 配置事务管理器
     * <p>
     * //@param dataSource
     *
     * @return
     */
//    @Bean(name = "entMasterTransactionManger")
//    @Primary
//    public DataSourceTransactionManager masterTransactionManger(@Qualifier("entUserMasterDatasource") DataSource dataSource) {
//
//        return new DataSourceTransactionManager(dataSource);
//
//    }
    public ModelDbConfig getConfig() {
        return config;
    }

    //    public DataSourceConfig setConfig(ModelDbConfig config) {
//        this.config = config;
//        return this;
//    }
}
/**
 * Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'authInterceptor': Unsatisfied dependency expressed through field 'recordService'; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'recordService': Unsatisfied dependency expressed through field 'daoAcUserActionBase'; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'DAOAcUserActionBase': Unsatisfied dependency expressed through field 'db'; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'c_user_action' defined in class path resource [com/shawn_works/shopping/config/datasource/DataSourceConfig.class]: Unsatisfied dependency expressed through method 'userDBInterface' parameter 0; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entLogMasterDatasource' defined in class path resource [com/shawn_works/shopping/config/datasource/DataSourceConfig.class]: Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [javax.sql.DataSource]: Factory method 'logMasterDatasource' threw exception; nested exception is com.zaxxer.hikari.pool.HikariPool$PoolInitializationException: Failed to initialize pool: Communications link failure
 * <p>
 * The last packet sent successfully to the server was 0 milliseconds ago. The driver has not received any packets from the server.
 */

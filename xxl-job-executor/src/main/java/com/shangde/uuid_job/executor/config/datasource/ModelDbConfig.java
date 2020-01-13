package com.shangde.uuid_job.executor.config.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

//@PropertySource("classpath:dbConfig.yml")
@ConfigurationProperties(prefix = "db")
//@Configuration("dbModel")
//@Component
public class ModelDbConfig {
    ModelCommonDbConfig config;
    List<ModelCommonDbConnectionConfig> dbs;

    public ModelCommonDbConfig getConfig() {
        return config;
    }

    public ModelDbConfig setConfig(ModelCommonDbConfig config) {
        this.config = config;
        return this;
    }

    public List<ModelCommonDbConnectionConfig> getDbs() {
        return dbs;
    }

    public ModelDbConfig setDbs(List<ModelCommonDbConnectionConfig> dbs) {
        this.dbs = dbs;
        return this;
    }
}

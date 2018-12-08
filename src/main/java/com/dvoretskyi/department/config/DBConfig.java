package com.dvoretskyi.department.config;


import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * The type Db config.
 */
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
public class DBConfig {

  @Autowired
  private Environment env;

  /**
   * Gets data source.
   *
   * @return the data source
   */
  @Bean(destroyMethod = "")
  public DataSource getDataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName(env.getProperty("database.driverClassName"));
    dataSource.setUrl(env.getProperty("database.url"));
    dataSource.setUsername(env.getProperty("database.username"));
    dataSource.setPassword(env.getProperty("database.password"));
    return dataSource;
  }

  /**
   * Jdbc template jdbc template.
   *
   * @return the jdbc template
   */
  @Bean
  public JdbcTemplate jdbcTemplate() {
    return new JdbcTemplate(getDataSource());
  }

  /**
   * Tx manager platform transaction manager.
   *
   * @return the platform transaction manager
   */
  @Bean(name = "transactionManager")
  public PlatformTransactionManager txManager() {
    DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(
        getDataSource());
    return transactionManager;
  }
}

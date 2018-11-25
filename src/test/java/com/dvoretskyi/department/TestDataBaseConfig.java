package com.dvoretskyi.department;

//@Configuration
public class TestDataBaseConfig {
 /* @Primary
  @Bean
  public EmbeddedDatabase testDataSource() {
    return new EmbeddedDatabaseBuilder()
        .setType(EmbeddedDatabaseType.H2)
        .build();
  }
*/
 /* @Primary
  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(dataSource);
    em.setPackagesToScan("com.softserve.academy.spaced.repetition.domain");

    // drop-and-create database
    Properties jpaProperties = new Properties();
    jpaProperties.put("javax.persistence.schema-generation.database.action", "drop-and-create");
    em.setJpaProperties(jpaProperties);

    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    vendorAdapter.setDatabasePlatform("org.hibernate.dialect.H2Dialect");
    vendorAdapter.setShowSql(false);
    em.setJpaVendorAdapter(vendorAdapter);

    em.afterPropertiesSet();
    return em;*/
  //}
}

package com.dvoretskyi.department;

//@Configuration
public class TestDataBaseConfig {

 /* private EmbeddedDatabase database;
  private EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl();


  @Before
  public void setUp() {
    database = new EmbeddedDatabaseBuilder()
        .setType(EmbeddedDatabaseType.H2)
        .addScript("employee.sql")
        .addScript("init.sql")
        .build();
    employeeRepository.jdbcTemplate = new JdbcTemplate(database);
  }

  @Test
  public void creatingIncrementsSize() {
   Employee employee = new Employee("huhu", true);

    int initialCount = employeeRepository.findAllEmployees();
    eventDao.createEvent(e);
    assertThat(eventDao.findNumberOfEvents(), is(initialCount + 1));
  }

  @Test
  public void deletingDecrementsSize() {
    Event e = new Event(1, "Poker Night");

    int initialCount = eventDao.findNumberOfEvents();
    eventDao.deleteEvent(e);
    assertThat(eventDao.findNumberOfEvents(), is(initialCount - 1));
  }

  @Test
  public void createdEventCanBeFound() {
    eventDao.createEvent(new Event(9, "Company Softball Game"));
    Event e = eventDao.findEventById(9);
    assertThat(e.getId(), is(9));
    assertThat(e.getName(), is("Company Softball Game"));
  }

  @Test
  public void updatesToCreatedEventCanBeRead() {
    eventDao.createEvent(new Event(9, "Company Softball Game"));
    Event e = eventDao.findEventById(9);
    e.setName("Cricket Game");
    eventDao.updateEvent(e);
    e = eventDao.findEventById(9);
    assertThat(e.getId(), is(9));
    assertThat(e.getName(), is("Cricket Game"));
  }

  @Test(expected=EventExistsException.class)
  public void creatingDuplicateEventThrowsException() {
    eventDao.createEvent(new Event(1, "Id1WasAlreadyUsed"));
  }

  @Test(expected=NoSuchEventException.class)
  public void updatingNonExistentEventThrowsException() {
    eventDao.updateEvent(new Event(1000, "Unknown"));
  }

  @Test(expected=NoSuchEventException.class)
  public void deletingNonExistentEventThrowsException() {
    eventDao.deleteEvent(new Event(1000, "Unknown"));
  }

  @Test(expected=NoSuchEventException.class)
  public void findingNonExistentEventThrowsException() {
    eventDao.findEventById(1000);
  }

  @Test
  public void countOfInitialDataSetIsAsExpected() {
    assertThat(eventDao.findNumberOfEvents(), is(8));
  }

*/


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

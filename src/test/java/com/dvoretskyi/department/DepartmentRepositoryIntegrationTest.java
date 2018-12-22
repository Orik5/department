package com.dvoretskyi.department;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.dvoretskyi.department.entity.Employee;
import com.dvoretskyi.department.repository.impl.DepartmentRepositoryImpl;
import com.dvoretskyi.department.repository.impl.EmployeeRepositoryImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DepartmentRepositoryIntegrationTest {

 /* @Autowired
  private TestEntityManager entityManager;
*/
  @Autowired
  private DepartmentRepositoryImpl departmentRepository;
  @Autowired
  private EmployeeRepositoryImpl employeeRepository;

  @Test
  public void whenInvalidId_thenReturnNull() {
    Employee fromDb = employeeRepository.findEmployeeById((long) -111);
    assertThat(fromDb).isNull();
  }

 /* @Test
  public void whenInvalidName_thenReturnNull() {
   Employee fromDb = employeeRepository("");
    assertThat(fromDb).isNull();
  }*/

/*
  @Test
  public void whenFindBySecondName_thenReturnHuman() {
    // given
    Human human = new Human(1, null, null, null, null);
    entityManager.persist(human);
    entityManager.flush();

    // when
    Human found = humanRepository.findBySecondName(human.getSecondName());

    // then
    assertThat(found.getSecondName())
        .isEqualTo(human.getSecondName());
  }
*/

 /* @Test
  public void whenFindById_thenReturnEmployee() {
    Human human = new Human(2, null, null, null, null);
    entityManager.persistAndFlush(human);

    Human fromDb = humanRepository.findById(human.getId()).orElse(null);
    assertThat(fromDb.getSecondName()).isEqualTo(human.getSecondName());
  }*/
  /*@Test
  public void givenSetOfEmployees_whenFindAll_thenReturnAllEmployees() {
    Human alex = new Human(1, null, null, "", "");
    Human ron = new Human(2, "", "ron", "", "");
    Human bob = new Human(3, "", "bob", "", "");

    entityManager.persist(alex);
    entityManager.persist(bob);
    entityManager.persist(ron);
    entityManager.flush();

    List<Human> allEmployees = humanRepository.findAll();

    assertThat(allEmployees).hasSize(3).extracting(Human::getSecondName)
        .containsOnly(alex.getSecondName(), ron.getSecondName(), bob.getSecondName());
  }*/
}

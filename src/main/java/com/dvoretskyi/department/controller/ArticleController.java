package com.dvoretskyi.department.controller;


import org.springframework.web.bind.annotation.RequestMapping;


//@RestController
@RequestMapping("/user")
public class ArticleController {
	/*@Autowired
	private EmployeeServiceImpl employeeService;
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getArticleById(@PathVariable("id") long id) {
		Employee employee = employeeService.findEmployeeById(id);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllArticles() {
		List<Employee> list = employeeService.findAllEmployees();
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}
*//*	@PostMapping("/articles")
	public ResponseEntity<Void> addArticle(@RequestBody Employee employee, UriComponentsBuilder builder) {
        boolean flag = employeeService.saveEmployee(employee);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{id}").buildAndExpand(article.getArticleId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}*//*
*//*	@PutMapping("/articles")
	public ResponseEntity<Employee> updateArticle(@RequestBody Employee employee) {
		employeeService.editEmployee(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}*//*
	@DeleteMapping("/articles/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		employeeService.deleteEmployeeById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	*/
} 
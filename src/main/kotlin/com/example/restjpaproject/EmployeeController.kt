package com.example.restjpaproject

import org.springframework.web.bind.annotation.*

@RestController
class EmployeeController(val repository: EmployeeRepository) {

    // Aggregate root

    @GetMapping("/employees")
    fun all() = repository.findAll()

    @PostMapping("/employees")
    fun newEmployee(@RequestBody newEmployee: Employee) = repository.save(newEmployee)

    // Single item

    @GetMapping("/employees/{id}")
    fun one(@PathVariable id:Long) = repository.findById(id).orElseThrow {
        EmployeeNotFoundException(id)
    }

    @PutMapping("/employees/{id}")
    fun replaceEmployee(@RequestBody newEmployee: Employee, @PathVariable id: Long): Employee {
        return repository.findById(id)
                .map { employee ->
                    employee.name = newEmployee.name
                    employee.role = newEmployee.role
                    repository.save(employee)
                }
                .orElseGet {
                    newEmployee.id = id
                    repository.save(newEmployee)
                }
    }

    @DeleteMapping("/employees/{id}")
    fun deleteEmployee(@PathVariable id: Long) = repository.deleteById(id)

}
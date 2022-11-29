package kg.megacom.springEmployee.controllers;

import kg.megacom.springEmployee.models.Account;
import kg.megacom.springEmployee.models.Employee;
import kg.megacom.springEmployee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/save")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @GetMapping("/get/{id}")
    public Optional<Employee> getEmployee(@PathVariable("id")Long id){
        return employeeService.findById(id);
    }

    @GetMapping("/get")
    public List<Employee> getAllEmployee(){
        return employeeService.findAll();
    }
}

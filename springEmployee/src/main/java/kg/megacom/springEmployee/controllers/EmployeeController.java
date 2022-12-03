package kg.megacom.springEmployee.controllers;

import kg.megacom.springEmployee.models.Account;
import kg.megacom.springEmployee.models.Employee;
import kg.megacom.springEmployee.models.dtos.EmployeeDto;
import kg.megacom.springEmployee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> saveEmployee(@RequestBody EmployeeDto employeeDto){
        try{
            return ResponseEntity.ok(employeeService.save(employeeDto));
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.I_AM_A_TEAPOT);
        }

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable("id")Long id){
        try {
            return ResponseEntity.ok(employeeService.findById(id));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }

//    @GetMapping("/get")
//    public List<Employee> getAllEmployee(){
//        return employeeService.findAll();
//    }
}

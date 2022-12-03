package kg.megacom.springEmployee.controllers;

import kg.megacom.springEmployee.models.Employee;
import kg.megacom.springEmployee.models.Phone;
import kg.megacom.springEmployee.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/phone")
public class PhoneController {

    private final PhoneService phoneService;

    @Autowired
    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @PostMapping("/save")
    public Phone savePhone(@RequestBody Phone phone){
        return phoneService.save(phone);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getPhone(@PathVariable("id")Long id){
        try{
            return ResponseEntity.ok(phoneService.findById(id));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }

    }

    @GetMapping("/get")
    public List<Phone> getAllPhone(){
        return phoneService.findAll();
    }
}

package kg.megacom.springEmployee.controllers;

import kg.megacom.springEmployee.models.Employee;
import kg.megacom.springEmployee.models.Phone;
import kg.megacom.springEmployee.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Optional<Phone> getPhone(@PathVariable("id")Long id){
        return phoneService.findById(id);
    }

    @GetMapping("/get")
    public List<Phone> getAllPhone(){
        return phoneService.findAll();
    }
}

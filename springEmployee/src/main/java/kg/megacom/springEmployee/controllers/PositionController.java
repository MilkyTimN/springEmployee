package kg.megacom.springEmployee.controllers;

import kg.megacom.springEmployee.models.Phone;
import kg.megacom.springEmployee.models.Position;
import kg.megacom.springEmployee.models.dtos.PositionDto;
import kg.megacom.springEmployee.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/position")
public class PositionController {

    private final PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> savePosition(@RequestBody PositionDto positionDto){
        try{
            return ResponseEntity.ok(positionService.save(positionDto));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getPosition(@PathVariable("id")Long id){
        try {
            return ResponseEntity.ok(positionService.findById(id));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }

//    @GetMapping("/get")
//    public List<Position> getAllPosition(){
//        return positionService.findAll();
//    }
}

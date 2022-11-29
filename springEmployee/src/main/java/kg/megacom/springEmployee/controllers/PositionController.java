package kg.megacom.springEmployee.controllers;

import kg.megacom.springEmployee.models.Phone;
import kg.megacom.springEmployee.models.Position;
import kg.megacom.springEmployee.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Position savePosition(@RequestBody Position position){
        return positionService.save(position);
    }

    @GetMapping("/get/{id}")
    public Optional<Position> getPosition(@PathVariable("id")Long id){
        return positionService.findById(id);
    }

    @GetMapping("/get")
    public List<Position> getAllPosition(){
        return positionService.findAll();
    }
}

package nl.novi.techiteasy.controllers;

import nl.novi.techiteasy.dtos.TelevisionInputDto;
import nl.novi.techiteasy.dtos.TelevisionResponseDto;
import nl.novi.techiteasy.services.TelevisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionService televisionService;

    public TelevisionController(TelevisionService televisionService){
        this.televisionService = televisionService;
    }

    @GetMapping
    public ResponseEntity<List<TelevisionResponseDto>> getAllTelevisions(@RequestParam(value = "brand", required = false) String brand) {
        return ResponseEntity.ok(televisionService.getTelevisions(brand));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelevisionResponseDto> getTelevisionById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(televisionService.getTelevisionById(id));
    }

    @PostMapping
    public ResponseEntity<TelevisionResponseDto> addTelevision(@RequestBody TelevisionInputDto newTelevision) {
        return ResponseEntity.created(null).body(televisionService.addTelevision(newTelevision));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelevisionResponseDto> updateTelevision(@PathVariable Long id, @RequestBody TelevisionInputDto newTelevision) {
        return ResponseEntity.ok(televisionService.updateTelevision(id, newTelevision));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TelevisionResponseDto> partialUpdateTelevision(@PathVariable Long id, @RequestBody TelevisionInputDto newTelevision) {
        return ResponseEntity.ok(televisionService.partialUpdateTelevision(id, newTelevision));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelevisionById(@PathVariable Long id) {
        televisionService.deleteTelevision(id);
        return ResponseEntity.noContent().build();
    }
}

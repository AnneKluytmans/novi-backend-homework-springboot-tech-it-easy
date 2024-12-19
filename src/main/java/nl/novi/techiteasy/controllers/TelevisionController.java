package nl.novi.techiteasy.controllers;

import jakarta.validation.Valid;
import nl.novi.techiteasy.dtos.*;
import nl.novi.techiteasy.services.TelevisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
    public ResponseEntity<List<TelevisionResponseDTO>> getAllTelevisions(@RequestParam(value = "brand", required = false) String brand) {
        return ResponseEntity.ok(televisionService.getTelevisions(brand));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelevisionResponseDTO> getTelevisionById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(televisionService.getTelevisionById(id));
    }

    @PostMapping
    public ResponseEntity<?> addTelevision(@Valid @RequestBody TelevisionCreateDTO newTelevision, BindingResult result) {
        if(result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        return ResponseEntity.created(null).body(televisionService.addTelevision(newTelevision));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTelevision(@PathVariable Long id, @Valid @RequestBody TelevisionUpdateDTO updateDto,
                                              BindingResult result) {
        if(result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        return ResponseEntity.ok(televisionService.updateTelevision(id, updateDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> partialUpdateTelevision(@PathVariable Long id, @Valid @RequestBody TelevisionPatchDTO patchDto,
                                                     BindingResult result) {
        if(result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        return ResponseEntity.ok(televisionService.partialUpdateTelevision(id, patchDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelevisionById(@PathVariable Long id) {
        televisionService.deleteTelevision(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/sales")
    public ResponseEntity<List<SalesInfoResponseDTO>> getSalesInfo() {
        return ResponseEntity.ok(televisionService.getSalesInfo());
    }
}

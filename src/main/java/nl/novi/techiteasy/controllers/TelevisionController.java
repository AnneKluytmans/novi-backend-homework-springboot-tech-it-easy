package nl.novi.techiteasy.controllers;

import jakarta.validation.Valid;
import nl.novi.techiteasy.dtos.SalesInfoDto;
import nl.novi.techiteasy.dtos.TelevisionInputDto;
import nl.novi.techiteasy.dtos.TelevisionDto;
import nl.novi.techiteasy.dtos.TelevisionPatchDto;
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
    public ResponseEntity<List<TelevisionDto>> getAllTelevisions(@RequestParam(value = "brand", required = false) String brand) {
        return ResponseEntity.ok(televisionService.getTelevisions(brand));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelevisionDto> getTelevisionById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(televisionService.getTelevisionById(id));
    }

    @PostMapping
    public ResponseEntity<?> addTelevision(@Valid @RequestBody TelevisionInputDto newTelevision, BindingResult result) {
        if(result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        return ResponseEntity.created(null).body(televisionService.addTelevision(newTelevision));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTelevision(@PathVariable Long id, @Valid @RequestBody TelevisionInputDto inputDto,
                                              BindingResult result) {
        if(result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        return ResponseEntity.ok(televisionService.updateTelevision(id, inputDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> partialUpdateTelevision(@PathVariable Long id, @Valid @RequestBody TelevisionPatchDto patchDto,
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
    public ResponseEntity<List<SalesInfoDto>> getSalesInfo() {
        return ResponseEntity.ok(televisionService.getSalesInfo());
    }
}

package nl.novi.techiteasy.controllers;

import nl.novi.techiteasy.exceptions.InvalidTelevisionNameException;
import nl.novi.techiteasy.exceptions.RecordNotFoundException;
import nl.novi.techiteasy.models.Television;
import nl.novi.techiteasy.repositories.TelevisionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionRepository televisionRepository;

    public TelevisionController(TelevisionRepository televisionRepository){
        this.televisionRepository = televisionRepository;
    }

    @GetMapping
    public ResponseEntity<List<Television>> getAllTelevisions(@RequestParam(value = "brand", required = false) String brand) {
        List<Television> televisions;

        if (brand == null) {
            televisions = televisionRepository.findAll();
        } else {
            televisions = televisionRepository.findByBrandIgnoreCase(brand);
        }
        return ResponseEntity.ok(televisions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Television> getTelevisionById(@PathVariable("id") Long id) {
        Optional<Television> television = televisionRepository.findById(id);

        if (television.isPresent()) {
            return ResponseEntity.ok(television.get());
        } else {
            throw new RecordNotFoundException("Television with id \"" + id + "\" not found.");
        }
    }

    @PostMapping
    public ResponseEntity<Television> addTelevision(@RequestBody Television television) {
        if (television.getName().length() > 20) {
            throw new InvalidTelevisionNameException("Television name may not exceed 20 characters");
        } else {
            Television newTelevision = televisionRepository.save(television);
            return ResponseEntity.created(null).body(newTelevision);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Television> updateTelevision(@PathVariable Long id, @RequestBody Television newTelevision) {
        Optional<Television> existingTelevision = televisionRepository.findById(id);

        if (existingTelevision.isPresent()) {
            Television updatedTelevision = existingTelevision.get();
            updatedTelevision.setType(newTelevision.getType());
            updatedTelevision.setBrand(newTelevision.getBrand());
            updatedTelevision.setName(newTelevision.getName());
            updatedTelevision.setPrice(newTelevision.getPrice());
            updatedTelevision.setAvailableSize(newTelevision.getAvailableSize());
            updatedTelevision.setRefreshRate(newTelevision.getRefreshRate());
            updatedTelevision.setScreenType(newTelevision.getScreenType());
            updatedTelevision.setScreenQuality(newTelevision.getScreenQuality());
            updatedTelevision.setSmartTv(newTelevision.getSmartTv());
            updatedTelevision.setWifi(newTelevision.getWifi());
            updatedTelevision.setVoiceControl(newTelevision.getVoiceControl());
            updatedTelevision.setHdr(newTelevision.getHdr());
            updatedTelevision.setBluetooth(newTelevision.getBluetooth());
            updatedTelevision.setAmbiLight(newTelevision.getAmbiLight());
            updatedTelevision.setOriginalStock(newTelevision.getOriginalStock());
            updatedTelevision.setSold(newTelevision.getSold());
            updatedTelevision.setSaleDate(newTelevision.getSaleDate());
            televisionRepository.save(updatedTelevision);
            return ResponseEntity.ok(updatedTelevision);
        } else {
            throw new RecordNotFoundException("Television with id \"" + id + "\" not found.");
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Television> partialUpdateTelevision(@PathVariable Long id, @RequestBody Television newTelevision) {
        Optional<Television> existingTelevision = televisionRepository.findById(id);

        if (existingTelevision.isPresent()) {
            Television updatedTelevision = existingTelevision.get();
            if (newTelevision.getType() != null) {
                updatedTelevision.setType(newTelevision.getType());
            }
            if (newTelevision.getBrand() != null) {
                updatedTelevision.setBrand(newTelevision.getBrand());
            }
            if (newTelevision.getName() != null) {
                if (newTelevision.getName().length() > 20) {
                    throw new InvalidTelevisionNameException("Television name may not exceed 20 characters");
                }
                updatedTelevision.setName(newTelevision.getName());
            }
            if (newTelevision.getPrice() != null) {
                updatedTelevision.setPrice(newTelevision.getPrice());
            }
            if (newTelevision.getAvailableSize() != null) {
                updatedTelevision.setAvailableSize(newTelevision.getAvailableSize());
            }
            if (newTelevision.getRefreshRate() != null) {
                updatedTelevision.setRefreshRate(newTelevision.getRefreshRate());
            }
            if (newTelevision.getScreenType() != null) {
                updatedTelevision.setScreenType(newTelevision.getScreenType());
            }
            if (newTelevision.getScreenQuality() != null) {
                updatedTelevision.setScreenQuality(newTelevision.getScreenQuality());
            }
            if (newTelevision.getSmartTv() != null) {
                updatedTelevision.setSmartTv(newTelevision.getSmartTv());
            }
            if (newTelevision.getWifi() != null) {
                updatedTelevision.setWifi(newTelevision.getWifi());
            }
            if (newTelevision.getVoiceControl() != null) {
                updatedTelevision.setVoiceControl(newTelevision.getVoiceControl());
            }
            if (newTelevision.getHdr() != null) {
                updatedTelevision.setHdr(newTelevision.getHdr());
            }
            if (newTelevision.getBluetooth() != null) {
                updatedTelevision.setBluetooth(newTelevision.getBluetooth());
            }
            if (newTelevision.getAmbiLight() != null) {
                updatedTelevision.setAmbiLight(newTelevision.getAmbiLight());
            }
            if (newTelevision.getOriginalStock() != null) {
                updatedTelevision.setOriginalStock(newTelevision.getOriginalStock());
            }
            if (newTelevision.getSold() != null) {
                updatedTelevision.setSold(newTelevision.getSold());
            }
            if (newTelevision.getSaleDate() != null) {
                updatedTelevision.setSaleDate(newTelevision.getSaleDate());
            }
            televisionRepository.save(updatedTelevision);
            return ResponseEntity.ok(updatedTelevision);
        } else {
            throw new RecordNotFoundException("Television with id \"" + id + "\" not found.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelevisionById(@PathVariable Long id) {
        if (televisionRepository.existsById(id)) {
            televisionRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new RecordNotFoundException("Television with id \"" + id + "\" not found.");
        }
    }
}

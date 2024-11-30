package nl.novi.techiteasy.controllers;

import nl.novi.techiteasy.exceptions.InvalidTelevisionNameException;
import nl.novi.techiteasy.exceptions.RecordNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final List<String> televisionDatabase = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<String>> getAllTelevisions() {
        return ResponseEntity.ok(televisionDatabase);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getTelevisionById(@PathVariable("id") int id) {
        if (id >= televisionDatabase.size()) {
            throw new RecordNotFoundException("Television with id \"" + id + "\" not found.");
        } else {
            return ResponseEntity.ok(televisionDatabase.get(id));
        }
    }

    @PostMapping
    public ResponseEntity<String> addTelevision(@RequestBody String television) {
        if (television.length() > 20) {
            throw new InvalidTelevisionNameException("Television name may not exceed 20 characters");
        } else {
            televisionDatabase.add(television);
            return ResponseEntity.created(null).body("Television added: " + television);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTelevisionById(@PathVariable int id, @RequestBody String television) {
        if (id >= televisionDatabase.size()) {
            throw new RecordNotFoundException("Television with id \"" + id + "\" not found.");
        } else {
            televisionDatabase.set(id, television);
            return ResponseEntity.ok("Updated television (id: " + id + ") : " + television);
            //of
//            return ResponseEntity.noContent().build();
            //welke van de twee is beter?
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelevisionById(@PathVariable int id) {
        if (id >= televisionDatabase.size()) {
            throw new RecordNotFoundException("Television with id \"" + id + "\" not found.");
        } else {
            televisionDatabase.set(id, null);
            return ResponseEntity.noContent().build();
        }
    }
}

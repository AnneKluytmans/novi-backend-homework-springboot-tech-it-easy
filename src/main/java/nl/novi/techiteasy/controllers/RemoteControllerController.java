package nl.novi.techiteasy.controllers;

import jakarta.validation.Valid;
import nl.novi.techiteasy.dtos.RemoteControllerCreateDTO;
import nl.novi.techiteasy.dtos.RemoteControllerPatchDTO;
import nl.novi.techiteasy.dtos.RemoteControllerResponseDTO;
import nl.novi.techiteasy.dtos.RemoteControllerUpdateDTO;
import nl.novi.techiteasy.services.RemoteControllerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/televisions/{televisionId}/remote-controllers")
public class RemoteControllerController {

    private final RemoteControllerService remoteControllerService;

    public RemoteControllerController(RemoteControllerService remoteControllerService) {
        this.remoteControllerService = remoteControllerService;
    }

    @GetMapping("/{remoteControllerId}")
    public ResponseEntity<RemoteControllerResponseDTO> getRemoteControllerById(
            @PathVariable("televisionId") Long televisionId,
            @PathVariable("remoteControllerId") Long remoteControllerId) {
        return ResponseEntity.ok(remoteControllerService.getRemoteControllerById(televisionId, remoteControllerId));
    }

    @PostMapping
    public ResponseEntity<?> addRemoteController(
            @PathVariable("televisionId") Long televisionId,
            @Valid @RequestBody RemoteControllerCreateDTO newRemoteController,
            BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        RemoteControllerResponseDTO createdRemoteController =
                remoteControllerService.addRemoteController(televisionId, newRemoteController);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRemoteController);
    }

    @PutMapping("/{remoteControllerId}")
    public ResponseEntity<?> updateRemoteController(
            @PathVariable("televisionId") Long televisionId,
            @PathVariable("remoteControllerId") Long remoteControllerId,
            @Valid @RequestBody RemoteControllerUpdateDTO updateDTO,
            BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        RemoteControllerResponseDTO updatedRemoteController =
                remoteControllerService.updateRemoteController(televisionId, remoteControllerId, updateDTO);
        return ResponseEntity.ok(updatedRemoteController);
    }

    @PatchMapping("/{remoteControllerId}")
    public ResponseEntity<?> partialUpdateRemoteController(
            @PathVariable("televisionId") Long televisionId,
            @PathVariable("remoteControllerId") Long remoteControllerId,
            @Valid @RequestBody RemoteControllerPatchDTO patchDTO,
            BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        RemoteControllerResponseDTO partiallyUpdatedRemoteController =
                remoteControllerService.partialUpdateRemoteController(televisionId, remoteControllerId, patchDTO);
        return ResponseEntity.ok(partiallyUpdatedRemoteController);
    }

    @DeleteMapping("/{remoteControllerId}")
    public ResponseEntity<Void> deleteRemoteController(
            @PathVariable("televisionId") Long televisionId,
            @PathVariable("remoteControllerId") Long remoteControllerId) {
        remoteControllerService.deleteRemoteController(televisionId, remoteControllerId);
        return ResponseEntity.noContent().build();
    }

}
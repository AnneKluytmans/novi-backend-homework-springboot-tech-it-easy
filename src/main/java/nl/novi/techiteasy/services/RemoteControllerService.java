package nl.novi.techiteasy.services;

import nl.novi.techiteasy.dtos.RemoteControllerCreateDTO;
import nl.novi.techiteasy.dtos.RemoteControllerPatchDTO;
import nl.novi.techiteasy.dtos.RemoteControllerResponseDTO;
import nl.novi.techiteasy.dtos.RemoteControllerUpdateDTO;
import nl.novi.techiteasy.exceptions.RecordNotFoundException;
import nl.novi.techiteasy.mappers.RemoteControllerMapper;
import nl.novi.techiteasy.models.RemoteController;
import nl.novi.techiteasy.models.Television;
import nl.novi.techiteasy.repositories.RemoteControllerRepository;
import nl.novi.techiteasy.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemoteControllerService {

    private final RemoteControllerRepository remoteControllerRepository;
    private final TelevisionRepository televisionRepository;

    public RemoteControllerService(RemoteControllerRepository remoteControllerRepository, TelevisionRepository televisionRepository) {
        this.remoteControllerRepository = remoteControllerRepository;
        this.televisionRepository = televisionRepository;
    }

    public RemoteControllerResponseDTO getRemoteControllerById(Long televisionId, Long remoteControllerId) {
        RemoteController remoteController = remoteControllerRepository.findByIdAndTelevisionId(remoteControllerId, televisionId)
                .orElseThrow(() -> new RecordNotFoundException("Remote Controller with ID " + remoteControllerId + " not found"));
        return RemoteControllerMapper.toDTO(remoteController);
    }


    public RemoteControllerResponseDTO addRemoteController(Long televisionId, RemoteControllerCreateDTO createDto) {
        Television television = televisionRepository.findById(televisionId)
                .orElseThrow(() -> new RecordNotFoundException("Television with ID " + televisionId + " not found"));

        RemoteController remoteController = RemoteControllerMapper.toEntity(createDto);
        remoteController.setTelevision(television);

        RemoteController savedRemoteController = remoteControllerRepository.save(remoteController);
        return RemoteControllerMapper.toDTO(savedRemoteController);
    }


    public RemoteControllerResponseDTO updateRemoteController(Long televisionId, Long remoteControllerId,
                                                              RemoteControllerUpdateDTO updateDTO) {
        RemoteController remoteController = remoteControllerRepository.findById(remoteControllerId)
                .orElseThrow(() -> new RecordNotFoundException("Remote Controller with ID " + remoteControllerId + " not found"));

        Television television = televisionRepository.findById(televisionId)
                        .orElseThrow(() -> new RecordNotFoundException("Television with ID " + televisionId + " not found"));

        remoteController.setBrand(updateDTO.getBrand());
        remoteController.setName(updateDTO.getName());
        remoteController.setPrice(updateDTO.getPrice());
        remoteController.setBatteryType(updateDTO.getBatteryType());
        remoteController.setIsSmart(updateDTO.getIsSmart());
        remoteController.setOriginalStock(updateDTO.getOriginalStock());
        remoteController.setSold(updateDTO.getSold());
        remoteController.setSaleDate(updateDTO.getSaleDate());
        remoteController.setTelevision(television);

        RemoteController updatedRemoteController = remoteControllerRepository.save(remoteController);
        return RemoteControllerMapper.toDTO(updatedRemoteController);
    }


    public RemoteControllerResponseDTO partialUpdateRemoteController(Long televisionId, Long remoteControllerId,
                                                                     RemoteControllerPatchDTO patchDto) {
        RemoteController remoteController = remoteControllerRepository.findById(remoteControllerId)
                .orElseThrow(() -> new RecordNotFoundException("Remote Controller with ID " + remoteControllerId + " not found"));

        Television television = televisionRepository.findById(televisionId)
                .orElseThrow(() -> new RecordNotFoundException("Television with ID " + televisionId + " not found"));

        if (patchDto.getBrand() != null) {
            remoteController.setBrand(patchDto.getBrand());
        }
        if (patchDto.getName() != null) {
            remoteController.setName(patchDto.getName());
        }
        if (patchDto.getPrice() != null) {
            remoteController.setPrice(patchDto.getPrice());
        }
        if (patchDto.getBatteryType() != null) {
            remoteController.setBatteryType(patchDto.getBatteryType());
        }
        if (patchDto.getIsSmart()) {
            remoteController.setIsSmart(patchDto.getIsSmart());
        }
        if (patchDto.getOriginalStock() != null) {
            remoteController.setOriginalStock(patchDto.getOriginalStock());
        }
        if (patchDto.getSold() != null) {
            remoteController.setSold(patchDto.getSold());
        }
        if (patchDto.getSaleDate() != null) {
            remoteController.setSaleDate(patchDto.getSaleDate());
        }
        remoteController.setTelevision(television);

        RemoteController updatedRemoteController = remoteControllerRepository.save(remoteController);
        return RemoteControllerMapper.toDTO(updatedRemoteController);
    }

    public void deleteRemoteController(Long televisionId, Long remoteControllerId) {
        RemoteController remoteController = remoteControllerRepository.findByIdAndTelevisionId(remoteControllerId, televisionId)
                .orElseThrow(() -> new RecordNotFoundException("Remote Controller with ID " + remoteControllerId
                        + " not found for Television ID " + televisionId));

        remoteControllerRepository.delete(remoteController);
    }
}

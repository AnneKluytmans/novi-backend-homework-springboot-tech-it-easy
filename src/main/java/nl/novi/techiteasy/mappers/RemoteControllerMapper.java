package nl.novi.techiteasy.mappers;

import nl.novi.techiteasy.dtos.RemoteControllerCreateDTO;
import nl.novi.techiteasy.dtos.RemoteControllerResponseDTO;
import nl.novi.techiteasy.models.RemoteController;
import nl.novi.techiteasy.services.TelevisionService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RemoteControllerMapper {

    public static RemoteControllerResponseDTO toDTO(RemoteController remoteController) {
        RemoteControllerResponseDTO dto = new RemoteControllerResponseDTO();
        dto.setId(remoteController.getId());
        dto.setBrand(remoteController.getBrand());
        dto.setName(remoteController.getName());
        dto.setPrice(remoteController.getPrice());
        dto.setBatteryType(remoteController.getBatteryType());
        dto.setIsSmart(remoteController.getIsSmart());
        dto.setOriginalStock(remoteController.getOriginalStock());
        dto.setSold(remoteController.getSold());
        dto.setSaleDate(remoteController.getSaleDate());
        return dto;
    }

    public static List<RemoteControllerResponseDTO> toDtoList(List<RemoteController> remoteControllers) {
        return remoteControllers.stream().map(RemoteControllerMapper::toDTO).collect(Collectors.toList());
    }

    public static RemoteController toEntity(RemoteControllerCreateDTO createDTO) {
        RemoteController remoteController = new RemoteController();
        remoteController.setBrand(createDTO.getBrand());
        remoteController.setName(createDTO.getName());
        remoteController.setPrice(createDTO.getPrice());
        remoteController.setBatteryType(createDTO.getBatteryType());
        remoteController.setIsSmart(createDTO.getIsSmart());
        remoteController.setOriginalStock(createDTO.getOriginalStock());
        remoteController.setSold(createDTO.getSold());
        remoteController.setSaleDate(createDTO.getSaleDate());

        return remoteController;
    }
}
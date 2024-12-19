package nl.novi.techiteasy.services;

import nl.novi.techiteasy.dtos.*;
import nl.novi.techiteasy.exceptions.RecordNotFoundException;
import nl.novi.techiteasy.mappers.RemoteControllerMapper;
import nl.novi.techiteasy.mappers.TelevisionMapper;
import nl.novi.techiteasy.models.RemoteController;
import nl.novi.techiteasy.models.Television;
import nl.novi.techiteasy.repositories.RemoteControllerRepository;
import nl.novi.techiteasy.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelevisionService {
    private final TelevisionRepository televisionRepository;
    private final RemoteControllerRepository remoteControllerRepository;

    public TelevisionService(TelevisionRepository televisionRepository, RemoteControllerRepository remoteControllerRepository) {
        this.televisionRepository = televisionRepository;
        this.remoteControllerRepository = remoteControllerRepository;
    }

    public List<TelevisionResponseDTO> getTelevisions(String brand) {
        List<Television> televisions = (brand == null) ? televisionRepository.findAll() : televisionRepository.findByBrandIgnoreCase(brand);
        return TelevisionMapper.toDtoList(televisions);
    }

    public TelevisionResponseDTO getTelevisionById(Long id) {
        Television television = televisionRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Television with ID " + id + " not found"));
        return TelevisionMapper.toDto(television);
    }

    public Television getTelevisionEntityById(Long id) {
        return televisionRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Television with ID " + id + " not found"));
    }

    public TelevisionResponseDTO addTelevision(TelevisionCreateDTO createDto) {
        Television television = TelevisionMapper.toEntity(createDto);
        Television savedTelevision = televisionRepository.save(television);
        return TelevisionMapper.toDto(savedTelevision);
    }

    public TelevisionResponseDTO updateTelevision(Long id, TelevisionUpdateDTO updateDTO) {
        Television television = televisionRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Television with ID " + id + " not found"));

        television.setType(updateDTO.getType());
        television.setBrand(updateDTO.getBrand());
        television.setName(updateDTO.getName());
        television.setPrice(updateDTO.getPrice());
        television.setAvailableSize(updateDTO.getAvailableSize());
        television.setRefreshRate(updateDTO.getRefreshRate());
        television.setScreenType(updateDTO.getScreenType());
        television.setScreenQuality(updateDTO.getScreenQuality());
        television.setSmartTv(updateDTO.getSmartTv());
        television.setWifi(updateDTO.getWifi());
        television.setVoiceControl(updateDTO.getVoiceControl());
        television.setHdr(updateDTO.getHdr());
        television.setBluetooth(updateDTO.getBluetooth());
        television.setAmbiLight(updateDTO.getAmbiLight());
        television.setOriginalStock(updateDTO.getOriginalStock());
        television.setSold(updateDTO.getSold());
        television.setSaleDate(updateDTO.getSaleDate());

        return TelevisionMapper.toDto(televisionRepository.save(television));
    }

    public TelevisionResponseDTO partialUpdateTelevision(Long id, TelevisionPatchDTO patchDto) {
        Television television = televisionRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Television with ID " + id + " not found"));

        if (patchDto.getType() != null) {
            television.setType(patchDto.getType());
        }
        if (patchDto.getBrand() != null) {
            television.setBrand(patchDto.getBrand());
        }
        if (patchDto.getName() != null) {
            television.setName(patchDto.getName());
        }
        if (patchDto.getPrice() != null) {
            television.setPrice(patchDto.getPrice());
        }
        if (patchDto.getAvailableSize() != null) {
            television.setAvailableSize(patchDto.getAvailableSize());
        }
        if (patchDto.getRefreshRate() != null) {
            television.setRefreshRate(patchDto.getRefreshRate());
        }
        if (patchDto.getScreenType() != null) {
            television.setScreenType(patchDto.getScreenType());
        }
        if (patchDto.getScreenQuality() != null) {
            television.setScreenQuality(patchDto.getScreenQuality());
        }
        if (patchDto.getSmartTv() != null) {
            television.setSmartTv(patchDto.getSmartTv());
        }
        if (patchDto.getWifi() != null) {
            television.setWifi(patchDto.getWifi());
        }
        if (patchDto.getVoiceControl() != null) {
            television.setVoiceControl(patchDto.getVoiceControl());
        }
        if (patchDto.getHdr() != null) {
            television.setHdr(patchDto.getHdr());
        }
        if (patchDto.getBluetooth() != null) {
            television.setBluetooth(patchDto.getBluetooth());
        }
        if (patchDto.getAmbiLight() != null) {
            television.setAmbiLight(patchDto.getAmbiLight());
        }
        if (patchDto.getOriginalStock() != null) {
            television.setOriginalStock(patchDto.getOriginalStock());
        }
        if (patchDto.getSold() != null) {
            television.setSold(patchDto.getSold());
        }
        if (patchDto.getSaleDate() != null) {
            television.setSaleDate(patchDto.getSaleDate());
        }
        return TelevisionMapper.toDto(televisionRepository.save(television));
    }

    public void deleteTelevision(Long id) {
        if (!televisionRepository.existsById(id)) {
            throw new RecordNotFoundException("Television with ID " + id + " not found");
        }
        televisionRepository.deleteById(id);
    }

    public List<SalesInfoResponseDTO> getSalesInfo() {
        return TelevisionMapper.toSalesInfoDtoList(televisionRepository.findAll());
    }
}
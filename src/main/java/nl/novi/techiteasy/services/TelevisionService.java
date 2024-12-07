package nl.novi.techiteasy.services;

import nl.novi.techiteasy.dtos.SalesInfoDto;
import nl.novi.techiteasy.dtos.TelevisionInputDto;
import nl.novi.techiteasy.dtos.TelevisionDto;
import nl.novi.techiteasy.dtos.TelevisionPatchDto;
import nl.novi.techiteasy.exceptions.RecordNotFoundException;
import nl.novi.techiteasy.mappers.TelevisionMapper;
import nl.novi.techiteasy.models.Television;
import nl.novi.techiteasy.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelevisionService {
    private final TelevisionRepository televisionRepository;

    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    public List<TelevisionDto> getTelevisions(String brand) {
        List<Television> televisions = (brand == null) ? televisionRepository.findAll() : televisionRepository.findByBrandIgnoreCase(brand);
        return TelevisionMapper.toDtoList(televisions);
    }

    public TelevisionDto getTelevisionById(Long id) {
        Television television = televisionRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Television with ID " + id + " not found"));
        return TelevisionMapper.toDto(television);
    }

    public TelevisionDto addTelevision(TelevisionInputDto inputDto) {
        Television television = TelevisionMapper.toEntity(inputDto);
        Television savedTelevision = televisionRepository.save(television);
        return TelevisionMapper.toDto(savedTelevision);
    }

    public TelevisionDto updateTelevision(Long id, TelevisionInputDto inputDto) {
        Television television = televisionRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Television with ID " + id + " not found"));

        television.setType(inputDto.getType());
        television.setBrand(inputDto.getBrand());
        television.setName(inputDto.getName());
        television.setPrice(inputDto.getPrice());
        television.setAvailableSize(inputDto.getAvailableSize());
        television.setRefreshRate(inputDto.getRefreshRate());
        television.setScreenType(inputDto.getScreenType());
        television.setScreenQuality(inputDto.getScreenQuality());
        television.setSmartTv(inputDto.getSmartTv());
        television.setWifi(inputDto.getWifi());
        television.setVoiceControl(inputDto.getVoiceControl());
        television.setHdr(inputDto.getHdr());
        television.setBluetooth(inputDto.getBluetooth());
        television.setAmbiLight(inputDto.getAmbiLight());
        television.setOriginalStock(inputDto.getOriginalStock());
        television.setSold(inputDto.getSold());
        television.setSaleDate(inputDto.getSaleDate());

        return TelevisionMapper.toDto(televisionRepository.save(television));
    }

    public TelevisionDto partialUpdateTelevision(Long id, TelevisionPatchDto patchDto) {
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

    public List<SalesInfoDto> getSalesInfo() {
        return TelevisionMapper.toSalesInfoDtoList(televisionRepository.findAll());
    }
}
package nl.novi.techiteasy.services;

import nl.novi.techiteasy.dtos.SalesInfoDto;
import nl.novi.techiteasy.dtos.TelevisionInputDto;
import nl.novi.techiteasy.dtos.TelevisionResponseDto;
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

    public List<TelevisionResponseDto> getTelevisions(String brand) {
        List<Television> televisions = (brand == null) ? televisionRepository.findAll() : televisionRepository.findByBrandIgnoreCase(brand);
        return TelevisionMapper.toDtoList(televisions);
    }

    public TelevisionResponseDto getTelevisionById(Long id) {
        Television television = televisionRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Television with ID " + id + " not found"));
        return TelevisionMapper.toDto(television);
    }

    public TelevisionResponseDto addTelevision(TelevisionInputDto inputDto) {
        Television television = TelevisionMapper.toEntity(inputDto);
        Television savedTelevision = televisionRepository.save(television);
        return TelevisionMapper.toDto(savedTelevision);
    }

    public TelevisionResponseDto updateTelevision(Long id, TelevisionInputDto inputDto) {
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

    public TelevisionResponseDto partialUpdateTelevision(Long id, TelevisionInputDto inputDto) {
        Television television = televisionRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Television with ID " + id + " not found"));

        if (inputDto.getType() != null) {
            television.setType(inputDto.getType());
        }
        if (inputDto.getBrand() != null) {
            television.setBrand(inputDto.getBrand());
        }
        if (inputDto.getName() != null) {
            television.setName(inputDto.getName());
        }
        if (inputDto.getPrice() != null) {
            television.setPrice(inputDto.getPrice());
        }
        if (inputDto.getAvailableSize() != null) {
            television.setAvailableSize(inputDto.getAvailableSize());
        }
        if (inputDto.getRefreshRate() != null) {
            television.setRefreshRate(inputDto.getRefreshRate());
        }
        if (inputDto.getScreenType() != null) {
            television.setScreenType(inputDto.getScreenType());
        }
        if (inputDto.getScreenQuality() != null) {
            television.setScreenQuality(inputDto.getScreenQuality());
        }
        if (inputDto.getSmartTv() != null) {
            television.setSmartTv(inputDto.getSmartTv());
        }
        if (inputDto.getWifi() != null) {
            television.setWifi(inputDto.getWifi());
        }
        if (inputDto.getVoiceControl() != null) {
            television.setVoiceControl(inputDto.getVoiceControl());
        }
        if (inputDto.getHdr() != null) {
            television.setHdr(inputDto.getHdr());
        }
        if (inputDto.getBluetooth() != null) {
            television.setBluetooth(inputDto.getBluetooth());
        }
        if (inputDto.getAmbiLight() != null) {
            television.setAmbiLight(inputDto.getAmbiLight());
        }
        if (inputDto.getOriginalStock() != null) {
            television.setOriginalStock(inputDto.getOriginalStock());
        }
        if (inputDto.getSold() != null) {
            television.setSold(inputDto.getSold());
        }
        if (inputDto.getSaleDate() != null) {
            television.setSaleDate(inputDto.getSaleDate());
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
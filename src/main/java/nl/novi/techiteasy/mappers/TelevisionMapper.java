package nl.novi.techiteasy.mappers;

import nl.novi.techiteasy.dtos.SalesInfoResponseDTO;
import nl.novi.techiteasy.dtos.TelevisionCreateDTO;
import nl.novi.techiteasy.dtos.TelevisionResponseDTO;
import nl.novi.techiteasy.dtos.TelevisionUpdateDTO;
import nl.novi.techiteasy.models.Television;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TelevisionMapper {
    public static TelevisionResponseDTO toDto(Television television) {
        TelevisionResponseDTO dto = new TelevisionResponseDTO();
        dto.setId(television.getId());
        dto.setType(television.getType());
        dto.setBrand(television.getBrand());
        dto.setName(television.getName());
        dto.setPrice(television.getPrice());
        dto.setAvailableSize(television.getAvailableSize());
        dto.setRefreshRate(television.getRefreshRate());
        dto.setScreenType(television.getScreenType());
        dto.setScreenQuality(television.getScreenQuality());
        dto.setSmartTv(television.getSmartTv());
        dto.setWifi(television.getWifi());
        dto.setVoiceControl(television.getVoiceControl());
        dto.setHdr(television.getHdr());
        dto.setBluetooth(television.getBluetooth());
        dto.setAmbiLight(television.getAmbiLight());
        dto.setOriginalStock(television.getOriginalStock());
        dto.setSold(television.getSold());
        dto.setSaleDate(television.getSaleDate());
        return dto;
    }

    public static List<TelevisionResponseDTO> toDtoList(List<Television> televisions) {
        return televisions.stream().map(TelevisionMapper::toDto).collect(Collectors.toList());
    }

    public static Television toEntity(TelevisionCreateDTO createDto) {
        Television television = new Television();
        television.setType(createDto.getType());
        television.setBrand(createDto.getBrand());
        television.setName(createDto.getName());
        television.setPrice(createDto.getPrice());
        television.setAvailableSize(createDto.getAvailableSize());
        television.setRefreshRate(createDto.getRefreshRate());
        television.setScreenType(createDto.getScreenType());
        television.setScreenQuality(createDto.getScreenQuality());
        television.setSmartTv(createDto.getSmartTv());
        television.setWifi(createDto.getWifi());
        television.setVoiceControl(createDto.getVoiceControl());
        television.setHdr(createDto.getHdr());
        television.setBluetooth(createDto.getBluetooth());
        television.setAmbiLight(createDto.getAmbiLight());
        television.setOriginalStock(createDto.getOriginalStock());
        television.setSold(createDto.getSold());
        television.setSaleDate(createDto.getSaleDate());
        return television;
    }

    public static SalesInfoResponseDTO toSalesInfoDto(Television television) {
        var dto = new SalesInfoResponseDTO();
        dto.setId(television.getId());
        dto.setPrice(television.getPrice());
        dto.setOriginalStock(television.getOriginalStock());
        dto.setSold(television.getSold());
        return dto;
    }

    public static List<SalesInfoResponseDTO> toSalesInfoDtoList(List<Television> televisions) {
        return televisions.stream().map(TelevisionMapper::toSalesInfoDto).collect(Collectors.toList());
    }
}

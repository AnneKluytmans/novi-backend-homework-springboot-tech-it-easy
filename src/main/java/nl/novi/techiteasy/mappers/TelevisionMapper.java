package nl.novi.techiteasy.mappers;

import nl.novi.techiteasy.dtos.TelevisionInputDto;
import nl.novi.techiteasy.dtos.TelevisionResponseDto;
import nl.novi.techiteasy.models.Television;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TelevisionMapper {
    public static TelevisionResponseDto toDto(Television television) {
        TelevisionResponseDto dto = new TelevisionResponseDto();
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

    public static List<TelevisionResponseDto> toDtoList(List<Television> televisions) {
        return televisions.stream().map(TelevisionMapper::toDto).toList();
    }

    public static Television toEntity(TelevisionInputDto inputDto) {
        Television television = new Television();
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
        return television;
    }
}

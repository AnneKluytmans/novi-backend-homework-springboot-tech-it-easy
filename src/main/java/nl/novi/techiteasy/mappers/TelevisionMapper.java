package nl.novi.techiteasy.mappers;

import nl.novi.techiteasy.dtos.SalesInfoDto;
import nl.novi.techiteasy.dtos.TelevisionInputDto;
import nl.novi.techiteasy.dtos.TelevisionDto;
import nl.novi.techiteasy.models.Television;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TelevisionMapper {
    public static TelevisionDto toDto(Television television) {
        TelevisionDto dto = new TelevisionDto();
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

    public static List<TelevisionDto> toDtoList(List<Television> televisions) {
        return televisions.stream().map(TelevisionMapper::toDto).collect(Collectors.toList());
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

    public static SalesInfoDto toSalesInfoDto(Television television) {
        var dto = new SalesInfoDto();
        dto.setId(television.getId());
        dto.setPrice(television.getPrice());
        dto.setOriginalStock(television.getOriginalStock());
        dto.setSold(television.getSold());
        return dto;
    }

    public static List<SalesInfoDto> toSalesInfoDtoList(List<Television> televisions) {
        return televisions.stream().map(TelevisionMapper::toSalesInfoDto).collect(Collectors.toList());
    }
}

package nl.novi.techiteasy.dtos;

import nl.novi.techiteasy.enums.TelevisionType;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class TelevisionCreateDTO {
    @NotNull(message = "Type is required.")
    private TelevisionType type;

    @NotBlank(message = "Brand cannot be empty.")
    @Size(max = 50, message = "Brand name cannot exceed 50 characters.")
    private String brand;

    @NotBlank(message = "Name cannot be empty.")
    @Size(max = 50, message = "Name cannot exceed 50 characters.")
    private String name;

    @NotNull(message = "Price is required.")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0.")
    private Double price;

    @NotNull(message = "Available size is required.")
    @DecimalMin(value = "0.1", message = "Available size must be greater than 0.")
    private Double availableSize;

    @NotNull(message = "Refresh rate is required.")
    @Min(value = 30, message = "Refresh rate must be at least 30Hz.")
    private Integer refreshRate;

    @NotBlank(message = "Screen type cannot be empty.")
    private String screenType;

    @NotBlank(message = "Screen quality cannot be empty.")
    private String screenQuality;

    private Boolean smartTv;
    private Boolean wifi;
    private Boolean voiceControl;
    private Boolean hdr;
    private Boolean bluetooth;
    private Boolean ambiLight;

    @NotNull(message = "Original stock is required.")
    @Min(value = 0, message = "Original stock cannot be negative.")
    private Integer originalStock;

    @NotNull(message = "Sold is required.")
    @Min(value = 0, message = "Sold items cannot be negative.")
    private Integer sold;

    @PastOrPresent(message = "Sale Date cannot be in the future.")
    private LocalDate saleDate;

    //getters
    public TelevisionType getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Double getAvailableSize() {
        return availableSize;
    }

    public Integer getRefreshRate() {
        return refreshRate;
    }

    public String getScreenType() {
        return screenType;
    }

    public String getScreenQuality() {
        return screenQuality;
    }

    public Boolean getSmartTv() {
        return smartTv;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public Boolean getVoiceControl() {
        return voiceControl;
    }

    public Boolean getHdr() {
        return hdr;
    }

    public Boolean getBluetooth() {
        return bluetooth;
    }

    public Boolean getAmbiLight() {
        return ambiLight;
    }

    public Integer getOriginalStock() {
        return originalStock;
    }

    public Integer getSold() {
        return sold;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }


    //setters
    public void setType(TelevisionType type) {
        this.type = type;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setAvailableSize(Double availableSize) {
        this.availableSize = availableSize;
    }

    public void setRefreshRate(Integer refreshRate) {
        this.refreshRate = refreshRate;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public void setScreenQuality(String screenQuality) {
        this.screenQuality = screenQuality;
    }

    public void setSmartTv(Boolean smartTv) {
        this.smartTv = smartTv;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public void setVoiceControl(Boolean voiceControl) {
        this.voiceControl = voiceControl;
    }

    public void setHdr(Boolean hdr) {
        this.hdr = hdr;
    }

    public void setBluetooth(Boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public void setAmbiLight(Boolean ambiLight) {
        this.ambiLight = ambiLight;
    }

    public void setOriginalStock(Integer originalStock) {
        this.originalStock = originalStock;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }
}

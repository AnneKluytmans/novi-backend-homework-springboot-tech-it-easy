package nl.novi.techiteasy.dtos;

import nl.novi.techiteasy.enums.TelevisionType;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class TelevisionPatchDto {

    private TelevisionType type;

    @Size(max = 50, message = "Brand name cannot exceed 50 characters.")
    private String brand;

    @Size(max = 50, message = "Name cannot exceed 50 characters.")
    private String name;

    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0.")
    private Double price;

    @DecimalMin(value = "0.1", message = "Available size must be greater than 0.")
    private Double availableSize;

    @Min(value = 30, message = "Refresh rate must be at least 30Hz.")
    private Integer refreshRate;

    private String screenType;
    private String screenQuality;
    private Boolean smartTv;
    private Boolean wifi;
    private Boolean voiceControl;
    private Boolean hdr;
    private Boolean bluetooth;
    private Boolean ambiLight;

    @Min(value = 0, message = "Original stock cannot be negative.")
    private Integer originalStock;

    @Min(value = 0, message = "Sold items cannot be negative.")
    private Integer sold;

    private LocalDate saleDate;


    //getters
    public TelevisionType getType() {
        return type;
    }

    public @Size(max = 50, message = "Brand name cannot exceed 50 characters.") String getBrand() {
        return brand;
    }

    public @Size(max = 50, message = "Name cannot exceed 50 characters.") String getName() {
        return name;
    }

    public @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0.") Double getPrice() {
        return price;
    }

    public @DecimalMin(value = "0.1", message = "Available size must be greater than 0.") Double getAvailableSize() {
        return availableSize;
    }

    public @Min(value = 30, message = "Refresh rate must be at least 30Hz.") Integer getRefreshRate() {
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

    public @Min(value = 0, message = "Original stock cannot be negative.") Integer getOriginalStock() {
        return originalStock;
    }

    public @Min(value = 0, message = "Sold items cannot be negative.") Integer getSold() {
        return sold;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }


    //setters
    public void setType(TelevisionType type) {
        this.type = type;
    }

    public void setBrand(@Size(max = 50, message = "Brand name cannot exceed 50 characters.") String brand) {
        this.brand = brand;
    }

    public void setName(@Size(max = 50, message = "Name cannot exceed 50 characters.") String name) {
        this.name = name;
    }

    public void setPrice(@DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0.") Double price) {
        this.price = price;
    }

    public void setAvailableSize(@DecimalMin(value = "0.1", message = "Available size must be greater than 0.") Double availableSize) {
        this.availableSize = availableSize;
    }

    public void setRefreshRate(@Min(value = 30, message = "Refresh rate must be at least 30Hz.") Integer refreshRate) {
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

    public void setOriginalStock(@Min(value = 0, message = "Original stock cannot be negative.") Integer originalStock) {
        this.originalStock = originalStock;
    }

    public void setSold(@Min(value = 0, message = "Sold items cannot be negative.") Integer sold) {
        this.sold = sold;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }
}

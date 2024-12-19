package nl.novi.techiteasy.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import nl.novi.techiteasy.enums.TelevisionType;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Television extends Product {
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Type is required.")
    private TelevisionType type;

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

    @OneToMany(mappedBy = "television", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CiModule> ciModules;

    @ManyToMany
    @JoinTable(
            name = "television_wallbracket",
            joinColumns = @JoinColumn(name = "television_id"),
            inverseJoinColumns = @JoinColumn(name = "wallbracket_id")
    )
    private List<WallBracket> wallBrackets;

    // Constructors
    public Television() {
        super();
    }

    public Television(TelevisionType type, String brand, String name, Double price, Double availableSize, Integer refreshRate,
                      String screenType, String screenQuality, Boolean smartTv, Boolean wifi, Boolean voiceControl,
                      Boolean hdr, Boolean bluetooth, Boolean ambiLight, Integer originalStock, Integer sold, LocalDate saleDate) {
        super(brand, name, price, originalStock, sold, saleDate);
        this.type = type;
        this.availableSize = availableSize;
        this.refreshRate = refreshRate;
        this.screenType = screenType;
        this.screenQuality = screenQuality;
        this.smartTv = smartTv;
        this.wifi = wifi;
        this.voiceControl = voiceControl;
        this.hdr = hdr;
        this.bluetooth = bluetooth;
        this.ambiLight = ambiLight;
    }

    //Getters and setters

    public TelevisionType getType() {
        return type;
    }

    public void setType(TelevisionType type) {
        this.type = type;
    }

    public Double getAvailableSize() {
        return availableSize;
    }

    public void setAvailableSize(Double availableSize) {
        this.availableSize = availableSize;
    }

    public Integer getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(Integer refreshRate) {
        this.refreshRate = refreshRate;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public String getScreenQuality() {
        return screenQuality;
    }

    public void setScreenQuality(String screenQuality) {
        this.screenQuality = screenQuality;
    }

    public Boolean getSmartTv() {
        return smartTv;
    }

    public void setSmartTv(Boolean smartTv) {
        this.smartTv = smartTv;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Boolean getVoiceControl() {
        return voiceControl;
    }

    public void setVoiceControl(Boolean voiceControl) {
        this.voiceControl = voiceControl;
    }

    public Boolean getHdr() {
        return hdr;
    }

    public void setHdr(Boolean hdr) {
        this.hdr = hdr;
    }

    public Boolean getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(Boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public Boolean getAmbiLight() {
        return ambiLight;
    }

    public void setAmbiLight(Boolean ambiLight) {
        this.ambiLight = ambiLight;
    }
}
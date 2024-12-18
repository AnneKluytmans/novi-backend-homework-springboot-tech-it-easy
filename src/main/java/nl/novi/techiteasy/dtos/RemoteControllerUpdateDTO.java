package nl.novi.techiteasy.dtos;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class RemoteControllerUpdateDTO {
    @NotBlank(message = "Brand cannot be empty.")
    @Size(max = 50, message = "Brand name cannot exceed 50 characters.")
    private String brand;

    @NotBlank(message = "Name cannot be empty.")
    @Size(max = 50, message = "Name cannot exceed 50 characters.")
    private String name;

    @NotNull(message = "Price is required.")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0.")
    private Double price;

    @NotBlank(message = "Battery type cannot be empty.")
    @Size(max = 24, message = "Battery type cannot exceed 24 characters.")
    private String batteryType;

    private boolean isSmart;

    @NotNull(message = "Original stock is required.")
    @Min(value = 0, message = "Original stock cannot be negative.")
    private Integer originalStock;

    @NotNull(message = "Sold is required.")
    @Min(value = 0, message = "Sold items cannot be negative.")
    private Integer sold;

    @PastOrPresent(message = "Sale Date cannot be in the future.")
    private LocalDate saleDate;

    private Long televisionId;


    //getters
    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public boolean isSmart() {
        return isSmart;
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

    public Long getTelevisionId() {
        return televisionId;
    }

    //setters
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public void setSmart(boolean smart) {
        isSmart = smart;
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

    public void setTelevisionId(Long televisionId) {
        this.televisionId = televisionId;
    }
}

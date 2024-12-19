package nl.novi.techiteasy.dtos;

import java.time.LocalDate;

public class RemoteControllerResponseDTO {
    private Long id;
    private String brand;
    private String name;
    private Double price;
    private String batteryType;
    private boolean isSmart;
    private Integer originalStock;
    private Integer sold;
    private LocalDate saleDate;


    //getters
    public Long getId() {
        return id;
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

    public String getBatteryType() {
        return batteryType;
    }

    public boolean getIsSmart() {
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


    //setters
    public void setId(Long id) {
        this.id = id;
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

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public void setIsSmart(boolean smart) {
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
}

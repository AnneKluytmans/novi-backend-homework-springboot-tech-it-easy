package nl.novi.techiteasy.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@MappedSuperclass
public abstract class Product {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Brand cannot be empty.")
    @Size(max = 50, message = "Brand name cannot exceed 50 characters.")
    private String brand;

    @NotBlank(message = "Name cannot be empty.")
    @Size(max = 100, message = "Name cannot exceed 100 characters.")
    private String name;

    @NotNull(message = "Price is required.")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0.")
    private Double price;

    @NotNull(message = "Original stock is required.")
    @Min(value = 0, message = "Original stock cannot be negative.")
    private Integer originalStock;

    @NotNull(message = "Sold is required.")
    @Min(value = 0, message = "Sold items cannot be negative.")
    private Integer sold;

    @PastOrPresent(message = "Sale Date cannot be in the future.")
    private LocalDate saleDate;

    //Constructor
    public Product() {
    }

    public Product(String brand, String name, Double price, Integer originalStock, Integer sold, LocalDate saleDate) {
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.originalStock = originalStock;
        this.sold = sold;
        this.saleDate = saleDate;
    }


    //Getters en setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(Integer originalStock) {
        this.originalStock = originalStock;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }
}

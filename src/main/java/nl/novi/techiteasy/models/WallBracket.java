package nl.novi.techiteasy.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

@Entity
public class WallBracket extends Product {
    @NotBlank(message = "Construction type cannot be empty.")
    @Size(max = 50, message = "Construction type cannot exceed 50 characters.")
    private String constructionType;

    @NotNull(message = "Width is required.")
    @DecimalMin(value = "0.1", message = "Width must be greater than 0.")
    private Float width;

    @NotNull(message = "Width is required.")
    @DecimalMin(value = "0.1", message = "Width must be greater than 0.")
    private Float height;

    @ManyToMany(mappedBy = "wallBrackets")
    private List<Television> televisions;

    //Constructors
    public WallBracket() {
        super();
    }

    public WallBracket(String brand, String name, Double price, String constructionType, Float width, Float height,
                       Integer originalStock, Integer sold, LocalDate saleDate, List<Television> televisions) {
        super(brand, name, price, originalStock, sold, saleDate);
        this.constructionType = constructionType;
        this.width = width;
        this.height = height;
        this.televisions = televisions;
    }

    //Getters and setters
    public String getConstructionType() {
        return constructionType;
    }

    public void setConstructionType(String constructionType) {
        this.constructionType = constructionType;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public List<Television> getTelevisions() {
        return televisions;
    }

    public void setTelevisions(List<Television> televisions) {
        this.televisions = televisions;
    }
}

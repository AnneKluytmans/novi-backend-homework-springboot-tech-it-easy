package nl.novi.techiteasy.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
public class CiModule extends Product {
    @NotBlank(message = "Type cannot be empty.")
    @Size(max = 24, message = "type cannot exceed 24 characters.")
    private String type;

    @NotBlank(message = "Provider is required.")
    @Size(max = 100, message = "Provide cannot exceed 100 characters.")
    private String provider;

    @NotBlank(message = "Encoding type is required")
    @Size(max = 24, message = "Encoding type cannot exceed 24 characters.")
    private String encodingType;

    @ManyToOne
    @JoinColumn(name = "television_id", referencedColumnName = "id")
    private Television television;

    //Constructors
    public CiModule() {
        super();
    }

    public CiModule(String type, String brand, String name, Double price, String provider, String encodingType,
                    Integer originalStock, Integer sold, LocalDate saleDate, Television television) {
        super(brand, name, price, originalStock, sold, saleDate);
        this.type = type;
        this.provider = provider;
        this.encodingType = encodingType;
        this.television = television;
    }


    //Getters en setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getEncodingType() {
        return encodingType;
    }

    public void setEncodingType(String encodingType) {
        this.encodingType = encodingType;
    }

    public Television getTelevision() {
        return television;
    }

    public void setTelevision(Television television) {
        this.television = television;
    }
}

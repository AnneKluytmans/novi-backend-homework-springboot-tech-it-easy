package nl.novi.techiteasy.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class RemoteController extends Product {
    @NotBlank(message = "Battery type cannot be empty.")
    @Size(max = 24, message = "Battery type cannot exceed 24 characters.")
    private String batteryType;

    private boolean isSmart;

    @OneToOne
    @JoinColumn(name = "television_id", referencedColumnName = "id")
    private Television television;

    //Constructors
    public RemoteController() {
        super();
    }

    public RemoteController(String brand, String name, Double price, String batteryType, Integer originalStock,
                            Integer sold, LocalDate saleDate, boolean isSmart, Television television) {
        super(brand, name, price, originalStock, sold, saleDate);
        this.batteryType = batteryType;
        this.isSmart = isSmart;
        this.television = television;
    }

    //Getters and Setters
    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public boolean getIsSmart() {
        return isSmart;
    }

    public void setIsSmart(boolean smart) {
        isSmart = smart;
    }

    public Television getTelevision() {
        return television;
    }

    public void setTelevision(Television television) {
        this.television = television;
    }
}

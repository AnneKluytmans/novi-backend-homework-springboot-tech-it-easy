package nl.novi.techiteasy.dtos;

public class SalesInfoDto {
    private Long id;
    private Double price;
    private Integer originalStock;
    private Integer sold;

    //getters
    public Long getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getOriginalStock() {
        return originalStock;
    }

    public Integer getSold() {
        return sold;
    }


    //setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setOriginalStock(Integer originalStock) {
        this.originalStock = originalStock;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }
}

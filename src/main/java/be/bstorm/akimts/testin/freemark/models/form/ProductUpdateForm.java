package be.bstorm.akimts.testin.freemark.models.form;

import be.bstorm.akimts.testin.freemark.models.entities.Product;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductUpdateForm {
    @NotBlank
    private String model;

    @NotBlank
    private String brand;

    @Min(0)
    private double price;

    public Product toEntity(){
        Product p = new Product();

        p.setModel( this.model );
        p.setBrand( this.brand );
        p.setPrice( this.price );

        return p;
    }
}

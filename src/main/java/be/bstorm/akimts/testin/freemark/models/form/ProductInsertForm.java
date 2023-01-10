package be.bstorm.akimts.testin.freemark.models.form;

import be.bstorm.akimts.testin.freemark.models.entities.Product;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ProductInsertForm {

    @NotBlank
    private String model;

    @NotBlank
    private String brand;

    @Min(0)
    private double price;

    private List<Long> categories;

    public Product toEntity(){
        Product p = new Product();

        p.setModel( this.model );
        p.setBrand( this.brand );
        p.setPrice( this.price );

        return p;
    }

}

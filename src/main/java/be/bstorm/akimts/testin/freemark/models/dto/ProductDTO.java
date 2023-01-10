package be.bstorm.akimts.testin.freemark.models.dto;

import be.bstorm.akimts.testin.freemark.models.entities.Category;
import be.bstorm.akimts.testin.freemark.models.entities.Product;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class ProductDTO {

    private Long id;
    private String model;
    private String brand;
    private double price;
    private Set<String> categories;

    public static ProductDTO fromEntity(Product entity){

        return ProductDTO.builder()
                .id( entity.getId() )
                .model( entity.getModel() )
                .brand( entity.getBrand() )
                .price( entity.getPrice() )
                .categories(
                        entity.getCategories().stream()
                                .map(Category::getName)
                                .collect(Collectors.toSet())
                )
                .build();

    }

}

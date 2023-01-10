package be.bstorm.akimts.testin.freemark.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Long id;

    @Column(name = "product_model", nullable = false)
    private String model;

    @Column(name = "product_brand", nullable = false)
    private String brand;

    @Column(name = "product_price", nullable = false)
    private double price;

    @ManyToMany
    @JoinTable(
            name = "product_categories",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

}

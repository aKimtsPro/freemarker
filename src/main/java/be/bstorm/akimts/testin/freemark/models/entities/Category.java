package be.bstorm.akimts.testin.freemark.models.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private Long id;

    @Column(name = "category_name", nullable = false)
    private String name;

    @Column(name = "category_desc")
    private String desc;

    @ManyToOne
    @JoinColumn(name = "super_category")
    private Category superCategory;

    @OneToMany(mappedBy = "superCategory")
    private Set<Category> subCategory;
}

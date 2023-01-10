package be.bstorm.akimts.testin.freemark.models.dto;

import be.bstorm.akimts.testin.freemark.models.entities.Category;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDTO {
    private Long id;
    private String name;

    public static CategoryDTO fromEntity(Category entity){
        return CategoryDTO.builder()
                .id( entity.getId() )
                .name( entity.getName() )
                .build();
    }
}

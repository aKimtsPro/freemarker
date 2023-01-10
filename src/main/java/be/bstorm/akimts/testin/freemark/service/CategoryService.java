package be.bstorm.akimts.testin.freemark.service;

import be.bstorm.akimts.testin.freemark.models.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getCategories();
}

package be.bstorm.akimts.testin.freemark.service.impl;

import be.bstorm.akimts.testin.freemark.models.dto.CategoryDTO;
import be.bstorm.akimts.testin.freemark.repo.CategoryRepository;
import be.bstorm.akimts.testin.freemark.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CategoryDTO> getCategories() {
        return repository.findAll().stream()
                .map(CategoryDTO::fromEntity)
                .toList();
    }
}

package be.bstorm.akimts.testin.freemark.service.impl;

import be.bstorm.akimts.testin.freemark.models.dto.ProductDTO;
import be.bstorm.akimts.testin.freemark.models.entities.Product;
import be.bstorm.akimts.testin.freemark.models.form.ProductInsertForm;
import be.bstorm.akimts.testin.freemark.models.form.ProductUpdateForm;
import be.bstorm.akimts.testin.freemark.repo.CategoryRepository;
import be.bstorm.akimts.testin.freemark.repo.ProductRepository;
import be.bstorm.akimts.testin.freemark.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository repository, CategoryRepository categoryRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<ProductDTO> getAllProduct() {
        return repository.findAll().stream()
                .map(ProductDTO::fromEntity)
                .toList();
    }

    @Override
    public ProductDTO getOne(Long id) {
        return repository.findById(id)
                .map(ProductDTO::fromEntity)
                .orElseThrow();
    }

    @Override
    public void update(Long id, ProductUpdateForm form) {
        Product product = repository.findById(id)
                .orElseThrow();

        product.setModel( form.getModel() );
        product.setBrand( form.getBrand() );
        product.setPrice(form.getPrice() );

        repository.save( product );
    }

    @Override
    public void insert(ProductInsertForm form) {
        Product product = form.toEntity();
        product.setCategories(
                categoryRepository.findAllById(form.getCategories())
        );
        repository.save( product );
    }

    @Override
    public void delete(Long id) {
        Product product = repository.findById(id)
                        .orElseThrow();
        repository.delete(product);
    }
}

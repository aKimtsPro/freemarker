package be.bstorm.akimts.testin.freemark.service;

import be.bstorm.akimts.testin.freemark.models.dto.ProductDTO;
import be.bstorm.akimts.testin.freemark.models.form.ProductInsertForm;
import be.bstorm.akimts.testin.freemark.models.form.ProductUpdateForm;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getAllProduct();
    ProductDTO getOne(Long id);
    void update(Long id, ProductUpdateForm form);
    void insert(ProductInsertForm form);
    void delete(Long id);

}

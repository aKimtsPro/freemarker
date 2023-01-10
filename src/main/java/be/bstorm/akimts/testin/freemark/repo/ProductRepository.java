package be.bstorm.akimts.testin.freemark.repo;

import be.bstorm.akimts.testin.freemark.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

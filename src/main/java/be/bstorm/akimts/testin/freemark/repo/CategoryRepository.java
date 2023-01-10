package be.bstorm.akimts.testin.freemark.repo;

import be.bstorm.akimts.testin.freemark.models.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

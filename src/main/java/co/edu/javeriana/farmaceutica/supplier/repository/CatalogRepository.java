package co.edu.javeriana.farmaceutica.supplier.repository;

import co.edu.javeriana.farmaceutica.supplier.entity.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatalogRepository extends JpaRepository<Catalog, String> {
    List<Catalog> findAllBySupplierId(String supplierId);
}

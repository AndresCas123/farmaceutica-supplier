package co.edu.javeriana.farmaceutica.supplier.repository;

import co.edu.javeriana.farmaceutica.supplier.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, String> {
}

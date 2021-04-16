package co.edu.javeriana.farmaceutica.supplier.repository;

import co.edu.javeriana.farmaceutica.supplier.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, String> {
}

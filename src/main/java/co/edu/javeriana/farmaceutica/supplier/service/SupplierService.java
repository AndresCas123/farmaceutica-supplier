package co.edu.javeriana.farmaceutica.supplier.service;

import co.edu.javeriana.farmaceutica.supplier.client.message.CatalogResponse;
import co.edu.javeriana.farmaceutica.supplier.entity.Department;
import co.edu.javeriana.farmaceutica.supplier.entity.Supplier;
import co.edu.javeriana.farmaceutica.supplier.message.CityResponse;
import java.util.List;
import java.util.Optional;

public interface SupplierService {
    Supplier save(Supplier supplier);
    List<Supplier> list();
    Optional<Supplier> get(String id);
    void syncDepartments(List<Department> departments);
    void syncCities(List<CityResponse> cities);
}

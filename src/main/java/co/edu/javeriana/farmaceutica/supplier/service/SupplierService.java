package co.edu.javeriana.farmaceutica.supplier.service;

import co.edu.javeriana.farmaceutica.supplier.entity.Supplier;

import java.util.List;
import java.util.Optional;

public interface SupplierService {

    Supplier save(Supplier supplier);
    List<Supplier> list();
    Optional<Supplier> get(String id);
}

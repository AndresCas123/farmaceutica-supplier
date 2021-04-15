package co.edu.javeriana.farmaceutica.delivery.service;

import co.edu.javeriana.farmaceutica.delivery.entity.Supplier;

import java.util.List;
import java.util.Optional;

public interface SupplierService {

    Supplier save(Supplier supplier);
    List<Supplier> list();
    Optional<Supplier> get(String id);
}

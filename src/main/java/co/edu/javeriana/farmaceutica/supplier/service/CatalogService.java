package co.edu.javeriana.farmaceutica.supplier.service;

import co.edu.javeriana.farmaceutica.supplier.entity.Catalog;

import java.util.List;

public interface CatalogService {
    List<Catalog> list(String supplierId);
}

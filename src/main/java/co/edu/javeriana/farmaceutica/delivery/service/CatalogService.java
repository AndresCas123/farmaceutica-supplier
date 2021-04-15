package co.edu.javeriana.farmaceutica.delivery.service;

import co.edu.javeriana.farmaceutica.delivery.entity.Catalog;

import java.util.List;

public interface CatalogService {
    List<Catalog> list(String supplierId);
}

package co.edu.javeriana.farmaceutica.supplier.service.impl;

import co.edu.javeriana.farmaceutica.supplier.entity.Catalog;
import co.edu.javeriana.farmaceutica.supplier.repository.CatalogRepository;
import co.edu.javeriana.farmaceutica.supplier.service.CatalogService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepository catalogoRepository;

    @Override
    public List<Catalog> list(String supplierId) {
        return catalogoRepository.findAllBySupplierId(supplierId);
    }
}

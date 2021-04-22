package co.edu.javeriana.farmaceutica.supplier.service.impl;

import co.edu.javeriana.farmaceutica.supplier.adapter.CatalogAdapter;
import co.edu.javeriana.farmaceutica.supplier.client.CatalogClientService;
import co.edu.javeriana.farmaceutica.supplier.client.message.CatalogResponse;
import co.edu.javeriana.farmaceutica.supplier.entity.Catalog;
import co.edu.javeriana.farmaceutica.supplier.repository.CatalogRepository;
import co.edu.javeriana.farmaceutica.supplier.service.CatalogService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepository catalogoRepository;
    private final CatalogClientService catalogClientService;
    private final CatalogAdapter catalogAdapter;

    @Override
    public List<Catalog> list(String supplierId) {
        List<Catalog> res = new ArrayList<>();
        try {
            CatalogResponse catalog = catalogClientService.list();
            log.info("Loading catalog from ERP");
            res = catalogAdapter.adapter(catalog);
            catalogoRepository.saveAll(res);
        } catch(Exception ex) {
            log.warn(ex.getMessage());
            log.info("Loading catalog from local cache");
            res = catalogoRepository.findAll();
        }
        return res.stream().filter(c -> c.getSupplier().getId().equals(supplierId)).collect(Collectors.toList());
    }
}

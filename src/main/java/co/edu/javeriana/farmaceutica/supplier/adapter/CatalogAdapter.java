package co.edu.javeriana.farmaceutica.supplier.adapter;

import co.edu.javeriana.farmaceutica.supplier.client.message.CatalogResponse;
import co.edu.javeriana.farmaceutica.supplier.entity.Catalog;
import co.edu.javeriana.farmaceutica.supplier.entity.City;
import co.edu.javeriana.farmaceutica.supplier.entity.Supplier;
import co.edu.javeriana.farmaceutica.supplier.repository.CatalogRepository;
import co.edu.javeriana.farmaceutica.supplier.repository.CityRepository;
import co.edu.javeriana.farmaceutica.supplier.repository.DepartmentRepository;
import co.edu.javeriana.farmaceutica.supplier.repository.SupplierRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CatalogAdapter {

    private final SupplierRepository supplierRepository;
    private final CityRepository cityRepository;

    public List<Catalog> adapter(CatalogResponse catalog) {
        List<Catalog> catalogs = new ArrayList<>();
        catalog.getCatalog().forEach(cat -> {
            Optional<City> source = cityRepository.findById(cat.getSource());
            Optional<City> destination = cityRepository.findById(cat.getDestination());
            Optional<Supplier> supplier = supplierRepository.findById(cat.getSupplier());
            if(source.isPresent() && destination.isPresent() && supplier.isPresent()) {
                Catalog tmpCat = new Catalog();
                tmpCat.setId(cat.getId());
                tmpCat.setMinWeight(cat.getMinWeight());
                tmpCat.setMaxWeight(cat.getMaxWeight());
                tmpCat.setSource(source.get());
                tmpCat.setDestination(destination.get());
                tmpCat.setPrice(cat.getPrice());
                tmpCat.setSupplier(supplier.get());
                catalogs.add(tmpCat);
            }
        });
        return catalogs;
    }
}

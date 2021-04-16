package co.edu.javeriana.farmaceutica.supplier.service.impl;

import co.edu.javeriana.farmaceutica.supplier.entity.Catalog;
import co.edu.javeriana.farmaceutica.supplier.entity.City;
import co.edu.javeriana.farmaceutica.supplier.entity.Department;
import co.edu.javeriana.farmaceutica.supplier.entity.Supplier;
import co.edu.javeriana.farmaceutica.supplier.message.CatalogResponse;
import co.edu.javeriana.farmaceutica.supplier.message.CityResponse;
import co.edu.javeriana.farmaceutica.supplier.repository.CatalogRepository;
import co.edu.javeriana.farmaceutica.supplier.repository.CityRepository;
import co.edu.javeriana.farmaceutica.supplier.repository.DepartmentRepository;
import co.edu.javeriana.farmaceutica.supplier.repository.SupplierRepository;
import co.edu.javeriana.farmaceutica.supplier.service.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final DepartmentRepository departmentRepository;
    private final CityRepository cityRepository;
    private final CatalogRepository catalogRepository;

    @Transactional
    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public List<Supplier> list() {
        return supplierRepository.findAll();
    }

    @Override
    public Optional<Supplier> get(String id) {
        return supplierRepository.findById(id);
    }

    @Override
    public void syncDepartments(List<Department> departments) {
        departmentRepository.saveAll(departments);
    }

    @Override
    public void syncCities(List<CityResponse> cities) {
        cities.forEach(cityR -> {
            departmentRepository.findById(cityR.getDepartmentId()).map(depto -> {
                City city = new City();
                city.setId(cityR.getId());
                city.setName(cityR.getName());
                city.setDepartment(depto);
                return city;
            })
            .map(city -> cityRepository.save(city));
        });
    }

    @Override
    public void syncSuppliers(List<Supplier> suppliers) {
        supplierRepository.saveAll(suppliers);
    }

    @Override
    public void syncCatalog(List<CatalogResponse> catalog) {
        catalog.forEach(cat -> {
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
                catalogRepository.save(tmpCat);
            }
        });
    }
}

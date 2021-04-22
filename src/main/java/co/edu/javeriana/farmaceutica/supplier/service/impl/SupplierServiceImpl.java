package co.edu.javeriana.farmaceutica.supplier.service.impl;

import co.edu.javeriana.farmaceutica.supplier.adapter.SupplierAdapter;
import co.edu.javeriana.farmaceutica.supplier.client.SupplierClientService;
import co.edu.javeriana.farmaceutica.supplier.entity.City;
import co.edu.javeriana.farmaceutica.supplier.entity.Department;
import co.edu.javeriana.farmaceutica.supplier.entity.Supplier;
import co.edu.javeriana.farmaceutica.supplier.message.CityResponse;
import co.edu.javeriana.farmaceutica.supplier.repository.CityRepository;
import co.edu.javeriana.farmaceutica.supplier.repository.DepartmentRepository;
import co.edu.javeriana.farmaceutica.supplier.repository.SupplierRepository;
import co.edu.javeriana.farmaceutica.supplier.service.SupplierService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final DepartmentRepository departmentRepository;
    private final CityRepository cityRepository;
    private final SupplierClientService supplierClientService;
    private final SupplierAdapter supplierAdapter;

    @Transactional
    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public List<Supplier> list() {
        List<Supplier> res = new ArrayList<>();
        try {
            res = supplierAdapter.adapter(supplierClientService.list());
            log.info("Loading suppliers from ERP");
            supplierRepository.saveAll(res);
        } catch(Exception ex) {
            log.warn(ex.getMessage());
            log.info("Loading suppliers from local cache");
            res = supplierRepository.findAll();
        }
        return res;
    }

    @Override
    public Optional<Supplier> get(String id) {
        List<Supplier> list = supplierRepository.findAll();
        if(list.isEmpty()) {
            list = list();
        }
        return list.stream().filter(s -> s.getId().equals(id)).findFirst();
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
}

package co.edu.javeriana.farmaceutica.supplier.service.impl;

import co.edu.javeriana.farmaceutica.supplier.entity.Supplier;
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
}
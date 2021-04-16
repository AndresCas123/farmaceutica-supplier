package co.edu.javeriana.farmaceutica.supplier.client.impl;

import co.edu.javeriana.farmaceutica.supplier.client.SupplierClientService;
import co.edu.javeriana.farmaceutica.supplier.entity.Supplier;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierClientServiceImpl implements SupplierClientService {
    @Value("${erp.url}")
    private String erpUrl;

    private final RestTemplate restTemplate;

    @Override
    public List<Supplier> list() {
        String endpoint = String.format("%s/suppliers", erpUrl);
        return Arrays.asList(restTemplate.getForObject(endpoint, Supplier[].class));
    }
}

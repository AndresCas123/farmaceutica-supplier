package co.edu.javeriana.farmaceutica.supplier.client.impl;

import co.edu.javeriana.farmaceutica.supplier.client.SupplierClientService;
import co.edu.javeriana.farmaceutica.supplier.client.message.SuppliersResponse;
import co.edu.javeriana.farmaceutica.supplier.entity.Supplier;
import lombok.RequiredArgsConstructor;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class SupplierClientServiceImpl implements SupplierClientService {
    @Value("${erp.url}")
    private String erpUrl;

    private final RestTemplate restTemplate;

    @Override
    public SuppliersResponse list() {
        String endpoint = String.format("%s/suppliers", erpUrl);
        String res = restTemplate.getForObject(endpoint, String.class);
        Serializer serializer = new Persister();
        try {
            return serializer.read(SuppliersResponse.class, res, true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

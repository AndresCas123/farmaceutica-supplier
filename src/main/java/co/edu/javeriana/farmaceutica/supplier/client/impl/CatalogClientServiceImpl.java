package co.edu.javeriana.farmaceutica.supplier.client.impl;

import co.edu.javeriana.farmaceutica.supplier.client.CatalogClientService;
import co.edu.javeriana.farmaceutica.supplier.message.CatalogResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogClientServiceImpl implements CatalogClientService {
    @Value("${erp.url}")
    private String erpUrl;

    private final RestTemplate restTemplate;

    @Override
    public List<CatalogResponse> list() {
        String endpoint = String.format("%s/catalog", erpUrl);
        return Arrays.asList(restTemplate.getForObject(endpoint, CatalogResponse[].class));
    }
}

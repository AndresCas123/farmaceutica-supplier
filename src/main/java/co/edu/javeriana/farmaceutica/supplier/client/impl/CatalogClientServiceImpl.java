package co.edu.javeriana.farmaceutica.supplier.client.impl;

import co.edu.javeriana.farmaceutica.supplier.client.CatalogClientService;
import co.edu.javeriana.farmaceutica.supplier.client.message.CatalogResponse;
import lombok.RequiredArgsConstructor;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CatalogClientServiceImpl implements CatalogClientService {
    @Value("${erp.url}")
    private String erpUrl;

    private final RestTemplate restTemplate;

    @Override
    public CatalogResponse list() {
        String endpoint = String.format("%s/catalog", erpUrl);
        String res = restTemplate.getForObject(endpoint, String.class);
        Serializer serializer = new Persister();
        try {
            return serializer.read(CatalogResponse.class, res, true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

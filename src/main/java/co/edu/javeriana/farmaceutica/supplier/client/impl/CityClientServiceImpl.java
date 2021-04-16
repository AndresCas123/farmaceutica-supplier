package co.edu.javeriana.farmaceutica.supplier.client.impl;

import co.edu.javeriana.farmaceutica.supplier.client.CityClientService;
import co.edu.javeriana.farmaceutica.supplier.message.CityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CityClientServiceImpl implements CityClientService {
    @Value("${erp.url}")
    private String erpUrl;

    private final RestTemplate restTemplate;
    @Override
    public List<CityResponse> list() {
        String endpoint = String.format("%s/cities", erpUrl);
        return Arrays.asList(restTemplate.getForObject(endpoint, CityResponse[].class));
    }
}

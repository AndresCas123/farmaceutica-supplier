package co.edu.javeriana.farmaceutica.supplier.client.impl;

import co.edu.javeriana.farmaceutica.supplier.client.DepartmentClientService;
import co.edu.javeriana.farmaceutica.supplier.entity.Department;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentClientServiceImpl implements DepartmentClientService {
    @Value("${erp.url}")
    private String erpUrl;

    private final RestTemplate restTemplate;

    public List<Department> list() {
        String endpoint = String.format("%s/departments", erpUrl);
        return Arrays.asList(restTemplate.getForObject(endpoint, Department[].class));
    }
}

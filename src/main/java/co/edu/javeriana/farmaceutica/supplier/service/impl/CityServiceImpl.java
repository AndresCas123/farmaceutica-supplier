package co.edu.javeriana.farmaceutica.supplier.service.impl;

import co.edu.javeriana.farmaceutica.supplier.entity.City;
import co.edu.javeriana.farmaceutica.supplier.repository.CityRepository;
import co.edu.javeriana.farmaceutica.supplier.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public List<City> list() {
        return cityRepository.findAll();
    }
}

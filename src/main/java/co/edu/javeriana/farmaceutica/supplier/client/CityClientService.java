package co.edu.javeriana.farmaceutica.supplier.client;

import co.edu.javeriana.farmaceutica.supplier.message.CityResponse;

import java.util.List;

public interface CityClientService {
    List<CityResponse> list();
}

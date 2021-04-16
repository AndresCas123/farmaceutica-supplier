package co.edu.javeriana.farmaceutica.supplier.client;

import co.edu.javeriana.farmaceutica.supplier.message.CatalogResponse;
import java.util.List;

public interface CatalogClientService {
    List<CatalogResponse> list();
}

package co.edu.javeriana.farmaceutica.supplier.adapter;

import co.edu.javeriana.farmaceutica.supplier.client.SupplierClientService;
import co.edu.javeriana.farmaceutica.supplier.client.message.SuppliersResponse;
import co.edu.javeriana.farmaceutica.supplier.entity.Supplier;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SupplierAdapter {

    public List<Supplier> adapter(SuppliersResponse suppliersResponse) {
        List<Supplier> suppliers = new ArrayList<>();
        suppliersResponse.getSuppliers().forEach(c -> {
            Supplier supplier = new Supplier();
            supplier.setId(c.getId());
            supplier.setDocumentType(c.getDocumentType());
            supplier.setDocument(c.getDocument());
            supplier.setName(c.getName());
            suppliers.add(supplier);
        });
        return suppliers;
    }
}

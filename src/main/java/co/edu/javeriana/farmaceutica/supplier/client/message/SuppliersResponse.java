package co.edu.javeriana.farmaceutica.supplier.client.message;

import lombok.Data;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import java.util.List;

@Root(name = "response")
@Data
public class SuppliersResponse {
    @ElementList
    private List<SupplierResponse> suppliers;
}

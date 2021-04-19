package co.edu.javeriana.farmaceutica.supplier.client.message;

import lombok.Data;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "supplier")
@Data
public class SupplierResponse {
    @Attribute
    private String id;
    @Attribute
    private String documentType;
    @Attribute
    private String document;
    @Attribute
    private String name;
}

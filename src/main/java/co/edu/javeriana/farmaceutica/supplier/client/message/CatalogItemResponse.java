package co.edu.javeriana.farmaceutica.supplier.client.message;

import lombok.Data;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "item")
@Data
public class CatalogItemResponse {
    @Attribute
    private String id;
    @Attribute
    private long minWeight;
    @Attribute
    private long maxWeight;
    @Attribute
    private String source;
    @Attribute
    private String destination;
    @Attribute
    private double price;
    @Attribute
    private String supplier;
}

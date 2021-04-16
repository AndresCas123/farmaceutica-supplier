package co.edu.javeriana.farmaceutica.supplier.message;

import lombok.Data;

@Data
public class CatalogResponse {
    private String id;
    private long minWeight;
    private long maxWeight;
    private String source;
    private String destination;
    private double price;
    private String supplier;
}

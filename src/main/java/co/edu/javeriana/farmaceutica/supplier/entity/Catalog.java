package co.edu.javeriana.farmaceutica.supplier.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Catalog {
    @Id
    private String id;

    @ApiModelProperty(name = "minWeight", notes = "Peso mínimo")
    private long minWeight;

    @ApiModelProperty(name = "maxWeight", notes = "Peso máximo")
    private long maxWeight;

    @ApiModelProperty(name = "source", notes = "Ciudad de origen")
    @ManyToOne
    private City source;

    @ApiModelProperty(name = "destination", notes = "Ciudad de destino")
    @ManyToOne
    private City destination;

    @ApiModelProperty(name = "price", notes = "Precio")
    private double price;

    @ApiModelProperty(name = "supplier", notes = "Proveedor")
    @ManyToOne
    private Supplier supplier;
}

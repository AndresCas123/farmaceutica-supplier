package co.edu.javeriana.farmaceutica.supplier.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Supplier {
    @Id
    @ApiModelProperty(name = "id", notes = "Identificador del proveedor")
    @Column(length = 64)
    private String id;

    @ApiModelProperty(name = "documentType", notes = "Tipo de documento", required=true)
    @Column(length = 5)
    private String documentType;

    @ApiModelProperty(name = "document", notes = "Documento", required=true)
    @Column(length = 15)
    private String document;

    @ApiModelProperty(name = "name", notes = "Nombre del proveedor", required=true)
    @Column(length = 100)
    private String name;

}

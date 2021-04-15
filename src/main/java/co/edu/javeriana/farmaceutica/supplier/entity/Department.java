package co.edu.javeriana.farmaceutica.supplier.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Department {
    @Id
    @ApiModelProperty(name = "id", notes = "Código del departamento")
    @Column(length = 4)
    private String id;

    @ApiModelProperty(name = "name", notes = "Nombre")
    @Column(length = 70)
    private String name;
}

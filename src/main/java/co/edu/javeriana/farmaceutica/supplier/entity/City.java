package co.edu.javeriana.farmaceutica.supplier.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class City {
    @Id
    @ApiModelProperty(name = "id", notes = "Código de la ciudad")
    @Column(length = 10)
    private String id;

    @ApiModelProperty(name = "name", notes = "Nombre de la ciudad")
    @Column(length = 70)
    private String name;

    @ApiModelProperty(name = "department", notes = "Departamento")
    @ManyToOne
    private Department department;
}

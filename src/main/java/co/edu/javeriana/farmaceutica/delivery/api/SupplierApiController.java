package co.edu.javeriana.farmaceutica.delivery.api;

import co.edu.javeriana.farmaceutica.delivery.entity.Catalog;
import co.edu.javeriana.farmaceutica.delivery.entity.Supplier;
import co.edu.javeriana.farmaceutica.delivery.service.CatalogService;
import co.edu.javeriana.farmaceutica.delivery.service.SupplierService;
import co.edu.javeriana.farmaceutica.delivery.util.LogTrace;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "suppliers", description = "API para gestión de proveedores.", tags = { "suppliers" })
@RequestMapping("${app.context-api}/suppliers")
@RestController
@Slf4j
@AllArgsConstructor
public class SupplierApiController {

    private final SupplierService supplierService;
    private final CatalogService catalogService;

    @ApiOperation(value = "Listar proveedores.",
            nickname = "list",
            notes = "Permite listar todos los proveedores.",
                    tags = { "suppliers" })
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200, message = "Listado con proveedores.",
                    response = Supplier.class, responseContainer = "List")
        }
    )
    @GetMapping
    public ResponseEntity<?> list() {
        LogTrace.trace(log);
        return new ResponseEntity<>(supplierService.list(), HttpStatus.OK);
    }

    @ApiOperation(value = "Retorna un proveedor.",
            nickname = "get",
            notes = "Permite retornar un proveedor de acuerdo a su identificador.",
            tags = { "suppliers" })
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200, message = "Retorna el proveedor solicitado.", response = Supplier.class),
            @ApiResponse(
                    code = 404, message = "Si el proveedor no existe.")
        }
    )
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> get(@ApiParam(value = "Identificador del proveedor", required = true) @PathVariable String id) {
        LogTrace.trace(log);
        return supplierService.get(id)
                .map(supplier -> new ResponseEntity<>(supplier, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @ApiOperation(value = "Listar catalogo de servicios.",
            nickname = "list",
            notes = "Permite listar todos los servicios del catalogo del proveedor.",
            tags = { "suppliers" })
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200, message = "Listado con servicios.",
                    response = Catalog.class, responseContainer = "List")
        }
    )
    @GetMapping(value = "/{id}/catalog")
    public ResponseEntity<?> catalog(@ApiParam(value = "Identificador del proveedor", required = true) @PathVariable String id) {
        LogTrace.trace(log);
        return new ResponseEntity<>(catalogService.list(id), HttpStatus.OK);
    }
}
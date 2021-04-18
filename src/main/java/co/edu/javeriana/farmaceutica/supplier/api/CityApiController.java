package co.edu.javeriana.farmaceutica.supplier.api;

import co.edu.javeriana.farmaceutica.supplier.entity.City;
import co.edu.javeriana.farmaceutica.supplier.service.CityService;
import co.edu.javeriana.farmaceutica.supplier.util.LogTrace;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "cities", description = "API para gestión de ciudades.", tags = { "cities" })
@RequestMapping("${app.context-api}/cities")
@RestController
@Slf4j
@AllArgsConstructor
public class CityApiController {

    private final CityService cityService;

    @ApiOperation(value = "Listar ciudades.",
            nickname = "list",
            notes = "Permite listar todas las ciudades.",
            tags = { "cities" })
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200, message = "Listado con ciudades.",
                    response = City.class, responseContainer = "List")
        }
    )
    @GetMapping
    public ResponseEntity<?> list() {
        LogTrace.trace(log);
        return new ResponseEntity<>(cityService.list(), HttpStatus.OK);
    }
}

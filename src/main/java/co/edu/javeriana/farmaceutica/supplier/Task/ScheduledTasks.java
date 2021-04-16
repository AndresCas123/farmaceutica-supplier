package co.edu.javeriana.farmaceutica.supplier.Task;

import co.edu.javeriana.farmaceutica.supplier.client.CatalogClientService;
import co.edu.javeriana.farmaceutica.supplier.client.CityClientService;
import co.edu.javeriana.farmaceutica.supplier.client.DepartmentClientService;
import co.edu.javeriana.farmaceutica.supplier.client.SupplierClientService;
import co.edu.javeriana.farmaceutica.supplier.service.SupplierService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class ScheduledTasks {

    private final SupplierService supplierService;
    private final DepartmentClientService departmentClientService;
    private final CityClientService cityClientService;
    private final SupplierClientService supplierClientService;
    private final CatalogClientService catalogClientService;

    @Scheduled(cron = "0 0/5 * * * ?")
    public void sync() {
        log.info("Sincronizando departments");
        try {
            supplierService.syncDepartments(departmentClientService.list());
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
        }
        log.info("Sincronizando cities");
        try {
            supplierService.syncCities(cityClientService.list());
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
        }
        log.info("Sincronizando suppliers");
        try {
            supplierService.syncSuppliers(supplierClientService.list());
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
        }
        log.info("Sincronizando catalog");
        try {
            supplierService.syncCatalog(catalogClientService.list());
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
        }
    }
}

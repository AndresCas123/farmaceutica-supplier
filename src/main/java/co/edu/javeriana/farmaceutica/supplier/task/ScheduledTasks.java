package co.edu.javeriana.farmaceutica.supplier.task;

import co.edu.javeriana.farmaceutica.supplier.client.CatalogClientService;
import co.edu.javeriana.farmaceutica.supplier.client.CityClientService;
import co.edu.javeriana.farmaceutica.supplier.client.DepartmentClientService;
import co.edu.javeriana.farmaceutica.supplier.client.SupplierClientService;
import co.edu.javeriana.farmaceutica.supplier.client.message.SuppliersResponse;
import co.edu.javeriana.farmaceutica.supplier.entity.Supplier;
import co.edu.javeriana.farmaceutica.supplier.service.SupplierService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class ScheduledTasks {

    private final SupplierService supplierService;
    private final DepartmentClientService departmentClientService;
    private final CityClientService cityClientService;
    private final SupplierClientService supplierClientService;
    private final CatalogClientService catalogClientService;

    @Scheduled(cron = "0 0/2 * * * ?")
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
            List<Supplier> suppliers = new ArrayList<>();
            SuppliersResponse res = supplierClientService.list();
            res.getSuppliers().forEach(c -> {
                Supplier supplier = new Supplier();
                supplier.setId(c.getId());
                supplier.setDocumentType(c.getDocumentType());
                supplier.setDocument(c.getDocument());
                supplier.setName(c.getName());
                suppliers.add(supplier);
            });
            supplierService.syncSuppliers(suppliers);
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

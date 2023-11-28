package ma.peps.sqli.app.backoffice.api.facade.admin.common;

import io.swagger.v3.oas.annotations.Operation;
import ma.peps.sqli.app.backoffice.api.converter.common.ContainerTypeConverter;
import ma.peps.sqli.app.backoffice.api.dto.common.ContainerTypeDto;
import ma.peps.sqli.app.backoffice.domain.model.common.ContainerType;
import ma.peps.sqli.app.backoffice.domain.service.facade.admin.common.ContainerTypeAdminService;
import ma.peps.sqli.infra.dao.criteria.core.common.ContainerTypeCriteria;
import ma.peps.sqli.util.controller.AbstractController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/containerType/")
public class ContainerTypeRestAdmin extends AbstractController<ContainerType, ContainerTypeDto, ContainerTypeCriteria, ContainerTypeAdminService, ContainerTypeConverter> {


    @Override
    @Operation(summary = "Finds a list of all containerTypes")
    @GetMapping("")
    public ResponseEntity<List<ContainerTypeDto>> findAll() throws Exception {
        return super.findAll();
    }
    @Override
    @Operation(summary = "Finds an optimized list of all containerTypes")
    @GetMapping("optimized")
    public ResponseEntity<List<ContainerTypeDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }
    @Override
    @Operation(summary = "Finds a containerType by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ContainerTypeDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @Override
    @Operation(summary = "Saves the specified  containerType")
    @PostMapping("")
    public ResponseEntity<ContainerTypeDto> save(@RequestBody ContainerTypeDto dto) throws Exception {
        return super.save(dto);
    }
    @Override
    @Operation(summary = "Updates the specified  containerType")
    @PutMapping("")
    public ResponseEntity<ContainerTypeDto> update(@RequestBody ContainerTypeDto dto) throws Exception {
        return super.update(dto);
    }
    @Override
    @Operation(summary = "Delete the specified containerType")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }


    public ContainerTypeRestAdmin(ContainerTypeAdminService service, ContainerTypeConverter converter) {
        super(service, converter);
    }


}

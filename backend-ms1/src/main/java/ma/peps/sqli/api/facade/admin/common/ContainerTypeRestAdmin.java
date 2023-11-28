package ma.peps.sqli.api.facade.admin.common;

import io.swagger.v3.oas.annotations.Operation;
import ma.peps.sqli.domain.model.common.ContainerType;
import ma.peps.sqli.domain.service.facade.admin.common.ContainerTypeAdminService;
import ma.peps.sqli.infra.dao.criteria.core.common.ContainerTypeCriteria;
import ma.peps.sqli.api.converter.common.ContainerTypeConverter;
import ma.peps.sqli.api.dto.common.ContainerTypeDto;
import ma.peps.sqli.util.controller.AbstractController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/containerType/")
public class ContainerTypeRestAdmin extends AbstractController<ContainerType, ContainerTypeDto, ContainerTypeCriteria, ContainerTypeAdminService, ContainerTypeConverter> {


    @Operation(summary = "Finds a list of all containerTypes")
    @GetMapping("")
    public ResponseEntity<List<ContainerTypeDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all containerTypes")
    @GetMapping("optimized")
    public ResponseEntity<List<ContainerTypeDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a containerType by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ContainerTypeDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }


    @Operation(summary = "Saves the specified  containerType")
    @PostMapping("")
    public ResponseEntity<ContainerTypeDto> save(@RequestBody ContainerTypeDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  containerType")
    @PutMapping("")
    public ResponseEntity<ContainerTypeDto> update(@RequestBody ContainerTypeDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete the specified containerType")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }


    public ContainerTypeRestAdmin(ContainerTypeAdminService service, ContainerTypeConverter converter) {
        super(service, converter);
    }


}

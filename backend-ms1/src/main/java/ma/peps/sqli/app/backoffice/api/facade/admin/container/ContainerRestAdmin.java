package ma.peps.sqli.app.backoffice.api.facade.admin.container;

import io.swagger.v3.oas.annotations.Operation;
import ma.peps.sqli.app.backoffice.api.converter.container.ContainerConverter;
import ma.peps.sqli.app.backoffice.api.dto.container.ContainerDto;
import ma.peps.sqli.app.backoffice.domain.model.container.Container;
import ma.peps.sqli.app.backoffice.domain.service.facade.admin.container.ContainerAdminService;
import ma.peps.sqli.infra.dao.criteria.core.container.ContainerCriteria;
import ma.peps.sqli.util.controller.AbstractController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/container/")
public class ContainerRestAdmin extends AbstractController<Container, ContainerDto, ContainerCriteria, ContainerAdminService, ContainerConverter> {

    @Override
    @Operation(summary = "Finds a list of all containers")
    @GetMapping("")
    public ResponseEntity<List<ContainerDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Override
    @Operation(summary = "Finds a container by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ContainerDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Override
    @Operation(summary = "Saves the specified  container")
    @PostMapping("")
    public ResponseEntity<ContainerDto> save(@RequestBody ContainerDto dto) throws Exception {
        return super.save(dto);
    }
    @Override
    @Operation(summary = "Updates the specified  container")
    @PutMapping("")
    public ResponseEntity<ContainerDto> update(@RequestBody ContainerDto dto) throws Exception {
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified container")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }

    @Operation(summary = "find by type id")
    @GetMapping("type/id/{id}")
    public List<ContainerDto> findByTypeId(@PathVariable Long id) {
        return findDtos(service.findByTypeId(id));
    }

    @Operation(summary = "delete by type id")
    @DeleteMapping("type/id/{id}")
    public int deleteByTypeId(@PathVariable Long id) {
        return service.deleteByTypeId(id);
    }


    public ContainerRestAdmin(ContainerAdminService service, ContainerConverter converter) {
        super(service, converter);
    }


}

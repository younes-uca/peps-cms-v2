package ma.peps.sqli.api.facade.admin.container;

import io.swagger.v3.oas.annotations.Operation;
import ma.peps.sqli.domain.model.container.Slot;
import ma.peps.sqli.domain.service.facade.admin.container.SlotAdminService;
import ma.peps.sqli.infra.dao.criteria.core.container.SlotCriteria;
import ma.peps.sqli.api.converter.container.SlotConverter;
import ma.peps.sqli.api.dto.container.SlotDto;
import ma.peps.sqli.util.controller.AbstractController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/slot/")
public class SlotRestAdmin extends AbstractController<Slot, SlotDto, SlotCriteria, SlotAdminService, SlotConverter> {


    @Operation(summary = "Finds a list of all slots")
    @GetMapping("")
    public ResponseEntity<List<SlotDto>> findAll() throws Exception {
        return super.findAll();
    }


    @Operation(summary = "Finds a slot by id")
    @GetMapping("id/{id}")
    public ResponseEntity<SlotDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }


    @Operation(summary = "Saves the specified  slot")
    @PostMapping("")
    public ResponseEntity<SlotDto> save(@RequestBody SlotDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  slot")
    @PutMapping("")
    public ResponseEntity<SlotDto> update(@RequestBody SlotDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete the specified slot")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }

    @Operation(summary = "find by container id")
    @GetMapping("container/id/{id}")
    public List<SlotDto> findByContainerId(@PathVariable Long id) {
        return findDtos(service.findByContainerId(id));
    }

    @Operation(summary = "delete by container id")
    @DeleteMapping("container/id/{id}")
    public int deleteByContainerId(@PathVariable Long id) {
        return service.deleteByContainerId(id);
    }


    public SlotRestAdmin(SlotAdminService service, SlotConverter converter) {
        super(service, converter);
    }


}

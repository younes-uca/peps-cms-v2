package ma.peps.sqli.app.backoffice.domain.service.facade.admin.container;


import ma.peps.sqli.app.backoffice.domain.model.container.Slot;
import ma.peps.sqli.infra.dao.criteria.core.container.SlotCriteria;
import ma.peps.sqli.util.service.IService;

import java.util.List;

public interface SlotAdminService extends IService<Slot, SlotCriteria> {

    List<Slot> findByContainerId(Long id);

    int deleteByContainerId(Long id);

    long countByContainerId(Long id);


}

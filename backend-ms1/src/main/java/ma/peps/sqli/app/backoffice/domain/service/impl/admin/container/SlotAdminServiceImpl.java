package ma.peps.sqli.app.backoffice.domain.service.impl.admin.container;


import ma.peps.sqli.app.backoffice.domain.dao.container.SlotDao;
import ma.peps.sqli.app.backoffice.domain.model.container.Slot;
import ma.peps.sqli.app.backoffice.domain.service.facade.admin.container.ContainerAdminService;
import ma.peps.sqli.app.backoffice.domain.service.facade.admin.container.SlotAdminService;
import ma.peps.sqli.infra.dao.criteria.core.container.SlotCriteria;
import ma.peps.sqli.util.service.AbstractServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlotAdminServiceImpl extends AbstractServiceImpl<Slot, SlotCriteria, SlotDao> implements SlotAdminService {


    public List<Slot> findByContainerId(Long id) {
        return dao.findByContainerId(id);
    }

    public int deleteByContainerId(Long id) {
        return dao.deleteByContainerId(id);
    }

    public long countByContainerId(Long id) {
        return dao.countByContainerId(id);
    }


    public void configure() {
        super.configure(Slot.class);
    }


    public SlotAdminServiceImpl(SlotDao dao, ContainerAdminService containerService) {
        super(dao);
    }

}

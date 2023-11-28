package ma.peps.sqli.app.backoffice.domain.service.impl.admin.container;


import ma.peps.sqli.app.backoffice.domain.dao.container.ContainerDao;
import ma.peps.sqli.app.backoffice.domain.model.container.Container;
import ma.peps.sqli.app.backoffice.domain.service.facade.admin.common.ContainerTypeAdminService;
import ma.peps.sqli.app.backoffice.domain.service.facade.admin.container.ContainerAdminService;
import ma.peps.sqli.app.backoffice.domain.service.facade.admin.container.SlotAdminService;
import ma.peps.sqli.infra.dao.criteria.core.container.ContainerCriteria;
import ma.peps.sqli.util.service.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContainerAdminServiceImpl extends AbstractServiceImpl<Container, ContainerCriteria, ContainerDao> implements ContainerAdminService {


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Container save(Container t) {
        Container saved = dao.save(t);
        if (t.getSlots() != null) {
            t.getSlots().forEach(element -> {
                element.setContainer(saved);
                slotService.save(element);
            });
        }
        return saved;

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public int deleteById(Long id) {
        int result = 0;
        result += slotService.deleteByContainerId(id);
        result += dao.deleteById(id);
        return result;
    }


    public List<Container> findByTypeId(Long id) {
        return dao.findByTypeId(id);
    }

    public int deleteByTypeId(Long id) {
        return dao.deleteByTypeId(id);
    }

    public long countByTypeCode(String code) {
        return dao.countByTypeCode(code);
    }


    public void configure() {
        super.configure(Container.class);
    }


    @Autowired
    private SlotAdminService slotService;
    @Autowired
    private ContainerTypeAdminService containerTypeService;

    public ContainerAdminServiceImpl(ContainerDao dao) {
        super(dao);
    }

}

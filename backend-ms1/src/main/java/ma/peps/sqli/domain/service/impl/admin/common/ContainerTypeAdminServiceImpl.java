package ma.peps.sqli.domain.service.impl.admin.common;


import ma.peps.sqli.domain.dao.common.ContainerTypeDao;
import ma.peps.sqli.domain.model.common.ContainerType;
import ma.peps.sqli.domain.service.facade.admin.common.ContainerTypeAdminService;
import ma.peps.sqli.infra.dao.criteria.core.common.ContainerTypeCriteria;
import ma.peps.sqli.util.service.AbstractServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContainerTypeAdminServiceImpl extends AbstractServiceImpl<ContainerType, ContainerTypeCriteria, ContainerTypeDao> implements ContainerTypeAdminService {





    public ContainerType findByReferenceEntity(ContainerType t){
        return  dao.findByCode(t.getCode());
    }


    public List<ContainerType> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(ContainerType.class);
    }



    public ContainerTypeAdminServiceImpl(ContainerTypeDao dao) {
        super(dao);
    }

}

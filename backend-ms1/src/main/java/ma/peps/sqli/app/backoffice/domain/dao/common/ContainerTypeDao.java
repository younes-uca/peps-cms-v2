package ma.peps.sqli.app.backoffice.domain.dao.common;

import ma.peps.sqli.app.backoffice.domain.model.common.ContainerType;
import ma.peps.sqli.util.dao.IDao;

import java.util.List;


public interface ContainerTypeDao extends IDao<ContainerType> {

    ContainerType findByCode(String code);

    int deleteByCode(String code);

    List<ContainerType> findAllOptimized();


}

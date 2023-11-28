package ma.peps.sqli.domain.dao.common;

import ma.peps.sqli.domain.model.common.ContainerType;
import ma.peps.sqli.util.dao.IDao;

import java.util.List;


public interface ContainerTypeDao extends IDao<ContainerType> {

    ContainerType findByCode(String code);

    int deleteByCode(String code);

    List<ContainerType> findAllOptimized();


}

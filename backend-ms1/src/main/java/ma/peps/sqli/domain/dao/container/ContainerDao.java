package ma.peps.sqli.domain.dao.container;

import ma.peps.sqli.domain.model.container.Container;
import ma.peps.sqli.util.dao.IDao;

import java.util.List;


public interface ContainerDao extends IDao<Container> {

    List<Container> findByTypeId(Long id);
    int deleteByTypeId(Long id);
    long countByTypeCode(String code);



}

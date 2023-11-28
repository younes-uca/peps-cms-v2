package ma.peps.sqli.app.backoffice.domain.dao.container;

import ma.peps.sqli.app.backoffice.domain.model.container.Container;
import ma.peps.sqli.util.dao.IDao;

import java.util.List;


public interface ContainerDao extends IDao<Container> {

    List<Container> findByTypeId(Long id);

    int deleteByTypeId(Long id);

    long countByTypeCode(String code);


}

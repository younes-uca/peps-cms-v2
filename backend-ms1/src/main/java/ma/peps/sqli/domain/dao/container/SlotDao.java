package ma.peps.sqli.domain.dao.container;

import ma.peps.sqli.domain.model.container.Slot;
import ma.peps.sqli.util.dao.IDao;


import java.util.List;


public interface SlotDao extends IDao<Slot> {

    List<Slot> findByContainerId(Long id);
    int deleteByContainerId(Long id);
    long countByContainerId(Long id);



}

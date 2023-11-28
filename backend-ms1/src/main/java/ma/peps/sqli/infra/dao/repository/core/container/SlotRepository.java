package ma.peps.sqli.infra.dao.repository.core.container;

import ma.peps.sqli.infra.bean.core.container.SlotEntity;
import ma.peps.sqli.util.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SlotRepository extends AbstractRepository<SlotEntity, Long> {

    List<SlotEntity> findByContainerId(Long id);

    int deleteByContainerId(Long id);

    long countByContainerId(Long id);


}

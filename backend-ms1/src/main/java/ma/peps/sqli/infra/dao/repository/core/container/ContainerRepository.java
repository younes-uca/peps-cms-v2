package ma.peps.sqli.infra.dao.repository.core.container;

import ma.peps.sqli.infra.bean.core.container.ContainerEntity;
import ma.peps.sqli.util.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ContainerRepository extends AbstractRepository<ContainerEntity, Long> {

    List<ContainerEntity> findByTypeId(Long id);

    int deleteByTypeId(Long id);

    long countByTypeCode(String code);


}

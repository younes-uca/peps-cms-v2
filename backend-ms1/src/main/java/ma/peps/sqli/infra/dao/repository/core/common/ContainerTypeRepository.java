package ma.peps.sqli.infra.dao.repository.core.common;

import ma.peps.sqli.infra.bean.core.common.ContainerTypeEntity;
import ma.peps.sqli.util.repository.AbstractRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ContainerTypeRepository extends AbstractRepository<ContainerTypeEntity, Long> {
    ContainerTypeEntity findByCode(String code);

    int deleteByCode(String code);


    @Query("SELECT NEW ContainerTypeEntity(item.id,item.libelle) FROM ContainerTypeEntity item")
    List<ContainerTypeEntity> findAllOptimized();

}

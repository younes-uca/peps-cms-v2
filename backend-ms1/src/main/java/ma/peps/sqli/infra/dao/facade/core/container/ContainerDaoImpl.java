package ma.peps.sqli.infra.dao.facade.core.container;

import ma.peps.sqli.app.backoffice.domain.dao.container.ContainerDao;
import ma.peps.sqli.app.backoffice.domain.model.container.Container;
import ma.peps.sqli.infra.bean.core.container.ContainerEntity;
import ma.peps.sqli.infra.converter.container.ContainerInfraConverter;
import ma.peps.sqli.infra.dao.repository.core.container.ContainerRepository;
import ma.peps.sqli.util.dao.AbstractDaoImpl;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContainerDaoImpl extends AbstractDaoImpl<ContainerEntity, Container, ContainerRepository, ContainerInfraConverter> implements ContainerDao {

    public List<Container> findByTypeId(Long id) {
        List<ContainerEntity> list = repository.findByTypeId(id);
        return converter.toModel(list);
    }

    public int deleteByTypeId(Long id) {
        return repository.deleteByTypeId(id);
    }

    public long countByTypeCode(String code) {
        return repository.countByTypeCode(code);
    }


    public ContainerDaoImpl(ContainerRepository repository, ContainerInfraConverter converter) {
        super(repository, converter);
    }
}

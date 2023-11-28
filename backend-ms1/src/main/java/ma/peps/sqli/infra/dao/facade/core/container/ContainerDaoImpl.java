package ma.peps.sqli.infra.dao.facade.core.container;

import ma.peps.sqli.domain.dao.container.ContainerDao;
import ma.peps.sqli.domain.model.container.Container;
import ma.peps.sqli.infra.bean.core.container.ContainerEntity;
import ma.peps.sqli.infra.converter.container.ContainerInfraConverter;
import ma.peps.sqli.infra.dao.repository.core.container.ContainerRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContainerDaoImpl implements ContainerDao {
    private ContainerRepository repository;
    private ContainerInfraConverter converter;

    public Container save(Container model) {
        ContainerEntity entity = converter.toEntity(model);
        repository.save(entity);
        return converter.toModel(entity);
    }

    public List<Container> findAll() {
        List<ContainerEntity> list = repository.findAll();
        return converter.toModel(list);
    }

    public Container findById(Long id) {
        ContainerEntity entity = repository.findById(id).orElse(null);
        return converter.toModel(entity);
    }

    public int deleteById(Long id) {
        int res = 0;
        if (findById(id) != null) {
            repository.deleteById(id);
            res = 1;
        }
        return res;
    }

    @Override
    public List<Container> findAlloptimized() {
        return findAll();
    }

    @Override
    public Container update(Container model) {
        ContainerEntity entity = converter.toEntity(model);
        repository.save(entity);
        return converter.toModel(entity);
    }


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
        this.repository = repository;
        this.converter = converter;
    }
}

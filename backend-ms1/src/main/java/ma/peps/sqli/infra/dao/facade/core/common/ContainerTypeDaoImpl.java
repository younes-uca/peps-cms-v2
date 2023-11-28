package ma.peps.sqli.infra.dao.facade.core.common;

import ma.peps.sqli.domain.dao.common.ContainerTypeDao;
import ma.peps.sqli.domain.model.common.ContainerType;
import ma.peps.sqli.infra.bean.core.common.ContainerTypeEntity;
import ma.peps.sqli.infra.converter.common.ContainerTypeInfraConverter;
import ma.peps.sqli.infra.dao.repository.core.common.ContainerTypeRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContainerTypeDaoImpl implements ContainerTypeDao {
    private ContainerTypeRepository repository;
    private ContainerTypeInfraConverter converter;

    public ContainerType save(ContainerType model) {
        ContainerTypeEntity entity = converter.toEntity(model);
        if (entity != null && findByCode(entity.getCode()) == null) {
            ContainerTypeEntity saved = repository.save(entity);
            return converter.toModel(saved);
        } else {
            return null;
        }
    }

    public List<ContainerType> findAll() {
        List<ContainerTypeEntity> list = repository.findAll();
        return converter.toModel(list);
    }

    public ContainerType findById(Long id) {
        ContainerTypeEntity entity = repository.findById(id).orElse(null);
        return converter.toModel(entity);
    }

    public int deleteById(Long id) {
        repository.deleteById(id);
        return 1;
    }

    @Override
    public List<ContainerType> findAlloptimized() {
        return findAll();
    }

    @Override
    public ContainerType update(ContainerType model) {
        ContainerTypeEntity entity = converter.toEntity(model);
        if (entity != null && findByCode(entity.getCode()) != null) {
            repository.save(entity);
            return converter.toModel(entity);
        } else {
            return null;
        }
    }

    public ContainerType findByCode(String code) {
        ContainerTypeEntity entity = repository.findByCode(code);
        return converter.toModel(entity);
    }

    public int deleteByCode(String code) {
        return repository.deleteByCode(code);
    }


    public List<ContainerType> findAllOptimized() {
        List<ContainerTypeEntity> list = repository.findAllOptimized();
        return converter.toModel(list);
    }


    public ContainerTypeDaoImpl(ContainerTypeRepository repository, ContainerTypeInfraConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }
}

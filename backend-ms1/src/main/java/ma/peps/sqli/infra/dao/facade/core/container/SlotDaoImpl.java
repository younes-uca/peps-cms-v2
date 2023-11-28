package ma.peps.sqli.infra.dao.facade.core.container;

import ma.peps.sqli.domain.dao.container.SlotDao;
import ma.peps.sqli.domain.model.container.Slot;
import ma.peps.sqli.infra.bean.core.container.SlotEntity;
import ma.peps.sqli.infra.converter.container.SlotInfraConverter;
import ma.peps.sqli.infra.dao.repository.core.container.SlotRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SlotDaoImpl implements SlotDao {
    private SlotRepository repository;
    private SlotInfraConverter converter;

    public Slot save(Slot model) {
        SlotEntity entity = converter.toEntity(model);
        repository.save(entity);
        return converter.toModel(entity);
    }

    public List<Slot> findAll() {
        List<SlotEntity> list = repository.findAll();
        return converter.toModel(list);
    }

    public Slot findById(Long id) {
        SlotEntity entity = repository.findById(id).orElse(null);
        return converter.toModel(entity);
    }

    public int deleteById(Long id) {
        repository.deleteById(id);
        return 1;
    }

    @Override
    public List<Slot> findAlloptimized() {
        return findAll();
    }

    @Override
    public Slot update(Slot model) {
        SlotEntity entity = converter.toEntity(model);
        repository.save(entity);
        return converter.toModel(entity);
    }


    public List<Slot> findByContainerId(Long id) {
        List<SlotEntity> list = repository.findByContainerId(id);
        return converter.toModel(list);
    }

    public int deleteByContainerId(Long id) {
        return repository.deleteByContainerId(id);
    }

    public long countByContainerId(Long id) {
        return repository.countByContainerId(id);
    }


    public SlotDaoImpl(SlotRepository repository, SlotInfraConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }
}

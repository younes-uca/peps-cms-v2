package ma.peps.sqli.infra.dao.facade.core.container;

import ma.peps.sqli.app.backoffice.domain.dao.container.SlotDao;
import ma.peps.sqli.app.backoffice.domain.model.container.Slot;
import ma.peps.sqli.infra.bean.core.container.SlotEntity;
import ma.peps.sqli.infra.converter.container.SlotInfraConverter;
import ma.peps.sqli.infra.dao.repository.core.container.SlotRepository;
import ma.peps.sqli.util.dao.AbstractDaoImpl;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SlotDaoImpl extends AbstractDaoImpl<SlotEntity, Slot, SlotRepository, SlotInfraConverter> implements SlotDao {


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
        super(repository, converter);
    }
}

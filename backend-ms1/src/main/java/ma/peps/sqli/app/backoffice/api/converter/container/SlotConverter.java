package ma.peps.sqli.app.backoffice.api.converter.container;

import ma.peps.sqli.app.backoffice.api.dto.container.SlotDto;
import ma.peps.sqli.app.backoffice.domain.model.container.Container;
import ma.peps.sqli.app.backoffice.domain.model.container.Slot;
import ma.peps.sqli.util.converter.AbstractConverter;
import ma.peps.sqli.util.helper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SlotConverter extends AbstractConverter<Slot, SlotDto> {

    @Autowired
    private ContainerConverter containerConverter;
    private boolean container;

    public SlotConverter() {
        super(Slot.class, SlotDto.class);
    }

    @Override
    public Slot toItem(SlotDto dto) {
        if (dto == null) {
            return null;
        } else {
            Slot item = new Slot();
            if (StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if (StringUtil.isNotEmpty(dto.getType()))
                item.setType(dto.getType());
            if (dto.getContainer() != null && dto.getContainer().getId() != null) {
                item.setContainer(new Container());
                item.getContainer().setId(dto.getContainer().getId());
                item.getContainer().setId(dto.getContainer().getId());
            }


            return item;
        }
    }

    @Override
    public SlotDto toDto(Slot item) {
        if (item == null) {
            return null;
        } else {
            SlotDto dto = new SlotDto();
            if (StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if (StringUtil.isNotEmpty(item.getType()))
                dto.setType(item.getType());
            if (this.container && item.getContainer() != null) {
                dto.setContainer(containerConverter.toDto(item.getContainer()));
            }


            return dto;
        }
    }


    public void initObject(boolean value) {
        this.container = value;
    }


    public ContainerConverter getContainerConverter() {
        return this.containerConverter;
    }

    public void setContainerConverter(ContainerConverter containerConverter) {
        this.containerConverter = containerConverter;
    }

    public boolean isContainer() {
        return this.container;
    }

    public void setContainer(boolean container) {
        this.container = container;
    }
}

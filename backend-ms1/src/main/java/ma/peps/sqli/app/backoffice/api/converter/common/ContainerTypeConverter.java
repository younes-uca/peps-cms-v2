package ma.peps.sqli.app.backoffice.api.converter.common;

import ma.peps.sqli.app.backoffice.api.dto.common.ContainerTypeDto;
import ma.peps.sqli.app.backoffice.domain.model.common.ContainerType;
import ma.peps.sqli.util.converter.AbstractConverter;
import ma.peps.sqli.util.helper.StringUtil;
import org.springframework.stereotype.Component;

@Component
public class ContainerTypeConverter extends AbstractConverter<ContainerType, ContainerTypeDto> {


    public ContainerTypeConverter() {
        super(ContainerType.class, ContainerTypeDto.class);
    }

    @Override
    public ContainerType toItem(ContainerTypeDto dto) {
        if (dto == null) {
            return null;
        } else {
            ContainerType item = new ContainerType();
            if (StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if (StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if (StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());


            return item;
        }
    }

    @Override
    public ContainerTypeDto toDto(ContainerType item) {
        if (item == null) {
            return null;
        } else {
            ContainerTypeDto dto = new ContainerTypeDto();
            if (StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if (StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if (StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());


            return dto;
        }
    }

}

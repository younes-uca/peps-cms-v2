package ma.peps.sqli.app.backoffice.api.dto.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.peps.sqli.util.dto.AuditBaseDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContainerTypeDto extends AuditBaseDto {

    private String libelle;
    private String code;


    public ContainerTypeDto() {
        super();
    }


    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}

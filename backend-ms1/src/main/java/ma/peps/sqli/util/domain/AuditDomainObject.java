package ma.peps.sqli.util.domain;

import ma.peps.sqli.util.bean.BusinessObject;

import java.time.LocalDateTime;


public class AuditDomainObject extends BusinessObject {

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;

    private String createdBy;

    private String updatedBy;

    public AuditDomainObject() {
        super();
    }

    public AuditDomainObject(Long id) {
        super(id);
    }


    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createOn) {
        this.createdOn = createOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getCreatedBy() {
        return createdBy != null ? createdBy : "";
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy != null ? updatedBy : "";
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}

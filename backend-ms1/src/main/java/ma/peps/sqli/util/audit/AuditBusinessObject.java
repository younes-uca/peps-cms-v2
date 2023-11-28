package ma.peps.sqli.util.audit;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import ma.peps.sqli.util.bean.BusinessObject;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(EntityListener.class)
public class AuditBusinessObject extends BusinessObject {

    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private String createdBy;
    private String updatedBy;
    public AuditBusinessObject() {
        super();
    }

    public AuditBusinessObject(Long id) {
        super(id);
    }


    @JsonProperty(access = Access.READ_ONLY)
    @Column(name = "createdon", updatable = false)
    public LocalDateTime getCreatedOn() {
        return createdOn;
    }


    public void setCreatedOn(LocalDateTime createOn) {
        this.createdOn = createOn;
    }

    /**
     * updated date
     *
     * @return LocalDateTime
     */
    @JsonProperty(access = Access.READ_ONLY)
    @Column(name = "updatedon")
    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    /**
     * updated date
     *
     * @param updatedOn
     */
    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    /**
     * created user
     *
     * @return String
     */
    @JsonProperty(access = Access.READ_ONLY)
    @Column(name = "createdby", updatable = false)
    public String getCreatedBy() {
        return createdBy != null ? createdBy : "";
    }

    /**
     * created user
     *
     * @param createdBy
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * updated user
     *
     * @return String
     */
    @JsonProperty(access = Access.READ_ONLY)
    @Column(name = "updatedby")
    public String getUpdatedBy() {
        return updatedBy != null ? updatedBy : "";
    }

    /**
     * updated user
     *
     * @param UpdatedBy
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}

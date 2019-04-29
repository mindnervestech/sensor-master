package com.mnt.sensor_master.entity.base;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class AuditableLongBaseEntity extends LongIdBaseEntity implements Auditable {

    private static final long serialVersionUID = 1L;

    @Column(name = "created_date", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdDate;

    @Column(name = "modified_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date modifiedDate;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @PrePersist
    public void prePersist() {
        if (this.getCreatedDate() == null) {
            this.setCreatedDate(new Date());
        }
        if (this.getModifiedDate() == null) {
            this.setModifiedDate(new Date());
        }
    }

    @PreUpdate
    public void preUpdate() {
        this.setModifiedDate(new Date());
    }
}

package io.riders.models;

import javax.persistence.*;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * Base for all Hibernate entities which encloses insert/update dates and id with generation
 */
@MappedSuperclass
@Getter
@Setter
public class AbstractModelObject implements ModelObject{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Version
    private Integer version;

    private Date dateCreated;
    private Date lastUpdated;

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @PreUpdate
    @PrePersist
    public void updateTimeStamps() {
        lastUpdated = new Date();
        if (dateCreated==null) {
            dateCreated = new Date();
        }
    }
}

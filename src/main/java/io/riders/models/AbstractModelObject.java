package io.riders.models;

import javax.persistence.*;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by tommy on 5/5/2017.
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

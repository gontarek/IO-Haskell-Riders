package io.riders.models;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Hibernate database entity for one of the events on the page
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoryEntry extends AbstractModelObject {
  private String user;
  private String drawType;
  private String value;
}

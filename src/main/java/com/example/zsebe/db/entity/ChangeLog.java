package com.example.zsebe.db.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Marko Moravcik
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ChangeLog")
public class ChangeLog {

  @Id
  @SequenceGenerator(name = "ChangeLogSequence", sequenceName = "CHANGE_LOG_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ChangeLogSequence")
  private Long id;

  @Column
  private Long recordId;

  @Column
  private Long userId;

  @Column
  private String name;

  @Column
  private LocalDateTime dateTime;
}

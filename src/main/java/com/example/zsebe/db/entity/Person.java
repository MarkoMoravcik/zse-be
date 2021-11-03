package com.example.zsebe.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Person")
public class Person {

  @Id
  @SequenceGenerator(name = "PersonSequence", sequenceName = "PERSON_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PersonSequence")
  private Long id;

  @Column
  @NotBlank(message = "Firstname is mandatory")
  private String firstname;

  @Column
  @NotBlank(message = "Surname is mandatory")
  private String surname;

  @Column
  @NotNull(message = "Age is mandatory")
  private Integer age;

  @Transient
  private Integer recordsCount;
}

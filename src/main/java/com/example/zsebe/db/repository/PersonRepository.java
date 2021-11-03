package com.example.zsebe.db.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.zsebe.db.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

  @Override
  Page<Person> findAll(Pageable pageable);
}

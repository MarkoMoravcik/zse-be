package com.example.zsebe.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.zsebe.db.entity.ChangeLog;

@Repository
public interface ChangeLogRepository extends JpaRepository<ChangeLog, Long> {

  ChangeLog findByRecordId(Long recordId);

}

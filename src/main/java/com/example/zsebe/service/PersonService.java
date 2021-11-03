package com.example.zsebe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.zsebe.db.entity.ChangeLog;
import com.example.zsebe.db.entity.Person;
import com.example.zsebe.db.repository.ChangeLogRepository;
import com.example.zsebe.db.repository.PersonRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

  private final PersonRepository personRepository;
  private final ChangeLogRepository changeLogRepository;

  private static final String ORDER_ASCENDING = "ASC";

  public List<Person> getPersonData(final String sort, final String order, final int page,
      final int limit) {
    if (ORDER_ASCENDING.equalsIgnoreCase(order)) {
      return this.personRepository.findAll(PageRequest.of(page, limit, Sort.by(sort).ascending()))
          .toList();
    } else {
      return this.personRepository.findAll(PageRequest.of(page, limit, Sort.by(sort).descending()))
          .toList();
    }
  }

  public List<ChangeLog> getChangeLogsData() {
    return this.changeLogRepository.findAll();
  }

  public ChangeLog getConcreteChangeLog(final Long recordId) {
    return this.changeLogRepository.findByRecordId(recordId);
  }

  public long getPersonDataCount() {
    return this.personRepository.count();
  }

  public void editPersonData(final Person person) {
    this.personRepository.save(person);
  }

  public void deletePersonData(final long personId) {
    this.personRepository.deleteById(personId);
  }
}

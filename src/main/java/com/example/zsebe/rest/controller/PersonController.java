package com.example.zsebe.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.zsebe.db.entity.ChangeLog;
import com.example.zsebe.db.entity.Person;
import com.example.zsebe.service.PersonService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

  private final PersonService service;

  @GetMapping("/")
  public String getPersons() {
    return "Hello";
  }

  @GetMapping("/table-data")
  public List<Person> getPersons(@RequestParam(name = "_sort") final String sortType,
      @RequestParam(name = "_order") @NotNull final String orderType,
      @RequestParam(name = "_page") final int pageNumber,
      @RequestParam(name = "_limit") final int dataLimit) {
    return this.service.getPersonData(sortType, orderType, pageNumber, dataLimit);
  }

  @GetMapping("/meta-data")
  public long getPersonsCount() {
    return this.service.getPersonDataCount();
  }

  @GetMapping("/table-change-logs")
  public List<ChangeLog> getChangeLogs() {
    return this.service.getChangeLogsData();
  }

  @GetMapping("/table-change-log")
  public ChangeLog getConcreteChangeLogs(@RequestParam(name = "recordId") final long recordId) {
    return this.service.getConcreteChangeLog(recordId);
  }

  @PutMapping("/table-data")
  public void edidPerson(@RequestBody @Valid final Person person) {
    this.service.editPersonData(person);
  }

  @DeleteMapping("/table-data")
  public void deletePerson(@RequestParam(name = "id") final long id) {
    this.service.deletePersonData(id);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler({MethodArgumentNotValidException.class})
  public Map<String, String> handleValidationExceptions(final MethodArgumentNotValidException ex) {
    final Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> {
      final String fieldName = ((FieldError) error).getField();
      final String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });
    return errors;
  }
}

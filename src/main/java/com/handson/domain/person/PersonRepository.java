package com.handson.domain.person;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, Integer> {
  List<PersonEntity> findByNameContainingIgnoreCaseOrId(String infix1, Integer infix2);
  List<PersonEntity> findByNameContainingIgnoreCase(String infix1);
  List<PersonEntity> findByName(String name);
}

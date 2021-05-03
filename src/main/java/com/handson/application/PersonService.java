package com.handson.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.handson.domain.person.PersonRepository;
import com.handson.domain.person.PersonEntity;

@Service
@Transactional
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    /**
     * @return List<PersonEntity>
     */
    public List<PersonEntity> findAll() {
        return (List<PersonEntity>) personRepository.findAll();
    }

    /**
     * @return List<PersonEntity>
     */
    public PersonEntity find(int id) {
        return personRepository.findById(id).get();
    }

    /**
     * @param PersonEntity
     * @return PersonEntity
     */
    public PersonEntity create(PersonEntity personEntity) {
        return personRepository.save(personEntity);
    }

    /**
     * @param PersonEntity
     * @return PersonEntity
     */
    public PersonEntity update(PersonEntity personEntity) {
        return personRepository.save(personEntity);
    }

    /**
     * @param id
     */
    public void delete(Integer id) {
        personRepository.deleteById(id);
    }

    /**
     * @param q
     * @return List<PersonEntity>
     */
    public List<PersonEntity> findByNameId(String q, int id) {
        return personRepository.findByNameContainingIgnoreCaseOrId(q,id);
    }

    /**
     * @param q
     * @return List<PersonEntity>
     */
    public List<PersonEntity> findByName(String q) {
        return personRepository.findByNameContainingIgnoreCase(q);
    }

}

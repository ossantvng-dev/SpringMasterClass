package com.database.repository.jpa;

import com.database.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonJpaRepository {

    private static final String FIND_ALL_SQL = "select p from Person p";

    @PersistenceContext
    private EntityManager entityManager;

    public Person findById(int id) { return entityManager.find(Person.class, id); }

    public List<Person> findAll() { return entityManager.createQuery(FIND_ALL_SQL, Person.class).getResultList(); }

    public Person saveOrUpdate(Person person) {
        if (person.getId() == null) {
            entityManager.persist(person);
            return person;
        } else {
            return entityManager.merge(person);
        }
    }

    public boolean deleteById(int id) {
        Person person = findById(id);
        if (person != null) {
            entityManager.remove(person);
            return true;
        } else {
            return false;
        }
    }

}

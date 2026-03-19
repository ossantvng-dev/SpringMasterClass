package com.database.repository.jpa;

import com.database.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonJpaRepositoryV2 extends JpaRepository<Person, Integer> {
}

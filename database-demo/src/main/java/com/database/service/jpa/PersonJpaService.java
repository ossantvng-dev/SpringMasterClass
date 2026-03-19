package com.database.service.jpa;

import com.database.dto.PersonDto;
import com.database.entity.Person;
import com.database.mapper.PersonMapper;
import com.database.repository.jpa.PersonJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonJpaService {

    private final PersonJpaRepository repository;
    private final PersonMapper mapper;

    public PersonJpaService(PersonJpaRepository repository, PersonMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public List<PersonDto> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public PersonDto findById(Integer id) {
        Person person = repository.findById(id);
        return person != null ? mapper.toDto(person) : null;
    }

    @Transactional
    public PersonDto saveOrUpdate(PersonDto dto) {
        Person entity = mapper.toEntity(dto);
        Person saved = repository.saveOrUpdate(entity);
        return mapper.toDto(saved);
    }

    @Transactional
    public boolean deleteById(Integer id) { return repository.deleteById(id); }

}

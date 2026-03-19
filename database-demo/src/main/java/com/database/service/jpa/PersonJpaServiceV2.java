package com.database.service.jpa;

import com.database.dto.PersonDto;
import com.database.entity.Person;
import com.database.mapper.PersonMapper;
import com.database.repository.jpa.PersonJpaRepositoryV2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonJpaServiceV2 {

    private final PersonJpaRepositoryV2 repository;
    private final PersonMapper mapper;

    public PersonJpaServiceV2(PersonJpaRepositoryV2 repository, PersonMapper mapper) {
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
        return repository.findById(id)
                .map(mapper::toDto)
                .orElse(null);
    }

    @Transactional
    public PersonDto saveOrUpdate(PersonDto dto) {
        Person entity = mapper.toEntity(dto);
        Person saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    @Transactional
    public boolean deleteById(Integer id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }

}

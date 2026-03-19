package com.database.service.jdbc;

import com.database.dto.PersonDto;
import com.database.mapper.PersonMapper;
import com.database.repository.jdbc.PersonJdbcDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonJdbcService {

    private final PersonJdbcDao personJdbcDao;

    private final PersonMapper personMapper;

    public PersonJdbcService(PersonJdbcDao personJdbcDao, PersonMapper personMapper) {
        this.personJdbcDao = personJdbcDao;
        this.personMapper = personMapper;
    }

    public List<PersonDto> findAll() {
        return personJdbcDao.findAll().stream()
                .map(personMapper::toDto)
                .toList();
    }

    public PersonDto findById(int id) {
        return personMapper.toDto(personJdbcDao.findById(id));
    }

    public int insert(PersonDto personDto) {
        return personJdbcDao.insert(personMapper.toEntity(personDto));
    }

    public int update(PersonDto person) {
        return personJdbcDao.update(personMapper.toEntity(person));
    }

    public int deleteById(int id) {
        return personJdbcDao.deleteById(id);
    }
}

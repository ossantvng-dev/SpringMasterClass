package com.database.repository.jdbc;

import com.database.entity.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PersonJdbcDao {

    private final JdbcTemplate jdbc;

    public PersonJdbcDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Person> findAll() {
        return jdbc.query("SELECT * FROM PERSON", this::mapRow);
    }

    public List<Person> findAllV2() {
        return jdbc.query("SELECT * FROM PERSON", new BeanPropertyRowMapper<>(Person.class));
    }

    private Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Person(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("location"),
                rs.getTimestamp("birth_date").toLocalDateTime()
        );
    }
}
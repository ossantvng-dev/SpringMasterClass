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

    private static final String FIND_ALL_QUERY = "SELECT * FROM PERSON";

    private static final String FIND_BY_ID_QUERY = "SELECT * FROM PERSON WHERE ID = ?";

    private static final String DELETE_BY_ID_QUERY = "DELETE FROM PERSON WHERE ID = ?";

    private static final String INSERT_QUERY = """
        INSERT INTO PERSON (id, name, location, birth_date)
        VALUES (?, ?, ?, ?)
        """;

    private static final String UPDATE_QUERY = """
        UPDATE PERSON
        SET name = ?, location = ?, birth_date = ?
        WHERE id = ?
        """;

    public PersonJdbcDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Person> findAll() {
        return jdbc.query(FIND_ALL_QUERY, this::mapRow);
    }

    public List<Person> findAllV2() {
        return jdbc.query(FIND_ALL_QUERY, new BeanPropertyRowMapper<>(Person.class));
    }

    public List<Person> findAllV3() {
        return jdbc.query(FIND_ALL_QUERY, new PersonRowMapper());
    }

    public Person findById(int id) {
        return jdbc.queryForObject(FIND_BY_ID_QUERY, this::mapRow, id);
    }

    public int insert(Person person) {
        return jdbc.update(
                INSERT_QUERY,
                person.getId(),
                person.getName(),
                person.getLocation(),
                person.getBirthDate()
        );
    }

    public int update(Person person) {
        return jdbc.update(
                UPDATE_QUERY,
                person.getName(),
                person.getLocation(),
                person.getBirthDate(),
                person.getId()
        );
    }

    public int deleteById(int id) { return jdbc.update(DELETE_BY_ID_QUERY, id); }

    private Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Person(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("location"),
                rs.getTimestamp("birth_date").toLocalDateTime()
        );
    }

}
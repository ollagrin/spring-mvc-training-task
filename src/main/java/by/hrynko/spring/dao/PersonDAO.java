package by.hrynko.spring.dao;

import by.hrynko.spring.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> getAllPeople() {
        return jdbcTemplate.query("select * from people", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person getById(int id) {
        return jdbcTemplate.query("select * from people where peopleId = ?", new BeanPropertyRowMapper<>(Person.class), id).
                stream().
                findAny().
                orElse(null);
    }

    public void addPerson(Person person){
        jdbcTemplate.update("insert into people(fullName, yearOfBirth) values (?, ?)",
                person.getFullName(),
                person.getYearOfBirth()
        );
    }

    public void updatePerson(int id, Person person){
        jdbcTemplate.update("update people set fullName = ?, yearOfBirth = ? where personId = ?",
                person.getFullName(),
                person.getYearOfBirth(),
                id
        );
    }
}

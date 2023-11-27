package by.hrynko.spring.dao;

import by.hrynko.spring.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getAllBooks(){
        return jdbcTemplate.query("select * from books", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book getBookById(int id){
        return jdbcTemplate.query("select * from books b " +
                        "join people p on p.personId = b.personId where bookId = ?",
                new BeanPropertyRowMapper<>(Book.class), id
        ).stream().findAny().orElse(null);
    }

    public void addBook(Book book){
        jdbcTemplate.update("insert into books(bookName, author, yearOfPublish, personID) values (?,?,?,?)",
                book.getBookName(),
                book.getAuthor(),
                book.getYearOfPublish(),
                book.getPersonId());
    }

    public void updateBook(int id, Book book){
        jdbcTemplate.update("update people set bookName = ?, author = ?, yearOfPublish = ?, personID = ?) on bookId = ?",
                book.getBookName(),
                book.getAuthor(),
                book.getYearOfPublish(),
                book.getPersonId(),
                id
        );
    }
}

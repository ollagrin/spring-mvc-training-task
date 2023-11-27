package by.hrynko.spring.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    int bookId;
    String bookName;
    String author;
    String yearOfPublish;
    String personId;
}

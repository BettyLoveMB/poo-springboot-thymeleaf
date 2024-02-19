package com.ups.poo.domain;

import jakarta.persistence.*;
import com.ups.poo.domain.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity//una notacion jpa para definir como un modelo de bases de datos entidad

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;// long tiene mas capacidad
    private String name;
    private String lastName;
    @OneToMany(mappedBy = "author")
    //para definir un autor va tener varios libros
    private List<Book> bookList = new ArrayList<Book>();

    public Author() {
    }

    public Author(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Author(String name, String lastName, List<Book> bookList) {
        this.name = name;
        this.lastName = lastName;
        this.bookList = bookList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id.equals(author.id) && name.equals(author.name) && lastName.equals(author.lastName) && bookList.equals(author.bookList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

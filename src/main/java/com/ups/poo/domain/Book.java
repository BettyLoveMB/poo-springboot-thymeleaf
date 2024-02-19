package com.ups.poo.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Book {
    @Id//autogenerable
    @GeneratedValue(strategy = GenerationType.AUTO)//se genera la id automaticamente
    private Long Id;
    private  String title;
    private String editorial;
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = true)//NN
    private Author author;

    public Book() {
    }

    public Book(String title, String editorial) {
        this.title = title;
        this.editorial = editorial;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return title.equals(book.title) && editorial.equals(book.editorial) && author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "Id=" + Id +
                ", title='" + title + '\'' +
                ", editorial='" + editorial + '\'' +
                '}';
    }
}

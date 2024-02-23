package com.ups.poo.BootStrap;

import com.ups.poo.domain.Author;
import com.ups.poo.domain.Book;
import com.ups.poo.repository.AuthorRepository;
import com.ups.poo.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Book book1 = new Book();
        book1.setTitle("Los 3 Mosqueteros");
        book1.setEditorial("Pearson");

        Book book2 = new Book();
        book2.setTitle("Cinderella");
        book2.setEditorial("Disney");

        Author author1 = new Author("Betty", "Melso");
        author1.getBooks().add(book1);
        author1.getBooks().add(book2);

        Book book3 = new Book();
        book3.setTitle("One piece");
        book3.setEditorial("Oda");

        Book book4 = new Book();
        book4.setTitle("The beauty and the beast");
        book4.setEditorial("Disney");

        Author author2 = new Author("Betty", "Melso");
        author2.getBooks().add(book3);
        author2.getBooks().add(book4);
        //save object in entities
        bookRepository.save(book1);
        bookRepository.save(book2);
        authorRepository.save(author1);

        bookRepository.save(book3);
        bookRepository.save(book4);
        authorRepository.save(author2);

        System.out.println("---------Started BootStrapData-------");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());

    }
}

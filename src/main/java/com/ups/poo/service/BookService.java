package com.ups.poo.service;

import com.ups.poo.domain.Book;
import com.ups.poo.dto.AuthorDTO;
import com.ups.poo.dto.BookDTO;
import com.ups.poo.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

public class BookService {
    private final BookRepository bookRepository;


    public BookService (BookRepository bookRepository) {
        this.bookRepository = bookRepository;}

    public List<BookDTO> findAll(){
        List<BookDTO> bookDTOList = new ArrayList<>();
        Iterable<Book> bookIterable = bookRepository.findAll();
        for (Book book: bookIterable){
            BookDTO bookDTO = new BookDTO(book.getTitle(), book.getEditorial());
            AuthorDTO authorDTO = new AuthorDTO(book.getAuthor().getName(), book.getAuthor().getLastname());
            bookDTO.setAuthorDTO(authorDTO);
            bookDTO.setPublisher(book.getPublisher());
            bookDTOList.add(bookDTO);
        }
        return bookDTOList;
    }
}

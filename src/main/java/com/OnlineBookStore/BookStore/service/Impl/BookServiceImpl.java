package com.OnlineBookStore.BookStore.service.Impl;

import com.OnlineBookStore.BookStore.entity.Book;
import com.OnlineBookStore.BookStore.payload.BookDTO;
import com.OnlineBookStore.BookStore.repository.BookRepository;
import com.OnlineBookStore.BookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookDTO createBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setDescription(bookDTO.getDescription());
        book.setYear(bookDTO.getYear());
        book.setPrice(bookDTO.getPrice());
        Book savedBook = bookRepository.save(book);
        return toDTO(savedBook);
    }

    @Override
    public List<BookDTO> searchBooks(String title) {
        List<Book> books = bookRepository.findByTitleContainingIgnoreCase(title);
        return books.stream().map(this::toDTO).collect(Collectors.toList());
    }

    private BookDTO toDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setDescription(book.getDescription());
        bookDTO.setYear(book.getYear());
        bookDTO.setPrice(book.getPrice());
        return bookDTO;
    }
}

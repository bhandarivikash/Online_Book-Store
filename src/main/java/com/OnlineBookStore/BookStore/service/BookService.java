package com.OnlineBookStore.BookStore.service;

import com.OnlineBookStore.BookStore.payload.BookDTO;

import java.util.List;

public interface BookService {
    BookDTO createBook(BookDTO bookDTO);
    List<BookDTO> searchBooks(String title);
}
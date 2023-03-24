package com.OnlineBookStore.BookStore.service;

import com.OnlineBookStore.BookStore.exception.NotFoundException;
import com.OnlineBookStore.BookStore.payload.UserDTO;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    UserDTO getUserByUsername(String username) throws NotFoundException;
}
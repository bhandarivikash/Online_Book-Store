package com.OnlineBookStore.BookStore.repository;

import com.OnlineBookStore.BookStore.entity.Order;
import com.OnlineBookStore.BookStore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUser(User user);

}
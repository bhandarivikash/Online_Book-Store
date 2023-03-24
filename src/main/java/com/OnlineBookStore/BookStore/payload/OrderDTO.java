package com.OnlineBookStore.BookStore.payload;

import com.OnlineBookStore.BookStore.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;

@Data
public class OrderDTO {

    private Long id;

    @Column(name = "user", nullable = false)
    private UserDTO user;

    @Column(name = "book", nullable = false)
    private BookDTO book;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "price", nullable = false)
    private Double price;

    private Order order;

}
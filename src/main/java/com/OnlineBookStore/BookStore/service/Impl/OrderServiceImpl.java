package com.OnlineBookStore.BookStore.service.Impl;

import com.OnlineBookStore.BookStore.entity.Book;
import com.OnlineBookStore.BookStore.entity.Order;
import com.OnlineBookStore.BookStore.exception.OrderNotFoundException;
import com.OnlineBookStore.BookStore.payload.BookDTO;
import com.OnlineBookStore.BookStore.payload.OrderDTO;
import com.OnlineBookStore.BookStore.repository.OrderRepository;
import com.OnlineBookStore.BookStore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderDTO> orderDTOs = new ArrayList<>();

        for (Order order : orders) {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setId(order.getId());
            orderDTO.setBook((BookDTO) order.getBook());
            orderDTO.setQuantity(order.getQuantity());
            orderDTOs.add(orderDTO);
        }

        return orderDTOs;
    }

    @Override
    public OrderDTO getOrderById(Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);

        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setId(order.getId());
            orderDTO.setBook((BookDTO) order.getBook());
            orderDTO.setQuantity(order.getQuantity());
            return orderDTO;
        }

        throw new OrderNotFoundException("Order not found with id: " + id);
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setBook((List<Book>) orderDTO.getBook());
        order.setQuantity(orderDTO.getQuantity());

        order = orderRepository.save(order);

        orderDTO.setId(order.getId());
        return orderDTO;
    }

    @Override
    public List<OrderDTO> getOrdersByUsername(String username) {
        return null;
    }

    @Override
    public OrderDTO updateOrder(Long id, OrderDTO orderDTO) {
        Optional<Order> optionalOrder = orderRepository.findById(id);

        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setBook((List<Book>) orderDTO.getBook());
            order.setQuantity(orderDTO.getQuantity());
            order = orderRepository.save(order);

            orderDTO.setId(order.getId());
            return orderDTO;
        }

        throw new OrderNotFoundException("Order not found with id: " + id);
    }

    @Override
    public void deleteOrder(Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);

        if (optionalOrder.isPresent()) {
            orderRepository.deleteById(id);
        } else {
            throw new OrderNotFoundException("Order not found with id: " + id);
        }
    }
}

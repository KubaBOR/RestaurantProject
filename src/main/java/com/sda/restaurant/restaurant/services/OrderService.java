package com.sda.restaurant.restaurant.services;

import com.sda.restaurant.restaurant.DTO.OrderDTO;
import com.sda.restaurant.restaurant.controllers.OrderController;
import com.sda.restaurant.restaurant.model.OrderEntity;
import com.sda.restaurant.restaurant.repositories.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public OrderService(OrderRepository orderRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

    public Long addOrder(OrderController.OrderForm orderForm){
        OrderEntity orderEntity = modelMapper.map(orderForm, OrderEntity.class);
        return orderRepository.save(orderEntity).getId();
    }
    public List<OrderDTO> getAllOrders(){
        return orderRepository.findAll(Sort.by(Sort.Direction.ASC, "id")).stream()
                .map(order -> modelMapper.map(order, OrderDTO.class))
                .collect(Collectors.toList());
    }
    public void deleteOrderById(Long id) { orderRepository.deleteById(id);}
}

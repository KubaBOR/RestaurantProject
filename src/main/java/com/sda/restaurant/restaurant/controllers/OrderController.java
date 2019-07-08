package com.sda.restaurant.restaurant.controllers;

import com.sda.restaurant.restaurant.DTO.OrderDTO;
import com.sda.restaurant.restaurant.DTO.ReservationDTO;
import com.sda.restaurant.restaurant.repositories.OrderRepository;
import com.sda.restaurant.restaurant.services.MenuService;
import com.sda.restaurant.restaurant.services.OrderService;
import com.sda.restaurant.restaurant.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Set;

@Controller
public class OrderController {
    private OrderService orderService;
    private OrderRepository orderRepository;
    private ReservationService reservationService;
    private MenuService menuService;

    @Autowired
    public OrderController(OrderService orderService, OrderRepository orderRepository, ReservationService reservationService, MenuService menuService) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
        this.reservationService = reservationService;
        this.menuService = menuService;
    }

    @GetMapping("/allOrdersPage")
    public String displayAllOrders(Model model){
        setupModel(model);
        return "allOrdersPage";
    }

    @PostMapping("/addOrderAction")
    public RedirectView addNewOrder(@ModelAttribute("orderForm") OrderForm orderForm, Model model){
        orderService.addOrder(orderForm);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/allOrdersPage");
        return redirectView;
    }

    @DeleteMapping("/deleteOrderAction/{id}")
    public RedirectView deleteOrder(@PathVariable Long id){
        orderService.deleteOrderById(id);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/allOrdersPage");
        return redirectView;
    }

//    @PutMapping("/orders/{id}")
//    public RedirectView updateOrder(@PathVariable Long id){
//        orderService.updateStuff(id);
//        RedirectView redirectView = new RedirectView();
//        redirectView.setUrl("/allOrdersPage");
//        return redirectView;
//    }

    private void setupModel(Model model){
        List<ReservationDTO> allReservations = reservationService.getAllReservations();
        model.addAttribute("AllReservations",allReservations);
        model.addAttribute("allMenus",menuService.getAllMenus());
        model.addAttribute("allOrders",orderService.getAllOrders());
        model.addAttribute("orderForm", new OrderForm());
    }

    public static class OrderForm{
        public OrderForm() {
        }

        Long reservationId;
        List<Long> menuId;

        public Long getReservationId() {
            return reservationId;
        }

        public void setReservationId(Long reservationId) {
            this.reservationId = reservationId;
        }

        public List<Long> getMenuId() {
            return menuId;
        }

        public void setMenuId(List<Long> menuId) {
            this.menuId = menuId;
        }
    }
}



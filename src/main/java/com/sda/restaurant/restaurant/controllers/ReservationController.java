package com.sda.restaurant.restaurant.controllers;

import com.sda.restaurant.restaurant.DTO.ReservationDTO;
import com.sda.restaurant.restaurant.model.ReservationEntity;
import com.sda.restaurant.restaurant.services.ClientService;
import com.sda.restaurant.restaurant.services.ReservationService;
import com.sda.restaurant.restaurant.services.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class ReservationController {

    private ReservationService reservationService;

    private ClientService clientService;

    private TableService tableService;

    @Autowired
    public ReservationController(ReservationService reservationService, ClientService clientService, TableService tableService) {
        this.reservationService = reservationService;
        this.clientService = clientService;
        this.tableService = tableService;
    }

    @GetMapping("/allReservationsPage")
    public String displayAllReservations(Model model) {
        setupModel(model);
        return "allReservationsPage";
    }
    @PostMapping("/addReservationAction")
    public RedirectView addNewReservation(@ModelAttribute ReservationDTO reservationDTO){
        reservationService.saveReservation(reservationDTO);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/allReservationsPage");
        return redirectView;
    }
    private void setupModel(Model model){
        List<ReservationDTO> allReservations = reservationService.getAllReservations();
        model.addAttribute("allReservations", allReservations);
        model.addAttribute("allClients", clientService.getAllClients());
        model.addAttribute("allTables", tableService.getAllTables());
        model.addAttribute("newReservation", new ReservationEntity());
    }
}

package com.sda.restaurant.restaurant.controllers;

import com.sda.restaurant.restaurant.DTO.ReservationDTO;
import com.sda.restaurant.restaurant.form.ReservationForm;
import com.sda.restaurant.restaurant.model.ReservationEntity;
import com.sda.restaurant.restaurant.repositories.ReservationRepository;
import com.sda.restaurant.restaurant.services.ClientService;
import com.sda.restaurant.restaurant.services.ReservationService;
import com.sda.restaurant.restaurant.services.TableService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
public class ReservationController {

    private ReservationService reservationService;

    private ReservationRepository reservationRepository;

    private ClientService clientService;

    private TableService tableService;

    @Autowired
    public ReservationController(ReservationService reservationService, ReservationRepository reservationRepository, ClientService clientService, TableService tableService) {
        this.reservationService = reservationService;
        this.reservationRepository = reservationRepository;
        this.clientService = clientService;
        this.tableService = tableService;
    }

    @GetMapping("/allReservationsPage")
    public String displayAllReservations(Model model) {
        setupModel(model);
        return "allReservationsPage";
    }

    @PostMapping("/addReservationAction")
    public RedirectView addNewReservation(@ModelAttribute("reservationForm") ReservationForm reservationForm, Model model) {
        reservationService.saveReservation(reservationForm);
        tableService.updateTableToOccupied(reservationForm.getTablesId());
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/allReservationsPage");
        return redirectView;
    }

    @GetMapping("/reservations/{id}")
    public ReservationEntity retrieveReservation(@PathVariable Long id) throws NotFoundException {
        Optional<ReservationEntity> reservation = reservationRepository.findById(id);
        if (!reservation.isPresent()) {
            throw new NotFoundException("id- " + id);
        }
        return reservation.get();
    }

    @DeleteMapping("/deleteReservationAction/{id}")
    public RedirectView deleteReservation(@PathVariable Long id) {
        tableService.updateTableToNotOccupied(reservationService.getReservationById(id).getTables().getId());
        reservationService.deleteReservationById(id);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/allReservationsPage");
        return redirectView;
    }

    @PutMapping("/reservations/{id}")
    public RedirectView updateReservation(@PathVariable Long id) {
        ReservationDTO reservation = reservationService.updateStuff(id);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/allReservationsPage");
        return redirectView;
    }
    @PostMapping("/setTipAmount/{id}")
    public RedirectView updateTimAmount (ReservationDTO reservation, @PathVariable Long id, @RequestParam Float tip) {
        reservationService.updateTipAmount(id, tip);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/allReservationsPage");
        return redirectView;
    }

    private void setupModel(Model model) {
        List<ReservationDTO> allReservations = reservationService.getAllReservations();
        model.addAttribute("allReservations", allReservations);
        model.addAttribute("allClients", clientService.getAllClients());
        model.addAttribute("allTables", tableService.getAllTables());
        model.addAttribute("reservationForm", new ReservationForm());
    }
}

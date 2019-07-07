package com.sda.restaurant.restaurant.controllers;

import com.sda.restaurant.restaurant.DTO.ReservationDTO;
import com.sda.restaurant.restaurant.model.ReservationEntity;
import com.sda.restaurant.restaurant.services.ClientService;
import com.sda.restaurant.restaurant.services.ReservationService;
import com.sda.restaurant.restaurant.services.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDateTime;
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
    public RedirectView addNewReservation(@ModelAttribute("reservationForm") ReservationForm reservationForm, Model model){



        //reservationService.saveReservation(reservationDTO);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/allReservationsPage");
        return redirectView;
    }
    private void setupModel(Model model){
        List<ReservationDTO> allReservations = reservationService.getAllReservations();
        model.addAttribute("allReservations", allReservations);
        model.addAttribute("allClients", clientService.getAllClients());
        model.addAttribute("allTables", tableService.getAllTables());
        model.addAttribute("reservationForm", new ReservationForm());
    }

    public static class ReservationForm{
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        private LocalDateTime dateAndTime;
        private Boolean isPaid = false;
        private Float tip;

        Long clientId;
        List<Long> tablesIds;

        public ReservationForm(){}

        public Long getClientId() {
            return clientId;
        }

        public void setClientId(Long clientId) {
            this.clientId = clientId;
        }

        public LocalDateTime getDateAndTime() {
            return dateAndTime;
        }

        public void setDateAndTime(LocalDateTime dateAndTime) {
            this.dateAndTime = dateAndTime;
        }

        public Boolean getPaid() {
            return isPaid;
        }

        public void setPaid(Boolean paid) {
            isPaid = paid;
        }

        public Float getTip() {
            return tip;
        }

        public void setTip(Float tip) {
            this.tip = tip;
        }

        public List<Long> getTablesIds() {
            return tablesIds;
        }

        public void setTablesIds(List<Long> tablesIds) {
            this.tablesIds = tablesIds;
        }
    }
}

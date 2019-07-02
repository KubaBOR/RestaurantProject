package com.sda.restaurant.restaurant.controllers;

import com.sda.restaurant.restaurant.entities.Client;
import com.sda.restaurant.restaurant.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/allClientsPage")
    public String displayAllClients(Model model){
        setupModel(model);
        return "allClientsPage";
    }

    private void setupModel(Model model){
        List<Client> allClients = clientService.getAllClients();
        model.addAttribute("allClients", allClients);
    }
}
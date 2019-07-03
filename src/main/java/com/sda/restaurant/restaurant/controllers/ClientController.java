package com.sda.restaurant.restaurant.controllers;

import com.sda.restaurant.restaurant.entities.Client;
import com.sda.restaurant.restaurant.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

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

    @PostMapping("/addClientAction")
    public RedirectView addNewClient(@ModelAttribute("newClient") Client client) {
        clientService.saveClient(client);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/allClientsPage");
        return redirectView;
    }

    private void setupModel(Model model){
        List<Client> allClients = clientService.getAllClients();
        model.addAttribute("allClients", allClients);
        model.addAttribute("newClient", new Client());
    }
}
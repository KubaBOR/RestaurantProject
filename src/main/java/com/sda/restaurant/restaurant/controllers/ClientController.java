package com.sda.restaurant.restaurant.controllers;

import com.sda.restaurant.restaurant.entities.Client;
import com.sda.restaurant.restaurant.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping(path="/")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/add")
    public @ResponseBody String addNewClient(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String email,
            @RequestParam String phoneNumber){
        Client c = new Client();
        c.setName(name);
        c.setSurname(surname);
        c.setEmail(email);
        c.setPhoneNumber(phoneNumber);

        clientRepository.save(c);
        return "Saved";

    }

}

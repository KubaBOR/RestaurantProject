package com.sda.restaurant.restaurant.controllers;

import com.sda.restaurant.restaurant.entities.Menu;
import com.sda.restaurant.restaurant.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class MenuController {

    private MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) { this.menuService = menuService; }

    @GetMapping("/allMenusPage")
    public String displayAllMenus(Model model){
        setupModel(model);
        return "allMenusPage";
    }

    @PostMapping("/addMenuAction")
    public RedirectView addNewMenu(@ModelAttribute("newMenu") Menu menu){
        menuService.saveMenu(menu);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/allMenusPage");
        return redirectView;
    }

    private void setupModel(Model model){
        List<Menu> allMenus = menuService.getAllMenus();
        model.addAttribute("allMenus",allMenus);
        model.addAttribute("newMenu",new Menu());
    }
}

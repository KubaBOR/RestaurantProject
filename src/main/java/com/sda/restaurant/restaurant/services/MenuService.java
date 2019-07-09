package com.sda.restaurant.restaurant.services;

import com.sda.restaurant.restaurant.DTO.MenuDTO;
import com.sda.restaurant.restaurant.model.MenuEntity;
import com.sda.restaurant.restaurant.repositories.MenuRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuService {

    private final MenuRepository menuRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MenuService(MenuRepository menuRepository, ModelMapper modelMapper) {
        this.menuRepository = menuRepository;
        this.modelMapper = modelMapper;
    }

    public Long saveMenu(MenuDTO menu){
        MenuEntity menu1 = modelMapper.map(menu, MenuEntity.class);
        return menuRepository.save(menu1).getId();
    }

    public List<MenuDTO> getAllMenus(){
        return menuRepository.findAll(Sort.by(Sort.Direction.ASC,"number")).stream()
                .map(menu -> modelMapper.map(menu, MenuDTO.class))
                .collect(Collectors.toList());
    }

    public MenuDTO findByCategory (String category){
        MenuEntity menuToFind = menuRepository.findByCategory(category);
        return modelMapper.map(menuToFind, MenuDTO.class);
    }

    public void deleteMenuById(Long id){
        menuRepository.deleteById(id);
    }


    @PostConstruct
    public void createMenuForPresentation() {
        if (menuRepository.count() < 30) {
            menuRepository.deleteAll();
            menuRepository.save(new MenuEntity(1, "Drink", "Espresso", 11.50F));
            menuRepository.save(new MenuEntity(2, "Drink", "Espresso Lungo", 14.50F));
            menuRepository.save(new MenuEntity(3, "Drink", "Espresso Con Panna", 17.0F));
            menuRepository.save(new MenuEntity(4, "Drink", "Caffe Americano", 18.50F));
            menuRepository.save(new MenuEntity(5, "Drink", "Caffe Mocha", 19F));
            menuRepository.save(new MenuEntity(6, "Drink", "Cafe Latte", 21.50F));
            menuRepository.save(new MenuEntity(7, "Drink", "Cappuccino", 21.50F));
            menuRepository.save(new MenuEntity(8, "Drink", "Paper Plane", 29F));
            menuRepository.save(new MenuEntity(9, "Drink", "Rocking Horse", 35F));
            menuRepository.save(new MenuEntity(10, "Drink", "Havana Club", 38F));
            menuRepository.save(new MenuEntity(11, "Drink", "The Ivy Spiced Rum", 46.50F));
            menuRepository.save(new MenuEntity(12, "Dinner", "Tomato Soup", 18.50F));
            menuRepository.save(new MenuEntity(13, "Dinner", "Mushroom Soup", 18.50F));
            menuRepository.save(new MenuEntity(14, "Dinner", "Dressed Cornish Crab", 92.00F));
            menuRepository.save(new MenuEntity(15, "Dinner", "Oscietra Caviar 30g", 455.00F));
            menuRepository.save(new MenuEntity(16, "Dinner", "Crispy Duck & Mango salad", 76.00F));
            menuRepository.save(new MenuEntity(17, "Dinner", "The Ristorante Burger", 98.00F));
            menuRepository.save(new MenuEntity(18, "Dinner", "The Ristorante Burger", 98.00F));
            menuRepository.save(new MenuEntity(19, "Dinner", "The Ristorante Pizza 40cm", 82.00F));
            menuRepository.save(new MenuEntity(20, "Dessert", "Chocolate Pyramid", 35.50F));
            menuRepository.save(new MenuEntity(21, "Dessert", "Ristorante Cheesecake", 42.00F));
            menuRepository.save(new MenuEntity(22, "Dessert", "Polish Strawberries", 32.50F));
            menuRepository.save(new MenuEntity(23, "Vegetarian", "Beetroot Salad", 28.50F));
            menuRepository.save(new MenuEntity(24, "Vegetarian", "The Ristorante Salad", 28.50F));
            menuRepository.save(new MenuEntity(25, "Vegetarian", "Chickpeas Salad", 28.50F));
            menuRepository.save(new MenuEntity(26, "Wine", "Burgundy", 379.0F));
            menuRepository.save(new MenuEntity(27, "Wine", "Stellenbosch", 239.0F));
            menuRepository.save(new MenuEntity(28, "Wine", "Castilla & Leon", 209.0F));
            menuRepository.save(new MenuEntity(29, "Wine", "Castilla & Leon", 209.0F));
            menuRepository.save(new MenuEntity(30, "Wine", "Piedmont", 750.0F));
            menuRepository.save(new MenuEntity(31, "Wine", "Blanc de Blancs", 510.0F));
            menuRepository.save(new MenuEntity(32, "Wine", "Le Mesnil Salon", 3700.0F));
        }
    }
}

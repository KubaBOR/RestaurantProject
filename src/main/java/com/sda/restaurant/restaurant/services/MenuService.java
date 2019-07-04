package com.sda.restaurant.restaurant.services;

import com.sda.restaurant.restaurant.entities.Menu;
import com.sda.restaurant.restaurant.repositories.MenuRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

    public Long saveMenu(Menu menu){
        Menu menu1 = modelMapper.map(menu,Menu.class);
        return menuRepository.save(menu1).getId();
    }

    public List<Menu> getAllMenus(){
        return menuRepository.findAll(Sort.by(Sort.Direction.ASC,"number")).stream()
                .map(menu -> modelMapper.map(menu,Menu.class))
                .collect(Collectors.toList());
    }

    public Menu findByCategory (String category){
        Menu menuToFind = menuRepository.findByCategory(category);
        return modelMapper.map(menuToFind,Menu.class);
    }

}

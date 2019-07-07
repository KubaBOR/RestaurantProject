package com.sda.restaurant.restaurant.services;

import com.sda.restaurant.restaurant.DTO.MenuDTO;
import com.sda.restaurant.restaurant.model.MenuEntity;
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
}

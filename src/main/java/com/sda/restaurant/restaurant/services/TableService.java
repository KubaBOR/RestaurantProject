package com.sda.restaurant.restaurant.services;

import com.sda.restaurant.restaurant.model.TablesEntity;
import com.sda.restaurant.restaurant.repositories.TableRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TableService {

    private final TableRepository tableRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public TableService(TableRepository tableRepository, ModelMapper modelMapper) {
        this.tableRepository = tableRepository;
        this.modelMapper = modelMapper;
    }

    public Long saveTable(TablesEntity tables) {
        TablesEntity tablesToSave = modelMapper.map(tables, TablesEntity.class);

        return tableRepository.save(tablesToSave).getId();
    }

    public List<TablesEntity> getAllTables(){
        return tableRepository.findAll(Sort.by(Sort.Direction.ASC, "size")).stream()
                .map(tables -> modelMapper.map(tables, TablesEntity.class))
                .collect(Collectors.toList());
    }
    public void deleteTableById(Long id){
        tableRepository.deleteById(id);
    }
}
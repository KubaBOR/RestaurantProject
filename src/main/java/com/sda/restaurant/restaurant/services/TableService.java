package com.sda.restaurant.restaurant.services;

import com.sda.restaurant.restaurant.DTO.TablesDTO;
import com.sda.restaurant.restaurant.model.TablesEntity;
import com.sda.restaurant.restaurant.repositories.TableRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
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

    public Long saveTable(TablesDTO tables) {
        TablesEntity tablesToSave = modelMapper.map(tables, TablesEntity.class);

        return tableRepository.save(tablesToSave).getId();
    }

    public List<TablesDTO> getAllTables(){
        return tableRepository.findAll(Sort.by(Sort.Direction.ASC, "size")).stream()
                .map(tables -> modelMapper.map(tables, TablesDTO.class))
                .collect(Collectors.toList());
    }
    public void deleteTableById(Long id){
        tableRepository.deleteById(id);
    }

    @PostConstruct
    public void createTablesForPresentation(){
        if (tableRepository.count() < 5) {
            tableRepository.deleteAll();
            tableRepository.save(new TablesEntity(2));
            tableRepository.save(new TablesEntity(4));
            tableRepository.save(new TablesEntity(6));
            tableRepository.save(new TablesEntity(8));
            tableRepository.save(new TablesEntity(10));
        }
    }
}

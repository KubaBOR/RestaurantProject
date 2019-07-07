package com.sda.restaurant.restaurant.services;

import com.sda.restaurant.restaurant.DTO.ReservationDTO;
import com.sda.restaurant.restaurant.controllers.ReservationController;
import com.sda.restaurant.restaurant.model.ReservationEntity;
import com.sda.restaurant.restaurant.repositories.ReservationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, ModelMapper modelMapper) {
        this.reservationRepository = reservationRepository;
        this.modelMapper = modelMapper;
    }

    public Long saveReservation(ReservationController.ReservationForm reservationForm) {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        ReservationEntity reservationEntity = modelMapper.map(reservationForm, ReservationEntity.class);
        return reservationRepository.save(reservationEntity).getId();
    }

    public List<ReservationDTO> getAllReservations(){
        return reservationRepository.findAll(Sort.by(Sort.Direction.ASC, "id")).stream()
                .map(reservationEntity -> modelMapper.map(reservationEntity, ReservationDTO.class))
                .collect(Collectors.toList());
    }

}

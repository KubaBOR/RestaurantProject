package com.sda.restaurant.restaurant.services;

import com.sda.restaurant.restaurant.DTO.ReservationDTO;
import com.sda.restaurant.restaurant.form.ReservationForm;
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

    public Long saveReservation(ReservationForm reservationForm) {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        ReservationEntity reservationEntity = modelMapper.map(reservationForm, ReservationEntity.class);

        return reservationRepository.save(reservationEntity).getId();
    }

    public ReservationDTO updateStuff(Long reservationId) {
        ReservationEntity foundReservation = reservationRepository.getOne(reservationId);
        foundReservation.setPaid(true);
        reservationRepository.save(foundReservation);
        return modelMapper.map(foundReservation, ReservationDTO.class);
    }

    public ReservationDTO updateTipAmount(Long id, Float tipAmount) {
        ReservationEntity foundReservation = reservationRepository.getOne(id);
        foundReservation.setTip(tipAmount);
        reservationRepository.save(foundReservation);
        return modelMapper.map(foundReservation, ReservationDTO.class);
    }

    public void deleteReservationById(Long id) {
        reservationRepository.deleteById(id);
    }

    public ReservationDTO getReservationById(Long id) {
        ReservationEntity foundReservation = reservationRepository.getById(id);
        return modelMapper.map(foundReservation, ReservationDTO.class);
    }

    public List<ReservationDTO> getAllReservations() {
        return reservationRepository.findAll(Sort.by(Sort.Direction.ASC, "id")).stream()
                .map(reservationEntity -> modelMapper.map(reservationEntity, ReservationDTO.class))
                .collect(Collectors.toList());
    }


}

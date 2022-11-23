package com.api_java_folcademy.demo.service;

import com.api_java_folcademy.demo.model.domain.ContactoDTO;
import com.api_java_folcademy.demo.model.domain.MensajeDTO;
import com.api_java_folcademy.demo.model.mapper.ContactoMapper;
import com.api_java_folcademy.demo.model.repository.ContactoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactoService {
    private final ContactoRepository contactoRepository;
    private final ContactoMapper contactoMapper;

    public ContactoService(ContactoRepository contactoRepository, ContactoMapper contactoMapper) {
        this.contactoRepository = contactoRepository;
        this.contactoMapper = contactoMapper;
    }

    public List<ContactoDTO> findAll(){
        return contactoRepository
                .findAll()
                .stream()
                .map(contactoMapper::contactoEntityToContactoDTO)
                .collect(Collectors.toList());
    }

    public MensajeDTO add(ContactoDTO contactoDTO){
        return Optional
                .ofNullable(contactoDTO)
                .map(dto -> contactoMapper.contactoDTOToContactoEntity(dto))
                .map(entity -> contactoRepository.save(entity))
                .map(entity -> contactoMapper.contactoEntityToContactoDTO(entity))
                .map(entity -> contactoMapper.contactoDTOToMensaje(entity))
                .orElse(new MensajeDTO());
    }

    public ContactoDTO findById(Integer id){
        return contactoRepository
                .findById(id)
                .map(contacto -> contactoMapper.contactoEntityToContactoDTO(contacto))
                .get();
    }

}

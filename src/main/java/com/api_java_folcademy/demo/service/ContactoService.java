package com.api_java_folcademy.demo.service;

import com.api_java_folcademy.demo.exceptions.exceptiosKinds.ContactoInexistenteException;
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

    public boolean existsByNombre(String nombre){
        if (contactoRepository.existsByNombre(nombre)){
            throw new ContactoInexistenteException("Ya se cargo ese nombre");
        }
        return contactoRepository.existsByNombre(nombre);
    }

    public boolean existsByCelular(Integer celular){
        if (contactoRepository.existsByCelular(celular)){
            throw new ContactoInexistenteException("Ya se cargo ese celular");
        }
        return contactoRepository.existsByCelular(celular);
    }

    public MensajeDTO add(ContactoDTO contactoDTO){
        existsByNombre(contactoDTO.getNombre());
        existsByCelular(contactoDTO.getCelular());
        return Optional
                .ofNullable(contactoDTO)
                .map(dto -> contactoMapper.contactoDTOToContactoEntity(dto))
                .map(entity -> contactoRepository.save(entity))
                .map(entity -> contactoMapper.contactoEntityToContactoDTO(entity))
                .map(entity -> contactoMapper.contactoDTOToMensaje(entity))
                .orElse(new MensajeDTO());
    }

    public ContactoDTO findById(Integer contactoId){
        return contactoRepository
                .findById(contactoId)
                .map(contacto -> contactoMapper.contactoEntityToContactoDTO(contacto))
                .orElseThrow(()->new ContactoInexistenteException("No se encontro el contacto con el id especificado"));
    }


    //public ContactoDTO findByCelular(Integer celular){
    //    return contactoRepository
    //            .findByCelular(celular)
    //            .map(contacto -> contactoMapper.contactoEntityToContactoDTO(contacto))
    //            .orElseThrow(()-> new ContactoInexistenteException("Contacto no encontrado"));
    //}
}

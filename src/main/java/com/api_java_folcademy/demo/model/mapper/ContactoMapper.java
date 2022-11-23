package com.api_java_folcademy.demo.model.mapper;

import com.api_java_folcademy.demo.model.domain.ContactoDTO;
import com.api_java_folcademy.demo.model.domain.MensajeDTO;
import com.api_java_folcademy.demo.model.entity.ContactoEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ContactoMapper {
    public ContactoEntity contactoDTOToContactoEntity(ContactoDTO contactoDTO){
        ContactoEntity contactoEntity = new ContactoEntity();
        contactoEntity.setNombre(contactoDTO.getNombre());
        contactoEntity.setCelular(contactoDTO.getCelular());
        contactoEntity.setId(contactoDTO.getId());
        return contactoEntity;
    }

    public ContactoDTO contactoEntityToContactoDTO(ContactoEntity contactoEntity){
        return Optional
                .ofNullable(contactoEntity)
                .map(entity -> new ContactoDTO(entity.getId(), entity.getNombre(), entity.getCelular()))
                .orElse(new ContactoDTO());
    }

    public MensajeDTO contactoDTOToMensaje(ContactoDTO contactoDTO){
        return Optional
                .ofNullable(contactoDTO)
                .map(contacto -> new MensajeDTO(contacto.getId(), "Añadido exitosamente"))
                .orElse(new MensajeDTO());
    }
}

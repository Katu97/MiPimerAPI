package com.api_java_folcademy.demo.model.repository;

import com.api_java_folcademy.demo.model.entity.ContactoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactoRepository extends JpaRepository<ContactoEntity,Integer> {
    //public Optional<ContactoEntity> findByNombre(String nombre);
    //public Optional<ContactoEntity> findByCelular(Integer celular);

    public boolean existsByNombre(String nombre);
    public boolean existsByCelular(Integer celular);

}

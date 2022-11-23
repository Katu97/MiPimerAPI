package com.api_java_folcademy.demo.model.repository;

import com.api_java_folcademy.demo.model.entity.ContactoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepository extends JpaRepository<ContactoEntity,Integer> {

}

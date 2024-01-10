package com.nishasoni.Rest_Demo.repository;

import com.nishasoni.Rest_Demo.model.Vender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VenderRepository extends JpaRepository<Vender, String> {

    List<Vender> findByVenderName(String venderName);
}

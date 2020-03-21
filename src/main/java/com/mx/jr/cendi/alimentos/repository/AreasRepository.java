package com.mx.jr.cendi.alimentos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.jr.cendi.alimentos.model.Areas;
import com.mx.jr.cendi.alimentos.model.User;

@Repository
public interface AreasRepository extends JpaRepository<Areas, String> {
    public List<User> findByClave(String email);
}
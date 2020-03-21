package com.mx.jr.cendi.cocina.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.jr.cendi.cocina.model.Areas;
import com.mx.jr.cendi.cocina.repository.AreasRepository;
import com.mx.jr.cendi.cocina.service.AreasService;

@Service
public class AreasServiceImpl implements AreasService {
    @Autowired
    private AreasRepository areasRepository;

    @Override
    public Boolean edit(Areas area) {
        try {
            areasRepository.save(area);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public Boolean delete(Areas area) {
        try {
            areasRepository.delete(area);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean find(String id) {
        try {
            areasRepository.findById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Areas> findAll() {
        try {
            return areasRepository.findAll();
        } catch (Exception e) {
            return null;
        }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.jr.cendi.cocina.jsf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.jr.cendi.cocina.model.ValeEntrada;

/**
 *
 * @author usuario
 */
@Repository
public interface ValeEntradaFacade extends JpaRepository<ValeEntrada, String> {
//    @PersistenceContext(unitName = "WebApplication1PU")
//    private EntityManager em;
//
//    @Override
//    protected EntityManager getEntityManager() {
//        return em;
//    }
//
//    public ValeEntradaFacade() {
//        super(ValeEntrada.class);
//    }
    
}

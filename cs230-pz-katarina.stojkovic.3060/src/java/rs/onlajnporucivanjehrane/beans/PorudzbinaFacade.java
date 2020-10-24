/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.onlajnporucivanjehrane.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import rs.onlajnporucivanjehrane.entities.Porudzbina;

/**
 *
 * @author ketty
 */
@Stateless
public class PorudzbinaFacade extends AbstractFacade<Porudzbina> {
    @PersistenceContext(unitName = "cs230-pz-katarina.stojkovic.3060PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PorudzbinaFacade() {
        super(Porudzbina.class);
    }
    
}

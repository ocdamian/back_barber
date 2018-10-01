/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Entidades.DetalleVenta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrator
 */
@Stateless
public class DetalleVentaFacade extends AbstractFacade<DetalleVenta> implements DetalleVentaFacadeRemote {
    @PersistenceContext(unitName = "HaircutsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleVentaFacade() {
        super(DetalleVenta.class);
    }
    
}

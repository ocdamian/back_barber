/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Entidades.Servicio;
import Model.ServicioModel;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
public class ServicioFacade extends AbstractFacade<Servicio> implements ServicioFacadeRemote {
    @PersistenceContext(unitName = "HaircutsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServicioFacade() {
        super(Servicio.class);
    }
    
    @Override
    public List<ServicioModel> ListarServiciosPorIdNegocio(int idNegocio){
    
        try {
            Query q = em.createQuery("SELECT NEW Model.ServicioModel(s.idServicio,s.nombre,s.descripcion,s.precio,s.idNegocio.idNegocio) FROM Servicio s WHERE s.idNegocio.idNegocio = :idNegocio", ServicioModel.class);
            q.setParameter("idNegocio", idNegocio);
            return q.getResultList();
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
    
    public ServicioModel ObtenerServicioIdServicio(int idServicio){
        try {
            Query q = em.createQuery("SELECT NEW Model.ServicioModel(s.idServicio, s.nombre,s.descripcion,s.precio,s.idNegocio.idNegocio) FROM Servicio s WHERE s.idServicio = :idServicio",ServicioModel.class);
            q.setParameter("idServicio", idServicio);
            return  (ServicioModel) q.getSingleResult();
        } catch (Exception e) {
            System.out.println("Error :" +e.getMessage());
            
            return null;
        } 
    }
    public Servicio ObtenerServicioObjetoIdServicio(int idServicio){
        try {
            Query q = em.createQuery("SELECT s FROM Servicio AS s WHERE s.idServicio = :idServicio",Servicio.class);
            q.setParameter("idServicio", idServicio);
            return  (Servicio) q.getSingleResult();
        } catch (Exception e) {
            System.out.println("Error :" +e.getMessage());
            
            return null;
        } 
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Entidades.Negocio;
import Model.NegocioModel;
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
public class NegocioFacade extends AbstractFacade<Negocio> implements NegocioFacadeRemote {

   @PersistenceContext(unitName = "HaircutsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public NegocioFacade() {
        super(Negocio.class);
    }
    
    
   @Override
    public List<NegocioModel> ListarNegocios(){
        try {
          Query q = em.createQuery("SELECT  NEW Model.NegocioModel(n.idNegocio, n.clave, n.nombre, n.correo, n.logo, n.nombrePropietario,n.activo )FROM Negocio n", NegocioModel.class);
          return q.getResultList();
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    
    
   @Override
   public Negocio ObtenerNegocioObjetoIdNegocio(int idNegocio){
        try {
            Query q = em.createQuery("SELECT n FROM Negocio AS n WHERE n.idNegocio = :idNegocio",Negocio.class);
            q.setParameter("idNegocio", idNegocio);
            Negocio negocio = (Negocio) q.getSingleResult();
            negocio.getServicioList().size();
            negocio.getUsuarioList().size();
            return  negocio;
        } catch (Exception e) {
            System.out.println("Error :" +e.getMessage());
            return null;
        } 
    }
    
    
}

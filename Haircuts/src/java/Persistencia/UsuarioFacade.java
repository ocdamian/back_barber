/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Entidades.Usuario;
import Model.UsuarioModel;
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
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeRemote {
    @PersistenceContext(unitName = "HaircutsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario IniciarSesion(String correo, String contra) {
        Usuario usuario;
        try {
            Query q = em.createQuery("SELECT u FROM Usuario AS u WHERE u.correo = :correo AND u.contra = :contra");
            q.setParameter("correo", correo);
            q.setParameter("contra", contra);
            usuario = (Usuario) q.getSingleResult();
            
        } catch (Exception ex) {
            return null;
        }
        return usuario;
    }
    
    @Override
    public List<UsuarioModel> ListarUsuarios(int idNegocio){
   //String idUsuario, String correo, String contra,String nombre, String idNegocio
     try {
          Query q = em.createQuery("SELECT NEW Model.UsuarioModel(u.idUsuario,u.correo,u.contra,u.nombre,u.tipo,u.idNegocio.idNegocio) FROM Usuario u WHERE u.idNegocio.idNegocio = :idNegocio", UsuarioModel.class);
          q.setParameter("idNegocio", idNegocio);
          return q.getResultList();
        } catch (Exception e) {
           System.out.println("Error: "+e.getMessage());
           System.out.println("InnerException : "+ e.getStackTrace());
            return null;
        } 
    }
    
    @Override
      public Usuario ObtenerUsuarioObjetoIdUsuario(int idUsuario){
        try {
            Query q = em.createQuery("SELECT u FROM Usuario AS u WHERE u.idUsuario = :idUsuario",Usuario.class);
            q.setParameter("idUsuario", idUsuario);
            Usuario user = (Usuario) q.getSingleResult();
            return  user;
        } catch (Exception e) {
            System.out.println("Error :" +e.getMessage());
            return null;
        } 
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Entidades.Usuario;
import Model.UsuarioModel;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Administrator
 */
@Remote
public interface UsuarioFacadeRemote {

    void create(Usuario usuario);

    void edit(Usuario usuario);

    void remove(Usuario usuario);

    Usuario find(Object id);

    List<Usuario> findAll();

    List<Usuario> findRange(int[] range);

    int count();

    public Usuario IniciarSesion(String correo, String contra);

    public List<UsuarioModel> ListarUsuarios(int idNegocio);

    public Usuario ObtenerUsuarioObjetoIdUsuario(int idUsuario);
    
}

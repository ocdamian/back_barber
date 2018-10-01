/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Entidades.Negocio;
import Model.NegocioModel;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Administrator
 */
@Remote
public interface NegocioFacadeRemote {

    void create(Negocio negocio);

    void edit(Negocio negocio);

    void remove(Negocio negocio);

    Negocio find(Object id);

    List<Negocio> findAll();

    List<Negocio> findRange(int[] range);

    int count();

    public List<NegocioModel> ListarNegocios();

    public Negocio ObtenerNegocioObjetoIdNegocio(int idNegocio);
    
}

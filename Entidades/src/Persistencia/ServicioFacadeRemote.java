/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Entidades.Servicio;
import Model.ServicioModel;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Administrator
 */
@Remote
public interface ServicioFacadeRemote {

    void create(Servicio servicio);

    void edit(Servicio servicio);

    void remove(Servicio servicio);

    Servicio find(Object id);

    List<Servicio> findAll();

    List<Servicio> findRange(int[] range);

    int count();

    public List<ServicioModel> ListarServiciosPorIdNegocio(int idNegocio);

    public ServicioModel ObtenerServicioIdServicio(int idServicio);

    public Servicio ObtenerServicioObjetoIdServicio(int idServicio);
    
}

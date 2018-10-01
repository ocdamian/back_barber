/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Facade;

import Entidades.Servicio;
import Model.ServicioModel;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface IFachada {
    public String GuardaServicio(String servicioModelJSON);
    public String EliminaServicio(int idServicio);
    public String EditaServicio(String servicioModelJSON);
    public String ListarServicios(int idNegocio);
    public String ObtenerServicioIdServicio(int idServicio);
    
    //Negocio
    public String GuardaNegocio(String negocioJSON);
    public String ListarNegocios();
    public String ObtenerNegocio(int IdNegocio);
    public String EditarNegocio(String negocioJSON);
    public String EliminarNegocio(int IdNegocio);
   
    
    ////Ventas
    public String CreaVenta(String jsonVenta);
    ///Usuarios
    public String IniciarSesion(String correo, String contrasena);
    public String ListarUsuarios(int idNegocio);
    public String GuardaUsuario(String usuarioJSON);
    public String EditarUsuario(String usuarioJSON);
    public String ObtenerUsuario(int idUsuario);
}

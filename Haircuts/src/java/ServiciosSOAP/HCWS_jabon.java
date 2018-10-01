/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ServiciosSOAP;

import Facade.Fachada;
import Facade.IFachada;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author ocamp
 */
@WebService(serviceName = "HCWS_jabon")
public class HCWS_jabon {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
 //LOGIN
   public String IniciarSesion(@WebParam(name = "correo") String correo,@WebParam(name = "contrasena") String contrasena){
            IFachada fachada = new Fachada();
            return fachada.IniciarSesion(correo,contrasena);
    }
  //Usuario
     public String GuardaUsuario(@WebParam(name = "usuarioJSON")String usuarioJSON) {
     IFachada fachada = new Fachada();
     return fachada.GuardaUsuario(usuarioJSON);
     }
   public String ListarUsuarios(@WebParam(name = "idNegocio") int idNegocio){
            IFachada fachada = new Fachada();
            return fachada.ListarUsuarios(idNegocio);
   }
   public String EditarUsuario(@WebParam(name = "usuarioJSON")String usuarioJSON) {
     IFachada fachada = new Fachada();
     return fachada.EditarUsuario(usuarioJSON);
   }
    public String ObtenerUsuario(@WebParam(name = "idUsuario") int idUsuario){
            IFachada fachada = new Fachada();
            return fachada.ObtenerUsuario(idUsuario);
   }
   
  //Eliminar Usuario
   
   
   ///NEGOCIOS
    public String GuardaNegocio(@WebParam(name="NegocioJSON") String NegocioJSON){
         IFachada fachada = new Fachada();
         return fachada.GuardaNegocio(NegocioJSON);
    }
    public String EditarNegocio(@WebParam(name="NegocioJSON") String NegocioJSON){
        IFachada fachada = new Fachada();
        return fachada.EditarNegocio(NegocioJSON);
    }
    public String EliminarNegocio(@WebParam(name="idNegocio") int idNegocio){
        IFachada fachada = new Fachada();
        return fachada.EliminarNegocio(idNegocio);
    }
    public String ObtenerNegocio(@WebParam(name="idNegocio") int idNegocio){
        IFachada fachada = new Fachada();
        return fachada.ObtenerNegocio(idNegocio);
    }
    public String ListarNegocios(){
         IFachada fachada = new Fachada();
         return fachada.ListarNegocios();
    }
    
    
   
   
    ///SERVICIOS
   public String GuardarServicio(@WebParam(name = "ServicioModelJSON") String ServicioModelJSON) {
        IFachada fachada = new Fachada();
        return fachada.GuardaServicio(ServicioModelJSON);
     
    }

   public String EditaServicio(@WebParam(name = "ServicioModelJSON") String ServicioModelJSON) {
        IFachada fachada = new Fachada();
        return fachada.EditaServicio(ServicioModelJSON);
     
    }

   
    public String EliminaServicio(@WebParam(name = "IdServicio") int IdServicio) {
        IFachada fachada = new Fachada();
        return fachada.EliminaServicio(IdServicio);
     
    }

   
    public String ListarServicios(@WebParam(name = "IdNegocio") int IdNegocio){
      IFachada fachada = new Fachada();
      return fachada.ListarServicios(IdNegocio);
    }

   
     public String ObtenerServicio(@WebParam(name = "IdServicio") int IdServicio){
         IFachada fachada = new Fachada();
        return fachada.ObtenerServicioIdServicio(IdServicio);
     }
    
    // Ventas y detalle ventas
       public String CreaVenta(@WebParam(name = "Venta") String Venta){
         IFachada fachada = new Fachada();
         return fachada.CreaVenta(Venta);
       }
     
    
    
    
}

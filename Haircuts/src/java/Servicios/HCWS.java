/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servicios;

import Facade.Fachada;
import Facade.IFachada;
import java.io.IOException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

/**
 *
 * @author ocamp
 */
@Path("WSbarber")
public class HCWS implements ContainerResponseFilter {
    @Path("Saludo")
    @GET
       public String Saludo() {
        return "Hola Damian REST si esta funcionando no se asuste xD !";
    }
       
    @Path("IniciarSesion")
    @GET    
    public String IniciarSesion(@QueryParam("correo") String correo,@QueryParam("contrasena") String contrasena){
            IFachada fachada = new Fachada();
            return fachada.IniciarSesion(correo,contrasena);
    }
    @Path("GuardaUsuario")
    @GET
    public String GuardaUsuario(@QueryParam("usuarioJSON") String usuarioJSON){
           IFachada fachada = new Fachada();
           return fachada.GuardaUsuario(usuarioJSON);
    }

    @Path("EditarUsuario")
     public String EditarUsuario(@QueryParam("usuarioJSON") String usuarioJSON){
         IFachada fachada = new Fachada();
         return fachada.EditarUsuario(usuarioJSON);
     }
    @Path("ListarUsuarios")
    @GET
    public String ListarUsuarios(@QueryParam("idNegocio") int idNegocio){
           IFachada fachada = new Fachada();
           return fachada.ListarUsuarios(idNegocio);
    }
    @Path("ObtenerUsuario")
    @GET
    public String ObtenerUsuario(@QueryParam("idUsuario") int idUsuario){
           IFachada fachada = new Fachada();
           return fachada.ObtenerUsuario(idUsuario);
    }
    
    @Path("GuardarServicio")
    @GET  
   public String GuardarServicio(@QueryParam("Servicio") String txt) {
        IFachada fachada = new Fachada();
        return fachada.GuardaServicio(txt);
     
    }
    @Path("EditaServicio")
    @GET   
         public String EditaServicio(@QueryParam("Servicio") String txt) {
        IFachada fachada = new Fachada();
        return fachada.EditaServicio(txt);
     
    }
    @Path("EliminaServicio")
    @GET  
      public String EliminaServicio(@QueryParam("Servicio") int txt) {
        IFachada fachada = new Fachada();
        return fachada.EliminaServicio(txt);
     
    }
     @Path("ListarServicios")
    @GET  
    public String ListarServicios(@QueryParam("idNegocio") int txt){
      IFachada fachada = new Fachada();
      return fachada.ListarServicios(txt);
    }
     @Path("ObtenerServicio")
    @GET  
     public String ObtenerServicio(@QueryParam("idServicio") int txt){
         IFachada fachada = new Fachada();
        return fachada.ObtenerServicioIdServicio(txt);
     }
     
      
     ///NEGOCIOS
    @Path("GuardaNegocio")
    @GET
    public String GuardaNegocio(@QueryParam("NegocioJSON") String NegocioJSON){
         IFachada fachada = new Fachada();
         return fachada.GuardaNegocio(NegocioJSON);
    }
    @Path("EditarNegocio")
    @GET
    public String EditarNegocio(@QueryParam("NegocioJSON") String NegocioJSON){
        IFachada fachada = new Fachada();
        return fachada.EditarNegocio(NegocioJSON);
    }
    @Path("EliminarNegocio")
    @GET
    public String EliminarNegocio(@QueryParam("idNegocio")int idNegocio){
        IFachada fachada = new Fachada();
        return fachada.EliminarNegocio(idNegocio);
    }
    @Path("ObtenerNegocio")
    @GET
    public String ObtenerNegocio(@QueryParam("idNegocio")int idNegocio){
        IFachada fachada = new Fachada();
        return fachada.ObtenerNegocio(idNegocio);
    }
    @Path("ListarNegocios")
    @GET 
    public String ListarNegocios(){
         IFachada fachada = new Fachada();
         return fachada.ListarNegocios();
    } 
      /////////////////////////////////////////////////////7
    @Path("CreaVenta")
    @GET  
     public String CreaVenta(@QueryParam("Venta") String txt){
         IFachada fachada = new Fachada();
         return fachada.CreaVenta(txt);
        
     }

    @Override
//    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
     public void filter(final ContainerRequestContext requestContext,
                      final ContainerResponseContext cres) throws IOException {
      cres.getHeaders().add("Access-Control-Allow-Origin", "*");
      cres.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
      cres.getHeaders().add("Access-Control-Allow-Credentials", "true");
      cres.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
      cres.getHeaders().add("Access-Control-Max-Age", "1209600");
   }
       
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Facade;

import Entidades.DetalleVenta;
import Entidades.Negocio;
import Entidades.Servicio;
import Entidades.Usuario;
import Entidades.Venta;
import Model.DetalleVentaModel;
import Model.NegocioModel;
import Model.Respuesta;
import Model.ServicioModel;
import Model.UsuarioModel;
import Model.VentaModel;
import Persistencia.NegocioFacadeRemote;
import Persistencia.ServicioFacadeRemote;
import Persistencia.UsuarioFacadeRemote;
import Persistencia.VentaFacadeRemote;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Administrator
 */
public class Fachada implements IFachada{
    UsuarioFacadeRemote usuarioFacade = lookupUsuarioFacadeRemote();
    NegocioFacadeRemote negocioFacade = lookupNegocioFacadeRemote();
    VentaFacadeRemote ventaFacade = lookupVentaFacadeRemote();
    ServicioFacadeRemote servicioFacade = lookupServicioFacadeRemote();
    
    
    
    ///Usuarios
    @Override
    public String  IniciarSesion(String correo, String contrasena){
        Respuesta respuesta = new Respuesta();
        Gson gson = new Gson();
        Usuario user =  usuarioFacade.IniciarSesion(correo, contrasena);
        
        if(user != null){
        
        Negocio ne = new Negocio();
        ne.setIdNegocio(user.getIdNegocio().getIdNegocio());
        ne.setNombre(user.getIdNegocio().getNombre());
        ne.setClave(user.getIdNegocio().getClave());
        ne.setLogo(user.getIdNegocio().getLogo());
        
        user.setIdNegocio(null);
        user.setIdNegocio(ne);
        
        String usuarioJSON = gson.toJson(user);
            
        respuesta.setSuccess(true);
        respuesta.setMensaje("Operación exitosa");
        respuesta.setContenido(usuarioJSON);
            
        }else{
        
            respuesta.setSuccess(false);
            respuesta.setContenido("");
            respuesta.setMensaje("Usuario o contraseña incorrecto");
        
        }
        
        String respuestaJSON = gson.toJson(respuesta);
        return respuestaJSON;
         
    }
    
    public String GuardaUsuario(String usuarioJSON) {
        try {
            Gson gson = new Gson();
            Respuesta respuesta = new Respuesta();
            UsuarioModel user = gson.fromJson(usuarioJSON, UsuarioModel.class);
            Usuario u = new Usuario();
            //u.setIdUsuario(user.getIdUsuario());
            u.setCorreo(user.getCorreo());
            u.setContra(user.getContra());
            u.setNombre(user.getNombre());
            u.setTipo(user.getTipo());
            u.setPathFoto(user.getPathFoto());
            u.setFoto(user.getFoto());
            u.setIdNegocio(new Negocio(user.getIdNegocio()));
            usuarioFacade.create(u);
        respuesta.setSuccess(true);
        respuesta.setMensaje("Operación exitosa");
        respuesta.setContenido("");
        String respuestaJSON = gson.toJson(respuesta);
        return respuestaJSON;
        
        } catch (Exception e) {
            Gson gsonerror = new Gson();
            Respuesta requestError = new Respuesta();
            requestError.setSuccess(false);
            requestError.setMensaje(e.getMessage());
            requestError.setContenido(""); 
            String requestJSON = gsonerror.toJson(requestError);
            return requestJSON;
        }
    }
    public String EditarUsuario(String usuarioJSON) {
        try {
            Gson gson = new Gson();
            Respuesta respuesta = new Respuesta();
            UsuarioModel user = gson.fromJson(usuarioJSON, UsuarioModel.class);
            Usuario u = usuarioFacade.ObtenerUsuarioObjetoIdUsuario(user.getIdUsuario());
            u.setIdUsuario(user.getIdUsuario());
            u.setCorreo(user.getCorreo());
            u.setContra(user.getContra());
            u.setNombre(user.getNombre());
            u.setTipo(user.getTipo());
            u.setPathFoto(user.getPathFoto());
            u.setFoto(user.getFoto());
            u.setIdNegocio(new Negocio(user.getIdNegocio()));
            usuarioFacade.edit(u);
        respuesta.setSuccess(true);
        respuesta.setMensaje("Operación exitosa");
        respuesta.setContenido("");
        String respuestaJSON = gson.toJson(respuesta);
        return respuestaJSON;
        
        } catch (Exception e) {
            Gson gsonerror = new Gson();
            Respuesta requestError = new Respuesta();
            requestError.setSuccess(false);
            requestError.setMensaje(e.getMessage());
            requestError.setContenido(""); 
            String requestJSON = gsonerror.toJson(requestError);
            return requestJSON;
        }
    }
    public String ObtenerUsuario(int idUsuario){
        try {
            Usuario user = usuarioFacade.ObtenerUsuarioObjetoIdUsuario(idUsuario);
            Gson gson = new Gson();
            Respuesta respuesta = new Respuesta();
            if(user != null){
             String userJSON = gson.toJson(user);
             respuesta.setSuccess(true);
             respuesta.setMensaje("Operación exitosa");
             respuesta.setContenido(userJSON);
            }else{
             respuesta.setSuccess(false);
             respuesta.setMensaje("No se encontro el negocio/barberia");
             respuesta.setContenido("null");
        
            }
            String respuestaJSON = gson.toJson(respuesta);
            return respuestaJSON;
        } catch (Exception e) {
            Gson gsonerror = new Gson();
            Respuesta requestError = new Respuesta();
            requestError.setSuccess(false);
            requestError.setMensaje(e.getMessage());
            requestError.setContenido(""); 
            String requestJSON = gsonerror.toJson(requestError);
            return requestJSON;
        }
    }
    @Override
     public String  ListarUsuarios(int idNegocio){
        Respuesta respuesta = new Respuesta();
        Gson gson = new Gson();
        List<UsuarioModel> usuarios = usuarioFacade.ListarUsuarios(idNegocio);
        
        if(usuarios != null){
        respuesta.setSuccess(true);
        respuesta.setMensaje("Operación exitosa");
        respuesta.setContenido(gson.toJson(usuarios));
        
        }else{
        respuesta.setSuccess(false);
        respuesta.setMensaje("null");
        respuesta.setContenido("");
        }
        
        String respuestaJSON = gson.toJson(respuesta);
        return respuestaJSON;
         
    }
    
    /////Negocios
    @Override
    public String ListarNegocios(){
        Respuesta respuesta = new Respuesta();
        Gson gson = new Gson();
        List<NegocioModel> negocios = negocioFacade.ListarNegocios();
        
        if(negocios != null){
        respuesta.setSuccess(true);
        respuesta.setMensaje("Operación exitosa");
        respuesta.setContenido(gson.toJson(negocios));
        
        }else{
        respuesta.setSuccess(false);
        respuesta.setMensaje("null");
        respuesta.setContenido("");
        }
        
        String respuestaJSON = gson.toJson(respuesta);
        return respuestaJSON;
        
   
    }
    
    @Override
    public String GuardaNegocio(String negocioJSON) {
        try {
            Gson gson = new Gson();
            Respuesta respuesta = new Respuesta();
            NegocioModel ne = gson.fromJson(negocioJSON, NegocioModel.class);
            Negocio n = new Negocio();
            n.setNombrePropietario(ne.getNombrePropietario());
            n.setIdNegocio(ne.getIdNegocio());
            n.setNombre(ne.getNombre());
            n.setCorreo(ne.getCorreo());
            n.setClave(ne.getClave());
            n.setLogo(ne.getLogo());
            n.setActivo(ne.isActivo());
            List<Usuario> usuarios = new ArrayList<Usuario>();
            Usuario u = new Usuario();
            u.setNombre(n.getNombrePropietario());
            u.setCorreo(n.getCorreo());
            u.setTipo("A");
            u.setContra("admin");
            u.setIdNegocio(n);
            usuarios.add(u);
//            usuarios = ne.getUsuarioList();
//            for(Usuario user :usuarios ){
//               user.setIdNegocio(n);
//            }
            n.setUsuarioList(usuarios);
            negocioFacade.create(n);
        respuesta.setSuccess(true);
        respuesta.setMensaje("Operación exitosa");
        respuesta.setContenido("");
        String respuestaJSON = gson.toJson(respuesta);
        return respuestaJSON;
        
        } catch (Exception e) {
            Gson gsonerror = new Gson();
            Respuesta requestError = new Respuesta();
            requestError.setSuccess(false);
            requestError.setMensaje(e.getMessage());
            requestError.setContenido(""); 
            String requestJSON = gsonerror.toJson(requestError);
            return requestJSON;
        }
    }
    
    public String ObtenerNegocio(int IdNegocio){
        try {
            Negocio n = negocioFacade.ObtenerNegocioObjetoIdNegocio(IdNegocio);
            //List<Servicio> servicios = new ArrayList<Servicio>();
            n.getServicioList().clear();
            n.getUsuarioList().clear();
            Gson gson = new Gson();
            Respuesta respuesta = new Respuesta();
            if(n != null){
             String negocioJSON = gson.toJson(n);
             respuesta.setSuccess(true);
             respuesta.setMensaje("Operación exitosa");
             respuesta.setContenido(negocioJSON);
            }else{
             respuesta.setSuccess(false);
             respuesta.setMensaje("No se encontro el negocio/barberia");
             respuesta.setContenido("null");
        
            }
            String respuestaJSON = gson.toJson(respuesta);
            return respuestaJSON;
        } catch (Exception e) {
            Gson gsonerror = new Gson();
            Respuesta requestError = new Respuesta();
            requestError.setSuccess(false);
            requestError.setMensaje(e.getMessage());
            requestError.setContenido(""); 
            String requestJSON = gsonerror.toJson(requestError);
            return requestJSON;
        }
    }
    
    public String EditarNegocio(String negocioJSON) {
        try {
            Gson gson = new Gson();
            Respuesta respuesta = new Respuesta();
            Negocio ne = gson.fromJson(negocioJSON, Negocio.class);
            Negocio n = negocioFacade.ObtenerNegocioObjetoIdNegocio(ne.getIdNegocio());
            n.setNombrePropietario(ne.getNombrePropietario());
            n.setIdNegocio(ne.getIdNegocio());
            n.setNombre(ne.getNombre());
            n.setCorreo(ne.getCorreo());
            n.setClave(ne.getClave());
            n.setLogo(ne.getLogo());
            n.setActivo(ne.isActivo());
            negocioFacade.edit(n);
        respuesta.setSuccess(true);
        respuesta.setMensaje("Operación exitosa");
        respuesta.setContenido("");
        String respuestaJSON = gson.toJson(respuesta);
        return respuestaJSON;
        
        } catch (Exception e) {
            Gson gsonerror = new Gson();
            Respuesta requestError = new Respuesta();
            requestError.setSuccess(false);
            requestError.setMensaje(e.getMessage());
            requestError.setContenido(""); 
            String requestJSON = gsonerror.toJson(requestError);
            return requestJSON;
        }
    }
      
    @Override
    public String EliminarNegocio(int IdNegocio){
    
        try {
            Gson gson = new Gson();
            Respuesta respuesta = new Respuesta();
            
            negocioFacade.remove(new Negocio(IdNegocio));
            
            respuesta.setSuccess(true);
            respuesta.setMensaje("Operación exitosa");
            respuesta.setContenido("");
            String respuestaJSON = gson.toJson(respuesta);
            return respuestaJSON;
        } catch (Exception e) {
            Gson gsonerror = new Gson();
            Respuesta requestError = new Respuesta();
            requestError.setSuccess(false);
            requestError.setMensaje(e.getMessage());
            requestError.setContenido(""); 
            String requestJSON = gsonerror.toJson(requestError);
            return requestJSON;
        }
        
    }
    
    ////Servicios
    @Override
    public String GuardaServicio(String servicioModelJSON){
         try {
             
        Gson gson= new Gson();
        ServicioModel servicioM = gson.fromJson(servicioModelJSON, ServicioModel.class);
        Servicio s = new Servicio();
        s.setIdServicio(servicioM.getIdServicio());
        s.setNombre(servicioM.getNombre());
        s.setDescripcion(servicioM.getDescripcion());
        s.setPrecio(servicioM.getPrecio());
        s.setIdNegocio(new Negocio(servicioM.getIdNegocio()));
        servicioFacade.create(s);
             return "success";
         } catch (Exception e) {
             return "error :" +e.getMessage();
         }
        
    }
    @Override
    public String EditaServicio(String servicioModelJSON){
        
        try {
            
        Gson gson= new Gson();
        ServicioModel servicioM = gson.fromJson(servicioModelJSON, ServicioModel.class);
        Servicio ser = servicioFacade.ObtenerServicioObjetoIdServicio(servicioM.getIdServicio());
        if(ser != null){
        ser.setNombre(servicioM.getNombre());
        ser.setDescripcion(servicioM.getDescripcion());
        ser.setPrecio(servicioM.getPrecio());
        ser.setIdNegocio(new Negocio(servicioM.getIdNegocio()));
        
        servicioFacade.edit(ser);
        return "success";
        }else{return "No se encontro el servicio";}
            
        } catch (Exception e) {
            return "error :" +e.getMessage();
        }
        
       
        
    }
      @Override
    public String  EliminaServicio(int idServicio) {
          try {
             servicioFacade.remove(new Servicio(idServicio));
             return "success";
          } catch (Exception e) {
              return "error :" +e.getMessage();
          }
        
    }
    @Override
    public String ListarServicios(int idNegocio){
         Respuesta respuesta = new Respuesta();
        Gson gson = new Gson();
        List<ServicioModel> servicios = servicioFacade.ListarServiciosPorIdNegocio(idNegocio);
        if(servicios != null){
        respuesta.setSuccess(true);
        respuesta.setMensaje("Operación exitosa");
        respuesta.setContenido(gson.toJson(servicios));
        
        }else{
        respuesta.setSuccess(false);
        respuesta.setMensaje("null");
        respuesta.setContenido("");
        }
        
        String respuestaJSON = gson.toJson(respuesta);
        return respuestaJSON;
        
    }
    @Override
    public String ObtenerServicioIdServicio(int idServicio){
        ServicioModel sm = servicioFacade.ObtenerServicioIdServicio(idServicio);
        Gson gson = new Gson();
        String servicioJSON = gson.toJson(sm);
        return servicioJSON;
    }
    
    
    ////////////VENTAS
    
    @Override
    public String CreaVenta(String jsonVenta){
    
        try {
            
          double totalVenta = 0;
          Gson gson = new Gson();
          VentaModel ventaModel = gson.fromJson(jsonVenta, new TypeToken<VentaModel>(){}.getType());
         
          Venta venta = new Venta();
          venta.setIdNegocio(ventaModel.getIdNegocio());
          venta.setFecha(new Date());
          UUID uuidNumeroVenta = UUID.randomUUID();
          venta.setNumeroVenta(uuidNumeroVenta.toString().substring(10,18));
          venta.setIdUsuario(ventaModel.getIdUsuario());
          venta.setNombreCompletoUsuario(ventaModel.getNombreCompletoUsuario());
          
          List<DetalleVenta> detalles = new ArrayList<DetalleVenta>();
            for(DetalleVentaModel detalleM : ventaModel.getDetallesVenta()){
            DetalleVenta detalleVenta = new DetalleVenta();
            
            detalleVenta.setCantidad(detalleM.getCantidad());
            detalleVenta.setPrecioUnitario(detalleM.getPrecioUnitario());
           detalleVenta.setProductoServicio(detalleM.getProductoServicio());
            detalleVenta.setIdVenta(venta);
            detalleVenta.setTotalPrecioDetalleVenta( detalleVenta.getCantidad() * detalleVenta.getPrecioUnitario());
            totalVenta = totalVenta + detalleVenta.getTotalPrecioDetalleVenta();
            detalles.add(detalleVenta);
            }
            
            venta.setTotal(totalVenta);
          
            venta.setDetalleVentaList(detalles);
            ventaFacade.create(venta);
            
        } catch (Exception e) {
            return "error";
        }
          
           return "success"; 
        
    }
    
    
    
    
    
    
    
    private ServicioFacadeRemote lookupServicioFacadeRemote() {
        try {
            Context c = new InitialContext();
            return (ServicioFacadeRemote) c.lookup("java:global/Haircuts/ServicioFacade!Persistencia.ServicioFacadeRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private VentaFacadeRemote lookupVentaFacadeRemote() {
        try {
            Context c = new InitialContext();
            return (VentaFacadeRemote) c.lookup("java:global/Haircuts/VentaFacade!Persistencia.VentaFacadeRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private NegocioFacadeRemote lookupNegocioFacadeRemote() {
        try {
            Context c = new InitialContext();
            return (NegocioFacadeRemote) c.lookup("java:global/Haircuts/NegocioFacade!Persistencia.NegocioFacadeRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private UsuarioFacadeRemote lookupUsuarioFacadeRemote() {
        try {
            Context c = new InitialContext();
            return (UsuarioFacadeRemote) c.lookup("java:global/Haircuts/UsuarioFacade!Persistencia.UsuarioFacadeRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}

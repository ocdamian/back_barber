/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Entidades.Usuario;
import java.util.List;

/**
 *
 * @author ocamp
 */
public class NegocioModel {
    private int idNegocio;
    
    private String clave;
   
    private String nombre;
   
    private String correo;
    
    private String logo;
    private String nombrePropietario;
    private boolean activo;
   
    //private List<Usuario> usuarioList;

    public NegocioModel() {
    }

    public NegocioModel(int idNegocio, String clave, String nombre, String correo, String logo,String nombrePropietario, boolean activo) {
        this.idNegocio = idNegocio;
        this.clave = clave;
        this.nombre = nombre;
        this.correo = correo;
        this.logo = logo;
        this.nombrePropietario = nombrePropietario;
        this.activo = activo;
    }

    public int getIdNegocio() {
        return idNegocio;
    }

    public void setIdNegocio(int idNegocio) {
        this.idNegocio = idNegocio;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

//    public List<Usuario> getUsuarioList() {
//        return usuarioList;
//    }
//
//    public void setUsuarioList(List<Usuario> usuarioList) {
//        this.usuarioList = usuarioList;
//    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
    
    
}

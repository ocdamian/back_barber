/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "negocios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Negocio.findAll", query = "SELECT n FROM Negocio n"),
    @NamedQuery(name = "Negocio.findByIdNegocio", query = "SELECT n FROM Negocio n WHERE n.idNegocio = :idNegocio"),
    @NamedQuery(name = "Negocio.findByClave", query = "SELECT n FROM Negocio n WHERE n.clave = :clave"),
    @NamedQuery(name = "Negocio.findByNombre", query = "SELECT n FROM Negocio n WHERE n.nombre = :nombre"),
    @NamedQuery(name = "Negocio.findByCorreo", query = "SELECT n FROM Negocio n WHERE n.correo = :correo"),
    @NamedQuery(name = "Negocio.findByLogo", query = "SELECT n FROM Negocio n WHERE n.logo = :logo")})
public class Negocio implements Serializable {
    private static final long serialVersionUID = 1L;
//    @Id
//    @Basic(optional = false)
//    @Column(name = "IdNegocio")
//    private String idNegocio;  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdNegocio")
    private Integer idNegocio;
   
    @Basic(optional = false)
    @Column(name = "Clave")
    private String clave;
    @Basic(optional = false)
    @Column(name = "NombrePropietario")
    private String nombrePropietario;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "Correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "Logo")
    private String logo;
    @Column(name = "PathLogo")
    private String pathLogo;
    @OneToMany(mappedBy = "idNegocio", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Servicio> servicioList;
    
    @OneToMany(mappedBy = "idNegocio",cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Usuario> usuarioList;
    @Column(name = "Activo")
    private boolean activo;
    
    
    public Negocio() {
    }

    public Negocio(Integer idNegocio) {
        this.idNegocio = idNegocio;
    }

    public Negocio(Integer idNegocio, String clave, String nombre, String correo, String logo) {
        this.idNegocio = idNegocio;
        this.clave = clave;
        this.nombre = nombre;
        this.correo = correo;
        this.logo = logo;
    }

    public Integer getIdNegocio() {
        return idNegocio;
    }

    public void setIdNegocio(Integer idNegocio) {
        this.idNegocio = idNegocio;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
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

    @XmlTransient
    public List<Servicio> getServicioList() {
        return servicioList;
    }

    public void setServicioList(List<Servicio> servicioList) {
        this.servicioList = servicioList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNegocio != null ? idNegocio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Negocio)) {
            return false;
        }
        Negocio other = (Negocio) object;
        if ((this.idNegocio == null && other.idNegocio != null) || (this.idNegocio != null && !this.idNegocio.equals(other.idNegocio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Negocio[ idNegocio=" + idNegocio + " ]";
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getPathLogo() {
        return pathLogo;
    }

    public void setPathLogo(String pathLogo) {
        this.pathLogo = pathLogo;
    }

 
    
}

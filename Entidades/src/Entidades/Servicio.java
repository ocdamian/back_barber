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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "servicios")
@XmlRootElement

public class Servicio implements Serializable {
    private static final long serialVersionUID = 1L;
//    @Id
//    @Basic(optional = false)
//    @Column(name = "IdServicio")
//    private String idServicio;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdServicio")
    private Integer idServicio;
    
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Precio")
    private double precio;
    @JoinColumn(name = "IdNegocio", referencedColumnName = "IdNegocio")
    @ManyToOne
    private Negocio idNegocio;
//    @OneToMany(mappedBy = "idServicio",cascade = CascadeType.MERGE)
//    private List<DetalleVenta> detalleVentaList;

    public Servicio() {
    }

    public Servicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Negocio getIdNegocio() {
        return idNegocio;
    }

    public void setIdNegocio(Negocio idNegocio) {
        this.idNegocio = idNegocio;
    }

//    @XmlTransient
//    public List<DetalleVenta> getDetalleVentaList() {
//        return detalleVentaList;
//    }
//
//    public void setDetalleVentaList(List<DetalleVenta> detalleVentaList) {
//        this.detalleVentaList = detalleVentaList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServicio != null ? idServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicio)) {
            return false;
        }
        Servicio other = (Servicio) object;
        if ((this.idServicio == null && other.idServicio != null) || (this.idServicio != null && !this.idServicio.equals(other.idServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Servicio[ idServicio=" + idServicio + " ]";
    }
    
}

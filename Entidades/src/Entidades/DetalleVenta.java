/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "detallesventa")
@XmlRootElement

public class DetalleVenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdDetalleVenta")
    private Integer idDetalleVenta;
    @Column(name = "Cantidad")
    private Integer cantidad;
    @Column(name = "PrecioUnitario")
    private double precioUnitario;
    @Column(name = "TotalPrecioDetalleVenta")
    private double totalPrecioDetalleVenta;
//    @JoinColumn(name = "IdServicio", referencedColumnName = "IdServicio")
//    @ManyToOne
    private String ProductoServicio;
//    @JoinColumn(name = "IdVenta", referencedColumnName = "IdVenta")
//    @ManyToOne()
    private Venta idVenta;

    public DetalleVenta() {
    }

    public DetalleVenta(Integer idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public Integer getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(Integer idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getTotalPrecioDetalleVenta() {
        return totalPrecioDetalleVenta;
    }

    public void setTotalPrecioDetalleVenta(double totalPrecioDetalleVenta) {
        this.totalPrecioDetalleVenta = totalPrecioDetalleVenta;
    }

    public String getProductoServicio() {
        return ProductoServicio;
    }

    public void setProductoServicio(String ProductoServicio) {
        this.ProductoServicio = ProductoServicio;
    }

    public Venta getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Venta idVenta) {
        this.idVenta = idVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleVenta != null ? idDetalleVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleVenta)) {
            return false;
        }
        DetalleVenta other = (DetalleVenta) object;
        if ((this.idDetalleVenta == null && other.idDetalleVenta != null) || (this.idDetalleVenta != null && !this.idDetalleVenta.equals(other.idDetalleVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.DetalleVenta[ idDetalleVenta=" + idDetalleVenta + " ]";
    }
    
}

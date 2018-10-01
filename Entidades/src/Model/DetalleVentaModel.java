/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author ocamp
 */
public class DetalleVentaModel {
    
    private int idDetalleVenta;
    private Integer cantidad;
    private double precioUnitario;
    private double totalPrecioDetalleVenta;
    private String ProductoServicio;
    private String decripcion;

    public DetalleVentaModel() {
    }

    public DetalleVentaModel(int idDetalleVenta, Integer cantidad, double precioUnitario, double totalPrecioDetalleVenta, int idServicio, String decripcion) {
        this.idDetalleVenta = idDetalleVenta;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.totalPrecioDetalleVenta = totalPrecioDetalleVenta;
        this.decripcion = decripcion;
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
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

    public String getDecripcion() {
        return decripcion;
    }

    public void setDecripcion(String decripcion) {
        this.decripcion = decripcion;
    }

    public String getProductoServicio() {
        return ProductoServicio;
    }

    public void setProductoServicio(String ProductoServicio) {
        this.ProductoServicio = ProductoServicio;
    }
    
    
    
}

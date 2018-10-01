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
public class ServicioModel {
    private int IdServicio;
    private String Nombre;
    private String Descripcion;
    private double Precio;
    private int IdNegocio;

    public ServicioModel() {
    }

    public ServicioModel(int IdServicio, String Nombre,String Descripcion,double Precio,int IdNegocio) {
        this.IdServicio = IdServicio;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Precio = Precio;
        this.IdNegocio = IdNegocio;
    }

    public int getIdServicio() {
        return IdServicio;
    }

    public void setIdServicio(int IdServicio) {
        this.IdServicio = IdServicio;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public int getIdNegocio() {
        return IdNegocio;
    }

    public void setIdNegocio(int IdNegocio) {
        this.IdNegocio = IdNegocio;
    }
    
    
}

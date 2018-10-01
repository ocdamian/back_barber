/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.List;

/**
 *
 * @author ocamp
 */
public class VentaModel {
    private int IdUsuario;
    private String NombreCompletoUsuario;
    private int IdNegocio;
    private List<DetalleVentaModel> DetallesVenta;

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public int getIdNegocio() {
        return IdNegocio;
    }

    public void setIdNegocio(int IdNegocio) {
        this.IdNegocio = IdNegocio;
    }

    public List<DetalleVentaModel> getDetallesVenta() {
        return DetallesVenta;
    }

    public void setDetallesVenta(List<DetalleVentaModel> DetallesVenta) {
        this.DetallesVenta = DetallesVenta;
    }

    public String getNombreCompletoUsuario() {
        return NombreCompletoUsuario;
    }

    public void setNombreCompletoUsuario(String NombreCompletoUsuario) {
        this.NombreCompletoUsuario = NombreCompletoUsuario;
    }
}

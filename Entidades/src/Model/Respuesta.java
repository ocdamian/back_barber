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
public class Respuesta {
    private boolean Success;
    private String Contenido;
    private String Mensaje;

  
    public String getContenido() {
        return Contenido;
    }

    public void setContenido(String Contenido) {
        this.Contenido = Contenido;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean Success) {
        this.Success = Success;
    }
    
    
}

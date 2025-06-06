/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package control;

import acceso_datos.RolusuarioFacade;
import java.util.List;
import javax.ejb.EJB;
import modelo.Rolusuario;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author razie
 */
@Named(value = "rolBean")
@RequestScoped
public class RolBean {
    
    @EJB
    private RolusuarioFacade rolusuarioFacade;

    // Retorna la lista completa de roles desde la base de datos
    public List<Rolusuario> getListaRoles() {
        return rolusuarioFacade.findAll();
    }

    // Retorna el nombre del rol según su ID (opcional, útil en vistas de solo lectura)
    public String getNombreRol(int id) {
        for (Rolusuario rol : getListaRoles()) {
            if (rol.getId() != null && rol.getId() == id) {
                return rol.getNombre();
            }
        }
        return "Desconocido";
    }

    /**
     * Creates a new instance of RolBean
     */
    public RolBean() {
    }
    
}

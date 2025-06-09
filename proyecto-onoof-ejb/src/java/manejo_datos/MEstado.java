/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package manejo_datos;

import acceso_datos.EstadoFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Estado;

/**
 *
 * @author razie
 */
@Stateless
@LocalBean
public class MEstado {
    
    @EJB
    private EstadoFacade estadoFacade;

    public Estado obtenerPorId(Integer id) {
        return estadoFacade.find(id);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}

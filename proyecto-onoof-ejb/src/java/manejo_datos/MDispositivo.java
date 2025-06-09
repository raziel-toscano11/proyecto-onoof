/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package manejo_datos;

import acceso_datos.DispositivoFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Dispositivo;

/**
 *
 * @author razie
 */
@Stateless
@LocalBean
public class MDispositivo {
    @EJB
    private DispositivoFacade dispositivoFacade;

    public void registrar(Dispositivo dispositivo) {
        dispositivoFacade.create(dispositivo);
    }

    public Dispositivo obtenerPorId(Integer id) {
        return dispositivoFacade.find(id);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}

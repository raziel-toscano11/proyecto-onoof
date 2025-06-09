/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package manejo_datos;

import acceso_datos.HistorialEstadoReparacionFacade;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Estado;
import modelo.HistorialEstadoReparacion;
import modelo.Reparacion;

/**
 *
 * @author razie
 */
@Stateless
@LocalBean
public class MHistorialEstadoReparacion {
    @EJB
    private HistorialEstadoReparacionFacade historialEstadoReparacionFacade;

    // Método para registrar un cambio de estado en el historial
    public void registrarCambioEstado(Reparacion reparacion, Estado estado) {
        HistorialEstadoReparacion historial = new HistorialEstadoReparacion();
        historial.setReparacion(reparacion);
        historial.setEstado(estado);
        historial.setFechaCambio(new Date());  // Fecha actual al registrar el cambio

        historialEstadoReparacionFacade.create(historial);  // Guardar en base de datos
    }

    // Método para obtener el historial de estados de una reparación específica
    public List<HistorialEstadoReparacion> obtenerHistorialPorReparacion(Integer idReparacion) {
        return historialEstadoReparacionFacade.obtenerHistorialPorReparacion(idReparacion);
    }

    // Método para obtener el último estado de una reparación
    public HistorialEstadoReparacion obtenerUltimoEstado(Integer idReparacion) {
        List<HistorialEstadoReparacion> historial = historialEstadoReparacionFacade.obtenerHistorialPorReparacion(idReparacion);
        if (historial != null && !historial.isEmpty()) {
            return historial.get(historial.size() - 1);  // Retorna el último estado
        }
        return null;  // Si no existe historial
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}

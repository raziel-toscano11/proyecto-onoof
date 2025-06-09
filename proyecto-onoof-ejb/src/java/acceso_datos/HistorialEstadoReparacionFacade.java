/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acceso_datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.HistorialEstadoReparacion;

/**
 *
 * @author razie
 */
@Stateless
public class HistorialEstadoReparacionFacade extends AbstractFacade<HistorialEstadoReparacion> {

    @PersistenceContext(unitName = "proyecto-onoof-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistorialEstadoReparacionFacade() {
        super(HistorialEstadoReparacion.class);
    }
    
    public List<HistorialEstadoReparacion> obtenerHistorialPorReparacion(Integer idReparacion) {
    return em.createQuery("SELECT h FROM HistorialEstadoReparacion h WHERE h.reparacion.id = :idReparacion", HistorialEstadoReparacion.class)
             .setParameter("idReparacion", idReparacion)
             .getResultList();
}

    
}

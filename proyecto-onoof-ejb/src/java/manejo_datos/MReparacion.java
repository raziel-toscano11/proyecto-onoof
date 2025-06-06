package manejo_datos;

import acceso_datos.ReparacionFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import modelo.Reparacion;

@Stateless
public class MReparacion {

    @EJB
    private ReparacionFacade reparacionFacade;

    public List<Reparacion> obtenerTodas() {
        return reparacionFacade.findAll();
    }

    public void registrar(Reparacion r) {
        reparacionFacade.create(r);
    }

    public void actualizar(Reparacion r) {
        reparacionFacade.edit(r);
    }

    public void eliminar(Reparacion r) {
        reparacionFacade.remove(r);
    }

    public Reparacion obtenerPorId(Integer id) {
        return reparacionFacade.find(id);
    }
}

package manejo_datos;

import acceso_datos.ClienteFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Cliente;

@Stateless
public class MCliente {

    @EJB
    private ClienteFacade clienteFacade;

    public List<Cliente> obtenerTodas() {
        return clienteFacade.findAll();
    }
    
    public void registrar(Cliente c) {
        clienteFacade.create(c);
    }

    public void actualizar(Cliente c) {
        clienteFacade.edit(c);
    }

    public void eliminar(Cliente c) {
        clienteFacade.remove(c);
    }

    public Cliente obtenerPorId(Integer id) {
        return clienteFacade.find(id);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package manejo_datos;

import acceso_datos.UsuarioFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Usuario;

/**
 *
 * @author razie
 */
@Stateless
@LocalBean
public class MUsuario {

    @PersistenceContext(unitName = "proyecto-onoof-ejbPU")
    private EntityManager em;

    @EJB
    private UsuarioFacade usuarioFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void persist(Object object) {
        em.persist(object);
    }
    
    public List<Usuario> usuarios() {
        return usuarioFacade.findAll();
    }
    
    public void registrar(Usuario usuario) {
        usuarioFacade.create(usuario);
    }
    
    public Usuario autenticarUsuario(Usuario u) {
        return usuarioFacade.obtenerUsuario(u.getNombre(), u.getContrasena());
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acceso_datos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import modelo.Usuario;

/**
 *
 * @author razie
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "proyecto-onoof-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario obtenerUsuario(String usuario, String password) {
        String query = "SELECT u FROM Usuario u WHERE u.nombre = :usuario AND u.contrasena = :password";
        try {
            return em.createQuery(query, Usuario.class)
                    .setParameter("nombre", usuario)
                    .setParameter("contrasena", password)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acceso_datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Modelo;

/**
 *
 * @author razie
 */
@Stateless
public class ModeloFacade extends AbstractFacade<Modelo> {

    @PersistenceContext(unitName = "proyecto-onoof-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ModeloFacade() {
        super(Modelo.class);
    }

    public List<Modelo> obtenerPorMarca(int idMarca) {
        return getEntityManager()
                .createQuery("SELECT m FROM Modelo m WHERE m.idMarca.id = :idMarca", Modelo.class)
                .setParameter("idMarca", idMarca)
                .getResultList();
    }

}

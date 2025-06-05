/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acceso_datos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.InventarioProducto;

/**
 *
 * @author razie
 */
@Stateless
public class InventarioProductoFacade extends AbstractFacade<InventarioProducto> {

    @PersistenceContext(unitName = "proyecto-onoof-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InventarioProductoFacade() {
        super(InventarioProducto.class);
    }
    
}

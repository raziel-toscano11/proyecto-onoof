/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package manejo_datos;

import acceso_datos.ModeloFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Modelo;

/**
 *
 * @author razie
 */
@Stateless
@LocalBean
public class MModelo {

    @EJB
    private ModeloFacade modeloFacade;

    // Obtener todos los modelos
    public List<Modelo> obtenerTodas() {
        return modeloFacade.findAll();
    }

    // Obtener modelos por idMarca
    public List<Modelo> obtenerPorMarca(int idMarca) {
        return modeloFacade.obtenerPorMarca(idMarca);
    }

    // Obtener modelo por id
    public Modelo obtenerPorId(Integer id) {
    if (modeloFacade == null) {
        System.out.println("modeloFacade está NULL ❌");
        throw new IllegalStateException("modeloFacade no inyectado");
    }
    return modeloFacade.find(id);
}


    // Crear modelo (opcional si se usa)
    public void registrar(Modelo modelo) {
        modeloFacade.create(modelo);
    }

    // Actualizar modelo (opcional si se usa)
    public void actualizar(Modelo modelo) {
        modeloFacade.edit(modelo);
    }

    // Eliminar modelo (opcional si se usa)
    public void eliminar(Modelo modelo) {
        modeloFacade.remove(modelo);
    }
}
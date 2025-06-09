/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package control;

import acceso_datos.ModeloFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import modelo.Modelo;

/**
 *
 * @author razie
 */
@Named(value = "modeloBean")
@SessionScoped
public class ModeloBean implements Serializable{
    
    @EJB
    private ModeloFacade modeloFacade;
    private Integer modeloSeleccionado;
    private Integer idMarcaSeleccionada;
    
    public List<Modelo> getListaModelos() {
        return modeloFacade.findAll();
    }
    
    public String getNombreModelo(int id) {
        for (Modelo modelo : getListaModelos()) {
            if (modelo.getId() != null && modelo.getId() == id) {
                return modelo.getNombre();
            }
        }
        return "Desconocido";
    }

    public Integer getModeloSeleccionado() {
        return modeloSeleccionado;
    }

    public void setModeloSeleccionado(Integer modeloSeleccionado) {
        this.modeloSeleccionado = modeloSeleccionado;
    }
    
    public Integer getIdMarcaSeleccionada() {
    return idMarcaSeleccionada;
}
    public void setIdMarcaSeleccionada(Integer idMarcaSeleccionada) {
    this.idMarcaSeleccionada = idMarcaSeleccionada;
}
    
    public List<Modelo> getModelosPorMarca(int idMarca) {
    List<Modelo> filtrados = new ArrayList<Modelo>();
    for (Modelo m : modeloFacade.findAll()) {
        if (m.getIdMarca() != null && m.getIdMarca().getId().equals(idMarca)) {
            filtrados.add(m);
        }
    }
    return filtrados;
}

    public List<Modelo> getModelosFiltrados() {
    if (idMarcaSeleccionada != null) {
        return getModelosPorMarca(idMarcaSeleccionada);
    }
    return new ArrayList<Modelo>(); // Lista vacía
}

public void limpiarSeleccion() {
    this.idMarcaSeleccionada = null;
    this.modeloSeleccionado = null;
}
    
    /**
     * Creates a new instance of ModeloBean
     */
    public ModeloBean() {
    }
    
}

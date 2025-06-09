/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package control;

import acceso_datos.EstadoFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import modelo.Estado;

/**
 *
 * @author razie
 */
@Named(value = "estadoBean")
@RequestScoped
public class EstadoBean {

    @EJB
    private EstadoFacade estadoFacade;
    private Integer estadoSeleccionado;
    
    public List<Estado> getListaEstados() {
        return estadoFacade.findAll();
    }
    
    public String getNombreEstado(int id) {
        for (Estado estado : getListaEstados()) {
            if (estado.getId() != null && estado.getId() == id) {
                return estado.getNombre();
            }
        }
        return "Desconocido";
    }

    public Integer getEstadoSeleccionado() {
        return estadoSeleccionado;
    }

    public void setEstadoSeleccionado(Integer estadoSeleccionado) {
        this.estadoSeleccionado = estadoSeleccionado;
    }
    
    public List<Estado> getEstadosParaCreacion() {
        List<Estado> listaEstados = estadoFacade.findAll();
        List<Estado> estadosParaCreacion = new ArrayList<>();

        for (Estado estado : listaEstados) {
            if ("En diagnóstico".equals(estado.getNombre()) || "En reparación".equals(estado.getNombre())) {
                estadosParaCreacion.add(estado);
            }
        }

        return estadosParaCreacion;
    }
    
    /**
     * Creates a new instance of EstadoBean
     */
    public EstadoBean() {
    }
    
}

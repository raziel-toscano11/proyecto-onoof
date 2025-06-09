/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package control;

import acceso_datos.MarcaFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import modelo.Marca;

/**
 *
 * @author razie
 */
@Named(value = "marcaBean")
@RequestScoped
public class MarcaBean {

    @EJB
    private MarcaFacade marcaFacade;
    private Integer marcaSeleccionada;

    public List<Marca> getListaMarcas() {
        return marcaFacade.findAll();
    }

    public String getNombreMarca(int id) {
        for (Marca marca : getListaMarcas()) {
            if (marca.getId() != null && marca.getId() == id) {
                return marca.getNombre();
            }
        }
        return "Desconocido";
    }

    public Integer getMarcaSeleccionada() {
        return marcaSeleccionada;
    }

    public void setMarcaSeleccionada(Integer marcaSeleccionada) {
        this.marcaSeleccionada = marcaSeleccionada;
    }

    /**
     * Creates a new instance of MarcaBean
     */
    public MarcaBean() {
    }

}

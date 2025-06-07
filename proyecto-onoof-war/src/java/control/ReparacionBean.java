/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package control;

/**
 *
 * @author razie
 */
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import manejo_datos.MReparacion;
import modelo.Reparacion;

@Named(value = "reparacionBean")
@SessionScoped
public class ReparacionBean implements Serializable {

    @EJB
    private MReparacion mReparacion;

    private List<Reparacion> listaReparaciones;

    private Reparacion seleccionada;

    private List<Reparacion> listaReparacionesFiltradas;
    private String busquedaCliente;

    public ReparacionBean() {
    }
    
    @PostConstruct
    public void init() {
        listaReparaciones = mReparacion.obtenerTodas();
    }

    // Método para obtener todas las reparaciones (invocado por la vista)
    public List<Reparacion> getListaReparaciones() {
        if (listaReparaciones == null) {
            listaReparaciones = mReparacion.obtenerTodas();
            System.out.println("Número de reparaciones obtenidas: " + listaReparaciones.size());
        }
        return listaReparaciones;
    }

    public Reparacion getSeleccionada() {
        return seleccionada;
    }

    public void setSeleccionada(Reparacion seleccionada) {
        this.seleccionada = seleccionada;
    }

    // Acción para editar una reparación desde la tabla
    public void editar(Reparacion r) {
        this.seleccionada = r;
        mReparacion.actualizar(seleccionada);
        limpiar();
    }

    // Acción para eliminar una reparación
    public void eliminar(Reparacion r) {
        mReparacion.eliminar(r);
        listaReparaciones = null; // Forzar recarga
    }

    // Limpia la selección
    public void limpiar() {
        this.seleccionada = null;
    }

    public String getEstadoNombre(Reparacion r) {
        try {
            return r.getIdEstado().getNombre();
        } catch (Exception e) {
            return "Sin estado";
        }
    }

    // Métodos para obtener Marca y Modelo a través de la relación encadenada
    public String getMarcaNombre(Reparacion r) {
        try {
            return r.getIdDispositivo().getModeloId().getIdMarca().getNombre();
        } catch (Exception e) {
            return "Desconocida";
        }
    }

    public String getModeloNombre(Reparacion r) {
        try {
            return r.getIdDispositivo().getModeloId().getNombre();
        } catch (Exception e) {
            return "Desconocido";
        }
    }

    public String getClienteNombre(Reparacion r) {
        try {
            return r.getIdCliente().getNombre();
        } catch (Exception e) {
            return "Desconocido";
        }
    }

    public List<Reparacion> getListaReparacionesFiltradas() {
        if (busquedaCliente == null || busquedaCliente.isEmpty()) {
            return listaReparaciones; // Si no hay filtro, mostrar todas
        }

        listaReparacionesFiltradas = new ArrayList<>();
        for (Reparacion r : listaReparaciones) {
            if (r.getIdCliente() != null && r.getIdCliente().getNombre() != null && r.getIdCliente().getNombre().toLowerCase().contains(busquedaCliente.toLowerCase())) {
                listaReparacionesFiltradas.add(r);
            }
        }
        return listaReparacionesFiltradas;
    }

    // Método para filtrar las reparaciones según el cliente
    public void filtrarPorCliente() {
        try {
            listaReparacionesFiltradas = getListaReparacionesFiltradas();
        } catch (NullPointerException e) {
            System.out.println("Error al filtrar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public String getBusquedaCliente() {
        return busquedaCliente;
    }

    public void setBusquedaCliente(String busquedaCliente) {
        this.busquedaCliente = busquedaCliente;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import modelo.Cliente;
import manejo_datos.MCliente;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author razie
 */
@Named(value = "clienteBean")
@SessionScoped
public class ClienteBean implements Serializable {

    @EJB
    private MCliente mCliente;

    private List<Cliente> listaClientes;

    private Cliente seleccionado;

    private List<Cliente> listaClientesFiltrados;
    private String busquedaCliente;

    public ClienteBean() {
    }

    @PostConstruct
    public void init() {
        listaClientes = mCliente.obtenerTodas();
        seleccionado = new Cliente();
    }

    public List<Cliente> getListaClientes() {
        if (listaClientes == null) {
            listaClientes = mCliente.obtenerTodas();
        }
        return listaClientes;
    }

    public Cliente getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Cliente seleccionada) {
        this.seleccionado = seleccionada;
    }

    public void crearCliente() {
        if (seleccionado != null) {
            mCliente.registrar(seleccionado);
            listaClientes = mCliente.obtenerTodas();
            listaClientesFiltrados = null;
            busquedaCliente = null;
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Cliente agregado exitosamente"));

            seleccionado = new Cliente();
        }
    }

    public void editar(Cliente c) {
        if (c != null) {
            mCliente.actualizar(c);
            listaClientes = mCliente.obtenerTodas(); // Actualiza la lista
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Cliente actualizado correctamente"));
            seleccionado = new Cliente(); // Limpia
        }
    }

    public void eliminar(Cliente r) {
        mCliente.eliminar(r);
        listaClientes = null; // Forzar recarga
    }

    public void limpiar() {
        this.seleccionado = null;
    }

    public String getBusquedaCliente() {
        return busquedaCliente;
    }

    public void setBusquedaCliente(String busquedaCliente) {
        this.busquedaCliente = busquedaCliente;
    }

    public List<Cliente> getListaClientesFiltrados() {
        if (busquedaCliente == null || busquedaCliente.trim().isEmpty()) {
            return listaClientes;
        }

        String criterio = busquedaCliente.toLowerCase();
        listaClientesFiltrados = new ArrayList<>();

        for (Cliente c : listaClientes) {
            String nombre = c.getNombre() != null ? c.getNombre().toLowerCase() : "";
            String apellido = c.getApellido() != null ? c.getApellido().toLowerCase() : "";

            if (nombre.contains(criterio) || apellido.contains(criterio)) {
                listaClientesFiltrados.add(c);
            }
        }

        return listaClientesFiltrados;
    }

    public void filtrarPorNombre() {
        try {
            listaClientesFiltrados = getListaClientesFiltrados();
        } catch (Exception e) {
            System.out.println("Error al filtrar clientes: " + e.getMessage());
        }
    }

    public void prepararEdicion(Cliente c) {
        this.seleccionado = c;
    }
}

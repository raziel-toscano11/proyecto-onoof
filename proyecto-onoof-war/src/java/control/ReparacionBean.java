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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import manejo_datos.MCliente;
import manejo_datos.MDispositivo;
import manejo_datos.MEstado;
import manejo_datos.MModelo;
import manejo_datos.MReparacion;
import modelo.Reparacion;
import modelo.Cliente;
import modelo.Dispositivo;
import modelo.Estado;
import modelo.Modelo;

@Named(value = "reparacionBean")
@SessionScoped
public class ReparacionBean implements Serializable {

    @EJB
    private MReparacion mReparacion;

    private List<Reparacion> listaReparaciones;

    private Reparacion seleccionada;

    private List<Reparacion> listaReparacionesFiltradas;
    private String busquedaCliente;

    @EJB
    private MCliente mCliente;
    private List<Cliente> listaClientes;
    private Integer idClienteSeleccionado;

    private Integer modeloIdSeleccionado;
    @EJB
    private MModelo mModelo;
    @EJB
    private MDispositivo mDispositivo;

    @EJB
    private MEstado mEstado;
    private Integer estadoIdSeleccionado;

    @Inject
    private ModeloBean modeloBean;

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
        this.idClienteSeleccionado = null;
        this.modeloIdSeleccionado = null;
        this.estadoIdSeleccionado = null;

        if (modeloBean != null) {
            modeloBean.limpiarSeleccion();
        }
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

    public List<Cliente> getListaClientes() {
        if (listaClientes == null) {
            listaClientes = mCliente.obtenerTodas();
        }
        return listaClientes;
    }

    public List<Cliente> completarClientes(String query) {
        List<Cliente> resultados = new ArrayList<>();
        if (query != null && !query.trim().isEmpty()) {
            String queryLower = query.toLowerCase();
            for (Cliente c : getListaClientes()) {
                if (c != null && c.getNombre() != null && c.getApellido() != null) {
                    // Busca coincidencias en nombre o apellido
                    if (c.getNombre().toLowerCase().contains(queryLower)
                            || c.getApellido().toLowerCase().contains(queryLower)) {
                        resultados.add(c);
                    }
                }
            }
        }
        System.out.println("Clientes filtrados para query '" + query + "': " + resultados.size());
        return resultados;
    }

    public Integer getIdClienteSeleccionado() {
        return idClienteSeleccionado;
    }

    public void setIdClienteSeleccionado(Integer idClienteSeleccionado) {
        this.idClienteSeleccionado = idClienteSeleccionado;
    }

    public void crearReparacion() {
        System.out.println("ID cliente: " + idClienteSeleccionado);
        System.out.println("ID modelo: " + modeloIdSeleccionado);
        System.out.println("ID estado: " + estadoIdSeleccionado);

        if (seleccionada != null && idClienteSeleccionado != null && modeloIdSeleccionado != null && estadoIdSeleccionado != null) {
            if (seleccionada.getFechaEntrega().before(seleccionada.getFechaIngreso())) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "La fecha de entrega no puede ser anterior a la de ingreso.", null));
                return; // No continúa
            }

            Cliente cliente = mCliente.obtenerPorId(idClienteSeleccionado);
            seleccionada.setIdCliente(cliente);

            Modelo modelo = mModelo.obtenerPorId(modeloIdSeleccionado);
            System.out.println("MODELO" + modelo);
            if (modelo != null) {
                Dispositivo dispositivo = new Dispositivo();
                dispositivo.setModeloId(modelo);
                mDispositivo.registrar(dispositivo); // Guardar en la base

                seleccionada.setIdDispositivo(dispositivo); // Asociar
            }

            Estado estado = mEstado.obtenerPorId(estadoIdSeleccionado);
            if (estado != null) {
                seleccionada.setIdEstado(estado); // Asignar estado
            }

            mReparacion.registrar(seleccionada); // Guardar reparación
            listaReparaciones = mReparacion.obtenerTodas();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Reparacion creada exitosamente", null));
        }
    }

    public Integer getModeloIdSeleccionado() {
        return modeloIdSeleccionado;
    }

    public void setModeloIdSeleccionado(Integer modeloIdSeleccionado) {
        this.modeloIdSeleccionado = modeloIdSeleccionado;
    }

    public Integer getEstadoIdSeleccionado() {
        return estadoIdSeleccionado;
    }

    public void setEstadoIdSeleccionado(Integer estadoIdSeleccionado) {
        this.estadoIdSeleccionado = estadoIdSeleccionado;
    }

    public void prepararNuevaReparacion() {
        this.seleccionada = new Reparacion(); // Instancia nueva
    }
    
    public void prepararEdicionEstado(Reparacion reparacion) {
    this.seleccionada = reparacion;
    if (reparacion.getIdEstado() != null) {
        this.estadoIdSeleccionado = reparacion.getIdEstado().getId();
    } else {
        this.estadoIdSeleccionado = null;
    }
}

    public void actualizarEstado() {
    if (seleccionada != null && estadoIdSeleccionado != null) {
        Estado nuevoEstado = mEstado.obtenerPorId(estadoIdSeleccionado);
        if (nuevoEstado != null) {
            seleccionada.setIdEstado(nuevoEstado);
            mReparacion.actualizar(seleccionada);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Estado actualizado correctamente", null));

            listaReparaciones = mReparacion.obtenerTodas();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Estado no válido", null));
        }
    }
}


}

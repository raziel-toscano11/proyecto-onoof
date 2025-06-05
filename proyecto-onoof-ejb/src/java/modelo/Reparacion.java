/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author razie
 */
@Entity
@Table(name = "reparacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reparacion.findAll", query = "SELECT r FROM Reparacion r"),
    @NamedQuery(name = "Reparacion.findById", query = "SELECT r FROM Reparacion r WHERE r.id = :id"),
    @NamedQuery(name = "Reparacion.findByAnticipo", query = "SELECT r FROM Reparacion r WHERE r.anticipo = :anticipo"),
    @NamedQuery(name = "Reparacion.findByMotivoReparacion", query = "SELECT r FROM Reparacion r WHERE r.motivoReparacion = :motivoReparacion"),
    @NamedQuery(name = "Reparacion.findByPrecioDiagnostico", query = "SELECT r FROM Reparacion r WHERE r.precioDiagnostico = :precioDiagnostico"),
    @NamedQuery(name = "Reparacion.findByDetalle", query = "SELECT r FROM Reparacion r WHERE r.detalle = :detalle"),
    @NamedQuery(name = "Reparacion.findByFechaIngreso", query = "SELECT r FROM Reparacion r WHERE r.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Reparacion.findByFechaEntrega", query = "SELECT r FROM Reparacion r WHERE r.fechaEntrega = :fechaEntrega"),
    @NamedQuery(name = "Reparacion.findByPrecioReparacion", query = "SELECT r FROM Reparacion r WHERE r.precioReparacion = :precioReparacion")})
public class Reparacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anticipo")
    private double anticipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "motivoReparacion")
    private String motivoReparacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioDiagnostico")
    private double precioDiagnostico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "detalle")
    private String detalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaIngreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaEntrega")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrega;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioReparacion")
    private double precioReparacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idReparacion")
    private List<ReparacionProducto> reparacionProductoList;
    @JoinColumn(name = "idCliente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "idDispositivo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Dispositivo idDispositivo;
    @JoinColumn(name = "idEstado", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Estado idEstado;

    public Reparacion() {
    }

    public Reparacion(Integer id) {
        this.id = id;
    }

    public Reparacion(Integer id, double anticipo, String motivoReparacion, double precioDiagnostico, String detalle, Date fechaIngreso, Date fechaEntrega, double precioReparacion) {
        this.id = id;
        this.anticipo = anticipo;
        this.motivoReparacion = motivoReparacion;
        this.precioDiagnostico = precioDiagnostico;
        this.detalle = detalle;
        this.fechaIngreso = fechaIngreso;
        this.fechaEntrega = fechaEntrega;
        this.precioReparacion = precioReparacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getAnticipo() {
        return anticipo;
    }

    public void setAnticipo(double anticipo) {
        this.anticipo = anticipo;
    }

    public String getMotivoReparacion() {
        return motivoReparacion;
    }

    public void setMotivoReparacion(String motivoReparacion) {
        this.motivoReparacion = motivoReparacion;
    }

    public double getPrecioDiagnostico() {
        return precioDiagnostico;
    }

    public void setPrecioDiagnostico(double precioDiagnostico) {
        this.precioDiagnostico = precioDiagnostico;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public double getPrecioReparacion() {
        return precioReparacion;
    }

    public void setPrecioReparacion(double precioReparacion) {
        this.precioReparacion = precioReparacion;
    }

    @XmlTransient
    public List<ReparacionProducto> getReparacionProductoList() {
        return reparacionProductoList;
    }

    public void setReparacionProductoList(List<ReparacionProducto> reparacionProductoList) {
        this.reparacionProductoList = reparacionProductoList;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Dispositivo getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(Dispositivo idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reparacion)) {
            return false;
        }
        Reparacion other = (Reparacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Reparacion[ id=" + id + " ]";
    }
    
}

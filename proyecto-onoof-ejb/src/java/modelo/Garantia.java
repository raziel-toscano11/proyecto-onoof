/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author razie
 */
@Entity
@Table(name = "garantia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Garantia.findAll", query = "SELECT g FROM Garantia g"),
    @NamedQuery(name = "Garantia.findById", query = "SELECT g FROM Garantia g WHERE g.id = :id"),
    @NamedQuery(name = "Garantia.findByFechaInicio", query = "SELECT g FROM Garantia g WHERE g.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Garantia.findByFechaFin", query = "SELECT g FROM Garantia g WHERE g.fechaFin = :fechaFin"),
    @NamedQuery(name = "Garantia.findByEstado", query = "SELECT g FROM Garantia g WHERE g.estado = :estado"),
    @NamedQuery(name = "Garantia.findByObservaciones", query = "SELECT g FROM Garantia g WHERE g.observaciones = :observaciones")})
public class Garantia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaInicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaFin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "estado")
    private String estado;
    @Size(max = 255)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "idVentaDetalle", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private VentaDetalle idVentaDetalle;

    public Garantia() {
    }

    public Garantia(Integer id) {
        this.id = id;
    }

    public Garantia(Integer id, Date fechaInicio, Date fechaFin, String estado) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public VentaDetalle getIdVentaDetalle() {
        return idVentaDetalle;
    }

    public void setIdVentaDetalle(VentaDetalle idVentaDetalle) {
        this.idVentaDetalle = idVentaDetalle;
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
        if (!(object instanceof Garantia)) {
            return false;
        }
        Garantia other = (Garantia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Garantia[ id=" + id + " ]";
    }
    
}

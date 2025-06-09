package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author razie
 */
@Entity
@Table(name = "historial_estado_reparacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistorialEstadoReparacion.findAll", query = "SELECT h FROM HistorialEstadoReparacion h"),
    @NamedQuery(name = "HistorialEstadoReparacion.findById", query = "SELECT h FROM HistorialEstadoReparacion h WHERE h.id = :id"),
    @NamedQuery(name = "HistorialEstadoReparacion.findByFechaCambio", query = "SELECT h FROM HistorialEstadoReparacion h WHERE h.fechaCambio = :fechaCambio")})
public class HistorialEstadoReparacion implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaCambio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCambio;

    // Relación con la tabla reparacion (reparacion_id)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idReparacion", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_historial_reparacion"))
    private Reparacion reparacion;

    // Relación con la tabla estado (estado_id)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEstado", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_historial_estado"))
    private Estado estado;

    public HistorialEstadoReparacion() {
    }

    public HistorialEstadoReparacion(Integer id) {
        this.id = id;
    }

    public HistorialEstadoReparacion(Integer id, Date fechaCambio, Reparacion reparacion, Estado estado) {
        this.id = id;
        this.fechaCambio = fechaCambio;
        this.reparacion = reparacion;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaCambio() {
        return fechaCambio;
    }

    public void setFechaCambio(Date fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    public Reparacion getReparacion() {
        return reparacion;
    }

    public void setReparacion(Reparacion reparacion) {
        this.reparacion = reparacion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
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
        if (!(object instanceof HistorialEstadoReparacion)) {
            return false;
        }
        HistorialEstadoReparacion other = (HistorialEstadoReparacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.HistorialEstadoReparacion[ id=" + id + " ]";
    }
}

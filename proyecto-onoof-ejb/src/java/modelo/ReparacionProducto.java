/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author razie
 */
@Entity
@Table(name = "reparacion_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReparacionProducto.findAll", query = "SELECT r FROM ReparacionProducto r"),
    @NamedQuery(name = "ReparacionProducto.findById", query = "SELECT r FROM ReparacionProducto r WHERE r.id = :id"),
    @NamedQuery(name = "ReparacionProducto.findByCantidad", query = "SELECT r FROM ReparacionProducto r WHERE r.cantidad = :cantidad")})
public class ReparacionProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "productoId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Producto productoId;
    @JoinColumn(name = "idReparacion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Reparacion idReparacion;

    public ReparacionProducto() {
    }

    public ReparacionProducto(Integer id) {
        this.id = id;
    }

    public ReparacionProducto(Integer id, int cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProductoId() {
        return productoId;
    }

    public void setProductoId(Producto productoId) {
        this.productoId = productoId;
    }

    public Reparacion getIdReparacion() {
        return idReparacion;
    }

    public void setIdReparacion(Reparacion idReparacion) {
        this.idReparacion = idReparacion;
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
        if (!(object instanceof ReparacionProducto)) {
            return false;
        }
        ReparacionProducto other = (ReparacionProducto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ReparacionProducto[ id=" + id + " ]";
    }
    
}

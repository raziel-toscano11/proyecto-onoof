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
@Table(name = "inventario_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InventarioProducto.findAll", query = "SELECT i FROM InventarioProducto i"),
    @NamedQuery(name = "InventarioProducto.findById", query = "SELECT i FROM InventarioProducto i WHERE i.id = :id"),
    @NamedQuery(name = "InventarioProducto.findByCantidadDisponible", query = "SELECT i FROM InventarioProducto i WHERE i.cantidadDisponible = :cantidadDisponible")})
public class InventarioProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidadDisponible")
    private int cantidadDisponible;
    @JoinColumn(name = "inventarioId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Inventario inventarioId;
    @JoinColumn(name = "productoId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Producto productoId;

    public InventarioProducto() {
    }

    public InventarioProducto(Integer id) {
        this.id = id;
    }

    public InventarioProducto(Integer id, int cantidadDisponible) {
        this.id = id;
        this.cantidadDisponible = cantidadDisponible;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public Inventario getInventarioId() {
        return inventarioId;
    }

    public void setInventarioId(Inventario inventarioId) {
        this.inventarioId = inventarioId;
    }

    public Producto getProductoId() {
        return productoId;
    }

    public void setProductoId(Producto productoId) {
        this.productoId = productoId;
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
        if (!(object instanceof InventarioProducto)) {
            return false;
        }
        InventarioProducto other = (InventarioProducto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.InventarioProducto[ id=" + id + " ]";
    }
    
}

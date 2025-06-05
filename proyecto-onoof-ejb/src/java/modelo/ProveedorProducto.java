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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author razie
 */
@Entity
@Table(name = "proveedor_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProveedorProducto.findAll", query = "SELECT p FROM ProveedorProducto p"),
    @NamedQuery(name = "ProveedorProducto.findById", query = "SELECT p FROM ProveedorProducto p WHERE p.id = :id")})
public class ProveedorProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "productoId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Producto productoId;
    @JoinColumn(name = "proveedorId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Proveedor proveedorId;

    public ProveedorProducto() {
    }

    public ProveedorProducto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Producto getProductoId() {
        return productoId;
    }

    public void setProductoId(Producto productoId) {
        this.productoId = productoId;
    }

    public Proveedor getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(Proveedor proveedorId) {
        this.proveedorId = proveedorId;
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
        if (!(object instanceof ProveedorProducto)) {
            return false;
        }
        ProveedorProducto other = (ProveedorProducto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ProveedorProducto[ id=" + id + " ]";
    }
    
}

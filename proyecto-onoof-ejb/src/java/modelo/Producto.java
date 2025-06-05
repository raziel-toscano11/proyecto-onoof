/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author razie
 */
@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findById", query = "SELECT p FROM Producto p WHERE p.id = :id"),
    @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Producto.findByCantidad", query = "SELECT p FROM Producto p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "Producto.findByCostoUnitario", query = "SELECT p FROM Producto p WHERE p.costoUnitario = :costoUnitario"),
    @NamedQuery(name = "Producto.findByGarantiaDias", query = "SELECT p FROM Producto p WHERE p.garantiaDias = :garantiaDias")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costoUnitario")
    private double costoUnitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "garantiaDias")
    private int garantiaDias;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoId")
    private List<InventarioProducto> inventarioProductoList;
    @JoinColumn(name = "categoriaId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Categoria categoriaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoId")
    private List<ReparacionProducto> reparacionProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoId")
    private List<VentaDetalle> ventaDetalleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoId")
    private List<ProveedorProducto> proveedorProductoList;

    public Producto() {
    }

    public Producto(Integer id) {
        this.id = id;
    }

    public Producto(Integer id, String nombre, String descripcion, int cantidad, double costoUnitario, int garantiaDias) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
        this.garantiaDias = garantiaDias;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public int getGarantiaDias() {
        return garantiaDias;
    }

    public void setGarantiaDias(int garantiaDias) {
        this.garantiaDias = garantiaDias;
    }

    @XmlTransient
    public List<InventarioProducto> getInventarioProductoList() {
        return inventarioProductoList;
    }

    public void setInventarioProductoList(List<InventarioProducto> inventarioProductoList) {
        this.inventarioProductoList = inventarioProductoList;
    }

    public Categoria getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Categoria categoriaId) {
        this.categoriaId = categoriaId;
    }

    @XmlTransient
    public List<ReparacionProducto> getReparacionProductoList() {
        return reparacionProductoList;
    }

    public void setReparacionProductoList(List<ReparacionProducto> reparacionProductoList) {
        this.reparacionProductoList = reparacionProductoList;
    }

    @XmlTransient
    public List<VentaDetalle> getVentaDetalleList() {
        return ventaDetalleList;
    }

    public void setVentaDetalleList(List<VentaDetalle> ventaDetalleList) {
        this.ventaDetalleList = ventaDetalleList;
    }

    @XmlTransient
    public List<ProveedorProducto> getProveedorProductoList() {
        return proveedorProductoList;
    }

    public void setProveedorProductoList(List<ProveedorProducto> proveedorProductoList) {
        this.proveedorProductoList = proveedorProductoList;
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
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Producto[ id=" + id + " ]";
    }
    
}

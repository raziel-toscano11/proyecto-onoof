package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Categoria;
import modelo.InventarioProducto;
import modelo.ProveedorProducto;
import modelo.ReparacionProducto;
import modelo.VentaDetalle;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2025-06-08T00:01:17")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> descripcion;
    public static volatile SingularAttribute<Producto, Integer> garantiaDias;
    public static volatile ListAttribute<Producto, ProveedorProducto> proveedorProductoList;
    public static volatile SingularAttribute<Producto, Integer> id;
    public static volatile SingularAttribute<Producto, Integer> cantidad;
    public static volatile ListAttribute<Producto, VentaDetalle> ventaDetalleList;
    public static volatile SingularAttribute<Producto, String> nombre;
    public static volatile SingularAttribute<Producto, Double> costoUnitario;
    public static volatile ListAttribute<Producto, InventarioProducto> inventarioProductoList;
    public static volatile ListAttribute<Producto, ReparacionProducto> reparacionProductoList;
    public static volatile SingularAttribute<Producto, Categoria> categoriaId;

}
package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Inventario;
import modelo.Producto;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2025-06-06T12:19:11")
@StaticMetamodel(InventarioProducto.class)
public class InventarioProducto_ { 

    public static volatile SingularAttribute<InventarioProducto, Inventario> inventarioId;
    public static volatile SingularAttribute<InventarioProducto, Producto> productoId;
    public static volatile SingularAttribute<InventarioProducto, Integer> id;
    public static volatile SingularAttribute<InventarioProducto, Integer> cantidadDisponible;

}
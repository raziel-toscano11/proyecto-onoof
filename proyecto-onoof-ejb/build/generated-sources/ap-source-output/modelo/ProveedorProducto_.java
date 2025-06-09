package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Producto;
import modelo.Proveedor;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2025-06-09T07:08:15")
@StaticMetamodel(ProveedorProducto.class)
public class ProveedorProducto_ { 

    public static volatile SingularAttribute<ProveedorProducto, Proveedor> proveedorId;
    public static volatile SingularAttribute<ProveedorProducto, Producto> productoId;
    public static volatile SingularAttribute<ProveedorProducto, Integer> id;

}
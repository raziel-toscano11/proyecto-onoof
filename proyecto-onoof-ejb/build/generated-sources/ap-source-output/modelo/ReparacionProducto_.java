package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Producto;
import modelo.Reparacion;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2025-06-09T12:42:41")
@StaticMetamodel(ReparacionProducto.class)
public class ReparacionProducto_ { 

    public static volatile SingularAttribute<ReparacionProducto, Reparacion> idReparacion;
    public static volatile SingularAttribute<ReparacionProducto, Producto> productoId;
    public static volatile SingularAttribute<ReparacionProducto, Integer> id;
    public static volatile SingularAttribute<ReparacionProducto, Integer> cantidad;

}
package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Garantia;
import modelo.Producto;
import modelo.Venta;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2025-06-09T12:06:44")
@StaticMetamodel(VentaDetalle.class)
public class VentaDetalle_ { 

    public static volatile SingularAttribute<VentaDetalle, Double> precioUnitario;
    public static volatile SingularAttribute<VentaDetalle, Producto> productoId;
    public static volatile ListAttribute<VentaDetalle, Garantia> garantiaList;
    public static volatile SingularAttribute<VentaDetalle, Integer> id;
    public static volatile SingularAttribute<VentaDetalle, Integer> cantidad;
    public static volatile SingularAttribute<VentaDetalle, Venta> idVenta;

}
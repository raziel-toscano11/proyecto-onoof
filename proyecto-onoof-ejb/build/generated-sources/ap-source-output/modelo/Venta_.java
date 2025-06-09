package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Cliente;
import modelo.VentaDetalle;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2025-06-09T12:42:41")
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile SingularAttribute<Venta, Double> total;
    public static volatile SingularAttribute<Venta, Cliente> idCliente;
    public static volatile SingularAttribute<Venta, Integer> id;
    public static volatile ListAttribute<Venta, VentaDetalle> ventaDetalleList;
    public static volatile SingularAttribute<Venta, Date> fechaVenta;

}
package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Cliente;
import modelo.Dispositivo;
import modelo.Estado;
import modelo.ReparacionProducto;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2025-06-08T00:01:17")
@StaticMetamodel(Reparacion.class)
public class Reparacion_ { 

    public static volatile SingularAttribute<Reparacion, Double> anticipo;
    public static volatile SingularAttribute<Reparacion, Date> fechaIngreso;
    public static volatile SingularAttribute<Reparacion, Double> precioReparacion;
    public static volatile SingularAttribute<Reparacion, Estado> idEstado;
    public static volatile SingularAttribute<Reparacion, String> motivoReparacion;
    public static volatile SingularAttribute<Reparacion, Cliente> idCliente;
    public static volatile SingularAttribute<Reparacion, Dispositivo> idDispositivo;
    public static volatile SingularAttribute<Reparacion, Date> fechaEntrega;
    public static volatile SingularAttribute<Reparacion, Double> precioDiagnostico;
    public static volatile SingularAttribute<Reparacion, Integer> id;
    public static volatile ListAttribute<Reparacion, ReparacionProducto> reparacionProductoList;
    public static volatile SingularAttribute<Reparacion, String> detalle;

}
package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.VentaDetalle;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2025-06-06T12:19:11")
@StaticMetamodel(Garantia.class)
public class Garantia_ { 

    public static volatile SingularAttribute<Garantia, String> estado;
    public static volatile SingularAttribute<Garantia, VentaDetalle> idVentaDetalle;
    public static volatile SingularAttribute<Garantia, Date> fechaInicio;
    public static volatile SingularAttribute<Garantia, String> observaciones;
    public static volatile SingularAttribute<Garantia, Integer> id;
    public static volatile SingularAttribute<Garantia, Date> fechaFin;

}
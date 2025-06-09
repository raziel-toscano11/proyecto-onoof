package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Estado;
import modelo.Reparacion;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2025-06-09T12:06:44")
@StaticMetamodel(HistorialEstadoReparacion.class)
public class HistorialEstadoReparacion_ { 

    public static volatile SingularAttribute<HistorialEstadoReparacion, Estado> estado;
    public static volatile SingularAttribute<HistorialEstadoReparacion, Date> fechaCambio;
    public static volatile SingularAttribute<HistorialEstadoReparacion, Reparacion> reparacion;
    public static volatile SingularAttribute<HistorialEstadoReparacion, Integer> id;

}
package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Reparacion;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2025-06-05T15:42:57")
@StaticMetamodel(Estado.class)
public class Estado_ { 

    public static volatile ListAttribute<Estado, Reparacion> reparacionList;
    public static volatile SingularAttribute<Estado, Integer> id;
    public static volatile SingularAttribute<Estado, String> nombre;

}
package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Modelo;
import modelo.Reparacion;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2025-06-07T11:58:33")
@StaticMetamodel(Dispositivo.class)
public class Dispositivo_ { 

    public static volatile ListAttribute<Dispositivo, Reparacion> reparacionList;
    public static volatile SingularAttribute<Dispositivo, Integer> id;
    public static volatile SingularAttribute<Dispositivo, Modelo> modeloId;

}
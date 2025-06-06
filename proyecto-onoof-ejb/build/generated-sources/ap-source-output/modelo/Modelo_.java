package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Dispositivo;
import modelo.Marca;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2025-06-06T12:19:11")
@StaticMetamodel(Modelo.class)
public class Modelo_ { 

    public static volatile ListAttribute<Modelo, Dispositivo> dispositivoList;
    public static volatile SingularAttribute<Modelo, Integer> id;
    public static volatile SingularAttribute<Modelo, Marca> idMarca;
    public static volatile SingularAttribute<Modelo, String> nombre;

}
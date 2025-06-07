package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Inventario;
import modelo.Producto;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2025-06-07T11:58:33")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile ListAttribute<Categoria, Producto> productoList;
    public static volatile ListAttribute<Categoria, Inventario> inventarioList;
    public static volatile SingularAttribute<Categoria, Integer> id;
    public static volatile SingularAttribute<Categoria, String> nombre;

}
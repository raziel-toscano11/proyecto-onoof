package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Categoria;
import modelo.InventarioProducto;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2025-06-09T07:08:15")
@StaticMetamodel(Inventario.class)
public class Inventario_ { 

    public static volatile SingularAttribute<Inventario, Date> fechaActualizacion;
    public static volatile SingularAttribute<Inventario, Integer> id;
    public static volatile SingularAttribute<Inventario, Categoria> idCategoria;
    public static volatile ListAttribute<Inventario, InventarioProducto> inventarioProductoList;

}
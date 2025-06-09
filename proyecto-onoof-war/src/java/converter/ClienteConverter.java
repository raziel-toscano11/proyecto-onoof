/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import manejo_datos.MCliente;
import modelo.Cliente;

@FacesConverter(value = "clienteConverter", managed = true) // managed = true es CLAVE
public class ClienteConverter implements Converter<Cliente> {

    @Inject
    private MCliente mCliente;

    @Override
    public Cliente getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        try {
            return mCliente.obtenerPorId(Integer.valueOf(value));
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Cliente cliente) {
        if (cliente == null || cliente.getId() == null) {
            return "";
        }
        return cliente.getId().toString();
    }
}

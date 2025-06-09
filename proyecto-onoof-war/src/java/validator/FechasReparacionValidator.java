/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validator;

/**
 *
 * @author razie
 */

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Date;

@FacesValidator("fechasReparacionValidator")
public class FechasReparacionValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Date fechaEntrega = (Date) value;

        // Buscar el componente "fechaIngreso" en el formulario
        UIComponent fechaIngresoComponent = component.findComponent("fechaIngreso");

        if (fechaIngresoComponent != null) {
            Object ingresoObj = ((javax.faces.component.UIInput) fechaIngresoComponent).getLocalValue();

            if (ingresoObj instanceof Date) {
                Date fechaIngreso = (Date) ingresoObj;

                if (fechaEntrega != null && fechaIngreso != null && fechaEntrega.before(fechaIngreso)) {
                    throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "La fecha de entrega no puede ser anterior a la fecha de ingreso.", null));
                }
            }
        }
    }
}

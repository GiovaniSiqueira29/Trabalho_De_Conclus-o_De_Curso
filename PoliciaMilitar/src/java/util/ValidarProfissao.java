//Polícia Militar
package util;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validarProfissao")
public class ValidarProfissao implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {

        String nome = (String) o;
        if (!nome.contains("MILITAR") && !nome.contains("CIVIL")) {
            FacesMessage msg = new FacesMessage("O campo profissao deve ser MILITAR ou CIVIL!");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}

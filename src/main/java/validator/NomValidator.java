package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator
public class NomValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
        System.out.println("Validation de Nom: " + value);

        UIInput nomInput = (UIInput) uiComponent.getAttributes().get("attributeNom");
        String nom = (String) nomInput.getValue();
        System.out.println("nom: " + nom);

        String prenom = (String) value;
        if (prenom.length() < 2) {
            System.out.println("le nom est invalide");
            FacesMessage fmsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Name Validation failed", "Invalid Name.");
            throw new ValidatorException(fmsg);
        }
    }
}
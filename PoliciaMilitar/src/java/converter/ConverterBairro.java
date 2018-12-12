//Policia Militar
package converter;

import dao.DAOGenerico;
import modelo.Bairro;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("converterBairro")
public class ConverterBairro implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String id) {
        if (id != null && !id.isEmpty()) {
            DAOGenerico<Bairro> dao = new DAOGenerico<Bairro>(Bairro.class);
            return dao.buscar(new Long(id));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o != null) {
            Bairro bairro = (Bairro) o;
            return String.valueOf(bairro.getId());
        }
        return null;
    }
}
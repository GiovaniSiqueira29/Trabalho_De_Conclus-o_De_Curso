//Policia Civil
package converter;

import dao.DAOGenerico;
import modelo.Civil;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("converterCivil")
public class ConverterCivil implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String id) {
        if (id != null && !id.isEmpty()) {
            DAOGenerico<Civil> dao = new DAOGenerico<Civil>(Civil.class);
            return dao.buscar(new Long(id));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o != null) {
            Civil civil = (Civil) o;
            return String.valueOf(civil.getId());
        }
        return null;
    }

}
//Policia Militar
package converter;

import dao.DAOGenerico;
import modelo.Militar;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("converterMilitar")
public class ConverterMilitar implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String id) {
        if (id != null && !id.isEmpty()) {
            DAOGenerico<Militar> dao = new DAOGenerico<Militar>(Militar.class);
            return dao.buscar(new Long(id));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o != null) {
            Militar militar = (Militar) o;
            return String.valueOf(militar.getId());
        }
        return null;
    }

}


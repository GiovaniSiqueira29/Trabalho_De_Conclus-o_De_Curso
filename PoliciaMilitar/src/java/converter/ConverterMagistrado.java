//Policia Magistrado
package converter;

import dao.DAOGenerico;
import modelo.Magistrado;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("converterMagistrado")
public class ConverterMagistrado implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String id) {
        if (id != null && !id.isEmpty()) {
            DAOGenerico<Magistrado> dao = new DAOGenerico<Magistrado>(Magistrado.class);
            return dao.buscar(new Long(id));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o != null) {
            Magistrado magistrado = (Magistrado) o;
            return String.valueOf(magistrado.getId());
        }
        return null;
    }

}


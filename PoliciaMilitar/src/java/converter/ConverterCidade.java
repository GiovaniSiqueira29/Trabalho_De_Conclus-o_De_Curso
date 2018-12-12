//Policia Militar
package converter;

import dao.DAOGenerico;
import modelo.Cidade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("converterCidade")
public class ConverterCidade implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String id) {
        if (id != null && !id.isEmpty()) {
            DAOGenerico<Cidade> dao = new DAOGenerico<Cidade>(Cidade.class);
            return dao.buscar(new Long(id));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o != null) {
            Cidade cidade = (Cidade) o;
            return String.valueOf(cidade.getId());
        }
        return null;
    }
}
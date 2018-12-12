//Policia Militar
package converter;

import dao.DAOGenerico;
import modelo.BoletimOcorrencia;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("converterBoletimOcorrencia")
public class ConverterBoletimOcorrencia implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String id) {
        if (id != null && !id.isEmpty()) {
            DAOGenerico<BoletimOcorrencia> dao = new DAOGenerico<BoletimOcorrencia>(BoletimOcorrencia.class);
            return dao.buscar(new Long(id));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o != null) {
            BoletimOcorrencia boletimOcorrencia = (BoletimOcorrencia) o;
            return String.valueOf(boletimOcorrencia.getId());
        }
        return null;
    }
}
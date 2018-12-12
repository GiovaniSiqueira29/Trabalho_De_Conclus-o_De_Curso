//policiaMilitar
package controle;

import dao.DAOGenerico;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Cidade;
import modelo.Estado;

@ManagedBean
@ViewScoped
public class UtilsMB {

    private Estado estado;
    private DAOGenerico<Cidade> daoCidade;
    private List<Cidade> listaCidade;

    public UtilsMB() {
        daoCidade = new DAOGenerico<Cidade>(Cidade.class);
        listaCidade = new ArrayList<Cidade>();
        estado = new Estado();
    }

    public void mudarCidade() {
        //System.out.println("Teste");
        listaCidade = daoCidade.buscarCondicao("estado.id = '" + estado.getId() + "'");
        System.out.println("Teste Dois");
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public DAOGenerico<Cidade> getDaoCidade() {
        return daoCidade;
    }

    public void setDaoCidade(DAOGenerico<Cidade> daoCidade) {
        this.daoCidade = daoCidade;
    }

    public List<Cidade> getListaCidade() {
        return listaCidade;
    }

    public void setListaCidade(List<Cidade> listaCidade) {
        this.listaCidade = listaCidade;
    }
    
    
}

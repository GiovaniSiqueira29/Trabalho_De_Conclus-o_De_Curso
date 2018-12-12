//Policia Militar
package controle;

import dao.DAOGenerico;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Militar;

@ManagedBean
@ViewScoped
public class MilitarMB {

    private Militar militar;
    private DAOGenerico<Militar> daoMilitar;
    private List<Militar> listaMilitar;

    public MilitarMB() {
        militar = new Militar();
        daoMilitar = new DAOGenerico<Militar>(Militar.class);
        listaMilitar = new ArrayList<Militar>();
        preencherListasMilitars();
    }

    public void atualizarCadastroMilitar() {
        militar = new Militar();
        preencherListasMilitars();
    }

    public DAOGenerico<Militar> getDaoMilitar() {
        return daoMilitar;
    }

    public void setDaoMilitar(DAOGenerico<Militar> daoMilitar) {
        this.daoMilitar = daoMilitar;
    }

    private void preencherListasMilitars() {
        listaMilitar = daoMilitar.buscarTodos();
    }

    public void remover(Long id) {
        daoMilitar.excluir(id);
        FacesMessage message = new FacesMessage("Exclusão realizada com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, message);
        preencherListasMilitars();
    }

    public void inserir() {
        if (militar.getId() == null) {
            daoMilitar.salvar(militar);
            FacesMessage message = new FacesMessage("Cadastro realizado com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            daoMilitar.alterar(militar);
            FacesMessage message = new FacesMessage("Alteração realizada com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        militar = new Militar();
        preencherListasMilitars();
    }

    public Militar getMilitar() {
        return militar;
    }

    public void setMilitar(Militar militar) {
        this.militar = militar;
    }

    public List<Militar> getListaMilitar() {
        return listaMilitar;
    }

    public void setListaMilitar(List<Militar> listaMilitar) {
        this.listaMilitar = listaMilitar;
    }

}

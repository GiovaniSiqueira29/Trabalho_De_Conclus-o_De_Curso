//policiaMilitar
package controle;

import dao.DAOGenerico;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.MandadosJudiciais;

@ManagedBean
@ViewScoped
public class MandadosJudiciaisMB {

    private MandadosJudiciais mandadosJudiciais;

    private DAOGenerico<MandadosJudiciais> daoMandadosJudiciais;

    private List<MandadosJudiciais> listaMandadosJudiciais;

    public MandadosJudiciaisMB() {
        mandadosJudiciais = new MandadosJudiciais();
        daoMandadosJudiciais = new DAOGenerico<MandadosJudiciais>(MandadosJudiciais.class);
        listaMandadosJudiciais = new ArrayList<MandadosJudiciais>();
        preencherListasMandadosJudiciaiss();
    }

    public void atualizarMandadosJudiciais() {
        mandadosJudiciais = new MandadosJudiciais();
        preencherListasMandadosJudiciaiss();
    }

    private void preencherListasMandadosJudiciaiss() {
        listaMandadosJudiciais = daoMandadosJudiciais.buscarTodos();
    }

    public void remover(Long id) {
        daoMandadosJudiciais.excluir(id);
        FacesMessage message = new FacesMessage("Exclusão realizada com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, message);
        preencherListasMandadosJudiciaiss();
    }

    public void inserir() {
        if (mandadosJudiciais.getId() == null) {
            daoMandadosJudiciais.salvar(mandadosJudiciais);
            FacesMessage message = new FacesMessage("Cadastro realizado com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            daoMandadosJudiciais.alterar(mandadosJudiciais);
            FacesMessage message = new FacesMessage("Alteração realizada com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        mandadosJudiciais = new MandadosJudiciais();
        preencherListasMandadosJudiciaiss();
    }

    public MandadosJudiciais getMandadosJudiciais() {
        return mandadosJudiciais;
    }

    public void setMandadosJudiciais(MandadosJudiciais mandadosJudiciais) {
        this.mandadosJudiciais = mandadosJudiciais;
    }

    public DAOGenerico<MandadosJudiciais> getDaoMandadosJudiciais() {
        return daoMandadosJudiciais;
    }

    public void setDaoMandadosJudiciais(DAOGenerico<MandadosJudiciais> daoMandadosJudiciais) {
        this.daoMandadosJudiciais = daoMandadosJudiciais;
    }

    public List<MandadosJudiciais> getListaMandadosJudiciais() {
        return listaMandadosJudiciais;
    }

    public void setListaMandadosJudiciais(List<MandadosJudiciais> listaMandadosJudiciais) {
        this.listaMandadosJudiciais = listaMandadosJudiciais;
    }

}

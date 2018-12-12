//Policia Militar
package controle;

import dao.DAOGenerico;
import modelo.Cidade;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class CidadeMB {

    private Cidade cidade;

    private DAOGenerico<Cidade> daoCidade;

    private List<Cidade> listaCidade;

    public CidadeMB() {
        cidade = new Cidade();
        daoCidade = new DAOGenerico<Cidade>(Cidade.class);
        listaCidade = new ArrayList<Cidade>();
        preencherListasCidades();
    }

    public void atualizarCidade() {
        cidade = new Cidade();
        preencherListasCidades();
    }

    private void preencherListasCidades() {
        listaCidade = daoCidade.buscarTodos();
    }

    public void remover(Long id) {
        daoCidade.excluir(id);
        FacesMessage message = new FacesMessage("Exclusão realizada com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, message);
        preencherListasCidades();
    }

    public void inserir() {
        if (cidade.getId() == null) {
            daoCidade.salvar(cidade);
            FacesMessage message = new FacesMessage("Cadastro realizado com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            daoCidade.alterar(cidade);
            FacesMessage message = new FacesMessage("Alteração realizada com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        cidade = new Cidade();
        preencherListasCidades();
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
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

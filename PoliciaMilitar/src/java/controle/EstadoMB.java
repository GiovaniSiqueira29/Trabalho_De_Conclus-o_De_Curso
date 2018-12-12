//Policia Militar
package controle;

import dao.DAOGenerico;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Cidade;
import modelo.Estado;

@ManagedBean
@ViewScoped
public class EstadoMB {

    private Estado estado;
    private DAOGenerico<Estado> daoEstado;
    private List<Estado> listaEstado;
    
    private Cidade cidade;
    private DAOGenerico<Cidade> daoCidade;
    private List<Cidade> listaCidade;

    public EstadoMB() {
        estado = new Estado();
        daoEstado = new DAOGenerico<Estado>(Estado.class);
        listaEstado = new ArrayList<Estado>();
        daoCidade = new DAOGenerico<Cidade>(Cidade.class);
        listaCidade = new ArrayList<Cidade>();
        preencherListasEstados();
    }

    public void atualizarEstado() {
        estado = new Estado();
        preencherListasEstados();
    }
    
    public void mudarCidade() {
        //System.out.println("Teste");
        listaCidade = daoCidade.buscarCondicao("estado.id = '" + estado.getId() + "'");
        System.out.println("Teste Dois");
    }

    public DAOGenerico<Estado> getDaoEstado() {
        return daoEstado;
    }

    public void setDaoEstado(DAOGenerico<Estado> daoEstado) {
        this.daoEstado = daoEstado;
    }

    private void preencherListasEstados() {
        listaEstado = daoEstado.buscarTodos();
    }

    public void remover(Long id) {
        daoEstado.excluir(id);
        FacesMessage message = new FacesMessage("Exclusão realizada com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, message);
        preencherListasEstados();
    }

    public void inserir() {
        if (estado.getId() == null) {
            daoEstado.salvar(estado);
            FacesMessage message = new FacesMessage("Cadastro realizado com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            daoEstado.alterar(estado);
            FacesMessage message = new FacesMessage("Alteração realizada com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        estado = new Estado();
        preencherListasEstados();
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Estado> getListaEstado() {
        return listaEstado;
    }

    public void setListaEstado(List<Estado> listaEstado) {
        this.listaEstado = listaEstado;
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

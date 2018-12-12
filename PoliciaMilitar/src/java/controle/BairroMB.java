//Policia Militar
package controle;

import dao.DAOGenerico;
import modelo.Bairro;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class BairroMB {

    private Bairro bairro;

    private DAOGenerico<Bairro> daoBairro;

    private List<Bairro> listaBairro;

    public BairroMB() {
        bairro = new Bairro();
        daoBairro = new DAOGenerico<Bairro>(Bairro.class);
        listaBairro = new ArrayList<Bairro>();
        preencherListasBairros();
    }

    public void atualizarBairros() {
        bairro = new Bairro();
        preencherListasBairros();
    }

    private void preencherListasBairros() {
        listaBairro = daoBairro.buscarTodos();
    }

    public void remover(Long id) {
        daoBairro.excluir(id);
        FacesMessage message = new FacesMessage("Exclusão realizada com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, message);
        preencherListasBairros();
    }

    public void inserir() {
        if (bairro.getId() == null) {
            daoBairro.salvar(bairro);
            FacesMessage message = new FacesMessage("Cadastro realizado com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            daoBairro.alterar(bairro);
            FacesMessage message = new FacesMessage("Alteração realizada com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        bairro = new Bairro();
        preencherListasBairros();
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public DAOGenerico<Bairro> getDaoBairro() {
        return daoBairro;
    }

    public void setDaoBairro(DAOGenerico<Bairro> daoBairro) {
        this.daoBairro = daoBairro;
    }

    public List<Bairro> getListaBairro() {
        return listaBairro;
    }

    public void setListaBairro(List<Bairro> listaBairro) {
        this.listaBairro = listaBairro;
    }

}

//Policia Magistrado
package controle;

import dao.DAOGenerico;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Magistrado;

@ManagedBean
@ViewScoped
public class MagistradoMB {

    private Magistrado magistrado;
    private DAOGenerico<Magistrado> daoMagistrado;
    private List<Magistrado> listaMagistrado;

    public MagistradoMB() {
        magistrado = new Magistrado();
        daoMagistrado = new DAOGenerico<Magistrado>(Magistrado.class);
        listaMagistrado = new ArrayList<Magistrado>();
        preencherListasMagistrados();
    }

    public void atualizarMagistrados() {
        magistrado = new Magistrado();
        preencherListasMagistrados();
    }

    public void atualizarCadastroMagistrado() {
        magistrado = new Magistrado();
        preencherListasMagistrados();
    }

    public DAOGenerico<Magistrado> getDaoMagistrado() {
        return daoMagistrado;
    }

    public void setDaoMagistrado(DAOGenerico<Magistrado> daoMagistrado) {
        this.daoMagistrado = daoMagistrado;
    }

    private void preencherListasMagistrados() {
        listaMagistrado = daoMagistrado.buscarTodos();
    }

    public void remover(Long id) {
        daoMagistrado.excluir(id);
        FacesMessage message = new FacesMessage("Exclusão realizada com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        preencherListasMagistrados();
    }

    public void inserir() {
        if (magistrado.getId() == null) {
            daoMagistrado.salvar(magistrado);
            FacesMessage message = new FacesMessage("Cadastro realizado com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            daoMagistrado.alterar(magistrado);
            FacesMessage message = new FacesMessage("Alteração realizada com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        magistrado = new Magistrado();
        preencherListasMagistrados();
    }

    public Magistrado getMagistrado() {
        return magistrado;
    }

    public void setMagistrado(Magistrado magistrado) {
        this.magistrado = magistrado;
    }

    public List<Magistrado> getListaMagistrado() {
        return listaMagistrado;
    }

    public void setListaMagistrado(List<Magistrado> listaMagistrado) {
        this.listaMagistrado = listaMagistrado;
    }

}

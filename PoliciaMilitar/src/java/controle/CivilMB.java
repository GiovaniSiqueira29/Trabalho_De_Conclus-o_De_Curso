//Policia Civil
package controle;

import dao.DAOGenerico;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Cidade;
import modelo.Civil;
import modelo.Estado;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean
@ViewScoped
public class CivilMB {

    private Civil civil;
    private DAOGenerico<Civil> daoCivil;
    private List<Civil> listaCivil;
    private Estado estado;
    private DAOGenerico<Cidade> daoCidade;
    private List<Cidade> listaCidade;
    private UploadedFile arquivo;

    public CivilMB() {
        civil = new Civil();
        daoCivil = new DAOGenerico<Civil>(Civil.class);
        listaCivil = new ArrayList<Civil>();
        daoCidade = new DAOGenerico<Cidade>(Cidade.class);
        listaCidade = new ArrayList<Cidade>();
        estado = new Estado();
        preencherListasCivils();

    }

    public void atualizarCadastroCivil() {
        civil = new Civil();
        preencherListasCivils();
    }

    public DAOGenerico<Civil> getDaoCivil() {
        return daoCivil;
    }

    public void setDaoCivil(DAOGenerico<Civil> daoCivil) {
        this.daoCivil = daoCivil;
    }

    private void preencherListasCivils() {
        listaCivil = daoCivil.buscarTodos();
    }

    public void remover(Long id) {
        daoCivil.excluir(id);
        FacesMessage message = new FacesMessage("Exclusão realizada com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, message);
        preencherListasCivils();
    }

    public void inserir() {
        if (civil.getId() == null) {
            daoCivil.salvar(civil);
            FacesMessage message = new FacesMessage("Cadastro realizado com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            daoCivil.alterar(civil);
            FacesMessage message = new FacesMessage("Alteração realizada com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        civil = new Civil();
        preencherListasCivils();
    }

    public void enviarArquivo() {
        if (arquivo != null) {
            FacesMessage message = new FacesMessage("Sucesso", arquivo.getFileName() + "o arquivo foi adicionado.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage msg = new FacesMessage("Sucesso", event.getFile().getFileName() + " o arquivo foi adicionado.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void filtrarCidade() {
        listaCidade = daoCidade.buscarCondicao("estado.id = '" + estado.getId()+ "'");
        System.out.println("Teste");
    }
    
    public Civil getCivil() {
        return civil;
    }

    public void setCivil(Civil civil) {
        this.civil = civil;
    }

    public List<Civil> getListaCivil() {
        return listaCivil;
    }

    public void setListaCivil(List<Civil> listaCivil) {
        this.listaCivil = listaCivil;
    }

    public UploadedFile getArquivo() {
        return arquivo;
    }

    public void setArquivo(UploadedFile arquivo) {
        this.arquivo = arquivo;
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

//    private Estado estado;
//    private DAOGenerico<Cidade> daoCidade;
//    private List<Cidade> listaCidade;
//
//    public UtilsMB() {
//       daoCidade = new DAOGenerico<Cidade>(Cidade.class);
//       listaCidade = new ArrayList<Cidade>();
//       estado = new Estado();
//    }
//
//    public void filtroCidade() {
//        listaCidade = daoCidade.buscarCondicao("estado.id = '" + estado.getId() + "'");
//    }

//policiaMilitar
package controle;

import dao.DAOGenerico;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Notificacao;
import util.ChamarRelatorio;

@ManagedBean
@ViewScoped
public class NotificacaoMB {

    private Notificacao notificacao;

    private DAOGenerico<Notificacao> daoNotificacao;

    private List<Notificacao> listaNotificacao;

    public NotificacaoMB() {
        notificacao = new Notificacao();
        daoNotificacao = new DAOGenerico<Notificacao>(Notificacao.class);
        listaNotificacao = new ArrayList<Notificacao>();
        preencherListasNotificacaos();
    }
    
    public void chamarRelatorio(){
        ChamarRelatorio rel = new ChamarRelatorio();
        rel.imprimeRelatorio("relBoletim.jasper", null, "Relatório_Boletim");
    }

    public void atualizarNotificacao() {
        notificacao = new Notificacao();
        preencherListasNotificacaos();
    }

    private void preencherListasNotificacaos() {
        listaNotificacao = daoNotificacao.buscarTodos();
    }

    public void remover(Long id) {
        daoNotificacao.excluir(id);
        FacesMessage message = new FacesMessage("Exclusão realizada com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        preencherListasNotificacaos();
    }

    public void inserir() {
        if (notificacao.getId() == null) {
            daoNotificacao.salvar(notificacao);
            FacesMessage message = new FacesMessage("Cadastro realizado com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            daoNotificacao.alterar(notificacao);
            FacesMessage message = new FacesMessage("Alteração realizada com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        notificacao = new Notificacao();
        preencherListasNotificacaos();
    }

    public Notificacao getNotificacao() {
        return notificacao;
    }

    public void setNotificacao(Notificacao notificacao) {
        this.notificacao = notificacao;
    }

    public DAOGenerico<Notificacao> getDaoNotificacao() {
        return daoNotificacao;
    }

    public void setDaoNotificacao(DAOGenerico<Notificacao> daoNotificacao) {
        this.daoNotificacao = daoNotificacao;
    }

    public List<Notificacao> getListaNotificacao() {
        return listaNotificacao;
    }

    public void setListaNotificacao(List<Notificacao> listaNotificacao) {
        this.listaNotificacao = listaNotificacao;
    }

}

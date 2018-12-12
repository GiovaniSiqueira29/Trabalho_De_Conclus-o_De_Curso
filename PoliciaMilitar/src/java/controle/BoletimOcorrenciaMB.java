//policiaMilitar
package controle;

import dao.DAOGenerico;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.BoletimOcorrencia;
import util.ChamarRelatorio;

@ManagedBean
@ViewScoped
public class BoletimOcorrenciaMB {

    private BoletimOcorrencia boletimOcorrencia;

    private DAOGenerico<BoletimOcorrencia> daoBoletimOcorrencia;

    private List<BoletimOcorrencia> listaBoletimOcorrencia;

    public BoletimOcorrenciaMB() {
        boletimOcorrencia = new BoletimOcorrencia();
        daoBoletimOcorrencia = new DAOGenerico<BoletimOcorrencia>(BoletimOcorrencia.class);
        listaBoletimOcorrencia = new ArrayList<BoletimOcorrencia>();
        preencherListasBoletimOcorrencias();
    }
    
    public void chamarRelatorio(){
        ChamarRelatorio rel = new ChamarRelatorio();
        rel.imprimeRelatorio("relBoletim.jasper", null, "Relatório_Boletim");
    }

    public void atualizarBoletimOcorrencia() {
        boletimOcorrencia = new BoletimOcorrencia();
        preencherListasBoletimOcorrencias();
    }

    private void preencherListasBoletimOcorrencias() {
        listaBoletimOcorrencia = daoBoletimOcorrencia.buscarTodos();
    }

    public void remover(Long id) {
        daoBoletimOcorrencia.excluir(id);
        FacesMessage message = new FacesMessage("Exclusão realizada com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        preencherListasBoletimOcorrencias();
    }

    public void inserir() {
        if (boletimOcorrencia.getId() == null) {
            daoBoletimOcorrencia.salvar(boletimOcorrencia);
            FacesMessage message = new FacesMessage("Cadastro realizado com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            daoBoletimOcorrencia.alterar(boletimOcorrencia);
            FacesMessage message = new FacesMessage("Alteração realizada com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        boletimOcorrencia = new BoletimOcorrencia();
        preencherListasBoletimOcorrencias();
    }

    public BoletimOcorrencia getBoletimOcorrencia() {
        return boletimOcorrencia;
    }

    public void setBoletimOcorrencia(BoletimOcorrencia boletimOcorrencia) {
        this.boletimOcorrencia = boletimOcorrencia;
    }

    public DAOGenerico<BoletimOcorrencia> getDaoBoletimOcorrencia() {
        return daoBoletimOcorrencia;
    }

    public void setDaoBoletimOcorrencia(DAOGenerico<BoletimOcorrencia> daoBoletimOcorrencia) {
        this.daoBoletimOcorrencia = daoBoletimOcorrencia;
    }

    public List<BoletimOcorrencia> getListaBoletimOcorrencia() {
        return listaBoletimOcorrencia;
    }

    public void setListaBoletimOcorrencia(List<BoletimOcorrencia> listaBoletimOcorrencia) {
        this.listaBoletimOcorrencia = listaBoletimOcorrencia;
    }

}

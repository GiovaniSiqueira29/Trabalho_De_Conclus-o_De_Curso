//policiaMilitar
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class BoletimOcorrencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String naturezaCrime;
    private String descricaoCrime;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dtRegistro = new Date();
    //@Temporal(javax.persistence.TemporalType.TIME)
    private Date horaRegistro;
    private String ambienteCrime;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dtFato = new Date();
    //@Temporal(javax.persistence.TemporalType.TIME)
    private Date horaInicioFato;
    //@Temporal(javax.persistence.TemporalType.TIME)
    private Date horaFinalFato;
    private String objetosApreendidos;
    private String requisicaoExames;
    private String observacoes;
    @ManyToOne
    private Militar militar;
    @ManyToOne
    private Civil vitimaCivil;
    @ManyToOne
    private Bairro bairro;
    @ManyToOne
    private Cidade cidade;
    @ManyToOne
    private Estado estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaturezaCrime() {
        return naturezaCrime;
    }

    public void setNaturezaCrime(String naturezaCrime) {
        this.naturezaCrime = naturezaCrime;
    }

    public String getDescricaoCrime() {
        return descricaoCrime;
    }

    public void setDescricaoCrime(String descricaoCrime) {
        this.descricaoCrime = descricaoCrime;
    }

    public Date getDtRegistro() {
        return dtRegistro;
    }

    public void setDtRegistro(Date dtRegistro) {
        this.dtRegistro = dtRegistro;
    }

    public Date getHoraRegistro() {
        return horaRegistro;
    }

    public void setHoraRegistro(Date horaRegistro) {
        this.horaRegistro = horaRegistro;
    }

    public String getAmbienteCrime() {
        return ambienteCrime;
    }

    public void setAmbienteCrime(String ambienteCrime) {
        this.ambienteCrime = ambienteCrime;
    }

    public Date getDtFato() {
        return dtFato;
    }

    public void setDtFato(Date dtFato) {
        this.dtFato = dtFato;
    }

    public Date getHoraInicioFato() {
        return horaInicioFato;
    }

    public void setHoraInicioFato(Date horaInicioFato) {
        this.horaInicioFato = horaInicioFato;
    }

    public Date getHoraFinalFato() {
        return horaFinalFato;
    }

    public void setHoraFinalFato(Date horaFinalFato) {
        this.horaFinalFato = horaFinalFato;
    }

    public String getObjetosApreendidos() {
        return objetosApreendidos;
    }

    public void setObjetosApreendidos(String objetosApreendidos) {
        this.objetosApreendidos = objetosApreendidos;
    }

    public String getRequisicaoExames() {
        return requisicaoExames;
    }

    public void setRequisicaoExames(String requisicaoExames) {
        this.requisicaoExames = requisicaoExames;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Militar getMilitar() {
        return militar;
    }

    public void setMilitar(Militar militar) {
        this.militar = militar;
    }

    public Civil getVitimaCivil() {
        return vitimaCivil;
    }

    public void setVitimaCivil(Civil vitimaCivil) {
        this.vitimaCivil = vitimaCivil;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BoletimOcorrencia other = (BoletimOcorrencia) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}

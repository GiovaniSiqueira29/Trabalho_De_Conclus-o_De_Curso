//Polícia Militar
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
public class MandadosJudiciais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String natureza;
    private String artigos;
    private String complementos;
    private String motivo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataRegistro = new Date();
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataValidade = new Date();
    @ManyToOne
    private Magistrado magistrado;
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

    public String getNatureza() {
        return natureza;
    }

    public void setNatureza(String natureza) {
        this.natureza = natureza;
    }

    public String getArtigos() {
        return artigos;
    }

    public void setArtigos(String artigos) {
        this.artigos = artigos;
    }

    public String getComplementos() {
        return complementos;
    }

    public void setComplementos(String complementos) {
        this.complementos = complementos;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Magistrado getMagistrado() {
        return magistrado;
    }

    public void setMagistrado(Magistrado magistrado) {
        this.magistrado = magistrado;
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
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final MandadosJudiciais other = (MandadosJudiciais) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}

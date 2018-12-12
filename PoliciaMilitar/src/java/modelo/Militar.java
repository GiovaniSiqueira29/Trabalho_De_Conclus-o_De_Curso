//Polícia Militar
package modelo;

import javax.persistence.Entity;

@Entity
public class Militar extends Pessoa {

    private String registroMilitar;
    private String senha;

    public String getRegistroMilitar() {
        return registroMilitar;
    }

    public void setRegistroMilitar(String registroMilitar) {
        this.registroMilitar = registroMilitar;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}

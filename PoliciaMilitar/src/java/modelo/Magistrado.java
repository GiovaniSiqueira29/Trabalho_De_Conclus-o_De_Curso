//Polícia Mlitar
package modelo;

import javax.persistence.Entity;

@Entity
public class Magistrado extends Pessoa {

    private String comarca;

    public String getComarca() {
        return comarca;
    }

    public void setComarca(String comarca) {
        this.comarca = comarca;
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ats;

/**
 *
 * @author luis
 */
public class Bc {
    private Integer boco;
    private Integer vezes;

    public Bc(Integer boco) {
        this.boco = boco;
        this.vezes = 0;
    }

    public Bc(Integer boco, Integer vezes) {
        this.boco = boco;
        this.vezes = vezes;
    }

    public Integer getBoco() {
        return boco;
    }

    public void setBoco(Integer boco) {
        this.boco = boco;
    }

    public Integer getVezes() {
        return vezes;
    }

    public void setVezes(Integer vezes) {
        this.vezes = vezes;
    }

    void incVezes() {
        this.vezes++;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("O bloco de codigo ");
        s.append(boco);
        s.append(", foi utilizado ");
        s.append(vezes);
        s.append(" vezes.");
        s.append("\n");
        return s.toString();
    }
    
    
}

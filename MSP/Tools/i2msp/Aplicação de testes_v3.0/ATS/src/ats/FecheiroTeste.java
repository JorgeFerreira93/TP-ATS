/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ats;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 *
 * @author luis
 */
public class FecheiroTeste {
    private ArrayList <TreeSet<Integer>> dados = new ArrayList <TreeSet<Integer>>();
    private ArrayList <String> resltados = new ArrayList <String>();
    private ArrayList <String> linhas = new ArrayList <String>();

    public ArrayList<TreeSet<Integer>> getDados() {
        return dados;
    }

    public ArrayList<String> getResltados() {
        return resltados;
    }

    public ArrayList<String> getLinhas() {
        return linhas;
    }
    public void clear(){
        this.dados.clear();
        this.resltados.clear();
        this.linhas.clear();
    }
   
    public ArrayList <Integer> semEfeito(FecheiroTeste falhas){
        ArrayList <Integer> aux = new ArrayList <Integer>();
        
        for(int i=0; i < linhas.size(); i++){
            if(this.linhas.get(i).equals(falhas.linhas.get(i))){
                aux.add(i+1);
            }
                
        }
        
       return aux;
    }
    
    
    
    
}

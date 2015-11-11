/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ats;

import java.util.ArrayList;

/**
 *
 * @author luis
 */
public class coiso {
   private ArrayList <ArrayList<Integer>> matriz;
   private ArrayList<Integer> res;
   private ArrayList<Float> prob;

    public coiso(ArrayList<ArrayList<Integer>> matriz, ArrayList<Integer> res) {
        this.matriz = matriz;
        this.res = res;
        this.prob = probabilidades(matriz, res);
    }
    
    // calcula probabilidade de todos os blocos de codigo serem os responsaveis pelo comportamento errado
    public ArrayList<Float> probabilidades (ArrayList <ArrayList<Integer>> matris,ArrayList<Integer> res){
        ArrayList<Float> probs = new ArrayList<Float>();
        float aux;
        int n11 = 0;
        int n10 = 0;
        int n01 = 0;
        
        for (int i = 0; i < matris.get(0).size() ; i++ ){
            for(int j = 0; j < res.size() ;j++){
                int a = matris.get(j).get(i);
                int b = res.get(j);
                if( a == 1 && b == 1 ) {
                    n11++;
                }
                else if ( a == 1 && b == 0 ) {
                    n10++;
                }
                else if ( a == 0 && b == 1 ) {
                    n01++;
                }
            }
            aux = (n11 + n10 + n01);
            aux = (n11 /aux);
            probs.add(aux);
            n11 = 0;
            n10 = 0;
            n01 = 0;
        }
        
        return probs;
    }

   
    public ArrayList<ArrayList<Integer>> getMatriz() {
        return matriz;
    }

    public void setMatriz(ArrayList<ArrayList<Integer>> matriz) {
        this.matriz = matriz;
    }

    public ArrayList<Integer> getRes() {
        return res;
    }

    public void setRes(ArrayList<Integer> res) {
        this.res = res;
    }

    public ArrayList<Float> getProb() {
        return prob;
    }

    public void setProb(ArrayList<Float> prob) {
        this.prob = prob;
    }
   
   
}

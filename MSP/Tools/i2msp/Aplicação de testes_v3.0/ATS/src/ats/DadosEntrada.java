/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ats;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;
import javax.swing.text.html.HTMLDocument;

/**
 *
 * @author luis
 */


public class DadosEntrada {

    private Integer max =0;
    private ArrayList <String> resltadosEsperados = new ArrayList <String>();
    private ArrayList <Bc> bCodigo = new  ArrayList <Bc>();
    private FecheiroTeste normal = new FecheiroTeste();
    private FecheiroTeste falhas = new FecheiroTeste();
    
    
    public ArrayList<Bc> bRanking(){
        return quicksort(bCodigo);
    }
    
    private ArrayList<Bc> quicksort(ArrayList<Bc> input){
        if(input.size() <= 1){
            return input;
        }
        int middle = (int) Math.ceil((double)input.size() / 2);
        Bc pivot = input.get(middle);

        ArrayList<Bc> less = new ArrayList<Bc>();
        ArrayList<Bc> greater = new ArrayList<Bc>();
        for (int i = 0; i < input.size(); i++) {
            if(input.get(i).getVezes() <= pivot.getVezes()){
                if(i == middle){
                    continue;
                }
                less.add(input.get(i));
                }
                else{
                    greater.add(input.get(i));
                }
        }
        return concatenate(quicksort(less), pivot, quicksort(greater));
    }
    private ArrayList<Bc> concatenate(ArrayList<Bc> less, Bc pivot, ArrayList<Bc> greater){
        ArrayList<Bc> list = new ArrayList<Bc>();
        
        for (int i = 0; i < greater.size(); i++) {
            list.add(greater.get(i));
        }
        
        list.add(pivot);
        
        for (int i = 0; i < less.size(); i++) {
            list.add(less.get(i));
        }
        return list;
    }
    private void addBcodigo(Integer bc){
    
        int tam = this.bCodigo.size();
        if(bc <= tam){
            bCodigo.get((bc - 1)).incVezes();
        }
        else{
            while((bc-1) != this.bCodigo.size()){
                if(tam >0){
                    Integer last =  bCodigo.get((bCodigo.size()-1)).getBoco();
                    bCodigo.add(new Bc((last+1)));
                }
                else{
                    bCodigo.add(new Bc(1));
                }
            }
            bCodigo.add(new Bc(bc, 1));
        }
       
    }
    public ArrayList <Integer> blocosNutilizados(){
        
        ArrayList <Integer> notUsed = new ArrayList<Integer>();
        
        for(int i =0; i < this.bCodigo.size(); i++){
            if(this.bCodigo.get(i).getVezes() == 0) {
                notUsed.add((i+1));
            }
        }
        
        return notUsed;
    }
    
    
    // da maior bloco de codigo encontrado
    public Integer getMax() {
        return max;
    }

    public ArrayList<Bc> getbCodigo() {
        return bCodigo;
    }
    /**
     * @param args the command line arguments
     */
    
    // carrega de um ficheiro a informação relativa aos resoltados dos testes
    // chamado com o valor 1 o ficheiro é o normal
    // chamado com o valor 2 é o ficheiro com as falhas
     
    public boolean lerFecheiroTeste(String file,int i) throws FileNotFoundException, IOException{
       if(i == 1){
           this.normal.clear();
       }
       else if ( i== 2){
           this.falhas.clear();
       }
       boolean t = true;
       BufferedReader br = new BufferedReader(new FileReader(file));
      
       while(br.ready() && t){   
            String linha = br.readLine();  
            if(i == 1){
                this.normal.getLinhas().add(linha);
            }
            else if ( i== 2){
                this.falhas.getLinhas().add(linha);
            }
            t = partir(linha,i);   
        }   
        br.close(); 
        
        if ( i== 1 && bCodigo.size()>this.max){
            t = false;
        }else if (i== 1 && bCodigo.size()>this.max){
            this.addBcodigo(this.max);
            this.bCodigo.get(this.max-1).setVezes(0);
        }
        
        return t;
    } 
    // carrega os resultados esperados de um ficheiro para memoria
    public void lerFecheiroRes(String file) throws FileNotFoundException, IOException{
       this.resltadosEsperados.clear();
       BufferedReader br = new BufferedReader(new FileReader(file));   
       while(br.ready()){   
            String linha = br.readLine();  
            this.resltadosEsperados.add(linha);
        }   
        br.close();   
    }
    
    // ver se os testes cobrem todos os blocos de codigo
    public ArrayList <Integer> testCoverage(){
        
        return this.normal.semEfeito(falhas);
    }
    
    // verifica se o ficheiro de teste e de resultados esperads tem os mesmo numero de elemntos.
    public boolean tamanho( int i){
        
        boolean aux = false;        
        if(i == 1)
            aux = tamanho(this.normal);
        else if ( i == 2)
            aux=tamanho(this.falhas);
        
        return aux;
        
    }
    private boolean tamanho( FecheiroTeste ft){
        boolean aux;        
        if(ft.getDados().size() == resltadosEsperados.size())
            aux = true;
        else
            aux=false;
        
        return aux;
        
    }
    // utilizado no mentudo lerFecheiroTeste, parte uma linha do ficheiro de testes
    // e coloca os seu elemtos nos seu siteo correcto, tambem vai validando o ficheiro de dados.
    public boolean partir(String linha, int j){
      boolean t = true;
      TreeSet<Integer> aux = new TreeSet<Integer>();
      StringTokenizer bc = new StringTokenizer(linha,"#");
      if(bc.hasMoreElements()){
          try {  
              int max = Integer.parseInt(bc.nextToken());
              if(this.max > 0 && this.max != max){
                   t = false;
              }
              else{
                  this.max=max;
              }
            } catch(NumberFormatException nfe) {  
               t = false;  
            }   
       }
       else{
           t = false;
      }
      if(bc.hasMoreElements() && t){
        StringTokenizer str = new StringTokenizer(bc.nextToken(),";");
        String blocos = str.nextToken();
        if(str.hasMoreElements()){
          StringTokenizer str2 = new StringTokenizer(blocos,",");
          Integer i = 0;
          while(str2.hasMoreElements() && t){
              try {  
                i = Integer.parseInt(str2.nextToken());  
                this.addBcodigo(i);
              } catch(NumberFormatException nfe) {  
                 t = false;  
              }   
             if(t){
  
                  aux.add(i);
              }
          }
          if(j == 1){
              this.normal.getResltados().add(str.nextToken());
              this.normal.getDados().add(aux);
          }
          else if (j == 2){
              this.falhas.getResltados().add(str.nextToken());
              this.falhas.getDados().add(aux);
          }

        }
        else{
            t = false;
        }
      }
      else{
        t = false;
      }
      return t;
    }
    
    // inicia a matris utilizada no algoritemos SFL 
    
    private ArrayList <ArrayList<Integer>> initMatris (int i){
        ArrayList <ArrayList<Integer>> tablea = new ArrayList <ArrayList<Integer>>();
        
        if (i==1){
            tablea=initMatris(this.normal);
        }
        else if( i ==2 ){
            tablea=initMatris(this.falhas);
        }
        
        return tablea;
    }
    private ArrayList <ArrayList<Integer>> initMatris (FecheiroTeste ft){
        ArrayList <ArrayList<Integer>> tablea = new ArrayList <ArrayList<Integer>>();
        
        for(int i =0; i< ft.getDados().size();i++){
            ArrayList<Integer> linhaTab = new ArrayList<Integer>();
            for (int j=0; j < this.max; j++){
                linhaTab.add(0);
            }
            tablea.add(linhaTab);
        }
        
        return tablea;
    }
    
    // constroi a matris com os dados dos ficheiros ja carregados que estao nas es truturas de dados
    // reservadas para esse efeito
     public ArrayList <ArrayList<Integer>> matris (int i){
         ArrayList <ArrayList<Integer>> tablea = initMatris(i);
         
        if (i==1){
            tablea=matris(this.normal,i);
        }
        else if( i ==2 ){
            tablea=matris(this.falhas,i);
        }
         
         return tablea;
     }
    private ArrayList <ArrayList<Integer>> matris (FecheiroTeste ft, int j){
        ArrayList <ArrayList<Integer>> tablea = initMatris(j);
         
        Iterator it1 = ft.getDados().iterator(); 
        int i=0;
        while (it1.hasNext())
        {
            TreeSet<Integer> aux = (TreeSet<Integer>) it1.next();
            Iterator it = aux.iterator(); 
            while (it.hasNext()){
               tablea.get(i).set((Integer)it.next()-1, 1);
            } 
            i++;    
        }
         
         return tablea;
    }
    
    // verefica o resultado obetido no teste coincide com o esperado e coloca essa 
    // avaliação um vector de resultados
    
    public ArrayList<Integer> res (int i){
        ArrayList<Integer> aux = new ArrayList<Integer>();
        if (i==1){
            aux=res(this.normal);
        }
        else if( i ==2 ){
            aux=res(this.falhas);
        }
        return aux;
    }
    private ArrayList<Integer> res (FecheiroTeste ft){
        ArrayList<Integer> aux = new ArrayList<Integer>();
        
        Iterator it1 = ft.getResltados().iterator(); 
        Iterator it2 = resltadosEsperados.iterator(); 
        
        while(it1.hasNext() && it2.hasNext()){
            if(it1.next().equals(it2.next()))
                aux.add(0);
            else
                aux.add(1);            
        }
        
        
        return aux;
    }
}
    
    
   

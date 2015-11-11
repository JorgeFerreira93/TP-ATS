/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ats;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author luis
 */
public class Main {
    
    private DadosEntrada dadosEntrda = new DadosEntrada();
    private coiso dadosAvaliados;
    
   // nao impelmetado 
     private void conPro(coiso c){
        //Tabela
        StringBuilder s = new StringBuilder();
        Iterator it1 = c.getProb().iterator();
        int i=0;
        while (it1.hasNext()){
             Float next = (Float) it1.next();
            if(next > 0.0F){
                if(i>0){
                    s.append(",");
                }
                s.append("(");
                s.append(i+1);
                s.append(",");
                s.append(it1.next());
                s.append(")");   
            }
            i++;
        }
        s.append("\n");
        
         System.out.println(s.toString());
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
                         

   

    private void relatorio1() {
       StringBuilder s = new StringBuilder();
       ArrayList<Bc> bc = dadosEntrda.bRanking();
       ArrayList<Integer> nubc = dadosEntrda.blocosNutilizados();
        
        // Bc not used
        Iterator it1 = nubc.iterator();
        while (it1.hasNext()){
            s.append(it1.next());
            if(it1.hasNext()){
                s.append(", ");
            }
        }
        s.append("\n\n");
        System.out.println(s.toString());
    }
    private void relatorio2() {
       StringBuilder s = new StringBuilder();
       ArrayList<Bc> bc = dadosEntrda.bRanking();
       ArrayList<Integer> nubc = dadosEntrda.blocosNutilizados();
    
        // mais utilizados 
        Iterator it1 = nubc.iterator();
        it1 = bc.iterator();
        int i = 0;
        while (it1.hasNext() && i < 10)
        {
            s.append(((Bc)it1.next()).getBoco());
            s.append(", ");
            s.append(((Bc)it1.next()).getVezes());
            s.append("\n");
            i++;
        }
        System.out.println(s.toString());
    }
     private void relatoriofalhas() {
       StringBuilder s = new StringBuilder();
       ArrayList<Integer> semEfeito = this.dadosEntrda.testCoverage();
       
        Iterator it1 = semEfeito.iterator();
        if (!it1.hasNext()){
        s.append("0\n");
        }
        else{
            while (it1.hasNext())
            {
                s.append(it1.next());
                if(it1.hasNext()){
                    s.append(", ");
                }
            }
            s.append("\n");
        }
        System.out.println(s.toString());
    }
    
      public static void main(String args[]) throws IOException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        Main m = new Main();
        if(args.length == 0){
                Interface i = new Interface();
                i.setVisible(true);
        }
            else{
            try {
                int tp = Integer.parseInt(args[0]);
                if(tp > 5 && tp == 1 && tp == 2){
                    System.out.println("Número de parâmetros incorretos");
                }
                else if(args.length > 2 && args.length < 5){
                  try {
                        if (!m.dadosEntrda.lerFecheiroTeste(args[1], 1)) {
                           System.out.println("Ficheiro Inválido: " +args[1]+ ". Ou não foi encontrado"  );
                        }
                        else{
                            m.dadosEntrda.lerFecheiroRes(args[2]);
                             if(m.dadosEntrda.tamanho(1)) {
                                 m.dadosAvaliados = new coiso(m.dadosEntrda.matris(1), m.dadosEntrda.res(1));
                                 if(tp == 1 || tp == 0){
                                     m.conPro(m.dadosAvaliados);
                                 }
                                 if(tp == 2 || tp == 0){
                                     m.relatorio1();
                                 }
                                 if(tp == 3 || tp == 0){
                                     m.relatorio2();
                                 }
                             }
                             else{
                                 System.out.println("Os ficheiros, "+args[1]+ " e " + args[2] +" não têm a mesma cardinalidade."  );
                             }
                        }
                        if(args.length == 4){
                            if (!m.dadosEntrda.lerFecheiroTeste(args[3], 2)) {
                               System.out.println("Ficheiro Inválido: " +args[3]+ ". Ou não foi encontrado"  );
                            }
                            else{
                                 if(m.dadosEntrda.tamanho(2)) {
                                    if(tp == 4 || tp == 0){
                                        m.relatoriofalhas();
                                    }
                                }
                                else {
                                    System.out.println("Os ficheiros, "+args[1]+ " e " + args[2] +" não têm a mesma cardinalidade."  );
                                }
                            }
                        }
                    }
                    catch (FileNotFoundException ex) {}
                    catch (IOException ex) {}
                }
                else{
                     System.out.println("Parâmetro incorreto");
                }
            }catch(NumberFormatException nfe) {  
                   System.out.println("Opeção invalida");
                }  
        }
        
      }
            
        
                
}

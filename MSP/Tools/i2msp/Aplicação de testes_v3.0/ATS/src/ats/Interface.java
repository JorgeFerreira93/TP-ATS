package ats;

import com.itextpdf.text.DocumentException;
import java.awt.Color;
import java.awt.Component;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;


/**
 *
 * @author luis
 */

public class Interface extends javax.swing.JFrame{

    private DadosEntrada dadosEntrda = new DadosEntrada();
    private coiso dadosAvaliados;
    private coiso dadosAvaliadosComFalhas;
    private int file1 = 0;
    private int file2 = 0;
    private boolean ok = false;
    
    public Interface() throws FileNotFoundException, IOException {
        initComponents();
        this.setTitle("Spectrum-based Fault Localization");
        this.setLocationRelativeTo(null);
        this.relatoriosPDF.setEnabled(false);
    }

    private void conTab( JTable tab , coiso c, int p){
        //Tabela
        DefaultTableModel Tmodel = new DefaultTableModel();
        Tmodel.addColumn("Teste");
        for(int i = 1; i < dadosEntrda.getMax()+1; i++){
            Tmodel.addColumn("B" + i);
        }
        Tmodel.addColumn("Erro");
        Iterator it = c.getMatriz().iterator();
        int i =1;
        while(it.hasNext()){
            ArrayList<Integer> aux = (ArrayList<Integer>) it.next();
            aux.add(0, i);
            aux.add(c.getRes().get(i-1));
            Tmodel.addRow(aux.toArray()); 
            i++;
        }
        Object aux[] = new Object[c.getProb().size()+1];
        Object aux2[] = c.getProb().toArray();
        aux[0]="PE";
        for(int j=1; j < (c.getProb().size()+1); j++){
            aux[j]=aux2[j-1];
        }
        Tmodel.addRow(aux);
        tab.setModel(Tmodel);
        tab.setAutoResizeMode(tab.AUTO_RESIZE_OFF);
        if(p == 1){
            this.pintar(tab);
        }
        else if( p == 2){
             this.pintar2(tab);
        }
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jFileChooser1 = new javax.swing.JFileChooser();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        relatoriosPDF = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        jMenuItem4.setText("jMenuItem4");

        jMenuItem6.setText("jMenuItem6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jScrollPane1, gridBagConstraints);

        jTabbedPane1.addTab("Tabela", jPanel1);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(jScrollPane2, gridBagConstraints);

        jTabbedPane1.addTab("Relatorio", jPanel2);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jTable2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel3.add(jScrollPane3, gridBagConstraints);

        jTabbedPane1.addTab("Tabela testes com falhas", jPanel3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jTabbedPane1, gridBagConstraints);

        jMenu1.setText("Carregar");

        jMenuItem1.setText("Resultados Esperados");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setText("Resultados Dos Testes");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem7.setText("Resultados Dos Testes Com Falhas");
        jMenuItem7.setEnabled(false);
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        relatoriosPDF.setText("Gerar Relatório PDF");
        relatoriosPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relatoriosPDFActionPerformed(evt);
            }
        });
        jMenu1.add(relatoriosPDF);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Avaliar");
        jMenu2.setEnabled(false);

        jMenuItem5.setText("Avaliar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem8.setText("Avaliar Testes");
        jMenuItem8.setEnabled(false);
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                dadosEntrda.lerFecheiroRes(fc.getSelectedFile().getAbsolutePath());
                file2=1;
            } 
            catch (FileNotFoundException ex) {} 
            catch (IOException ex) {}
        }
        if(file1 == file2 && file1 == 1){
            this.jMenu2.setEnabled(true);
            this.relatoriosPDF.setEnabled(true);
            dadosAvaliados = new coiso(dadosEntrda.matris(1), dadosEntrda.res(1));
        }
        else{
            this.jMenu2.setEnabled(false);
            this.relatoriosPDF.setEnabled(false);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String aux =fc.getSelectedFile().getAbsolutePath();
            try {
                if (dadosEntrda.lerFecheiroTeste(aux,1)){
                    file1 = 1;
                    jMenuItem7.setEnabled(true);
                }
                else{
                    JOptionPane.showMessageDialog(this, "Ficheiro Inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (FileNotFoundException ex) {}
            catch (IOException ex) {}
        }
        if(file1 == file2 && file1 == 1){
            this.jMenu2.setEnabled(true);
            this.relatoriosPDF.setEnabled(true);
            dadosAvaliados = new coiso(dadosEntrda.matris(1), dadosEntrda.res(1));
        }
        else{
            this.jMenu2.setEnabled(false);
            this.relatoriosPDF.setEnabled(false);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        if(dadosEntrda.tamanho(1)) {
            if(this.dadosAvaliadosComFalhas != null){
                this.jMenuItem8.setEnabled(true);
            }
            this.ok= true;
            this.conTab(this.jTable1,dadosAvaliados,1);
            this.relatorio();
            this.file1 = 0;
            this.file2 = 0;
        }
        else {
            JOptionPane.showMessageDialog(this, "Os ficheiros não têm a mesma cardinalidade.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void relatoriosPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relatoriosPDFActionPerformed
        JFileChooser fc = new JFileChooser();
        int returnVal =  fc.showSaveDialog(this);;
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                Pdf relatorio = new Pdf(dadosAvaliados,dadosAvaliadosComFalhas,dadosEntrda, dadosEntrda.getMax());
                String cam = fc.getSelectedFile().getAbsolutePath();
                System.out.println(cam);
                if(!fc.getSelectedFile().getName().contains(".pdf")){
                    cam = cam + ".pdf";
                }
                relatorio.gerarRelatorio(cam);
            } catch (FileNotFoundException | DocumentException ex) {}
        }
    }//GEN-LAST:event_relatoriosPDFActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String aux =fc.getSelectedFile().getAbsolutePath();
            try {
                if (!(dadosEntrda.lerFecheiroTeste(aux,2))){
                    JOptionPane.showMessageDialog(this, "Ficheiro Inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (FileNotFoundException ex) {}
            catch (IOException ex) {}
        
            dadosAvaliadosComFalhas = new coiso(dadosEntrda.matris(2), dadosEntrda.res(2));
            if(ok){
                this.jMenuItem8.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        if(dadosEntrda.tamanho(2)) {
            this.conTab(this.jTable2,dadosAvaliadosComFalhas,2);
            this.relatorio();
            this.relatoriofalhas();
            this.file1 = 0;
            this.file2 = 0;
        }
        else {
            JOptionPane.showMessageDialog(this, "Os ficheiros não têm a mesma cardinalidade.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JMenuItem relatoriosPDF;
    // End of variables declaration//GEN-END:variables

    private void pintar(JTable tab) {
       final int rowCount = tab.getRowCount() -1 ;
       final int columnCount = tab.getColumnCount() -1 ;
       DefaultTableCellRenderer tableRenderer;
       tableRenderer = new DefaultTableCellRenderer(){
           public Component getTableCellRendererComponent(JTable table, Object value,  
                                    boolean isSelected, boolean hasFocus, int row, int column)
           {  
                super.getTableCellRendererComponent(table, value, isSelected,  
                        hasFocus, row, column);  
                if (column >0 && row == rowCount && column < columnCount) { 
                    
                    float valor = (Float) table.getModel().getValueAt(row, column);
                    if ( valor > 0){ 
                        int red =Math.round( ( 255 - 155*valor)) ;
                        setBackground(new Color(red, 10, 10));
                    }
                    else  
                    setBackground(null);
                   
                      
                } else {  
                    setBackground(null);  
                }  
                return this;  
            }  
       };
       tab.setDefaultRenderer(Object.class, tableRenderer); 
       

        
    }
    
     private void pintar2(JTable tab) {
       final int rowCount = tab.getRowCount() -1 ;
       final int columnCount = tab.getColumnCount() -1 ;
       final ArrayList<Integer> semEfeito = this.dadosEntrda.testCoverage();
       DefaultTableCellRenderer tableRenderer;
       tableRenderer = new DefaultTableCellRenderer(){
           public Component getTableCellRendererComponent(JTable table, Object value,  
                                    boolean isSelected, boolean hasFocus, int row, int column)
           {  
                super.getTableCellRendererComponent(table, value, isSelected,  
                        hasFocus, row, column);  
                if (column >0 && row == rowCount && column < columnCount) { 
                    float valor = (Float) table.getModel().getValueAt(row, column);
                    if ( valor > 0){ 
                        int red =Math.round( ( 255 - 155*valor)) ;
                        setBackground(new Color(red, 10, 10));
                    }
                    else  
                    setBackground(null);
                   
                      
                } else {  
                    setBackground(null);  
                }  
                if (semEfeito.contains(row+1)){
                    setBackground(Color.yellow);
                }
                return this;  
            }  
       };
       tab.setDefaultRenderer(Object.class, tableRenderer); 
       

        
    }

    private void relatorio() {
       StringBuilder s = new StringBuilder();
       ArrayList<Bc> bc = dadosEntrda.bRanking();
       ArrayList<Integer> nubc = dadosEntrda.blocosNutilizados();
       
        Iterator it1 = nubc.iterator();
        s.append("Blocos de código não utilizados: ");
        while (it1.hasNext())
        {
            s.append(it1.next());
            if(it1.hasNext()){
                s.append(", ");
            }
        }
        s.append("\n\n");
       
        it1 = bc.iterator();
        
        int i = 0;
        while (it1.hasNext() && i < 10)
        {
            s.append(it1.next().toString());
            i++;
        }
        this.jTextArea1.setText(s.toString());
    }
     private void relatoriofalhas() {
       StringBuilder s = new StringBuilder();
       ArrayList<Integer> semEfeito = this.dadosEntrda.testCoverage();
       
        Iterator it1 = semEfeito.iterator();
        if (!it1.hasNext()){
        s.append("Todos os teste demonstram anomalias face ao comportamento normal.\n");
        }
        else{
            s.append("Teste que não sofreram alterações com a injeção de falhas: ");
            while (it1.hasNext())
            {
                s.append(it1.next());
                if(it1.hasNext()){
                    s.append(", ");
                }
            }
            s.append("\n\n");
        }
        this.jTextArea1.append(s.toString());
    }

}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ats;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

    
    
/**
 *
 * @author luis
 */
public class Pdf {
    private coiso dadosAvaliados;
    private coiso dadosAvaliadosComFalhas;
    private DadosEntrada dadosEntrda;
    private Integer max; 

    public Pdf(coiso dadosAvaliados, coiso dadosAvaliadosComFalhas,DadosEntrada dadosEntrda, Integer max) {
        this.dadosAvaliados = dadosAvaliados;
        this.dadosAvaliadosComFalhas = dadosAvaliadosComFalhas;
        this.max = max;
        this.dadosEntrda=dadosEntrda; 
    }
    
   

   
    
     public void gerarRelatorio(String FILE) throws FileNotFoundException, DocumentException{
        Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
        Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
        Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(FILE));
            doc.open();
            addMetaData(doc);
            addTitlePage(doc, catFont, smallBold);
            addContent(doc, catFont, subFont);
            doc.close();
        } catch (FileNotFoundException | DocumentException e) {}
    }

    private void addMetaData(Document document) {
        document.addTitle("Spectrum-based Fault Localization");
        document.addSubject("Matrizes");
        document.addAuthor("Bruno, Luís e Tiago");
        document.addCreator("Bruno, Luís e Tiago");
    }

    private void addTitlePage(Document document, Font catFont, Font smallBold) throws DocumentException{
        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Spectrum-based Fault Localization", catFont));
        addEmptyLine(preface, 4);
        preface.add(new Paragraph("Este documento demonstra a matriz criada pela aplicação assim como o vector de erros.", smallBold));
        addEmptyLine(preface, 8);
        document.add(preface);
    }

    private void addContent(Document document, Font catFont, Font subFont) throws DocumentException {
        Anchor anchor = new Anchor("Matriz", catFont);
        anchor.setName("Matriz");
        // Second parameter is the number of the chapter
        Chapter catPart = new Chapter(new Paragraph(anchor), 1);
        // Add a table
        createTable(catPart,dadosAvaliados);
        // Now add all this to the document
        document.add(catPart);
        
        anchor = new Anchor("Relatorio Blocos de Codigo", catFont);
        anchor.setName("Relatorio Blocos de Codigo");
        // Second parameter is the number of the chapter
        catPart = new Chapter(new Paragraph(anchor), 2);
        relatorio(catPart);
        // Now add all this to the document
        document.add(catPart);
        if(this.dadosAvaliadosComFalhas != null){
            
        anchor = new Anchor("Relatorio Testes", catFont);
        anchor.setName("Relatorio Testes");
        // Second parameter is the number of the chapter
        catPart = new Chapter(new Paragraph(anchor), 3);
        relatoriofalhas(catPart);
        catPart.add(new Paragraph(" "));
        catPart.add(new Paragraph("Matriz dos testes com falhas."));
        catPart.add(new Paragraph(" "));
        createTable(catPart,dadosAvaliadosComFalhas);
        document.add(catPart);
        }
        
        
        
    }
    
    private void createTable(Chapter CatPart, coiso c) throws BadElementException {
        int colunas = this.max + 2;//2 corresponde ao teste e ao erro
        int cont = 0, nr_tab = colunas/7, resto = colunas%7, i = 0;
        
        for(; cont<nr_tab; cont++){ //vai fazer "nr_tab" tabelas
            if(cont == 0){ //Na primeira tabela tem que meter a coluna teste
                int lim = 6*(cont+1);
                PdfPTable table = new PdfPTable(7);
                //colunas
                table.addCell("Teste");
                for(; i < lim; i++){
                    table.addCell("B" + (i+1));
                }
                //linhas
                int j = 1;
                Iterator it = c.getMatriz().iterator();
                while(it.hasNext()){
                    table.addCell(""+j);
                    ArrayList<Integer> aux = (ArrayList<Integer>) it.next();
                    for(i = 0; i < lim; i++){
                        table.addCell("" + aux.get(i));
                    }
                    j++;
                }
                //adicionar probabilidades
                table.addCell("PE");
                for(i = 0; i < lim; i++){
                    table.addCell("" + c.getProb().get(i));
                }
                //adicionar tabela
                CatPart.add(table);
                CatPart.newPage();
            }
            else{
                if(resto != 0){//Garantir que o erro não aparece aqui
                    int aux_nr = i; int lim = 7*(cont+1)-1;
                    PdfPTable table = new PdfPTable(7);
                    //colunas
                    for(; i < lim; i++){
                        table.addCell("B" + (i+1));
                    }
                    //linhas
                    for(ArrayList<Integer> aux: c.getMatriz()){
                        for(i = aux_nr; i < lim; i++){
                            table.addCell("" + aux.get(i));
                        }
                    }
                    //adicionar probabilidades
                    for(i = aux_nr; i < lim; i++){
                        table.addCell("" + c.getProb().get(i));
                    }
                    //adicionar tabela
                    CatPart.add(table);
                    CatPart.newPage();
                }
                else{//Erro na última coluna; implica que resto é 0
                    if((cont+1) == nr_tab){
                        int aux_nr = i; int lim = 7*(cont+1)-2;
                        PdfPTable table = new PdfPTable(7);
                        //colunas
                        for(; i < lim; i++){
                            table.addCell("B" + (i+1));
                        }
                        table.addCell("Erro");
                        //linhas
                        int linh = 0;
                        for(ArrayList<Integer> aux: c.getMatriz()){
                            for(i = aux_nr; i < lim; i++){
                                table.addCell("" + aux.get(i));
                            }
                            //adicionar erro
                            table.addCell("" + c.getRes().get(linh));
                            linh++;
                        }
                        //adicionar probabilidades
                        for(i = aux_nr; i < lim; i++){
                            table.addCell("" + c.getProb().get(i));
                        }
                        table.addCell("");
                        //adicionar tabela
                        CatPart.add(table);
                        CatPart.newPage();
                    }
                    else{ //Ainda não é a ultima tabela
                        int aux_nr = i; int lim = 7*(cont+1)-1;
                        PdfPTable table = new PdfPTable(7);
                        //colunas
                        for(; i < lim; i++){
                            table.addCell("B" + (i+1));
                        }
                        //linhas
                        for(ArrayList<Integer> aux: c.getMatriz()){
                            for(i = aux_nr; i < lim; i++){
                                table.addCell("" + aux.get(i));
                            }
                        }
                        //adicionar probabilidades
                        for(i = aux_nr; i < lim; i++){
                            table.addCell("" + c.getProb().get(i));
                        }
                        //adicionar tabela
                        CatPart.add(table);
                        CatPart.newPage();
                    }
                }
            }
        }
        if(resto>0){ //Se ainda sobrar colunas mas que não chegam a 7 colunas
            int aux_nr = i;
            PdfPTable table = new PdfPTable(resto);
            //colunas
            for(; i < (colunas-2); i++){
                table.addCell("B" + (i+1));
            }
            table.addCell("Erro");
            //linhas
            int linh = 0;
            for(ArrayList<Integer> aux: c.getMatriz()){
                for(i = aux_nr; i < (colunas-2); i++){
                    table.addCell("" + aux.get(i));
                }
                //adicionar erro
                table.addCell("" + c.getRes().get(linh));
                linh++;
            }
            //adicionar probabilidades
            for(i = aux_nr; i < (colunas-2); i++){
                table.addCell("" + c.getProb().get(i));
            }
            table.addCell("");
            //adicionar tabela
            CatPart.add(table);
            /*PdfPTable table = new PdfPTable(resto);
            int lim = res.size(), aux_nr = i;
            for(int z = 0; z < resto-1; z++){
                table.addCell("B" + (i+1));
                //linhas
                for(ArrayList<Integer> aux: matriz){ 
                    for(i = aux_nr; i < (colunas-2); i++){
                        table.addCell("" + aux.get(i));
                    }
                }
                //adicionar probabilidades
                for(i = aux_nr; i < (colunas-2); i++){
                    table.addCell("" + prob.get(i));
                }
            }
            //Última coluna de erros
            table.addCell("Erro");
            i = 0;
            while(i<lim){
                table.addCell("" + res.get(i));
                i++;
            }
            CatPart.add(table);*/
        }
    }
    
    private void relatorio(Chapter catPart) throws DocumentException {
       ArrayList<Bc> bc = dadosEntrda.bRanking();
       ArrayList<Integer> nubc = dadosEntrda.blocosNutilizados();
       StringBuilder s = new StringBuilder();
       Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 12);
       
       
        Iterator it1 = nubc.iterator();
        catPart.add(new Paragraph("", catFont));
        s.append("Blocos de código não utilizados: ");
        while (it1.hasNext())
        {
            s.append(it1.next());
            if(it1.hasNext()){
                s.append(", ");
            }
        }
        s.append(".");
        catPart.add(new Paragraph(s.toString(), catFont));
        it1 = bc.iterator();
        while (it1.hasNext())
        {
             catPart.add(new Paragraph(it1.next().toString(), catFont));
        }
        
    }
     private void relatoriofalhas(Chapter catPartt) throws DocumentException {
       StringBuilder s = new StringBuilder();
       Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 12);
       ArrayList<Integer> semFeito = this.dadosEntrda.testCoverage();
        Iterator it1 = semFeito.iterator();
        if (!it1.hasNext()){
        catPartt.add(new Paragraph("Todos os teste demonstram anomalias face ao comportamento normal.\n", catFont));
        }
        else{
             s.append("Teste que não sofreram alterações com a injeção de falhas: ");
             while (it1.hasNext()){
                s.append(it1.next());
                if(it1.hasNext()){
                    s.append(", ");
                }
            }
            catPartt.add(new Paragraph(s.toString(), catFont));
        }
    }
    
    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
          paragraph.add(new Paragraph(" "));
        }
    }
    
}

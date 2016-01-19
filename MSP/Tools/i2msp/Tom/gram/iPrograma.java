
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PedroJosé
 */
public interface iPrograma {
    public int totLinhas();
    public HashMap<String, Funcao> getFuncs();
    public ArrayList<String> getArrayFuncs();
    public Funcao getFuncao(String nome);
    public String toString();
    
}

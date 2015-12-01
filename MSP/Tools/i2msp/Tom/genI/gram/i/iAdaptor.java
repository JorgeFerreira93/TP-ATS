
package gram.i;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.Tree;


public class iAdaptor {
  public static shared.SharedObject getTerm(Tree tree) {
    shared.SharedObject res = null;
    if (tree.isNil()) {
      throw new RuntimeException("nil term");
    }
    if (tree.getType()==Token.INVALID_TOKEN_TYPE) {
      throw new RuntimeException("bad type");
    }

    switch (tree.getType()) {
      case 43:
        {

          if (tree.getChildCount()!=1) {
            throw new RuntimeException("Node " + tree + ": 1 child(s) expected, but " + tree.getChildCount() + " found");
          }
          String field0 = tree.getChild(0).getText();
          res = gram.i.types.expressao.Char.make(field0);
          break;
        }
      case 48:
        {

          if (tree.getChildCount()!=7) {
            throw new RuntimeException("Node " + tree + ": 7 child(s) expected, but " + tree.getChildCount() + " found");
          }
          gram.i.types.LComentarios field0 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(0));
          String field1 = tree.getChild(1).getText();
          gram.i.types.LComentarios field2 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(2));
          gram.i.types.LComentarios field3 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(3));
          gram.i.types.Parametros field4 = (gram.i.types.Parametros)iAdaptor.getTerm(tree.getChild(4));
          gram.i.types.LComentarios field5 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(5));
          gram.i.types.LComentarios field6 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(6));
          res = gram.i.types.expressao.Call.make(field0, field1, field2, field3, field4, field5, field6);
          break;
        }
      case 62:
        {
          res = gram.i.types.lcomentarios.EmptyComentarios.make();
          for(int i = 0; i < tree.getChildCount(); i++) {
            gram.i.types.LComentarios elem = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(i));
            gram.i.types.lcomentarios.Comentarios list = (gram.i.types.lcomentarios.Comentarios) res;
            res = list.append(elem);
          }
          break;
        }
      case 40:
        {

          if (tree.getChildCount()!=1) {
            throw new RuntimeException("Node " + tree + ": 1 child(s) expected, but " + tree.getChildCount() + " found");
          }
          int field0 = Integer.parseInt(tree.getChild(0).getText());
          res = gram.i.types.expressao.Float.make(field0);
          break;
        }
      case 61:
        {

          if (tree.getChildCount()!=1) {
            throw new RuntimeException("Node " + tree + ": 1 child(s) expected, but " + tree.getChildCount() + " found");
          }
          String field0 = tree.getChild(0).getText();
          res = gram.i.types.lcomentarios.Comentario.make(field0);
          break;
        }
      case 20:
        {

          if (tree.getChildCount()!=5) {
            throw new RuntimeException("Node " + tree + ": 5 child(s) expected, but " + tree.getChildCount() + " found");
          }
          String field0 = tree.getChild(0).getText();
          gram.i.types.LComentarios field1 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(1));
          gram.i.types.LComentarios field2 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(2));
          gram.i.types.Expressao field3 = (gram.i.types.Expressao)iAdaptor.getTerm(tree.getChild(3));
          gram.i.types.LComentarios field4 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(4));
          res = gram.i.types.declaracoes.Decl.make(field0, field1, field2, field3, field4);
          break;
        }
      case 67:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = gram.i.types.opnum.Mais.make();
          break;
        }
      case 47:
        {

          if (tree.getChildCount()!=2) {
            throw new RuntimeException("Node " + tree + ": 2 child(s) expected, but " + tree.getChildCount() + " found");
          }
          gram.i.types.OpInc field0 = (gram.i.types.OpInc)iAdaptor.getTerm(tree.getChild(0));
          String field1 = tree.getChild(1).getText();
          res = gram.i.types.expressao.IncAntes.make(field0, field1);
          break;
        }
      case 52:
        {

          if (tree.getChildCount()!=1) {
            throw new RuntimeException("Node " + tree + ": 1 child(s) expected, but " + tree.getChildCount() + " found");
          }
          String field0 = tree.getChild(0).getText();
          res = gram.i.types.expressao.Id.make(field0);
          break;
        }
      case 64:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = gram.i.types.opnum.Menos.make();
          break;
        }
      case 63:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = gram.i.types.opnum.Mod.make();
          break;
        }
      case 22:
        {

          if (tree.getChildCount()!=5) {
            throw new RuntimeException("Node " + tree + ": 5 child(s) expected, but " + tree.getChildCount() + " found");
          }
          gram.i.types.LComentarios field0 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(0));
          gram.i.types.DefTipo field1 = (gram.i.types.DefTipo)iAdaptor.getTerm(tree.getChild(1));
          gram.i.types.LComentarios field2 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(2));
          String field3 = tree.getChild(3).getText();
          gram.i.types.LComentarios field4 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(4));
          res = gram.i.types.argumentos.Argumento.make(field0, field1, field2, field3, field4);
          break;
        }
      case 46:
        {

          if (tree.getChildCount()!=2) {
            throw new RuntimeException("Node " + tree + ": 2 child(s) expected, but " + tree.getChildCount() + " found");
          }
          gram.i.types.OpInc field0 = (gram.i.types.OpInc)iAdaptor.getTerm(tree.getChild(0));
          String field1 = tree.getChild(1).getText();
          res = gram.i.types.expressao.IncDepois.make(field0, field1);
          break;
        }
      case 19:
        {

          if (tree.getChildCount()!=7) {
            throw new RuntimeException("Node " + tree + ": 7 child(s) expected, but " + tree.getChildCount() + " found");
          }
          gram.i.types.LComentarios field0 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(0));
          String field1 = tree.getChild(1).getText();
          gram.i.types.LComentarios field2 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(2));
          gram.i.types.OpAtribuicao field3 = (gram.i.types.OpAtribuicao)iAdaptor.getTerm(tree.getChild(3));
          gram.i.types.LComentarios field4 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(4));
          gram.i.types.Expressao field5 = (gram.i.types.Expressao)iAdaptor.getTerm(tree.getChild(5));
          gram.i.types.LComentarios field6 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(6));
          res = gram.i.types.instrucao.Atribuicao.make(field0, field1, field2, field3, field4, field5, field6);
          break;
        }
      case 21:
        {
          res = gram.i.types.declaracoes.EmptyListaDecl.make();
          for(int i = 0; i < tree.getChildCount(); i++) {
            gram.i.types.Declaracoes elem = (gram.i.types.Declaracoes)iAdaptor.getTerm(tree.getChild(i));
            gram.i.types.declaracoes.ListaDecl list = (gram.i.types.declaracoes.ListaDecl) res;
            res = list.append(elem);
          }
          break;
        }
      case 29:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = gram.i.types.opatribuicao.Soma.make();
          break;
        }
      case 72:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = gram.i.types.deftipo.DInt.make();
          break;
        }
      case 70:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = gram.i.types.deftipo.DBoolean.make();
          break;
        }
      case 36:
        {

          if (tree.getChildCount()!=6) {
            throw new RuntimeException("Node " + tree + ": 6 child(s) expected, but " + tree.getChildCount() + " found");
          }
          gram.i.types.LComentarios field0 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(0));
          gram.i.types.LComentarios field1 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(1));
          gram.i.types.LComentarios field2 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(2));
          gram.i.types.DefTipo field3 = (gram.i.types.DefTipo)iAdaptor.getTerm(tree.getChild(3));
          gram.i.types.LComentarios field4 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(4));
          gram.i.types.LComentarios field5 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(5));
          res = gram.i.types.expressao.Input.make(field0, field1, field2, field3, field4, field5);
          break;
        }
      case 24:
        {

          if (tree.getChildCount()!=3) {
            throw new RuntimeException("Node " + tree + ": 3 child(s) expected, but " + tree.getChildCount() + " found");
          }
          gram.i.types.LComentarios field0 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(0));
          gram.i.types.Expressao field1 = (gram.i.types.Expressao)iAdaptor.getTerm(tree.getChild(1));
          gram.i.types.LComentarios field2 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(2));
          res = gram.i.types.parametros.Parametro.make(field0, field1, field2);
          break;
        }
      case 37:
        {

          if (tree.getChildCount()!=5) {
            throw new RuntimeException("Node " + tree + ": 5 child(s) expected, but " + tree.getChildCount() + " found");
          }
          gram.i.types.Expressao field0 = (gram.i.types.Expressao)iAdaptor.getTerm(tree.getChild(0));
          gram.i.types.LComentarios field1 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(1));
          gram.i.types.OpComp field2 = (gram.i.types.OpComp)iAdaptor.getTerm(tree.getChild(2));
          gram.i.types.LComentarios field3 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(3));
          gram.i.types.Expressao field4 = (gram.i.types.Expressao)iAdaptor.getTerm(tree.getChild(4));
          res = gram.i.types.expressao.Comp.make(field0, field1, field2, field3, field4);
          break;
        }
      case 17:
        {

          if (tree.getChildCount()!=8) {
            throw new RuntimeException("Node " + tree + ": 8 child(s) expected, but " + tree.getChildCount() + " found");
          }
          gram.i.types.LComentarios field0 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(0));
          gram.i.types.LComentarios field1 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(1));
          gram.i.types.LComentarios field2 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(2));
          gram.i.types.Expressao field3 = (gram.i.types.Expressao)iAdaptor.getTerm(tree.getChild(3));
          gram.i.types.LComentarios field4 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(4));
          gram.i.types.LComentarios field5 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(5));
          gram.i.types.Instrucao field6 = (gram.i.types.Instrucao)iAdaptor.getTerm(tree.getChild(6));
          gram.i.types.Instrucao field7 = (gram.i.types.Instrucao)iAdaptor.getTerm(tree.getChild(7));
          res = gram.i.types.instrucao.If.make(field0, field1, field2, field3, field4, field5, field6, field7);
          break;
        }
      case 68:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = gram.i.types.deftipo.DVoid.make();
          break;
        }
      case 59:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = gram.i.types.opcomp.Maior.make();
          break;
        }
      case 32:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = gram.i.types.opatribuicao.Atrib.make();
          break;
        }
      case 51:
        {

          if (tree.getChildCount()!=1) {
            throw new RuntimeException("Node " + tree + ": 1 child(s) expected, but " + tree.getChildCount() + " found");
          }
          gram.i.types.Expressao field0 = (gram.i.types.Expressao)iAdaptor.getTerm(tree.getChild(0));
          res = gram.i.types.expressao.Pos.make(field0);
          break;
        }
      case 49:
        {

          if (tree.getChildCount()!=1) {
            throw new RuntimeException("Node " + tree + ": 1 child(s) expected, but " + tree.getChildCount() + " found");
          }
          gram.i.types.Expressao field0 = (gram.i.types.Expressao)iAdaptor.getTerm(tree.getChild(0));
          res = gram.i.types.expressao.Nao.make(field0);
          break;
        }
      case 69:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = gram.i.types.deftipo.DFloat.make();
          break;
        }
      case 35:
        {

          if (tree.getChildCount()!=6) {
            throw new RuntimeException("Node " + tree + ": 6 child(s) expected, but " + tree.getChildCount() + " found");
          }
          gram.i.types.LComentarios field0 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(0));
          gram.i.types.LComentarios field1 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(1));
          gram.i.types.LComentarios field2 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(2));
          gram.i.types.Expressao field3 = (gram.i.types.Expressao)iAdaptor.getTerm(tree.getChild(3));
          gram.i.types.LComentarios field4 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(4));
          gram.i.types.LComentarios field5 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(5));
          res = gram.i.types.expressao.Print.make(field0, field1, field2, field3, field4, field5);
          break;
        }
      case 41:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = gram.i.types.expressao.False.make();
          break;
        }
      case 30:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = gram.i.types.opatribuicao.Div.make();
          break;
        }
      case 18:
        {

          if (tree.getChildCount()!=6) {
            throw new RuntimeException("Node " + tree + ": 6 child(s) expected, but " + tree.getChildCount() + " found");
          }
          gram.i.types.LComentarios field0 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(0));
          gram.i.types.DefTipo field1 = (gram.i.types.DefTipo)iAdaptor.getTerm(tree.getChild(1));
          gram.i.types.LComentarios field2 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(2));
          gram.i.types.Declaracoes field3 = (gram.i.types.Declaracoes)iAdaptor.getTerm(tree.getChild(3));
          gram.i.types.LComentarios field4 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(4));
          gram.i.types.LComentarios field5 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(5));
          res = gram.i.types.instrucao.Declaracao.make(field0, field1, field2, field3, field4, field5);
          break;
        }
      case 38:
        {

          if (tree.getChildCount()!=4) {
            throw new RuntimeException("Node " + tree + ": 4 child(s) expected, but " + tree.getChildCount() + " found");
          }
          gram.i.types.Expressao field0 = (gram.i.types.Expressao)iAdaptor.getTerm(tree.getChild(0));
          gram.i.types.LComentarios field1 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(1));
          gram.i.types.LComentarios field2 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(2));
          gram.i.types.Expressao field3 = (gram.i.types.Expressao)iAdaptor.getTerm(tree.getChild(3));
          res = gram.i.types.expressao.E.make(field0, field1, field2, field3);
          break;
        }
      case 50:
        {

          if (tree.getChildCount()!=1) {
            throw new RuntimeException("Node " + tree + ": 1 child(s) expected, but " + tree.getChildCount() + " found");
          }
          gram.i.types.Expressao field0 = (gram.i.types.Expressao)iAdaptor.getTerm(tree.getChild(0));
          res = gram.i.types.expressao.Neg.make(field0);
          break;
        }
      case 66:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = gram.i.types.opnum.Vezes.make();
          break;
        }
      case 44:
        {

          if (tree.getChildCount()!=1) {
            throw new RuntimeException("Node " + tree + ": 1 child(s) expected, but " + tree.getChildCount() + " found");
          }
          int field0 = Integer.parseInt(tree.getChild(0).getText());
          res = gram.i.types.expressao.Int.make(field0);
          break;
        }
      case 54:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = gram.i.types.opcomp.Igual.make();
          break;
        }
      case 33:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = gram.i.types.expressao.Empty.make();
          break;
        }
      case 58:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = gram.i.types.opcomp.Menor.make();
          break;
        }
      case 56:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = gram.i.types.opcomp.MenorQ.make();
          break;
        }
      case 55:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = gram.i.types.opcomp.Dif.make();
          break;
        }
      case 71:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = gram.i.types.deftipo.DChar.make();
          break;
        }
      case 45:
        {

          if (tree.getChildCount()!=7) {
            throw new RuntimeException("Node " + tree + ": 7 child(s) expected, but " + tree.getChildCount() + " found");
          }
          gram.i.types.Expressao field0 = (gram.i.types.Expressao)iAdaptor.getTerm(tree.getChild(0));
          gram.i.types.LComentarios field1 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(1));
          gram.i.types.LComentarios field2 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(2));
          gram.i.types.Expressao field3 = (gram.i.types.Expressao)iAdaptor.getTerm(tree.getChild(3));
          gram.i.types.LComentarios field4 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(4));
          gram.i.types.LComentarios field5 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(5));
          gram.i.types.Expressao field6 = (gram.i.types.Expressao)iAdaptor.getTerm(tree.getChild(6));
          res = gram.i.types.expressao.Condicional.make(field0, field1, field2, field3, field4, field5, field6);
          break;
        }
      case 25:
        {
          res = gram.i.types.parametros.EmptyListaParametros.make();
          for(int i = 0; i < tree.getChildCount(); i++) {
            gram.i.types.Parametros elem = (gram.i.types.Parametros)iAdaptor.getTerm(tree.getChild(i));
            gram.i.types.parametros.ListaParametros list = (gram.i.types.parametros.ListaParametros) res;
            res = list.append(elem);
          }
          break;
        }
      case 34:
        {
          res = gram.i.types.expressao.EmptyExpressoes.make();
          for(int i = 0; i < tree.getChildCount(); i++) {
            gram.i.types.Expressao elem = (gram.i.types.Expressao)iAdaptor.getTerm(tree.getChild(i));
            gram.i.types.expressao.Expressoes list = (gram.i.types.expressao.Expressoes) res;
            res = list.append(elem);
          }
          break;
        }
      case 31:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = gram.i.types.opatribuicao.Mult.make();
          break;
        }
      case 53:
        {

          if (tree.getChildCount()!=5) {
            throw new RuntimeException("Node " + tree + ": 5 child(s) expected, but " + tree.getChildCount() + " found");
          }
          gram.i.types.Expressao field0 = (gram.i.types.Expressao)iAdaptor.getTerm(tree.getChild(0));
          gram.i.types.LComentarios field1 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(1));
          gram.i.types.OpNum field2 = (gram.i.types.OpNum)iAdaptor.getTerm(tree.getChild(2));
          gram.i.types.LComentarios field3 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(3));
          gram.i.types.Expressao field4 = (gram.i.types.Expressao)iAdaptor.getTerm(tree.getChild(4));
          res = gram.i.types.expressao.ExpNum.make(field0, field1, field2, field3, field4);
          break;
        }
      case 60:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = gram.i.types.lcomentarios.Vazio.make();
          break;
        }
      case 26:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = gram.i.types.opinc.Dec.make();
          break;
        }
      case 11:
        {
          res = gram.i.types.instrucao.EmptySeqInstrucao.make();
          for(int i = 0; i < tree.getChildCount(); i++) {
            gram.i.types.Instrucao elem = (gram.i.types.Instrucao)iAdaptor.getTerm(tree.getChild(i));
            gram.i.types.instrucao.SeqInstrucao list = (gram.i.types.instrucao.SeqInstrucao) res;
            res = list.append(elem);
          }
          break;
        }
      case 42:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = gram.i.types.expressao.True.make();
          break;
        }
      case 10:
        {

          if (tree.getChildCount()!=1) {
            throw new RuntimeException("Node " + tree + ": 1 child(s) expected, but " + tree.getChildCount() + " found");
          }
          int field0 = Integer.parseInt(tree.getChild(0).getText());
          res = gram.i.types.intwrapper.IntWrap.make(field0);
          break;
        }
      case 15:
        {

          if (tree.getChildCount()!=12) {
            throw new RuntimeException("Node " + tree + ": 12 child(s) expected, but " + tree.getChildCount() + " found");
          }
          gram.i.types.LComentarios field0 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(0));
          gram.i.types.LComentarios field1 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(1));
          gram.i.types.Instrucao field2 = (gram.i.types.Instrucao)iAdaptor.getTerm(tree.getChild(2));
          gram.i.types.LComentarios field3 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(3));
          gram.i.types.Expressao field4 = (gram.i.types.Expressao)iAdaptor.getTerm(tree.getChild(4));
          gram.i.types.LComentarios field5 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(5));
          gram.i.types.LComentarios field6 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(6));
          gram.i.types.Expressao field7 = (gram.i.types.Expressao)iAdaptor.getTerm(tree.getChild(7));
          gram.i.types.LComentarios field8 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(8));
          gram.i.types.LComentarios field9 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(9));
          gram.i.types.Instrucao field10 = (gram.i.types.Instrucao)iAdaptor.getTerm(tree.getChild(10));
          gram.i.types.LComentarios field11 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(11));
          res = gram.i.types.instrucao.For.make(field0, field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11);
          break;
        }
      case 27:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = gram.i.types.opinc.Inc.make();
          break;
        }
      case 13:
        {

          if (tree.getChildCount()!=11) {
            throw new RuntimeException("Node " + tree + ": 11 child(s) expected, but " + tree.getChildCount() + " found");
          }
          gram.i.types.LComentarios field0 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(0));
          gram.i.types.DefTipo field1 = (gram.i.types.DefTipo)iAdaptor.getTerm(tree.getChild(1));
          gram.i.types.LComentarios field2 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(2));
          String field3 = tree.getChild(3).getText();
          gram.i.types.LComentarios field4 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(4));
          gram.i.types.LComentarios field5 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(5));
          gram.i.types.Argumentos field6 = (gram.i.types.Argumentos)iAdaptor.getTerm(tree.getChild(6));
          gram.i.types.LComentarios field7 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(7));
          gram.i.types.LComentarios field8 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(8));
          gram.i.types.Instrucao field9 = (gram.i.types.Instrucao)iAdaptor.getTerm(tree.getChild(9));
          gram.i.types.LComentarios field10 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(10));
          res = gram.i.types.instrucao.Funcao.make(field0, field1, field2, field3, field4, field5, field6, field7, field8, field9, field10);
          break;
        }
      case 28:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = gram.i.types.opatribuicao.Sub.make();
          break;
        }
      case 39:
        {

          if (tree.getChildCount()!=4) {
            throw new RuntimeException("Node " + tree + ": 4 child(s) expected, but " + tree.getChildCount() + " found");
          }
          gram.i.types.Expressao field0 = (gram.i.types.Expressao)iAdaptor.getTerm(tree.getChild(0));
          gram.i.types.LComentarios field1 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(1));
          gram.i.types.LComentarios field2 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(2));
          gram.i.types.Expressao field3 = (gram.i.types.Expressao)iAdaptor.getTerm(tree.getChild(3));
          res = gram.i.types.expressao.Ou.make(field0, field1, field2, field3);
          break;
        }
      case 65:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = gram.i.types.opnum.Divide.make();
          break;
        }
      case 16:
        {

          if (tree.getChildCount()!=8) {
            throw new RuntimeException("Node " + tree + ": 8 child(s) expected, but " + tree.getChildCount() + " found");
          }
          gram.i.types.LComentarios field0 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(0));
          gram.i.types.LComentarios field1 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(1));
          gram.i.types.LComentarios field2 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(2));
          gram.i.types.Expressao field3 = (gram.i.types.Expressao)iAdaptor.getTerm(tree.getChild(3));
          gram.i.types.LComentarios field4 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(4));
          gram.i.types.LComentarios field5 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(5));
          gram.i.types.Instrucao field6 = (gram.i.types.Instrucao)iAdaptor.getTerm(tree.getChild(6));
          gram.i.types.LComentarios field7 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(7));
          res = gram.i.types.instrucao.While.make(field0, field1, field2, field3, field4, field5, field6, field7);
          break;
        }
      case 23:
        {
          res = gram.i.types.argumentos.EmptyListaArgumentos.make();
          for(int i = 0; i < tree.getChildCount(); i++) {
            gram.i.types.Argumentos elem = (gram.i.types.Argumentos)iAdaptor.getTerm(tree.getChild(i));
            gram.i.types.argumentos.ListaArgumentos list = (gram.i.types.argumentos.ListaArgumentos) res;
            res = list.append(elem);
          }
          break;
        }
      case 12:
        {

          if (tree.getChildCount()!=1) {
            throw new RuntimeException("Node " + tree + ": 1 child(s) expected, but " + tree.getChildCount() + " found");
          }
          gram.i.types.Expressao field0 = (gram.i.types.Expressao)iAdaptor.getTerm(tree.getChild(0));
          res = gram.i.types.instrucao.Exp.make(field0);
          break;
        }
      case 14:
        {

          if (tree.getChildCount()!=4) {
            throw new RuntimeException("Node " + tree + ": 4 child(s) expected, but " + tree.getChildCount() + " found");
          }
          gram.i.types.LComentarios field0 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(0));
          gram.i.types.LComentarios field1 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(1));
          gram.i.types.Expressao field2 = (gram.i.types.Expressao)iAdaptor.getTerm(tree.getChild(2));
          gram.i.types.LComentarios field3 = (gram.i.types.LComentarios)iAdaptor.getTerm(tree.getChild(3));
          res = gram.i.types.instrucao.Return.make(field0, field1, field2, field3);
          break;
        }
      case 57:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = gram.i.types.opcomp.MaiorQ.make();
          break;
        }

    }
    return res;
  }
}


package maqv.msp;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.Tree;


public class mspAdaptor {
  public static shared.SharedObject getTerm(Tree tree) {
    shared.SharedObject res = null;
    if (tree.isNil()) {
      throw new RuntimeException("nil term");
    }
    if (tree.getType()==Token.INVALID_TOKEN_TYPE) {
      throw new RuntimeException("bad type");
    }

    switch (tree.getType()) {
      case 10:
        {
          res = maqv.msp.types.instrucoes.EmptyInstrucoes.make();
          for(int i = 0; i < tree.getChildCount(); i++) {
            maqv.msp.types.Instrucao elem = (maqv.msp.types.Instrucao)mspAdaptor.getTerm(tree.getChild(i));
            maqv.msp.types.instrucoes.Instrucoes list = (maqv.msp.types.instrucoes.Instrucoes) res;
            res = list.append(elem);
          }
          break;
        }
      case 19:
        {

          if (tree.getChildCount()!=1) {
            throw new RuntimeException("Node " + tree + ": 1 child(s) expected, but " + tree.getChildCount() + " found");
          }
          maqv.msp.types.DefTipo field0 = (maqv.msp.types.DefTipo)mspAdaptor.getTerm(tree.getChild(0));
          res = maqv.msp.types.instrucao.IIn.make(field0);
          break;
        }
      case 17:
        {

          if (tree.getChildCount()!=1) {
            throw new RuntimeException("Node " + tree + ": 1 child(s) expected, but " + tree.getChildCount() + " found");
          }
          String field0 = tree.getChild(0).getText();
          res = maqv.msp.types.instrucao.Jump.make(field0);
          break;
        }
      case 45:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = maqv.msp.types.deftipo.DInt.make();
          break;
        }
      case 27:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = maqv.msp.types.instrucao.Gt.make();
          break;
        }
      case 22:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = maqv.msp.types.instrucao.Or.make();
          break;
        }
      case 49:
        {

          if (tree.getChildCount()!=1) {
            throw new RuntimeException("Node " + tree + ": 1 child(s) expected, but " + tree.getChildCount() + " found");
          }
          String field0 = tree.getChild(0).getText();
          res = maqv.msp.types.termo.S.make(field0);
          break;
        }
      case 44:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = maqv.msp.types.deftipo.DChar.make();
          break;
        }
      case 42:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = maqv.msp.types.deftipo.DFloat.make();
          break;
        }
      case 40:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = maqv.msp.types.boool.False.make();
          break;
        }
      case 13:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = maqv.msp.types.instrucao.Load.make();
          break;
        }
      case 50:
        {

          if (tree.getChildCount()!=1) {
            throw new RuntimeException("Node " + tree + ": 1 child(s) expected, but " + tree.getChildCount() + " found");
          }
          int field0 = Integer.parseInt(tree.getChild(0).getText());
          res = maqv.msp.types.termo.I.make(field0);
          break;
        }
      case 16:
        {

          if (tree.getChildCount()!=1) {
            throw new RuntimeException("Node " + tree + ": 1 child(s) expected, but " + tree.getChildCount() + " found");
          }
          String field0 = tree.getChild(0).getText();
          res = maqv.msp.types.instrucao.Jumpf.make(field0);
          break;
        }
      case 26:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = maqv.msp.types.instrucao.GoEq.make();
          break;
        }
      case 33:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = maqv.msp.types.instrucao.Mul.make();
          break;
        }
      case 51:
        {
          res = maqv.msp.types.stackk.EmptyStackk.make();
          for(int i = 0; i < tree.getChildCount(); i++) {
            maqv.msp.types.Termo elem = (maqv.msp.types.Termo)mspAdaptor.getTerm(tree.getChild(i));
            maqv.msp.types.stackk.Stackk list = (maqv.msp.types.stackk.Stackk) res;
            res = list.append(elem);
          }
          break;
        }
      case 41:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = maqv.msp.types.boool.True.make();
          break;
        }
      case 43:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = maqv.msp.types.deftipo.DBoolean.make();
          break;
        }
      case 36:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = maqv.msp.types.instrucao.Add.make();
          break;
        }
      case 24:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = maqv.msp.types.instrucao.LoEq.make();
          break;
        }
      case 29:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = maqv.msp.types.instrucao.Eq.make();
          break;
        }
      case 25:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = maqv.msp.types.instrucao.Lt.make();
          break;
        }
      case 15:
        {

          if (tree.getChildCount()!=1) {
            throw new RuntimeException("Node " + tree + ": 1 child(s) expected, but " + tree.getChildCount() + " found");
          }
          maqv.msp.types.Termo field0 = (maqv.msp.types.Termo)mspAdaptor.getTerm(tree.getChild(0));
          res = maqv.msp.types.instrucao.Push.make(field0);
          break;
        }
      case 20:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = maqv.msp.types.instrucao.Halt.make();
          break;
        }
      case 11:
        {

          if (tree.getChildCount()!=3) {
            throw new RuntimeException("Node " + tree + ": 3 child(s) expected, but " + tree.getChildCount() + " found");
          }
          String field0 = tree.getChild(0).getText();
          int field1 = Integer.parseInt(tree.getChild(1).getText());
          int field2 = Integer.parseInt(tree.getChild(2).getText());
          res = maqv.msp.types.instrucao.Decl.make(field0, field1, field2);
          break;
        }
      case 30:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = maqv.msp.types.instrucao.Dec.make();
          break;
        }
      case 21:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = maqv.msp.types.instrucao.And.make();
          break;
        }
      case 12:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = maqv.msp.types.instrucao.Store.make();
          break;
        }
      case 37:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = maqv.msp.types.instrucao.Ret.make();
          break;
        }
      case 34:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = maqv.msp.types.instrucao.Div.make();
          break;
        }
      case 48:
        {

          if (tree.getChildCount()!=1) {
            throw new RuntimeException("Node " + tree + ": 1 child(s) expected, but " + tree.getChildCount() + " found");
          }
          maqv.msp.types.Boool field0 = (maqv.msp.types.Boool)mspAdaptor.getTerm(tree.getChild(0));
          res = maqv.msp.types.termo.B.make(field0);
          break;
        }
      case 14:
        {

          if (tree.getChildCount()!=1) {
            throw new RuntimeException("Node " + tree + ": 1 child(s) expected, but " + tree.getChildCount() + " found");
          }
          maqv.msp.types.Termo field0 = (maqv.msp.types.Termo)mspAdaptor.getTerm(tree.getChild(0));
          res = maqv.msp.types.instrucao.Pusha.make(field0);
          break;
        }
      case 31:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = maqv.msp.types.instrucao.Inc.make();
          break;
        }
      case 38:
        {

          if (tree.getChildCount()!=1) {
            throw new RuntimeException("Node " + tree + ": 1 child(s) expected, but " + tree.getChildCount() + " found");
          }
          String field0 = tree.getChild(0).getText();
          res = maqv.msp.types.instrucao.Call.make(field0);
          break;
        }
      case 32:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = maqv.msp.types.instrucao.Mod.make();
          break;
        }
      case 46:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = maqv.msp.types.termo.Vazio.make();
          break;
        }
      case 28:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = maqv.msp.types.instrucao.Neq.make();
          break;
        }
      case 47:
        {

          if (tree.getChildCount()!=1) {
            throw new RuntimeException("Node " + tree + ": 1 child(s) expected, but " + tree.getChildCount() + " found");
          }
          int field0 = Integer.parseInt(tree.getChild(0).getText());
          res = maqv.msp.types.termo.F.make(field0);
          break;
        }
      case 18:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = maqv.msp.types.instrucao.IOut.make();
          break;
        }
      case 35:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = maqv.msp.types.instrucao.Sub.make();
          break;
        }
      case 23:
        {

          if (tree.getChildCount()!=0) {
            throw new RuntimeException("Node " + tree + ": 0 child(s) expected, but " + tree.getChildCount() + " found");
          }
          res = maqv.msp.types.instrucao.Nott.make();
          break;
        }
      case 39:
        {

          if (tree.getChildCount()!=1) {
            throw new RuntimeException("Node " + tree + ": 1 child(s) expected, but " + tree.getChildCount() + " found");
          }
          String field0 = tree.getChild(0).getText();
          res = maqv.msp.types.instrucao.ALabel.make(field0);
          break;
        }

    }
    return res;
  }
}

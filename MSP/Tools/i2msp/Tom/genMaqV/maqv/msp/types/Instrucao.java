
package maqv.msp.types;


public abstract class Instrucao extends maqv.msp.mspAbstractType  {
  /**
   * Sole constructor.  (For invocation by subclass
   * constructors, typically implicit.)
   */
  protected Instrucao() {}



  /**
   * Returns true if the term is rooted by the symbol ALabel
   *
   * @return true if the term is rooted by the symbol ALabel
   */
  public boolean isALabel() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Call
   *
   * @return true if the term is rooted by the symbol Call
   */
  public boolean isCall() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Ret
   *
   * @return true if the term is rooted by the symbol Ret
   */
  public boolean isRet() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Add
   *
   * @return true if the term is rooted by the symbol Add
   */
  public boolean isAdd() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Sub
   *
   * @return true if the term is rooted by the symbol Sub
   */
  public boolean isSub() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Div
   *
   * @return true if the term is rooted by the symbol Div
   */
  public boolean isDiv() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Mul
   *
   * @return true if the term is rooted by the symbol Mul
   */
  public boolean isMul() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Mod
   *
   * @return true if the term is rooted by the symbol Mod
   */
  public boolean isMod() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Inc
   *
   * @return true if the term is rooted by the symbol Inc
   */
  public boolean isInc() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Dec
   *
   * @return true if the term is rooted by the symbol Dec
   */
  public boolean isDec() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Eq
   *
   * @return true if the term is rooted by the symbol Eq
   */
  public boolean isEq() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Neq
   *
   * @return true if the term is rooted by the symbol Neq
   */
  public boolean isNeq() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Gt
   *
   * @return true if the term is rooted by the symbol Gt
   */
  public boolean isGt() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol GoEq
   *
   * @return true if the term is rooted by the symbol GoEq
   */
  public boolean isGoEq() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Lt
   *
   * @return true if the term is rooted by the symbol Lt
   */
  public boolean isLt() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol LoEq
   *
   * @return true if the term is rooted by the symbol LoEq
   */
  public boolean isLoEq() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Nott
   *
   * @return true if the term is rooted by the symbol Nott
   */
  public boolean isNott() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Or
   *
   * @return true if the term is rooted by the symbol Or
   */
  public boolean isOr() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol And
   *
   * @return true if the term is rooted by the symbol And
   */
  public boolean isAnd() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Halt
   *
   * @return true if the term is rooted by the symbol Halt
   */
  public boolean isHalt() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol IIn
   *
   * @return true if the term is rooted by the symbol IIn
   */
  public boolean isIIn() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol IOut
   *
   * @return true if the term is rooted by the symbol IOut
   */
  public boolean isIOut() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Jump
   *
   * @return true if the term is rooted by the symbol Jump
   */
  public boolean isJump() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Jumpf
   *
   * @return true if the term is rooted by the symbol Jumpf
   */
  public boolean isJumpf() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Push
   *
   * @return true if the term is rooted by the symbol Push
   */
  public boolean isPush() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Pusha
   *
   * @return true if the term is rooted by the symbol Pusha
   */
  public boolean isPusha() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Load
   *
   * @return true if the term is rooted by the symbol Load
   */
  public boolean isLoad() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Store
   *
   * @return true if the term is rooted by the symbol Store
   */
  public boolean isStore() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Decl
   *
   * @return true if the term is rooted by the symbol Decl
   */
  public boolean isDecl() {
    return false;
  }

  /**
   * Returns the subterm corresponding to the slot size
   *
   * @return the subterm corresponding to the slot size
   */
  public int getsize() {
    throw new UnsupportedOperationException("This Instrucao has no size");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot size
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot size is replaced by _arg
   */
  public Instrucao setsize(int _arg) {
    throw new UnsupportedOperationException("This Instrucao has no size");
  }

  /**
   * Returns the subterm corresponding to the slot t
   *
   * @return the subterm corresponding to the slot t
   */
  public maqv.msp.types.Termo gett() {
    throw new UnsupportedOperationException("This Instrucao has no t");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot t
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot t is replaced by _arg
   */
  public Instrucao sett(maqv.msp.types.Termo _arg) {
    throw new UnsupportedOperationException("This Instrucao has no t");
  }

  /**
   * Returns the subterm corresponding to the slot tipo
   *
   * @return the subterm corresponding to the slot tipo
   */
  public maqv.msp.types.DefTipo gettipo() {
    throw new UnsupportedOperationException("This Instrucao has no tipo");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot tipo
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot tipo is replaced by _arg
   */
  public Instrucao settipo(maqv.msp.types.DefTipo _arg) {
    throw new UnsupportedOperationException("This Instrucao has no tipo");
  }

  /**
   * Returns the subterm corresponding to the slot initMemAddress
   *
   * @return the subterm corresponding to the slot initMemAddress
   */
  public int getinitMemAddress() {
    throw new UnsupportedOperationException("This Instrucao has no initMemAddress");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot initMemAddress
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot initMemAddress is replaced by _arg
   */
  public Instrucao setinitMemAddress(int _arg) {
    throw new UnsupportedOperationException("This Instrucao has no initMemAddress");
  }

  /**
   * Returns the subterm corresponding to the slot id
   *
   * @return the subterm corresponding to the slot id
   */
  public String getid() {
    throw new UnsupportedOperationException("This Instrucao has no id");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot id
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot id is replaced by _arg
   */
  public Instrucao setid(String _arg) {
    throw new UnsupportedOperationException("This Instrucao has no id");
  }

  protected static tom.library.utils.IdConverter idConv = new tom.library.utils.IdConverter();

  /**
   * Returns an ATerm representation of this term.
   *
   * @return null to indicate to sub-classes that they have to work
   */
  public aterm.ATerm toATerm() {
    // returns null to indicate sub-classes that they have to work
    return null;
  }

  /**
   * Returns a maqv.msp.types.Instrucao from an ATerm without any conversion
   *
   * @param trm ATerm to handle to retrieve a Gom term
   * @return the term from the ATerm
   */
  public static maqv.msp.types.Instrucao fromTerm(aterm.ATerm trm) {
    return fromTerm(trm,idConv);
  }

  /**
   * Returns a maqv.msp.types.Instrucao from a String without any conversion
   *
   * @param s String containing the ATerm
   * @return the term from the String
   */
  public static maqv.msp.types.Instrucao fromString(String s) {
    return fromTerm(atermFactory.parse(s),idConv);
  }

  /**
   * Returns a maqv.msp.types.Instrucao from a Stream without any conversion
   *
   * @param stream stream containing the ATerm
   * @return the term from the Stream
   * @throws java.io.IOException if a problem occurs with the stream
   */
  public static maqv.msp.types.Instrucao fromStream(java.io.InputStream stream) throws java.io.IOException {
    return fromTerm(atermFactory.readFromFile(stream),idConv);
  }

  /**
   * Apply a conversion on the ATerm and returns a maqv.msp.types.Instrucao
   *
   * @param trm ATerm to convert into a Gom term
   * @param atConv ATermConverter used to convert the ATerm
   * @return the Gom term
   * @throws IllegalArgumentException
   */
  public static maqv.msp.types.Instrucao fromTerm(aterm.ATerm trm, tom.library.utils.ATermConverter atConv) {
    aterm.ATerm convertedTerm = atConv.convert(trm);
    maqv.msp.types.Instrucao tmp;
    java.util.ArrayList<maqv.msp.types.Instrucao> results = new java.util.ArrayList<maqv.msp.types.Instrucao>();

    tmp = maqv.msp.types.instrucao.ALabel.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = maqv.msp.types.instrucao.Call.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = maqv.msp.types.instrucao.Ret.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = maqv.msp.types.instrucao.Add.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = maqv.msp.types.instrucao.Sub.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = maqv.msp.types.instrucao.Div.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = maqv.msp.types.instrucao.Mul.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = maqv.msp.types.instrucao.Mod.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = maqv.msp.types.instrucao.Inc.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = maqv.msp.types.instrucao.Dec.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = maqv.msp.types.instrucao.Eq.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = maqv.msp.types.instrucao.Neq.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = maqv.msp.types.instrucao.Gt.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = maqv.msp.types.instrucao.GoEq.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = maqv.msp.types.instrucao.Lt.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = maqv.msp.types.instrucao.LoEq.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = maqv.msp.types.instrucao.Nott.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = maqv.msp.types.instrucao.Or.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = maqv.msp.types.instrucao.And.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = maqv.msp.types.instrucao.Halt.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = maqv.msp.types.instrucao.IIn.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = maqv.msp.types.instrucao.IOut.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = maqv.msp.types.instrucao.Jump.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = maqv.msp.types.instrucao.Jumpf.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = maqv.msp.types.instrucao.Push.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = maqv.msp.types.instrucao.Pusha.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = maqv.msp.types.instrucao.Load.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = maqv.msp.types.instrucao.Store.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = maqv.msp.types.instrucao.Decl.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    switch(results.size()) {
      case 0:
        throw new IllegalArgumentException(trm + " is not a Instrucao");
      case 1:
        return results.get(0);
      default:
        java.util.logging.Logger.getLogger("Instrucao").log(java.util.logging.Level.WARNING,"There were many possibilities ({0}) in {1} but the first one was chosen: {2}",new Object[] {results.toString(), "maqv.msp.types.Instrucao", results.get(0).toString()});
        return results.get(0);
    }
  }

  /**
   * Apply a conversion on the ATerm contained in the String and returns a maqv.msp.types.Instrucao from it
   *
   * @param s String containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static maqv.msp.types.Instrucao fromString(String s, tom.library.utils.ATermConverter atConv) {
    return fromTerm(atermFactory.parse(s),atConv);
  }

  /**
   * Apply a conversion on the ATerm contained in the Stream and returns a maqv.msp.types.Instrucao from it
   *
   * @param stream stream containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static maqv.msp.types.Instrucao fromStream(java.io.InputStream stream, tom.library.utils.ATermConverter atConv) throws java.io.IOException {
    return fromTerm(atermFactory.readFromFile(stream),atConv);
  }

  /**
   * Returns the length of the list
   *
   * @return the length of the list
   * @throws IllegalArgumentException if the term is not a list
   */
  public int length() {
    throw new IllegalArgumentException(
      "This "+this.getClass().getName()+" is not a list");
  }

  /**
   * Returns an inverted term
   *
   * @return the inverted list
   * @throws IllegalArgumentException if the term is not a list
   */
  public maqv.msp.types.Instrucao reverse() {
    throw new IllegalArgumentException(
      "This "+this.getClass().getName()+" is not a list");
  }

  
  /*
   * Initialize the (cyclic) data-structure
   * in order to generate/enumerate terms
   */

  protected static tom.library.enumerator.Enumeration<maqv.msp.types.Instrucao> enumInstrucao = null;
  public static final tom.library.enumerator.Enumeration<maqv.msp.types.Instrucao> tmpenumInstrucao = new tom.library.enumerator.Enumeration<maqv.msp.types.Instrucao>((tom.library.enumerator.LazyList<tom.library.enumerator.Finite<maqv.msp.types.Instrucao>>) null);

  public static tom.library.enumerator.Enumeration<maqv.msp.types.Instrucao> getEnumeration() {
    if(enumInstrucao == null) { 
      enumInstrucao = maqv.msp.types.instrucao.ALabel.funMake().apply(tom.library.enumerator.Combinators.makeString())
        .plus(maqv.msp.types.instrucao.Call.funMake().apply(tom.library.enumerator.Combinators.makeString()))
        .plus(maqv.msp.types.instrucao.Ret.funMake().apply(maqv.msp.types.Instrucao.tmpenumInstrucao))
        .plus(maqv.msp.types.instrucao.Add.funMake().apply(maqv.msp.types.Instrucao.tmpenumInstrucao))
        .plus(maqv.msp.types.instrucao.Sub.funMake().apply(maqv.msp.types.Instrucao.tmpenumInstrucao))
        .plus(maqv.msp.types.instrucao.Div.funMake().apply(maqv.msp.types.Instrucao.tmpenumInstrucao))
        .plus(maqv.msp.types.instrucao.Mul.funMake().apply(maqv.msp.types.Instrucao.tmpenumInstrucao))
        .plus(maqv.msp.types.instrucao.Mod.funMake().apply(maqv.msp.types.Instrucao.tmpenumInstrucao))
        .plus(maqv.msp.types.instrucao.Inc.funMake().apply(maqv.msp.types.Instrucao.tmpenumInstrucao))
        .plus(maqv.msp.types.instrucao.Dec.funMake().apply(maqv.msp.types.Instrucao.tmpenumInstrucao))
        .plus(maqv.msp.types.instrucao.Eq.funMake().apply(maqv.msp.types.Instrucao.tmpenumInstrucao))
        .plus(maqv.msp.types.instrucao.Neq.funMake().apply(maqv.msp.types.Instrucao.tmpenumInstrucao))
        .plus(maqv.msp.types.instrucao.Gt.funMake().apply(maqv.msp.types.Instrucao.tmpenumInstrucao))
        .plus(maqv.msp.types.instrucao.GoEq.funMake().apply(maqv.msp.types.Instrucao.tmpenumInstrucao))
        .plus(maqv.msp.types.instrucao.Lt.funMake().apply(maqv.msp.types.Instrucao.tmpenumInstrucao))
        .plus(maqv.msp.types.instrucao.LoEq.funMake().apply(maqv.msp.types.Instrucao.tmpenumInstrucao))
        .plus(maqv.msp.types.instrucao.Nott.funMake().apply(maqv.msp.types.Instrucao.tmpenumInstrucao))
        .plus(maqv.msp.types.instrucao.Or.funMake().apply(maqv.msp.types.Instrucao.tmpenumInstrucao))
        .plus(maqv.msp.types.instrucao.And.funMake().apply(maqv.msp.types.Instrucao.tmpenumInstrucao))
        .plus(maqv.msp.types.instrucao.Halt.funMake().apply(maqv.msp.types.Instrucao.tmpenumInstrucao))
        .plus(maqv.msp.types.instrucao.IIn.funMake().apply(maqv.msp.types.DefTipo.tmpenumDefTipo))
        .plus(maqv.msp.types.instrucao.IOut.funMake().apply(maqv.msp.types.Instrucao.tmpenumInstrucao))
        .plus(maqv.msp.types.instrucao.Jump.funMake().apply(tom.library.enumerator.Combinators.makeString()))
        .plus(maqv.msp.types.instrucao.Jumpf.funMake().apply(tom.library.enumerator.Combinators.makeString()))
        .plus(maqv.msp.types.instrucao.Push.funMake().apply(maqv.msp.types.Termo.tmpenumTermo))
        .plus(maqv.msp.types.instrucao.Pusha.funMake().apply(maqv.msp.types.Termo.tmpenumTermo))
        .plus(maqv.msp.types.instrucao.Load.funMake().apply(maqv.msp.types.Instrucao.tmpenumInstrucao))
        .plus(maqv.msp.types.instrucao.Store.funMake().apply(maqv.msp.types.Instrucao.tmpenumInstrucao))
        .plus(maqv.msp.types.instrucao.Decl.funMake().apply(tom.library.enumerator.Combinators.makeString()).apply(tom.library.enumerator.Combinators.makeint()).apply(tom.library.enumerator.Combinators.makeint()));

      maqv.msp.types.Termo.getEnumeration();
      maqv.msp.types.DefTipo.getEnumeration();

      tmpenumInstrucao.p1 = new tom.library.enumerator.P1<tom.library.enumerator.LazyList<tom.library.enumerator.Finite<maqv.msp.types.Instrucao>>>() {
        public tom.library.enumerator.LazyList<tom.library.enumerator.Finite<maqv.msp.types.Instrucao>> _1() { return enumInstrucao.parts(); }
      };

    }
    return enumInstrucao;
  }

}

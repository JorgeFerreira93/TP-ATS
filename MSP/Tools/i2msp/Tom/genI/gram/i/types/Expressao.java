
package gram.i.types;


public abstract class Expressao extends gram.i.iAbstractType  {
  /**
   * Sole constructor.  (For invocation by subclass
   * constructors, typically implicit.)
   */
  protected Expressao() {}



  /**
   * Returns true if the term is rooted by the symbol ExpNum
   *
   * @return true if the term is rooted by the symbol ExpNum
   */
  public boolean isExpNum() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Id
   *
   * @return true if the term is rooted by the symbol Id
   */
  public boolean isId() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Pos
   *
   * @return true if the term is rooted by the symbol Pos
   */
  public boolean isPos() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Neg
   *
   * @return true if the term is rooted by the symbol Neg
   */
  public boolean isNeg() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Nao
   *
   * @return true if the term is rooted by the symbol Nao
   */
  public boolean isNao() {
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
   * Returns true if the term is rooted by the symbol IncAntes
   *
   * @return true if the term is rooted by the symbol IncAntes
   */
  public boolean isIncAntes() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol IncDepois
   *
   * @return true if the term is rooted by the symbol IncDepois
   */
  public boolean isIncDepois() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Condicional
   *
   * @return true if the term is rooted by the symbol Condicional
   */
  public boolean isCondicional() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Int
   *
   * @return true if the term is rooted by the symbol Int
   */
  public boolean isInt() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Char
   *
   * @return true if the term is rooted by the symbol Char
   */
  public boolean isChar() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol True
   *
   * @return true if the term is rooted by the symbol True
   */
  public boolean isTrue() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol False
   *
   * @return true if the term is rooted by the symbol False
   */
  public boolean isFalse() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Float
   *
   * @return true if the term is rooted by the symbol Float
   */
  public boolean isFloat() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Ou
   *
   * @return true if the term is rooted by the symbol Ou
   */
  public boolean isOu() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol E
   *
   * @return true if the term is rooted by the symbol E
   */
  public boolean isE() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Comp
   *
   * @return true if the term is rooted by the symbol Comp
   */
  public boolean isComp() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Input
   *
   * @return true if the term is rooted by the symbol Input
   */
  public boolean isInput() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Print
   *
   * @return true if the term is rooted by the symbol Print
   */
  public boolean isPrint() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol ConsExpressoes
   *
   * @return true if the term is rooted by the symbol ConsExpressoes
   */
  public boolean isConsExpressoes() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol EmptyExpressoes
   *
   * @return true if the term is rooted by the symbol EmptyExpressoes
   */
  public boolean isEmptyExpressoes() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Empty
   *
   * @return true if the term is rooted by the symbol Empty
   */
  public boolean isEmpty() {
    return false;
  }

  /**
   * Returns the subterm corresponding to the slot Cond2
   *
   * @return the subterm corresponding to the slot Cond2
   */
  public gram.i.types.Expressao getCond2() {
    throw new UnsupportedOperationException("This Expressao has no Cond2");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot Cond2
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot Cond2 is replaced by _arg
   */
  public Expressao setCond2(gram.i.types.Expressao _arg) {
    throw new UnsupportedOperationException("This Expressao has no Cond2");
  }

  /**
   * Returns the subterm corresponding to the slot Cond1
   *
   * @return the subterm corresponding to the slot Cond1
   */
  public gram.i.types.Expressao getCond1() {
    throw new UnsupportedOperationException("This Expressao has no Cond1");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot Cond1
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot Cond1 is replaced by _arg
   */
  public Expressao setCond1(gram.i.types.Expressao _arg) {
    throw new UnsupportedOperationException("This Expressao has no Cond1");
  }

  /**
   * Returns the subterm corresponding to the slot c2
   *
   * @return the subterm corresponding to the slot c2
   */
  public gram.i.types.LComentarios getc2() {
    throw new UnsupportedOperationException("This Expressao has no c2");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot c2
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot c2 is replaced by _arg
   */
  public Expressao setc2(gram.i.types.LComentarios _arg) {
    throw new UnsupportedOperationException("This Expressao has no c2");
  }

  /**
   * Returns the subterm corresponding to the slot c1
   *
   * @return the subterm corresponding to the slot c1
   */
  public gram.i.types.LComentarios getc1() {
    throw new UnsupportedOperationException("This Expressao has no c1");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot c1
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot c1 is replaced by _arg
   */
  public Expressao setc1(gram.i.types.LComentarios _arg) {
    throw new UnsupportedOperationException("This Expressao has no c1");
  }

  /**
   * Returns the subterm corresponding to the slot c3
   *
   * @return the subterm corresponding to the slot c3
   */
  public gram.i.types.LComentarios getc3() {
    throw new UnsupportedOperationException("This Expressao has no c3");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot c3
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot c3 is replaced by _arg
   */
  public Expressao setc3(gram.i.types.LComentarios _arg) {
    throw new UnsupportedOperationException("This Expressao has no c3");
  }

  /**
   * Returns the subterm corresponding to the slot OpComp
   *
   * @return the subterm corresponding to the slot OpComp
   */
  public gram.i.types.OpComp getOpComp() {
    throw new UnsupportedOperationException("This Expressao has no OpComp");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot OpComp
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot OpComp is replaced by _arg
   */
  public Expressao setOpComp(gram.i.types.OpComp _arg) {
    throw new UnsupportedOperationException("This Expressao has no OpComp");
  }

  /**
   * Returns the subterm corresponding to the slot TailExpressoes
   *
   * @return the subterm corresponding to the slot TailExpressoes
   */
  public gram.i.types.Expressao getTailExpressoes() {
    throw new UnsupportedOperationException("This Expressao has no TailExpressoes");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot TailExpressoes
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot TailExpressoes is replaced by _arg
   */
  public Expressao setTailExpressoes(gram.i.types.Expressao _arg) {
    throw new UnsupportedOperationException("This Expressao has no TailExpressoes");
  }

  /**
   * Returns the subterm corresponding to the slot Tipo
   *
   * @return the subterm corresponding to the slot Tipo
   */
  public gram.i.types.DefTipo getTipo() {
    throw new UnsupportedOperationException("This Expressao has no Tipo");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot Tipo
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot Tipo is replaced by _arg
   */
  public Expressao setTipo(gram.i.types.DefTipo _arg) {
    throw new UnsupportedOperationException("This Expressao has no Tipo");
  }

  /**
   * Returns the subterm corresponding to the slot op
   *
   * @return the subterm corresponding to the slot op
   */
  public gram.i.types.OpNum getop() {
    throw new UnsupportedOperationException("This Expressao has no op");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot op
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot op is replaced by _arg
   */
  public Expressao setop(gram.i.types.OpNum _arg) {
    throw new UnsupportedOperationException("This Expressao has no op");
  }

  /**
   * Returns the subterm corresponding to the slot Parametros
   *
   * @return the subterm corresponding to the slot Parametros
   */
  public gram.i.types.Parametros getParametros() {
    throw new UnsupportedOperationException("This Expressao has no Parametros");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot Parametros
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot Parametros is replaced by _arg
   */
  public Expressao setParametros(gram.i.types.Parametros _arg) {
    throw new UnsupportedOperationException("This Expressao has no Parametros");
  }

  /**
   * Returns the subterm corresponding to the slot Condicao
   *
   * @return the subterm corresponding to the slot Condicao
   */
  public gram.i.types.Expressao getCondicao() {
    throw new UnsupportedOperationException("This Expressao has no Condicao");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot Condicao
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot Condicao is replaced by _arg
   */
  public Expressao setCondicao(gram.i.types.Expressao _arg) {
    throw new UnsupportedOperationException("This Expressao has no Condicao");
  }

  /**
   * Returns the subterm corresponding to the slot c5
   *
   * @return the subterm corresponding to the slot c5
   */
  public gram.i.types.LComentarios getc5() {
    throw new UnsupportedOperationException("This Expressao has no c5");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot c5
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot c5 is replaced by _arg
   */
  public Expressao setc5(gram.i.types.LComentarios _arg) {
    throw new UnsupportedOperationException("This Expressao has no c5");
  }

  /**
   * Returns the subterm corresponding to the slot Id
   *
   * @return the subterm corresponding to the slot Id
   */
  public String getId() {
    throw new UnsupportedOperationException("This Expressao has no Id");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot Id
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot Id is replaced by _arg
   */
  public Expressao setId(String _arg) {
    throw new UnsupportedOperationException("This Expressao has no Id");
  }

  /**
   * Returns the subterm corresponding to the slot OpInc
   *
   * @return the subterm corresponding to the slot OpInc
   */
  public gram.i.types.OpInc getOpInc() {
    throw new UnsupportedOperationException("This Expressao has no OpInc");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot OpInc
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot OpInc is replaced by _arg
   */
  public Expressao setOpInc(gram.i.types.OpInc _arg) {
    throw new UnsupportedOperationException("This Expressao has no OpInc");
  }

  /**
   * Returns the subterm corresponding to the slot Char
   *
   * @return the subterm corresponding to the slot Char
   */
  public String getChar() {
    throw new UnsupportedOperationException("This Expressao has no Char");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot Char
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot Char is replaced by _arg
   */
  public Expressao setChar(String _arg) {
    throw new UnsupportedOperationException("This Expressao has no Char");
  }

  /**
   * Returns the subterm corresponding to the slot c4
   *
   * @return the subterm corresponding to the slot c4
   */
  public gram.i.types.LComentarios getc4() {
    throw new UnsupportedOperationException("This Expressao has no c4");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot c4
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot c4 is replaced by _arg
   */
  public Expressao setc4(gram.i.types.LComentarios _arg) {
    throw new UnsupportedOperationException("This Expressao has no c4");
  }

  /**
   * Returns the subterm corresponding to the slot Int
   *
   * @return the subterm corresponding to the slot Int
   */
  public int getInt() {
    throw new UnsupportedOperationException("This Expressao has no Int");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot Int
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot Int is replaced by _arg
   */
  public Expressao setInt(int _arg) {
    throw new UnsupportedOperationException("This Expressao has no Int");
  }

  /**
   * Returns the subterm corresponding to the slot num
   *
   * @return the subterm corresponding to the slot num
   */
  public int getnum() {
    throw new UnsupportedOperationException("This Expressao has no num");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot num
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot num is replaced by _arg
   */
  public Expressao setnum(int _arg) {
    throw new UnsupportedOperationException("This Expressao has no num");
  }

  /**
   * Returns the subterm corresponding to the slot Exp2
   *
   * @return the subterm corresponding to the slot Exp2
   */
  public gram.i.types.Expressao getExp2() {
    throw new UnsupportedOperationException("This Expressao has no Exp2");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot Exp2
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot Exp2 is replaced by _arg
   */
  public Expressao setExp2(gram.i.types.Expressao _arg) {
    throw new UnsupportedOperationException("This Expressao has no Exp2");
  }

  /**
   * Returns the subterm corresponding to the slot Exp1
   *
   * @return the subterm corresponding to the slot Exp1
   */
  public gram.i.types.Expressao getExp1() {
    throw new UnsupportedOperationException("This Expressao has no Exp1");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot Exp1
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot Exp1 is replaced by _arg
   */
  public Expressao setExp1(gram.i.types.Expressao _arg) {
    throw new UnsupportedOperationException("This Expressao has no Exp1");
  }

  /**
   * Returns the subterm corresponding to the slot HeadExpressoes
   *
   * @return the subterm corresponding to the slot HeadExpressoes
   */
  public gram.i.types.Expressao getHeadExpressoes() {
    throw new UnsupportedOperationException("This Expressao has no HeadExpressoes");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot HeadExpressoes
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot HeadExpressoes is replaced by _arg
   */
  public Expressao setHeadExpressoes(gram.i.types.Expressao _arg) {
    throw new UnsupportedOperationException("This Expressao has no HeadExpressoes");
  }

  /**
   * Returns the subterm corresponding to the slot Expressao
   *
   * @return the subterm corresponding to the slot Expressao
   */
  public gram.i.types.Expressao getExpressao() {
    throw new UnsupportedOperationException("This Expressao has no Expressao");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot Expressao
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot Expressao is replaced by _arg
   */
  public Expressao setExpressao(gram.i.types.Expressao _arg) {
    throw new UnsupportedOperationException("This Expressao has no Expressao");
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
   * Returns a gram.i.types.Expressao from an ATerm without any conversion
   *
   * @param trm ATerm to handle to retrieve a Gom term
   * @return the term from the ATerm
   */
  public static gram.i.types.Expressao fromTerm(aterm.ATerm trm) {
    return fromTerm(trm,idConv);
  }

  /**
   * Returns a gram.i.types.Expressao from a String without any conversion
   *
   * @param s String containing the ATerm
   * @return the term from the String
   */
  public static gram.i.types.Expressao fromString(String s) {
    return fromTerm(atermFactory.parse(s),idConv);
  }

  /**
   * Returns a gram.i.types.Expressao from a Stream without any conversion
   *
   * @param stream stream containing the ATerm
   * @return the term from the Stream
   * @throws java.io.IOException if a problem occurs with the stream
   */
  public static gram.i.types.Expressao fromStream(java.io.InputStream stream) throws java.io.IOException {
    return fromTerm(atermFactory.readFromFile(stream),idConv);
  }

  /**
   * Apply a conversion on the ATerm and returns a gram.i.types.Expressao
   *
   * @param trm ATerm to convert into a Gom term
   * @param atConv ATermConverter used to convert the ATerm
   * @return the Gom term
   * @throws IllegalArgumentException
   */
  public static gram.i.types.Expressao fromTerm(aterm.ATerm trm, tom.library.utils.ATermConverter atConv) {
    aterm.ATerm convertedTerm = atConv.convert(trm);
    gram.i.types.Expressao tmp;
    java.util.ArrayList<gram.i.types.Expressao> results = new java.util.ArrayList<gram.i.types.Expressao>();

    tmp = gram.i.types.expressao.ExpNum.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.expressao.Id.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.expressao.Pos.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.expressao.Neg.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.expressao.Nao.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.expressao.Call.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.expressao.IncAntes.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.expressao.IncDepois.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.expressao.Condicional.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.expressao.Int.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.expressao.Char.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.expressao.True.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.expressao.False.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.expressao.Float.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.expressao.Ou.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.expressao.E.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.expressao.Comp.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.expressao.Input.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.expressao.Print.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.expressao.ConsExpressoes.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.expressao.EmptyExpressoes.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.expressao.Empty.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.expressao.Expressoes.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    switch(results.size()) {
      case 0:
        throw new IllegalArgumentException(trm + " is not a Expressao");
      case 1:
        return results.get(0);
      default:
        java.util.logging.Logger.getLogger("Expressao").log(java.util.logging.Level.WARNING,"There were many possibilities ({0}) in {1} but the first one was chosen: {2}",new Object[] {results.toString(), "gram.i.types.Expressao", results.get(0).toString()});
        return results.get(0);
    }
  }

  /**
   * Apply a conversion on the ATerm contained in the String and returns a gram.i.types.Expressao from it
   *
   * @param s String containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static gram.i.types.Expressao fromString(String s, tom.library.utils.ATermConverter atConv) {
    return fromTerm(atermFactory.parse(s),atConv);
  }

  /**
   * Apply a conversion on the ATerm contained in the Stream and returns a gram.i.types.Expressao from it
   *
   * @param stream stream containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static gram.i.types.Expressao fromStream(java.io.InputStream stream, tom.library.utils.ATermConverter atConv) throws java.io.IOException {
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
  public gram.i.types.Expressao reverse() {
    throw new IllegalArgumentException(
      "This "+this.getClass().getName()+" is not a list");
  }

  
  /**
   * Returns a Collection extracted from the term
   *
   * @return the collection
   * @throws UnsupportedOperationException if the term is not a list
   */
  public java.util.Collection<gram.i.types.Expressao> getCollectionExpressoes() {
    throw new UnsupportedOperationException("This Expressao cannot be converted into a Collection");
  }
          
  /*
   * Initialize the (cyclic) data-structure
   * in order to generate/enumerate terms
   */

  protected static tom.library.enumerator.Enumeration<gram.i.types.Expressao> enumExpressao = null;
  public static final tom.library.enumerator.Enumeration<gram.i.types.Expressao> tmpenumExpressao = new tom.library.enumerator.Enumeration<gram.i.types.Expressao>((tom.library.enumerator.LazyList<tom.library.enumerator.Finite<gram.i.types.Expressao>>) null);

  public static tom.library.enumerator.Enumeration<gram.i.types.Expressao> getEnumeration() {
    if(enumExpressao == null) { 
      enumExpressao = gram.i.types.expressao.ExpNum.funMake().apply(gram.i.types.Expressao.tmpenumExpressao).apply(gram.i.types.LComentarios.tmpenumLComentarios).apply(gram.i.types.OpNum.tmpenumOpNum).apply(gram.i.types.LComentarios.tmpenumLComentarios).apply(gram.i.types.Expressao.tmpenumExpressao)
        .plus(gram.i.types.expressao.Id.funMake().apply(tom.library.enumerator.Combinators.makeString()))
        .plus(gram.i.types.expressao.Pos.funMake().apply(gram.i.types.Expressao.tmpenumExpressao))
        .plus(gram.i.types.expressao.Neg.funMake().apply(gram.i.types.Expressao.tmpenumExpressao))
        .plus(gram.i.types.expressao.Nao.funMake().apply(gram.i.types.Expressao.tmpenumExpressao))
        .plus(gram.i.types.expressao.Call.funMake().apply(gram.i.types.LComentarios.tmpenumLComentarios).apply(tom.library.enumerator.Combinators.makeString()).apply(gram.i.types.LComentarios.tmpenumLComentarios).apply(gram.i.types.LComentarios.tmpenumLComentarios).apply(gram.i.types.Parametros.tmpenumParametros).apply(gram.i.types.LComentarios.tmpenumLComentarios).apply(gram.i.types.LComentarios.tmpenumLComentarios))
        .plus(gram.i.types.expressao.IncAntes.funMake().apply(gram.i.types.OpInc.tmpenumOpInc).apply(tom.library.enumerator.Combinators.makeString()))
        .plus(gram.i.types.expressao.IncDepois.funMake().apply(gram.i.types.OpInc.tmpenumOpInc).apply(tom.library.enumerator.Combinators.makeString()))
        .plus(gram.i.types.expressao.Condicional.funMake().apply(gram.i.types.Expressao.tmpenumExpressao).apply(gram.i.types.LComentarios.tmpenumLComentarios).apply(gram.i.types.LComentarios.tmpenumLComentarios).apply(gram.i.types.Expressao.tmpenumExpressao).apply(gram.i.types.LComentarios.tmpenumLComentarios).apply(gram.i.types.LComentarios.tmpenumLComentarios).apply(gram.i.types.Expressao.tmpenumExpressao))
        .plus(gram.i.types.expressao.Int.funMake().apply(tom.library.enumerator.Combinators.makeint()))
        .plus(gram.i.types.expressao.Char.funMake().apply(tom.library.enumerator.Combinators.makeString()))
        .plus(gram.i.types.expressao.True.funMake().apply(gram.i.types.Expressao.tmpenumExpressao))
        .plus(gram.i.types.expressao.False.funMake().apply(gram.i.types.Expressao.tmpenumExpressao))
        .plus(gram.i.types.expressao.Float.funMake().apply(tom.library.enumerator.Combinators.makeint()))
        .plus(gram.i.types.expressao.Ou.funMake().apply(gram.i.types.Expressao.tmpenumExpressao).apply(gram.i.types.LComentarios.tmpenumLComentarios).apply(gram.i.types.LComentarios.tmpenumLComentarios).apply(gram.i.types.Expressao.tmpenumExpressao))
        .plus(gram.i.types.expressao.E.funMake().apply(gram.i.types.Expressao.tmpenumExpressao).apply(gram.i.types.LComentarios.tmpenumLComentarios).apply(gram.i.types.LComentarios.tmpenumLComentarios).apply(gram.i.types.Expressao.tmpenumExpressao))
        .plus(gram.i.types.expressao.Comp.funMake().apply(gram.i.types.Expressao.tmpenumExpressao).apply(gram.i.types.LComentarios.tmpenumLComentarios).apply(gram.i.types.OpComp.tmpenumOpComp).apply(gram.i.types.LComentarios.tmpenumLComentarios).apply(gram.i.types.Expressao.tmpenumExpressao))
        .plus(gram.i.types.expressao.Input.funMake().apply(gram.i.types.LComentarios.tmpenumLComentarios).apply(gram.i.types.LComentarios.tmpenumLComentarios).apply(gram.i.types.LComentarios.tmpenumLComentarios).apply(gram.i.types.DefTipo.tmpenumDefTipo).apply(gram.i.types.LComentarios.tmpenumLComentarios).apply(gram.i.types.LComentarios.tmpenumLComentarios))
        .plus(gram.i.types.expressao.Print.funMake().apply(gram.i.types.LComentarios.tmpenumLComentarios).apply(gram.i.types.LComentarios.tmpenumLComentarios).apply(gram.i.types.LComentarios.tmpenumLComentarios).apply(gram.i.types.Expressao.tmpenumExpressao).apply(gram.i.types.LComentarios.tmpenumLComentarios).apply(gram.i.types.LComentarios.tmpenumLComentarios))
        .plus(gram.i.types.expressao.Empty.funMake().apply(gram.i.types.Expressao.tmpenumExpressao));

      gram.i.types.DefTipo.getEnumeration();
      gram.i.types.OpInc.getEnumeration();
      gram.i.types.Parametros.getEnumeration();
      gram.i.types.OpComp.getEnumeration();
      gram.i.types.OpNum.getEnumeration();
      gram.i.types.LComentarios.getEnumeration();

      tmpenumExpressao.p1 = new tom.library.enumerator.P1<tom.library.enumerator.LazyList<tom.library.enumerator.Finite<gram.i.types.Expressao>>>() {
        public tom.library.enumerator.LazyList<tom.library.enumerator.Finite<gram.i.types.Expressao>> _1() { return enumExpressao.parts(); }
      };

    }
    return enumExpressao;
  }

}

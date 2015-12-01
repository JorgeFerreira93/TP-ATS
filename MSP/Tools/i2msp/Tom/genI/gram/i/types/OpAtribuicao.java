
package gram.i.types;


public abstract class OpAtribuicao extends gram.i.iAbstractType  {
  /**
   * Sole constructor.  (For invocation by subclass
   * constructors, typically implicit.)
   */
  protected OpAtribuicao() {}



  /**
   * Returns true if the term is rooted by the symbol Atrib
   *
   * @return true if the term is rooted by the symbol Atrib
   */
  public boolean isAtrib() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Mult
   *
   * @return true if the term is rooted by the symbol Mult
   */
  public boolean isMult() {
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
   * Returns true if the term is rooted by the symbol Soma
   *
   * @return true if the term is rooted by the symbol Soma
   */
  public boolean isSoma() {
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
   * Returns a gram.i.types.OpAtribuicao from an ATerm without any conversion
   *
   * @param trm ATerm to handle to retrieve a Gom term
   * @return the term from the ATerm
   */
  public static gram.i.types.OpAtribuicao fromTerm(aterm.ATerm trm) {
    return fromTerm(trm,idConv);
  }

  /**
   * Returns a gram.i.types.OpAtribuicao from a String without any conversion
   *
   * @param s String containing the ATerm
   * @return the term from the String
   */
  public static gram.i.types.OpAtribuicao fromString(String s) {
    return fromTerm(atermFactory.parse(s),idConv);
  }

  /**
   * Returns a gram.i.types.OpAtribuicao from a Stream without any conversion
   *
   * @param stream stream containing the ATerm
   * @return the term from the Stream
   * @throws java.io.IOException if a problem occurs with the stream
   */
  public static gram.i.types.OpAtribuicao fromStream(java.io.InputStream stream) throws java.io.IOException {
    return fromTerm(atermFactory.readFromFile(stream),idConv);
  }

  /**
   * Apply a conversion on the ATerm and returns a gram.i.types.OpAtribuicao
   *
   * @param trm ATerm to convert into a Gom term
   * @param atConv ATermConverter used to convert the ATerm
   * @return the Gom term
   * @throws IllegalArgumentException
   */
  public static gram.i.types.OpAtribuicao fromTerm(aterm.ATerm trm, tom.library.utils.ATermConverter atConv) {
    aterm.ATerm convertedTerm = atConv.convert(trm);
    gram.i.types.OpAtribuicao tmp;
    java.util.ArrayList<gram.i.types.OpAtribuicao> results = new java.util.ArrayList<gram.i.types.OpAtribuicao>();

    tmp = gram.i.types.opatribuicao.Atrib.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.opatribuicao.Mult.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.opatribuicao.Div.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.opatribuicao.Soma.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.opatribuicao.Sub.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    switch(results.size()) {
      case 0:
        throw new IllegalArgumentException(trm + " is not a OpAtribuicao");
      case 1:
        return results.get(0);
      default:
        java.util.logging.Logger.getLogger("OpAtribuicao").log(java.util.logging.Level.WARNING,"There were many possibilities ({0}) in {1} but the first one was chosen: {2}",new Object[] {results.toString(), "gram.i.types.OpAtribuicao", results.get(0).toString()});
        return results.get(0);
    }
  }

  /**
   * Apply a conversion on the ATerm contained in the String and returns a gram.i.types.OpAtribuicao from it
   *
   * @param s String containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static gram.i.types.OpAtribuicao fromString(String s, tom.library.utils.ATermConverter atConv) {
    return fromTerm(atermFactory.parse(s),atConv);
  }

  /**
   * Apply a conversion on the ATerm contained in the Stream and returns a gram.i.types.OpAtribuicao from it
   *
   * @param stream stream containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static gram.i.types.OpAtribuicao fromStream(java.io.InputStream stream, tom.library.utils.ATermConverter atConv) throws java.io.IOException {
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
  public gram.i.types.OpAtribuicao reverse() {
    throw new IllegalArgumentException(
      "This "+this.getClass().getName()+" is not a list");
  }

  
  /*
   * Initialize the (cyclic) data-structure
   * in order to generate/enumerate terms
   */

  protected static tom.library.enumerator.Enumeration<gram.i.types.OpAtribuicao> enumOpAtribuicao = null;
  public static final tom.library.enumerator.Enumeration<gram.i.types.OpAtribuicao> tmpenumOpAtribuicao = new tom.library.enumerator.Enumeration<gram.i.types.OpAtribuicao>((tom.library.enumerator.LazyList<tom.library.enumerator.Finite<gram.i.types.OpAtribuicao>>) null);

  public static tom.library.enumerator.Enumeration<gram.i.types.OpAtribuicao> getEnumeration() {
    if(enumOpAtribuicao == null) { 
      enumOpAtribuicao = gram.i.types.opatribuicao.Atrib.funMake().apply(gram.i.types.OpAtribuicao.tmpenumOpAtribuicao)
        .plus(gram.i.types.opatribuicao.Mult.funMake().apply(gram.i.types.OpAtribuicao.tmpenumOpAtribuicao))
        .plus(gram.i.types.opatribuicao.Div.funMake().apply(gram.i.types.OpAtribuicao.tmpenumOpAtribuicao))
        .plus(gram.i.types.opatribuicao.Soma.funMake().apply(gram.i.types.OpAtribuicao.tmpenumOpAtribuicao))
        .plus(gram.i.types.opatribuicao.Sub.funMake().apply(gram.i.types.OpAtribuicao.tmpenumOpAtribuicao));


      tmpenumOpAtribuicao.p1 = new tom.library.enumerator.P1<tom.library.enumerator.LazyList<tom.library.enumerator.Finite<gram.i.types.OpAtribuicao>>>() {
        public tom.library.enumerator.LazyList<tom.library.enumerator.Finite<gram.i.types.OpAtribuicao>> _1() { return enumOpAtribuicao.parts(); }
      };

    }
    return enumOpAtribuicao;
  }

}

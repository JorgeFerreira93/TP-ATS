
package gram.i.types;


public abstract class Parametros extends gram.i.iAbstractType  {
  /**
   * Sole constructor.  (For invocation by subclass
   * constructors, typically implicit.)
   */
  protected Parametros() {}



  /**
   * Returns true if the term is rooted by the symbol ConsListaParametros
   *
   * @return true if the term is rooted by the symbol ConsListaParametros
   */
  public boolean isConsListaParametros() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol EmptyListaParametros
   *
   * @return true if the term is rooted by the symbol EmptyListaParametros
   */
  public boolean isEmptyListaParametros() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Parametro
   *
   * @return true if the term is rooted by the symbol Parametro
   */
  public boolean isParametro() {
    return false;
  }

  /**
   * Returns the subterm corresponding to the slot TailListaParametros
   *
   * @return the subterm corresponding to the slot TailListaParametros
   */
  public gram.i.types.Parametros getTailListaParametros() {
    throw new UnsupportedOperationException("This Parametros has no TailListaParametros");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot TailListaParametros
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot TailListaParametros is replaced by _arg
   */
  public Parametros setTailListaParametros(gram.i.types.Parametros _arg) {
    throw new UnsupportedOperationException("This Parametros has no TailListaParametros");
  }

  /**
   * Returns the subterm corresponding to the slot c2
   *
   * @return the subterm corresponding to the slot c2
   */
  public gram.i.types.LComentarios getc2() {
    throw new UnsupportedOperationException("This Parametros has no c2");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot c2
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot c2 is replaced by _arg
   */
  public Parametros setc2(gram.i.types.LComentarios _arg) {
    throw new UnsupportedOperationException("This Parametros has no c2");
  }

  /**
   * Returns the subterm corresponding to the slot c1
   *
   * @return the subterm corresponding to the slot c1
   */
  public gram.i.types.LComentarios getc1() {
    throw new UnsupportedOperationException("This Parametros has no c1");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot c1
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot c1 is replaced by _arg
   */
  public Parametros setc1(gram.i.types.LComentarios _arg) {
    throw new UnsupportedOperationException("This Parametros has no c1");
  }

  /**
   * Returns the subterm corresponding to the slot HeadListaParametros
   *
   * @return the subterm corresponding to the slot HeadListaParametros
   */
  public gram.i.types.Parametros getHeadListaParametros() {
    throw new UnsupportedOperationException("This Parametros has no HeadListaParametros");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot HeadListaParametros
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot HeadListaParametros is replaced by _arg
   */
  public Parametros setHeadListaParametros(gram.i.types.Parametros _arg) {
    throw new UnsupportedOperationException("This Parametros has no HeadListaParametros");
  }

  /**
   * Returns the subterm corresponding to the slot Expressao
   *
   * @return the subterm corresponding to the slot Expressao
   */
  public gram.i.types.Expressao getExpressao() {
    throw new UnsupportedOperationException("This Parametros has no Expressao");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot Expressao
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot Expressao is replaced by _arg
   */
  public Parametros setExpressao(gram.i.types.Expressao _arg) {
    throw new UnsupportedOperationException("This Parametros has no Expressao");
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
   * Returns a gram.i.types.Parametros from an ATerm without any conversion
   *
   * @param trm ATerm to handle to retrieve a Gom term
   * @return the term from the ATerm
   */
  public static gram.i.types.Parametros fromTerm(aterm.ATerm trm) {
    return fromTerm(trm,idConv);
  }

  /**
   * Returns a gram.i.types.Parametros from a String without any conversion
   *
   * @param s String containing the ATerm
   * @return the term from the String
   */
  public static gram.i.types.Parametros fromString(String s) {
    return fromTerm(atermFactory.parse(s),idConv);
  }

  /**
   * Returns a gram.i.types.Parametros from a Stream without any conversion
   *
   * @param stream stream containing the ATerm
   * @return the term from the Stream
   * @throws java.io.IOException if a problem occurs with the stream
   */
  public static gram.i.types.Parametros fromStream(java.io.InputStream stream) throws java.io.IOException {
    return fromTerm(atermFactory.readFromFile(stream),idConv);
  }

  /**
   * Apply a conversion on the ATerm and returns a gram.i.types.Parametros
   *
   * @param trm ATerm to convert into a Gom term
   * @param atConv ATermConverter used to convert the ATerm
   * @return the Gom term
   * @throws IllegalArgumentException
   */
  public static gram.i.types.Parametros fromTerm(aterm.ATerm trm, tom.library.utils.ATermConverter atConv) {
    aterm.ATerm convertedTerm = atConv.convert(trm);
    gram.i.types.Parametros tmp;
    java.util.ArrayList<gram.i.types.Parametros> results = new java.util.ArrayList<gram.i.types.Parametros>();

    tmp = gram.i.types.parametros.ConsListaParametros.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.parametros.EmptyListaParametros.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.parametros.Parametro.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.parametros.ListaParametros.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    switch(results.size()) {
      case 0:
        throw new IllegalArgumentException(trm + " is not a Parametros");
      case 1:
        return results.get(0);
      default:
        java.util.logging.Logger.getLogger("Parametros").log(java.util.logging.Level.WARNING,"There were many possibilities ({0}) in {1} but the first one was chosen: {2}",new Object[] {results.toString(), "gram.i.types.Parametros", results.get(0).toString()});
        return results.get(0);
    }
  }

  /**
   * Apply a conversion on the ATerm contained in the String and returns a gram.i.types.Parametros from it
   *
   * @param s String containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static gram.i.types.Parametros fromString(String s, tom.library.utils.ATermConverter atConv) {
    return fromTerm(atermFactory.parse(s),atConv);
  }

  /**
   * Apply a conversion on the ATerm contained in the Stream and returns a gram.i.types.Parametros from it
   *
   * @param stream stream containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static gram.i.types.Parametros fromStream(java.io.InputStream stream, tom.library.utils.ATermConverter atConv) throws java.io.IOException {
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
  public gram.i.types.Parametros reverse() {
    throw new IllegalArgumentException(
      "This "+this.getClass().getName()+" is not a list");
  }

  
  /**
   * Returns a Collection extracted from the term
   *
   * @return the collection
   * @throws UnsupportedOperationException if the term is not a list
   */
  public java.util.Collection<gram.i.types.Parametros> getCollectionListaParametros() {
    throw new UnsupportedOperationException("This Parametros cannot be converted into a Collection");
  }
          
  /*
   * Initialize the (cyclic) data-structure
   * in order to generate/enumerate terms
   */

  protected static tom.library.enumerator.Enumeration<gram.i.types.Parametros> enumParametros = null;
  public static final tom.library.enumerator.Enumeration<gram.i.types.Parametros> tmpenumParametros = new tom.library.enumerator.Enumeration<gram.i.types.Parametros>((tom.library.enumerator.LazyList<tom.library.enumerator.Finite<gram.i.types.Parametros>>) null);

  public static tom.library.enumerator.Enumeration<gram.i.types.Parametros> getEnumeration() {
    if(enumParametros == null) { 
      enumParametros = gram.i.types.parametros.Parametro.funMake().apply(gram.i.types.LComentarios.tmpenumLComentarios).apply(gram.i.types.Expressao.tmpenumExpressao).apply(gram.i.types.LComentarios.tmpenumLComentarios);

      gram.i.types.LComentarios.getEnumeration();
      gram.i.types.Expressao.getEnumeration();

      tmpenumParametros.p1 = new tom.library.enumerator.P1<tom.library.enumerator.LazyList<tom.library.enumerator.Finite<gram.i.types.Parametros>>>() {
        public tom.library.enumerator.LazyList<tom.library.enumerator.Finite<gram.i.types.Parametros>> _1() { return enumParametros.parts(); }
      };

    }
    return enumParametros;
  }

}

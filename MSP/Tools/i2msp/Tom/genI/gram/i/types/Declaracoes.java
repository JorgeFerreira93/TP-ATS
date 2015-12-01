
package gram.i.types;


public abstract class Declaracoes extends gram.i.iAbstractType  {
  /**
   * Sole constructor.  (For invocation by subclass
   * constructors, typically implicit.)
   */
  protected Declaracoes() {}



  /**
   * Returns true if the term is rooted by the symbol ConsListaDecl
   *
   * @return true if the term is rooted by the symbol ConsListaDecl
   */
  public boolean isConsListaDecl() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol EmptyListaDecl
   *
   * @return true if the term is rooted by the symbol EmptyListaDecl
   */
  public boolean isEmptyListaDecl() {
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
   * Returns the subterm corresponding to the slot Id
   *
   * @return the subterm corresponding to the slot Id
   */
  public String getId() {
    throw new UnsupportedOperationException("This Declaracoes has no Id");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot Id
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot Id is replaced by _arg
   */
  public Declaracoes setId(String _arg) {
    throw new UnsupportedOperationException("This Declaracoes has no Id");
  }

  /**
   * Returns the subterm corresponding to the slot c2
   *
   * @return the subterm corresponding to the slot c2
   */
  public gram.i.types.LComentarios getc2() {
    throw new UnsupportedOperationException("This Declaracoes has no c2");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot c2
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot c2 is replaced by _arg
   */
  public Declaracoes setc2(gram.i.types.LComentarios _arg) {
    throw new UnsupportedOperationException("This Declaracoes has no c2");
  }

  /**
   * Returns the subterm corresponding to the slot TailListaDecl
   *
   * @return the subterm corresponding to the slot TailListaDecl
   */
  public gram.i.types.Declaracoes getTailListaDecl() {
    throw new UnsupportedOperationException("This Declaracoes has no TailListaDecl");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot TailListaDecl
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot TailListaDecl is replaced by _arg
   */
  public Declaracoes setTailListaDecl(gram.i.types.Declaracoes _arg) {
    throw new UnsupportedOperationException("This Declaracoes has no TailListaDecl");
  }

  /**
   * Returns the subterm corresponding to the slot c3
   *
   * @return the subterm corresponding to the slot c3
   */
  public gram.i.types.LComentarios getc3() {
    throw new UnsupportedOperationException("This Declaracoes has no c3");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot c3
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot c3 is replaced by _arg
   */
  public Declaracoes setc3(gram.i.types.LComentarios _arg) {
    throw new UnsupportedOperationException("This Declaracoes has no c3");
  }

  /**
   * Returns the subterm corresponding to the slot c1
   *
   * @return the subterm corresponding to the slot c1
   */
  public gram.i.types.LComentarios getc1() {
    throw new UnsupportedOperationException("This Declaracoes has no c1");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot c1
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot c1 is replaced by _arg
   */
  public Declaracoes setc1(gram.i.types.LComentarios _arg) {
    throw new UnsupportedOperationException("This Declaracoes has no c1");
  }

  /**
   * Returns the subterm corresponding to the slot HeadListaDecl
   *
   * @return the subterm corresponding to the slot HeadListaDecl
   */
  public gram.i.types.Declaracoes getHeadListaDecl() {
    throw new UnsupportedOperationException("This Declaracoes has no HeadListaDecl");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot HeadListaDecl
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot HeadListaDecl is replaced by _arg
   */
  public Declaracoes setHeadListaDecl(gram.i.types.Declaracoes _arg) {
    throw new UnsupportedOperationException("This Declaracoes has no HeadListaDecl");
  }

  /**
   * Returns the subterm corresponding to the slot Expressao
   *
   * @return the subterm corresponding to the slot Expressao
   */
  public gram.i.types.Expressao getExpressao() {
    throw new UnsupportedOperationException("This Declaracoes has no Expressao");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot Expressao
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot Expressao is replaced by _arg
   */
  public Declaracoes setExpressao(gram.i.types.Expressao _arg) {
    throw new UnsupportedOperationException("This Declaracoes has no Expressao");
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
   * Returns a gram.i.types.Declaracoes from an ATerm without any conversion
   *
   * @param trm ATerm to handle to retrieve a Gom term
   * @return the term from the ATerm
   */
  public static gram.i.types.Declaracoes fromTerm(aterm.ATerm trm) {
    return fromTerm(trm,idConv);
  }

  /**
   * Returns a gram.i.types.Declaracoes from a String without any conversion
   *
   * @param s String containing the ATerm
   * @return the term from the String
   */
  public static gram.i.types.Declaracoes fromString(String s) {
    return fromTerm(atermFactory.parse(s),idConv);
  }

  /**
   * Returns a gram.i.types.Declaracoes from a Stream without any conversion
   *
   * @param stream stream containing the ATerm
   * @return the term from the Stream
   * @throws java.io.IOException if a problem occurs with the stream
   */
  public static gram.i.types.Declaracoes fromStream(java.io.InputStream stream) throws java.io.IOException {
    return fromTerm(atermFactory.readFromFile(stream),idConv);
  }

  /**
   * Apply a conversion on the ATerm and returns a gram.i.types.Declaracoes
   *
   * @param trm ATerm to convert into a Gom term
   * @param atConv ATermConverter used to convert the ATerm
   * @return the Gom term
   * @throws IllegalArgumentException
   */
  public static gram.i.types.Declaracoes fromTerm(aterm.ATerm trm, tom.library.utils.ATermConverter atConv) {
    aterm.ATerm convertedTerm = atConv.convert(trm);
    gram.i.types.Declaracoes tmp;
    java.util.ArrayList<gram.i.types.Declaracoes> results = new java.util.ArrayList<gram.i.types.Declaracoes>();

    tmp = gram.i.types.declaracoes.ConsListaDecl.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.declaracoes.EmptyListaDecl.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.declaracoes.Decl.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.declaracoes.ListaDecl.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    switch(results.size()) {
      case 0:
        throw new IllegalArgumentException(trm + " is not a Declaracoes");
      case 1:
        return results.get(0);
      default:
        java.util.logging.Logger.getLogger("Declaracoes").log(java.util.logging.Level.WARNING,"There were many possibilities ({0}) in {1} but the first one was chosen: {2}",new Object[] {results.toString(), "gram.i.types.Declaracoes", results.get(0).toString()});
        return results.get(0);
    }
  }

  /**
   * Apply a conversion on the ATerm contained in the String and returns a gram.i.types.Declaracoes from it
   *
   * @param s String containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static gram.i.types.Declaracoes fromString(String s, tom.library.utils.ATermConverter atConv) {
    return fromTerm(atermFactory.parse(s),atConv);
  }

  /**
   * Apply a conversion on the ATerm contained in the Stream and returns a gram.i.types.Declaracoes from it
   *
   * @param stream stream containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static gram.i.types.Declaracoes fromStream(java.io.InputStream stream, tom.library.utils.ATermConverter atConv) throws java.io.IOException {
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
  public gram.i.types.Declaracoes reverse() {
    throw new IllegalArgumentException(
      "This "+this.getClass().getName()+" is not a list");
  }

  
  /**
   * Returns a Collection extracted from the term
   *
   * @return the collection
   * @throws UnsupportedOperationException if the term is not a list
   */
  public java.util.Collection<gram.i.types.Declaracoes> getCollectionListaDecl() {
    throw new UnsupportedOperationException("This Declaracoes cannot be converted into a Collection");
  }
          
  /*
   * Initialize the (cyclic) data-structure
   * in order to generate/enumerate terms
   */

  protected static tom.library.enumerator.Enumeration<gram.i.types.Declaracoes> enumDeclaracoes = null;
  public static final tom.library.enumerator.Enumeration<gram.i.types.Declaracoes> tmpenumDeclaracoes = new tom.library.enumerator.Enumeration<gram.i.types.Declaracoes>((tom.library.enumerator.LazyList<tom.library.enumerator.Finite<gram.i.types.Declaracoes>>) null);

  public static tom.library.enumerator.Enumeration<gram.i.types.Declaracoes> getEnumeration() {
    if(enumDeclaracoes == null) { 
      enumDeclaracoes = gram.i.types.declaracoes.Decl.funMake().apply(tom.library.enumerator.Combinators.makeString()).apply(gram.i.types.LComentarios.tmpenumLComentarios).apply(gram.i.types.LComentarios.tmpenumLComentarios).apply(gram.i.types.Expressao.tmpenumExpressao).apply(gram.i.types.LComentarios.tmpenumLComentarios);

      gram.i.types.LComentarios.getEnumeration();
      gram.i.types.Expressao.getEnumeration();

      tmpenumDeclaracoes.p1 = new tom.library.enumerator.P1<tom.library.enumerator.LazyList<tom.library.enumerator.Finite<gram.i.types.Declaracoes>>>() {
        public tom.library.enumerator.LazyList<tom.library.enumerator.Finite<gram.i.types.Declaracoes>> _1() { return enumDeclaracoes.parts(); }
      };

    }
    return enumDeclaracoes;
  }

}

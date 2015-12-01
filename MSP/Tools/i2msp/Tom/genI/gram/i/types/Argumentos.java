
package gram.i.types;


public abstract class Argumentos extends gram.i.iAbstractType  {
  /**
   * Sole constructor.  (For invocation by subclass
   * constructors, typically implicit.)
   */
  protected Argumentos() {}



  /**
   * Returns true if the term is rooted by the symbol ConsListaArgumentos
   *
   * @return true if the term is rooted by the symbol ConsListaArgumentos
   */
  public boolean isConsListaArgumentos() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol EmptyListaArgumentos
   *
   * @return true if the term is rooted by the symbol EmptyListaArgumentos
   */
  public boolean isEmptyListaArgumentos() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Argumento
   *
   * @return true if the term is rooted by the symbol Argumento
   */
  public boolean isArgumento() {
    return false;
  }

  /**
   * Returns the subterm corresponding to the slot Id
   *
   * @return the subterm corresponding to the slot Id
   */
  public String getId() {
    throw new UnsupportedOperationException("This Argumentos has no Id");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot Id
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot Id is replaced by _arg
   */
  public Argumentos setId(String _arg) {
    throw new UnsupportedOperationException("This Argumentos has no Id");
  }

  /**
   * Returns the subterm corresponding to the slot HeadListaArgumentos
   *
   * @return the subterm corresponding to the slot HeadListaArgumentos
   */
  public gram.i.types.Argumentos getHeadListaArgumentos() {
    throw new UnsupportedOperationException("This Argumentos has no HeadListaArgumentos");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot HeadListaArgumentos
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot HeadListaArgumentos is replaced by _arg
   */
  public Argumentos setHeadListaArgumentos(gram.i.types.Argumentos _arg) {
    throw new UnsupportedOperationException("This Argumentos has no HeadListaArgumentos");
  }

  /**
   * Returns the subterm corresponding to the slot c2
   *
   * @return the subterm corresponding to the slot c2
   */
  public gram.i.types.LComentarios getc2() {
    throw new UnsupportedOperationException("This Argumentos has no c2");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot c2
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot c2 is replaced by _arg
   */
  public Argumentos setc2(gram.i.types.LComentarios _arg) {
    throw new UnsupportedOperationException("This Argumentos has no c2");
  }

  /**
   * Returns the subterm corresponding to the slot c3
   *
   * @return the subterm corresponding to the slot c3
   */
  public gram.i.types.LComentarios getc3() {
    throw new UnsupportedOperationException("This Argumentos has no c3");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot c3
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot c3 is replaced by _arg
   */
  public Argumentos setc3(gram.i.types.LComentarios _arg) {
    throw new UnsupportedOperationException("This Argumentos has no c3");
  }

  /**
   * Returns the subterm corresponding to the slot c1
   *
   * @return the subterm corresponding to the slot c1
   */
  public gram.i.types.LComentarios getc1() {
    throw new UnsupportedOperationException("This Argumentos has no c1");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot c1
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot c1 is replaced by _arg
   */
  public Argumentos setc1(gram.i.types.LComentarios _arg) {
    throw new UnsupportedOperationException("This Argumentos has no c1");
  }

  /**
   * Returns the subterm corresponding to the slot DefTipo
   *
   * @return the subterm corresponding to the slot DefTipo
   */
  public gram.i.types.DefTipo getDefTipo() {
    throw new UnsupportedOperationException("This Argumentos has no DefTipo");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot DefTipo
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot DefTipo is replaced by _arg
   */
  public Argumentos setDefTipo(gram.i.types.DefTipo _arg) {
    throw new UnsupportedOperationException("This Argumentos has no DefTipo");
  }

  /**
   * Returns the subterm corresponding to the slot TailListaArgumentos
   *
   * @return the subterm corresponding to the slot TailListaArgumentos
   */
  public gram.i.types.Argumentos getTailListaArgumentos() {
    throw new UnsupportedOperationException("This Argumentos has no TailListaArgumentos");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot TailListaArgumentos
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot TailListaArgumentos is replaced by _arg
   */
  public Argumentos setTailListaArgumentos(gram.i.types.Argumentos _arg) {
    throw new UnsupportedOperationException("This Argumentos has no TailListaArgumentos");
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
   * Returns a gram.i.types.Argumentos from an ATerm without any conversion
   *
   * @param trm ATerm to handle to retrieve a Gom term
   * @return the term from the ATerm
   */
  public static gram.i.types.Argumentos fromTerm(aterm.ATerm trm) {
    return fromTerm(trm,idConv);
  }

  /**
   * Returns a gram.i.types.Argumentos from a String without any conversion
   *
   * @param s String containing the ATerm
   * @return the term from the String
   */
  public static gram.i.types.Argumentos fromString(String s) {
    return fromTerm(atermFactory.parse(s),idConv);
  }

  /**
   * Returns a gram.i.types.Argumentos from a Stream without any conversion
   *
   * @param stream stream containing the ATerm
   * @return the term from the Stream
   * @throws java.io.IOException if a problem occurs with the stream
   */
  public static gram.i.types.Argumentos fromStream(java.io.InputStream stream) throws java.io.IOException {
    return fromTerm(atermFactory.readFromFile(stream),idConv);
  }

  /**
   * Apply a conversion on the ATerm and returns a gram.i.types.Argumentos
   *
   * @param trm ATerm to convert into a Gom term
   * @param atConv ATermConverter used to convert the ATerm
   * @return the Gom term
   * @throws IllegalArgumentException
   */
  public static gram.i.types.Argumentos fromTerm(aterm.ATerm trm, tom.library.utils.ATermConverter atConv) {
    aterm.ATerm convertedTerm = atConv.convert(trm);
    gram.i.types.Argumentos tmp;
    java.util.ArrayList<gram.i.types.Argumentos> results = new java.util.ArrayList<gram.i.types.Argumentos>();

    tmp = gram.i.types.argumentos.ConsListaArgumentos.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.argumentos.EmptyListaArgumentos.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.argumentos.Argumento.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.argumentos.ListaArgumentos.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    switch(results.size()) {
      case 0:
        throw new IllegalArgumentException(trm + " is not a Argumentos");
      case 1:
        return results.get(0);
      default:
        java.util.logging.Logger.getLogger("Argumentos").log(java.util.logging.Level.WARNING,"There were many possibilities ({0}) in {1} but the first one was chosen: {2}",new Object[] {results.toString(), "gram.i.types.Argumentos", results.get(0).toString()});
        return results.get(0);
    }
  }

  /**
   * Apply a conversion on the ATerm contained in the String and returns a gram.i.types.Argumentos from it
   *
   * @param s String containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static gram.i.types.Argumentos fromString(String s, tom.library.utils.ATermConverter atConv) {
    return fromTerm(atermFactory.parse(s),atConv);
  }

  /**
   * Apply a conversion on the ATerm contained in the Stream and returns a gram.i.types.Argumentos from it
   *
   * @param stream stream containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static gram.i.types.Argumentos fromStream(java.io.InputStream stream, tom.library.utils.ATermConverter atConv) throws java.io.IOException {
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
  public gram.i.types.Argumentos reverse() {
    throw new IllegalArgumentException(
      "This "+this.getClass().getName()+" is not a list");
  }

  
  /**
   * Returns a Collection extracted from the term
   *
   * @return the collection
   * @throws UnsupportedOperationException if the term is not a list
   */
  public java.util.Collection<gram.i.types.Argumentos> getCollectionListaArgumentos() {
    throw new UnsupportedOperationException("This Argumentos cannot be converted into a Collection");
  }
          
  /*
   * Initialize the (cyclic) data-structure
   * in order to generate/enumerate terms
   */

  protected static tom.library.enumerator.Enumeration<gram.i.types.Argumentos> enumArgumentos = null;
  public static final tom.library.enumerator.Enumeration<gram.i.types.Argumentos> tmpenumArgumentos = new tom.library.enumerator.Enumeration<gram.i.types.Argumentos>((tom.library.enumerator.LazyList<tom.library.enumerator.Finite<gram.i.types.Argumentos>>) null);

  public static tom.library.enumerator.Enumeration<gram.i.types.Argumentos> getEnumeration() {
    if(enumArgumentos == null) { 
      enumArgumentos = gram.i.types.argumentos.Argumento.funMake().apply(gram.i.types.LComentarios.tmpenumLComentarios).apply(gram.i.types.DefTipo.tmpenumDefTipo).apply(gram.i.types.LComentarios.tmpenumLComentarios).apply(tom.library.enumerator.Combinators.makeString()).apply(gram.i.types.LComentarios.tmpenumLComentarios);

      gram.i.types.DefTipo.getEnumeration();
      gram.i.types.LComentarios.getEnumeration();

      tmpenumArgumentos.p1 = new tom.library.enumerator.P1<tom.library.enumerator.LazyList<tom.library.enumerator.Finite<gram.i.types.Argumentos>>>() {
        public tom.library.enumerator.LazyList<tom.library.enumerator.Finite<gram.i.types.Argumentos>> _1() { return enumArgumentos.parts(); }
      };

    }
    return enumArgumentos;
  }

}

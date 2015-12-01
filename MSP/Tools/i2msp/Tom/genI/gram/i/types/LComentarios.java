
package gram.i.types;


public abstract class LComentarios extends gram.i.iAbstractType  {
  /**
   * Sole constructor.  (For invocation by subclass
   * constructors, typically implicit.)
   */
  protected LComentarios() {}



  /**
   * Returns true if the term is rooted by the symbol ConsComentarios
   *
   * @return true if the term is rooted by the symbol ConsComentarios
   */
  public boolean isConsComentarios() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol EmptyComentarios
   *
   * @return true if the term is rooted by the symbol EmptyComentarios
   */
  public boolean isEmptyComentarios() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Comentario
   *
   * @return true if the term is rooted by the symbol Comentario
   */
  public boolean isComentario() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Vazio
   *
   * @return true if the term is rooted by the symbol Vazio
   */
  public boolean isVazio() {
    return false;
  }

  /**
   * Returns the subterm corresponding to the slot comentario
   *
   * @return the subterm corresponding to the slot comentario
   */
  public String getcomentario() {
    throw new UnsupportedOperationException("This LComentarios has no comentario");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot comentario
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot comentario is replaced by _arg
   */
  public LComentarios setcomentario(String _arg) {
    throw new UnsupportedOperationException("This LComentarios has no comentario");
  }

  /**
   * Returns the subterm corresponding to the slot TailComentarios
   *
   * @return the subterm corresponding to the slot TailComentarios
   */
  public gram.i.types.LComentarios getTailComentarios() {
    throw new UnsupportedOperationException("This LComentarios has no TailComentarios");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot TailComentarios
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot TailComentarios is replaced by _arg
   */
  public LComentarios setTailComentarios(gram.i.types.LComentarios _arg) {
    throw new UnsupportedOperationException("This LComentarios has no TailComentarios");
  }

  /**
   * Returns the subterm corresponding to the slot HeadComentarios
   *
   * @return the subterm corresponding to the slot HeadComentarios
   */
  public gram.i.types.LComentarios getHeadComentarios() {
    throw new UnsupportedOperationException("This LComentarios has no HeadComentarios");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot HeadComentarios
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot HeadComentarios is replaced by _arg
   */
  public LComentarios setHeadComentarios(gram.i.types.LComentarios _arg) {
    throw new UnsupportedOperationException("This LComentarios has no HeadComentarios");
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
   * Returns a gram.i.types.LComentarios from an ATerm without any conversion
   *
   * @param trm ATerm to handle to retrieve a Gom term
   * @return the term from the ATerm
   */
  public static gram.i.types.LComentarios fromTerm(aterm.ATerm trm) {
    return fromTerm(trm,idConv);
  }

  /**
   * Returns a gram.i.types.LComentarios from a String without any conversion
   *
   * @param s String containing the ATerm
   * @return the term from the String
   */
  public static gram.i.types.LComentarios fromString(String s) {
    return fromTerm(atermFactory.parse(s),idConv);
  }

  /**
   * Returns a gram.i.types.LComentarios from a Stream without any conversion
   *
   * @param stream stream containing the ATerm
   * @return the term from the Stream
   * @throws java.io.IOException if a problem occurs with the stream
   */
  public static gram.i.types.LComentarios fromStream(java.io.InputStream stream) throws java.io.IOException {
    return fromTerm(atermFactory.readFromFile(stream),idConv);
  }

  /**
   * Apply a conversion on the ATerm and returns a gram.i.types.LComentarios
   *
   * @param trm ATerm to convert into a Gom term
   * @param atConv ATermConverter used to convert the ATerm
   * @return the Gom term
   * @throws IllegalArgumentException
   */
  public static gram.i.types.LComentarios fromTerm(aterm.ATerm trm, tom.library.utils.ATermConverter atConv) {
    aterm.ATerm convertedTerm = atConv.convert(trm);
    gram.i.types.LComentarios tmp;
    java.util.ArrayList<gram.i.types.LComentarios> results = new java.util.ArrayList<gram.i.types.LComentarios>();

    tmp = gram.i.types.lcomentarios.ConsComentarios.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.lcomentarios.EmptyComentarios.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.lcomentarios.Comentario.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.lcomentarios.Vazio.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.lcomentarios.Comentarios.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    switch(results.size()) {
      case 0:
        throw new IllegalArgumentException(trm + " is not a LComentarios");
      case 1:
        return results.get(0);
      default:
        java.util.logging.Logger.getLogger("LComentarios").log(java.util.logging.Level.WARNING,"There were many possibilities ({0}) in {1} but the first one was chosen: {2}",new Object[] {results.toString(), "gram.i.types.LComentarios", results.get(0).toString()});
        return results.get(0);
    }
  }

  /**
   * Apply a conversion on the ATerm contained in the String and returns a gram.i.types.LComentarios from it
   *
   * @param s String containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static gram.i.types.LComentarios fromString(String s, tom.library.utils.ATermConverter atConv) {
    return fromTerm(atermFactory.parse(s),atConv);
  }

  /**
   * Apply a conversion on the ATerm contained in the Stream and returns a gram.i.types.LComentarios from it
   *
   * @param stream stream containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static gram.i.types.LComentarios fromStream(java.io.InputStream stream, tom.library.utils.ATermConverter atConv) throws java.io.IOException {
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
  public gram.i.types.LComentarios reverse() {
    throw new IllegalArgumentException(
      "This "+this.getClass().getName()+" is not a list");
  }

  
  /**
   * Returns a Collection extracted from the term
   *
   * @return the collection
   * @throws UnsupportedOperationException if the term is not a list
   */
  public java.util.Collection<gram.i.types.LComentarios> getCollectionComentarios() {
    throw new UnsupportedOperationException("This LComentarios cannot be converted into a Collection");
  }
          
  /*
   * Initialize the (cyclic) data-structure
   * in order to generate/enumerate terms
   */

  protected static tom.library.enumerator.Enumeration<gram.i.types.LComentarios> enumLComentarios = null;
  public static final tom.library.enumerator.Enumeration<gram.i.types.LComentarios> tmpenumLComentarios = new tom.library.enumerator.Enumeration<gram.i.types.LComentarios>((tom.library.enumerator.LazyList<tom.library.enumerator.Finite<gram.i.types.LComentarios>>) null);

  public static tom.library.enumerator.Enumeration<gram.i.types.LComentarios> getEnumeration() {
    if(enumLComentarios == null) { 
      enumLComentarios = gram.i.types.lcomentarios.Comentario.funMake().apply(tom.library.enumerator.Combinators.makeString())
        .plus(gram.i.types.lcomentarios.Vazio.funMake().apply(gram.i.types.LComentarios.tmpenumLComentarios));


      tmpenumLComentarios.p1 = new tom.library.enumerator.P1<tom.library.enumerator.LazyList<tom.library.enumerator.Finite<gram.i.types.LComentarios>>>() {
        public tom.library.enumerator.LazyList<tom.library.enumerator.Finite<gram.i.types.LComentarios>> _1() { return enumLComentarios.parts(); }
      };

    }
    return enumLComentarios;
  }

}

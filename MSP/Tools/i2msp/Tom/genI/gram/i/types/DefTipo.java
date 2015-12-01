
package gram.i.types;


public abstract class DefTipo extends gram.i.iAbstractType  {
  /**
   * Sole constructor.  (For invocation by subclass
   * constructors, typically implicit.)
   */
  protected DefTipo() {}



  /**
   * Returns true if the term is rooted by the symbol DInt
   *
   * @return true if the term is rooted by the symbol DInt
   */
  public boolean isDInt() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol DChar
   *
   * @return true if the term is rooted by the symbol DChar
   */
  public boolean isDChar() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol DBoolean
   *
   * @return true if the term is rooted by the symbol DBoolean
   */
  public boolean isDBoolean() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol DFloat
   *
   * @return true if the term is rooted by the symbol DFloat
   */
  public boolean isDFloat() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol DVoid
   *
   * @return true if the term is rooted by the symbol DVoid
   */
  public boolean isDVoid() {
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
   * Returns a gram.i.types.DefTipo from an ATerm without any conversion
   *
   * @param trm ATerm to handle to retrieve a Gom term
   * @return the term from the ATerm
   */
  public static gram.i.types.DefTipo fromTerm(aterm.ATerm trm) {
    return fromTerm(trm,idConv);
  }

  /**
   * Returns a gram.i.types.DefTipo from a String without any conversion
   *
   * @param s String containing the ATerm
   * @return the term from the String
   */
  public static gram.i.types.DefTipo fromString(String s) {
    return fromTerm(atermFactory.parse(s),idConv);
  }

  /**
   * Returns a gram.i.types.DefTipo from a Stream without any conversion
   *
   * @param stream stream containing the ATerm
   * @return the term from the Stream
   * @throws java.io.IOException if a problem occurs with the stream
   */
  public static gram.i.types.DefTipo fromStream(java.io.InputStream stream) throws java.io.IOException {
    return fromTerm(atermFactory.readFromFile(stream),idConv);
  }

  /**
   * Apply a conversion on the ATerm and returns a gram.i.types.DefTipo
   *
   * @param trm ATerm to convert into a Gom term
   * @param atConv ATermConverter used to convert the ATerm
   * @return the Gom term
   * @throws IllegalArgumentException
   */
  public static gram.i.types.DefTipo fromTerm(aterm.ATerm trm, tom.library.utils.ATermConverter atConv) {
    aterm.ATerm convertedTerm = atConv.convert(trm);
    gram.i.types.DefTipo tmp;
    java.util.ArrayList<gram.i.types.DefTipo> results = new java.util.ArrayList<gram.i.types.DefTipo>();

    tmp = gram.i.types.deftipo.DInt.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.deftipo.DChar.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.deftipo.DBoolean.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.deftipo.DFloat.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.deftipo.DVoid.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    switch(results.size()) {
      case 0:
        throw new IllegalArgumentException(trm + " is not a DefTipo");
      case 1:
        return results.get(0);
      default:
        java.util.logging.Logger.getLogger("DefTipo").log(java.util.logging.Level.WARNING,"There were many possibilities ({0}) in {1} but the first one was chosen: {2}",new Object[] {results.toString(), "gram.i.types.DefTipo", results.get(0).toString()});
        return results.get(0);
    }
  }

  /**
   * Apply a conversion on the ATerm contained in the String and returns a gram.i.types.DefTipo from it
   *
   * @param s String containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static gram.i.types.DefTipo fromString(String s, tom.library.utils.ATermConverter atConv) {
    return fromTerm(atermFactory.parse(s),atConv);
  }

  /**
   * Apply a conversion on the ATerm contained in the Stream and returns a gram.i.types.DefTipo from it
   *
   * @param stream stream containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static gram.i.types.DefTipo fromStream(java.io.InputStream stream, tom.library.utils.ATermConverter atConv) throws java.io.IOException {
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
  public gram.i.types.DefTipo reverse() {
    throw new IllegalArgumentException(
      "This "+this.getClass().getName()+" is not a list");
  }

  
  /*
   * Initialize the (cyclic) data-structure
   * in order to generate/enumerate terms
   */

  protected static tom.library.enumerator.Enumeration<gram.i.types.DefTipo> enumDefTipo = null;
  public static final tom.library.enumerator.Enumeration<gram.i.types.DefTipo> tmpenumDefTipo = new tom.library.enumerator.Enumeration<gram.i.types.DefTipo>((tom.library.enumerator.LazyList<tom.library.enumerator.Finite<gram.i.types.DefTipo>>) null);

  public static tom.library.enumerator.Enumeration<gram.i.types.DefTipo> getEnumeration() {
    if(enumDefTipo == null) { 
      enumDefTipo = gram.i.types.deftipo.DInt.funMake().apply(gram.i.types.DefTipo.tmpenumDefTipo)
        .plus(gram.i.types.deftipo.DChar.funMake().apply(gram.i.types.DefTipo.tmpenumDefTipo))
        .plus(gram.i.types.deftipo.DBoolean.funMake().apply(gram.i.types.DefTipo.tmpenumDefTipo))
        .plus(gram.i.types.deftipo.DFloat.funMake().apply(gram.i.types.DefTipo.tmpenumDefTipo))
        .plus(gram.i.types.deftipo.DVoid.funMake().apply(gram.i.types.DefTipo.tmpenumDefTipo));


      tmpenumDefTipo.p1 = new tom.library.enumerator.P1<tom.library.enumerator.LazyList<tom.library.enumerator.Finite<gram.i.types.DefTipo>>>() {
        public tom.library.enumerator.LazyList<tom.library.enumerator.Finite<gram.i.types.DefTipo>> _1() { return enumDefTipo.parts(); }
      };

    }
    return enumDefTipo;
  }

}

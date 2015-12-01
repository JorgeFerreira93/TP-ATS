
package maqv.msp.types;


public abstract class DefTipo extends maqv.msp.mspAbstractType  {
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
   * Returns a maqv.msp.types.DefTipo from an ATerm without any conversion
   *
   * @param trm ATerm to handle to retrieve a Gom term
   * @return the term from the ATerm
   */
  public static maqv.msp.types.DefTipo fromTerm(aterm.ATerm trm) {
    return fromTerm(trm,idConv);
  }

  /**
   * Returns a maqv.msp.types.DefTipo from a String without any conversion
   *
   * @param s String containing the ATerm
   * @return the term from the String
   */
  public static maqv.msp.types.DefTipo fromString(String s) {
    return fromTerm(atermFactory.parse(s),idConv);
  }

  /**
   * Returns a maqv.msp.types.DefTipo from a Stream without any conversion
   *
   * @param stream stream containing the ATerm
   * @return the term from the Stream
   * @throws java.io.IOException if a problem occurs with the stream
   */
  public static maqv.msp.types.DefTipo fromStream(java.io.InputStream stream) throws java.io.IOException {
    return fromTerm(atermFactory.readFromFile(stream),idConv);
  }

  /**
   * Apply a conversion on the ATerm and returns a maqv.msp.types.DefTipo
   *
   * @param trm ATerm to convert into a Gom term
   * @param atConv ATermConverter used to convert the ATerm
   * @return the Gom term
   * @throws IllegalArgumentException
   */
  public static maqv.msp.types.DefTipo fromTerm(aterm.ATerm trm, tom.library.utils.ATermConverter atConv) {
    aterm.ATerm convertedTerm = atConv.convert(trm);
    maqv.msp.types.DefTipo tmp;
    java.util.ArrayList<maqv.msp.types.DefTipo> results = new java.util.ArrayList<maqv.msp.types.DefTipo>();

    tmp = maqv.msp.types.deftipo.DInt.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = maqv.msp.types.deftipo.DChar.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = maqv.msp.types.deftipo.DBoolean.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = maqv.msp.types.deftipo.DFloat.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    switch(results.size()) {
      case 0:
        throw new IllegalArgumentException(trm + " is not a DefTipo");
      case 1:
        return results.get(0);
      default:
        java.util.logging.Logger.getLogger("DefTipo").log(java.util.logging.Level.WARNING,"There were many possibilities ({0}) in {1} but the first one was chosen: {2}",new Object[] {results.toString(), "maqv.msp.types.DefTipo", results.get(0).toString()});
        return results.get(0);
    }
  }

  /**
   * Apply a conversion on the ATerm contained in the String and returns a maqv.msp.types.DefTipo from it
   *
   * @param s String containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static maqv.msp.types.DefTipo fromString(String s, tom.library.utils.ATermConverter atConv) {
    return fromTerm(atermFactory.parse(s),atConv);
  }

  /**
   * Apply a conversion on the ATerm contained in the Stream and returns a maqv.msp.types.DefTipo from it
   *
   * @param stream stream containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static maqv.msp.types.DefTipo fromStream(java.io.InputStream stream, tom.library.utils.ATermConverter atConv) throws java.io.IOException {
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
  public maqv.msp.types.DefTipo reverse() {
    throw new IllegalArgumentException(
      "This "+this.getClass().getName()+" is not a list");
  }

  
  /*
   * Initialize the (cyclic) data-structure
   * in order to generate/enumerate terms
   */

  protected static tom.library.enumerator.Enumeration<maqv.msp.types.DefTipo> enumDefTipo = null;
  public static final tom.library.enumerator.Enumeration<maqv.msp.types.DefTipo> tmpenumDefTipo = new tom.library.enumerator.Enumeration<maqv.msp.types.DefTipo>((tom.library.enumerator.LazyList<tom.library.enumerator.Finite<maqv.msp.types.DefTipo>>) null);

  public static tom.library.enumerator.Enumeration<maqv.msp.types.DefTipo> getEnumeration() {
    if(enumDefTipo == null) { 
      enumDefTipo = maqv.msp.types.deftipo.DInt.funMake().apply(maqv.msp.types.DefTipo.tmpenumDefTipo)
        .plus(maqv.msp.types.deftipo.DChar.funMake().apply(maqv.msp.types.DefTipo.tmpenumDefTipo))
        .plus(maqv.msp.types.deftipo.DBoolean.funMake().apply(maqv.msp.types.DefTipo.tmpenumDefTipo))
        .plus(maqv.msp.types.deftipo.DFloat.funMake().apply(maqv.msp.types.DefTipo.tmpenumDefTipo));


      tmpenumDefTipo.p1 = new tom.library.enumerator.P1<tom.library.enumerator.LazyList<tom.library.enumerator.Finite<maqv.msp.types.DefTipo>>>() {
        public tom.library.enumerator.LazyList<tom.library.enumerator.Finite<maqv.msp.types.DefTipo>> _1() { return enumDefTipo.parts(); }
      };

    }
    return enumDefTipo;
  }

}

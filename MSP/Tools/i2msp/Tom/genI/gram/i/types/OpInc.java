
package gram.i.types;


public abstract class OpInc extends gram.i.iAbstractType  {
  /**
   * Sole constructor.  (For invocation by subclass
   * constructors, typically implicit.)
   */
  protected OpInc() {}



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
   * Returns a gram.i.types.OpInc from an ATerm without any conversion
   *
   * @param trm ATerm to handle to retrieve a Gom term
   * @return the term from the ATerm
   */
  public static gram.i.types.OpInc fromTerm(aterm.ATerm trm) {
    return fromTerm(trm,idConv);
  }

  /**
   * Returns a gram.i.types.OpInc from a String without any conversion
   *
   * @param s String containing the ATerm
   * @return the term from the String
   */
  public static gram.i.types.OpInc fromString(String s) {
    return fromTerm(atermFactory.parse(s),idConv);
  }

  /**
   * Returns a gram.i.types.OpInc from a Stream without any conversion
   *
   * @param stream stream containing the ATerm
   * @return the term from the Stream
   * @throws java.io.IOException if a problem occurs with the stream
   */
  public static gram.i.types.OpInc fromStream(java.io.InputStream stream) throws java.io.IOException {
    return fromTerm(atermFactory.readFromFile(stream),idConv);
  }

  /**
   * Apply a conversion on the ATerm and returns a gram.i.types.OpInc
   *
   * @param trm ATerm to convert into a Gom term
   * @param atConv ATermConverter used to convert the ATerm
   * @return the Gom term
   * @throws IllegalArgumentException
   */
  public static gram.i.types.OpInc fromTerm(aterm.ATerm trm, tom.library.utils.ATermConverter atConv) {
    aterm.ATerm convertedTerm = atConv.convert(trm);
    gram.i.types.OpInc tmp;
    java.util.ArrayList<gram.i.types.OpInc> results = new java.util.ArrayList<gram.i.types.OpInc>();

    tmp = gram.i.types.opinc.Inc.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.opinc.Dec.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    switch(results.size()) {
      case 0:
        throw new IllegalArgumentException(trm + " is not a OpInc");
      case 1:
        return results.get(0);
      default:
        java.util.logging.Logger.getLogger("OpInc").log(java.util.logging.Level.WARNING,"There were many possibilities ({0}) in {1} but the first one was chosen: {2}",new Object[] {results.toString(), "gram.i.types.OpInc", results.get(0).toString()});
        return results.get(0);
    }
  }

  /**
   * Apply a conversion on the ATerm contained in the String and returns a gram.i.types.OpInc from it
   *
   * @param s String containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static gram.i.types.OpInc fromString(String s, tom.library.utils.ATermConverter atConv) {
    return fromTerm(atermFactory.parse(s),atConv);
  }

  /**
   * Apply a conversion on the ATerm contained in the Stream and returns a gram.i.types.OpInc from it
   *
   * @param stream stream containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static gram.i.types.OpInc fromStream(java.io.InputStream stream, tom.library.utils.ATermConverter atConv) throws java.io.IOException {
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
  public gram.i.types.OpInc reverse() {
    throw new IllegalArgumentException(
      "This "+this.getClass().getName()+" is not a list");
  }

  
  /*
   * Initialize the (cyclic) data-structure
   * in order to generate/enumerate terms
   */

  protected static tom.library.enumerator.Enumeration<gram.i.types.OpInc> enumOpInc = null;
  public static final tom.library.enumerator.Enumeration<gram.i.types.OpInc> tmpenumOpInc = new tom.library.enumerator.Enumeration<gram.i.types.OpInc>((tom.library.enumerator.LazyList<tom.library.enumerator.Finite<gram.i.types.OpInc>>) null);

  public static tom.library.enumerator.Enumeration<gram.i.types.OpInc> getEnumeration() {
    if(enumOpInc == null) { 
      enumOpInc = gram.i.types.opinc.Inc.funMake().apply(gram.i.types.OpInc.tmpenumOpInc)
        .plus(gram.i.types.opinc.Dec.funMake().apply(gram.i.types.OpInc.tmpenumOpInc));


      tmpenumOpInc.p1 = new tom.library.enumerator.P1<tom.library.enumerator.LazyList<tom.library.enumerator.Finite<gram.i.types.OpInc>>>() {
        public tom.library.enumerator.LazyList<tom.library.enumerator.Finite<gram.i.types.OpInc>> _1() { return enumOpInc.parts(); }
      };

    }
    return enumOpInc;
  }

}


package maqv.msp.types;


public abstract class Stackk extends maqv.msp.mspAbstractType  {
  /**
   * Sole constructor.  (For invocation by subclass
   * constructors, typically implicit.)
   */
  protected Stackk() {}



  /**
   * Returns true if the term is rooted by the symbol ConsStackk
   *
   * @return true if the term is rooted by the symbol ConsStackk
   */
  public boolean isConsStackk() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol EmptyStackk
   *
   * @return true if the term is rooted by the symbol EmptyStackk
   */
  public boolean isEmptyStackk() {
    return false;
  }

  /**
   * Returns the subterm corresponding to the slot TailStackk
   *
   * @return the subterm corresponding to the slot TailStackk
   */
  public maqv.msp.types.Stackk getTailStackk() {
    throw new UnsupportedOperationException("This Stackk has no TailStackk");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot TailStackk
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot TailStackk is replaced by _arg
   */
  public Stackk setTailStackk(maqv.msp.types.Stackk _arg) {
    throw new UnsupportedOperationException("This Stackk has no TailStackk");
  }

  /**
   * Returns the subterm corresponding to the slot HeadStackk
   *
   * @return the subterm corresponding to the slot HeadStackk
   */
  public maqv.msp.types.Termo getHeadStackk() {
    throw new UnsupportedOperationException("This Stackk has no HeadStackk");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot HeadStackk
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot HeadStackk is replaced by _arg
   */
  public Stackk setHeadStackk(maqv.msp.types.Termo _arg) {
    throw new UnsupportedOperationException("This Stackk has no HeadStackk");
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
   * Returns a maqv.msp.types.Stackk from an ATerm without any conversion
   *
   * @param trm ATerm to handle to retrieve a Gom term
   * @return the term from the ATerm
   */
  public static maqv.msp.types.Stackk fromTerm(aterm.ATerm trm) {
    return fromTerm(trm,idConv);
  }

  /**
   * Returns a maqv.msp.types.Stackk from a String without any conversion
   *
   * @param s String containing the ATerm
   * @return the term from the String
   */
  public static maqv.msp.types.Stackk fromString(String s) {
    return fromTerm(atermFactory.parse(s),idConv);
  }

  /**
   * Returns a maqv.msp.types.Stackk from a Stream without any conversion
   *
   * @param stream stream containing the ATerm
   * @return the term from the Stream
   * @throws java.io.IOException if a problem occurs with the stream
   */
  public static maqv.msp.types.Stackk fromStream(java.io.InputStream stream) throws java.io.IOException {
    return fromTerm(atermFactory.readFromFile(stream),idConv);
  }

  /**
   * Apply a conversion on the ATerm and returns a maqv.msp.types.Stackk
   *
   * @param trm ATerm to convert into a Gom term
   * @param atConv ATermConverter used to convert the ATerm
   * @return the Gom term
   * @throws IllegalArgumentException
   */
  public static maqv.msp.types.Stackk fromTerm(aterm.ATerm trm, tom.library.utils.ATermConverter atConv) {
    aterm.ATerm convertedTerm = atConv.convert(trm);
    maqv.msp.types.Stackk tmp;
    java.util.ArrayList<maqv.msp.types.Stackk> results = new java.util.ArrayList<maqv.msp.types.Stackk>();

    tmp = maqv.msp.types.stackk.ConsStackk.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = maqv.msp.types.stackk.EmptyStackk.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = maqv.msp.types.stackk.Stackk.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    switch(results.size()) {
      case 0:
        throw new IllegalArgumentException(trm + " is not a Stackk");
      case 1:
        return results.get(0);
      default:
        java.util.logging.Logger.getLogger("Stackk").log(java.util.logging.Level.WARNING,"There were many possibilities ({0}) in {1} but the first one was chosen: {2}",new Object[] {results.toString(), "maqv.msp.types.Stackk", results.get(0).toString()});
        return results.get(0);
    }
  }

  /**
   * Apply a conversion on the ATerm contained in the String and returns a maqv.msp.types.Stackk from it
   *
   * @param s String containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static maqv.msp.types.Stackk fromString(String s, tom.library.utils.ATermConverter atConv) {
    return fromTerm(atermFactory.parse(s),atConv);
  }

  /**
   * Apply a conversion on the ATerm contained in the Stream and returns a maqv.msp.types.Stackk from it
   *
   * @param stream stream containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static maqv.msp.types.Stackk fromStream(java.io.InputStream stream, tom.library.utils.ATermConverter atConv) throws java.io.IOException {
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
  public maqv.msp.types.Stackk reverse() {
    throw new IllegalArgumentException(
      "This "+this.getClass().getName()+" is not a list");
  }

  
  /**
   * Returns a Collection extracted from the term
   *
   * @return the collection
   * @throws UnsupportedOperationException if the term is not a list
   */
  public java.util.Collection<maqv.msp.types.Termo> getCollectionStackk() {
    throw new UnsupportedOperationException("This Stackk cannot be converted into a Collection");
  }
          
  /*
   * Initialize the (cyclic) data-structure
   * in order to generate/enumerate terms
   */

  protected static tom.library.enumerator.Enumeration<maqv.msp.types.Stackk> enumStackk = null;
  public static final tom.library.enumerator.Enumeration<maqv.msp.types.Stackk> tmpenumStackk = new tom.library.enumerator.Enumeration<maqv.msp.types.Stackk>((tom.library.enumerator.LazyList<tom.library.enumerator.Finite<maqv.msp.types.Stackk>>) null);

  public static tom.library.enumerator.Enumeration<maqv.msp.types.Stackk> getEnumeration() {
    if(enumStackk == null) { 
      enumStackk = null;


      tmpenumStackk.p1 = new tom.library.enumerator.P1<tom.library.enumerator.LazyList<tom.library.enumerator.Finite<maqv.msp.types.Stackk>>>() {
        public tom.library.enumerator.LazyList<tom.library.enumerator.Finite<maqv.msp.types.Stackk>> _1() { return enumStackk.parts(); }
      };

    }
    return enumStackk;
  }

}

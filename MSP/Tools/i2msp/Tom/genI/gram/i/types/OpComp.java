
package gram.i.types;


public abstract class OpComp extends gram.i.iAbstractType  {
  /**
   * Sole constructor.  (For invocation by subclass
   * constructors, typically implicit.)
   */
  protected OpComp() {}



  /**
   * Returns true if the term is rooted by the symbol Maior
   *
   * @return true if the term is rooted by the symbol Maior
   */
  public boolean isMaior() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Menor
   *
   * @return true if the term is rooted by the symbol Menor
   */
  public boolean isMenor() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol MaiorQ
   *
   * @return true if the term is rooted by the symbol MaiorQ
   */
  public boolean isMaiorQ() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol MenorQ
   *
   * @return true if the term is rooted by the symbol MenorQ
   */
  public boolean isMenorQ() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Dif
   *
   * @return true if the term is rooted by the symbol Dif
   */
  public boolean isDif() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Igual
   *
   * @return true if the term is rooted by the symbol Igual
   */
  public boolean isIgual() {
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
   * Returns a gram.i.types.OpComp from an ATerm without any conversion
   *
   * @param trm ATerm to handle to retrieve a Gom term
   * @return the term from the ATerm
   */
  public static gram.i.types.OpComp fromTerm(aterm.ATerm trm) {
    return fromTerm(trm,idConv);
  }

  /**
   * Returns a gram.i.types.OpComp from a String without any conversion
   *
   * @param s String containing the ATerm
   * @return the term from the String
   */
  public static gram.i.types.OpComp fromString(String s) {
    return fromTerm(atermFactory.parse(s),idConv);
  }

  /**
   * Returns a gram.i.types.OpComp from a Stream without any conversion
   *
   * @param stream stream containing the ATerm
   * @return the term from the Stream
   * @throws java.io.IOException if a problem occurs with the stream
   */
  public static gram.i.types.OpComp fromStream(java.io.InputStream stream) throws java.io.IOException {
    return fromTerm(atermFactory.readFromFile(stream),idConv);
  }

  /**
   * Apply a conversion on the ATerm and returns a gram.i.types.OpComp
   *
   * @param trm ATerm to convert into a Gom term
   * @param atConv ATermConverter used to convert the ATerm
   * @return the Gom term
   * @throws IllegalArgumentException
   */
  public static gram.i.types.OpComp fromTerm(aterm.ATerm trm, tom.library.utils.ATermConverter atConv) {
    aterm.ATerm convertedTerm = atConv.convert(trm);
    gram.i.types.OpComp tmp;
    java.util.ArrayList<gram.i.types.OpComp> results = new java.util.ArrayList<gram.i.types.OpComp>();

    tmp = gram.i.types.opcomp.Maior.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.opcomp.Menor.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.opcomp.MaiorQ.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.opcomp.MenorQ.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.opcomp.Dif.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.opcomp.Igual.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    switch(results.size()) {
      case 0:
        throw new IllegalArgumentException(trm + " is not a OpComp");
      case 1:
        return results.get(0);
      default:
        java.util.logging.Logger.getLogger("OpComp").log(java.util.logging.Level.WARNING,"There were many possibilities ({0}) in {1} but the first one was chosen: {2}",new Object[] {results.toString(), "gram.i.types.OpComp", results.get(0).toString()});
        return results.get(0);
    }
  }

  /**
   * Apply a conversion on the ATerm contained in the String and returns a gram.i.types.OpComp from it
   *
   * @param s String containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static gram.i.types.OpComp fromString(String s, tom.library.utils.ATermConverter atConv) {
    return fromTerm(atermFactory.parse(s),atConv);
  }

  /**
   * Apply a conversion on the ATerm contained in the Stream and returns a gram.i.types.OpComp from it
   *
   * @param stream stream containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static gram.i.types.OpComp fromStream(java.io.InputStream stream, tom.library.utils.ATermConverter atConv) throws java.io.IOException {
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
  public gram.i.types.OpComp reverse() {
    throw new IllegalArgumentException(
      "This "+this.getClass().getName()+" is not a list");
  }

  
  /*
   * Initialize the (cyclic) data-structure
   * in order to generate/enumerate terms
   */

  protected static tom.library.enumerator.Enumeration<gram.i.types.OpComp> enumOpComp = null;
  public static final tom.library.enumerator.Enumeration<gram.i.types.OpComp> tmpenumOpComp = new tom.library.enumerator.Enumeration<gram.i.types.OpComp>((tom.library.enumerator.LazyList<tom.library.enumerator.Finite<gram.i.types.OpComp>>) null);

  public static tom.library.enumerator.Enumeration<gram.i.types.OpComp> getEnumeration() {
    if(enumOpComp == null) { 
      enumOpComp = gram.i.types.opcomp.Maior.funMake().apply(gram.i.types.OpComp.tmpenumOpComp)
        .plus(gram.i.types.opcomp.Menor.funMake().apply(gram.i.types.OpComp.tmpenumOpComp))
        .plus(gram.i.types.opcomp.MaiorQ.funMake().apply(gram.i.types.OpComp.tmpenumOpComp))
        .plus(gram.i.types.opcomp.MenorQ.funMake().apply(gram.i.types.OpComp.tmpenumOpComp))
        .plus(gram.i.types.opcomp.Dif.funMake().apply(gram.i.types.OpComp.tmpenumOpComp))
        .plus(gram.i.types.opcomp.Igual.funMake().apply(gram.i.types.OpComp.tmpenumOpComp));


      tmpenumOpComp.p1 = new tom.library.enumerator.P1<tom.library.enumerator.LazyList<tom.library.enumerator.Finite<gram.i.types.OpComp>>>() {
        public tom.library.enumerator.LazyList<tom.library.enumerator.Finite<gram.i.types.OpComp>> _1() { return enumOpComp.parts(); }
      };

    }
    return enumOpComp;
  }

}

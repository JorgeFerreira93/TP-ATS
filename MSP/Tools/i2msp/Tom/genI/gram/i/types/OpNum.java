
package gram.i.types;


public abstract class OpNum extends gram.i.iAbstractType  {
  /**
   * Sole constructor.  (For invocation by subclass
   * constructors, typically implicit.)
   */
  protected OpNum() {}



  /**
   * Returns true if the term is rooted by the symbol Mais
   *
   * @return true if the term is rooted by the symbol Mais
   */
  public boolean isMais() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Vezes
   *
   * @return true if the term is rooted by the symbol Vezes
   */
  public boolean isVezes() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Divide
   *
   * @return true if the term is rooted by the symbol Divide
   */
  public boolean isDivide() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Menos
   *
   * @return true if the term is rooted by the symbol Menos
   */
  public boolean isMenos() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Mod
   *
   * @return true if the term is rooted by the symbol Mod
   */
  public boolean isMod() {
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
   * Returns a gram.i.types.OpNum from an ATerm without any conversion
   *
   * @param trm ATerm to handle to retrieve a Gom term
   * @return the term from the ATerm
   */
  public static gram.i.types.OpNum fromTerm(aterm.ATerm trm) {
    return fromTerm(trm,idConv);
  }

  /**
   * Returns a gram.i.types.OpNum from a String without any conversion
   *
   * @param s String containing the ATerm
   * @return the term from the String
   */
  public static gram.i.types.OpNum fromString(String s) {
    return fromTerm(atermFactory.parse(s),idConv);
  }

  /**
   * Returns a gram.i.types.OpNum from a Stream without any conversion
   *
   * @param stream stream containing the ATerm
   * @return the term from the Stream
   * @throws java.io.IOException if a problem occurs with the stream
   */
  public static gram.i.types.OpNum fromStream(java.io.InputStream stream) throws java.io.IOException {
    return fromTerm(atermFactory.readFromFile(stream),idConv);
  }

  /**
   * Apply a conversion on the ATerm and returns a gram.i.types.OpNum
   *
   * @param trm ATerm to convert into a Gom term
   * @param atConv ATermConverter used to convert the ATerm
   * @return the Gom term
   * @throws IllegalArgumentException
   */
  public static gram.i.types.OpNum fromTerm(aterm.ATerm trm, tom.library.utils.ATermConverter atConv) {
    aterm.ATerm convertedTerm = atConv.convert(trm);
    gram.i.types.OpNum tmp;
    java.util.ArrayList<gram.i.types.OpNum> results = new java.util.ArrayList<gram.i.types.OpNum>();

    tmp = gram.i.types.opnum.Mais.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.opnum.Vezes.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.opnum.Divide.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.opnum.Menos.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = gram.i.types.opnum.Mod.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    switch(results.size()) {
      case 0:
        throw new IllegalArgumentException(trm + " is not a OpNum");
      case 1:
        return results.get(0);
      default:
        java.util.logging.Logger.getLogger("OpNum").log(java.util.logging.Level.WARNING,"There were many possibilities ({0}) in {1} but the first one was chosen: {2}",new Object[] {results.toString(), "gram.i.types.OpNum", results.get(0).toString()});
        return results.get(0);
    }
  }

  /**
   * Apply a conversion on the ATerm contained in the String and returns a gram.i.types.OpNum from it
   *
   * @param s String containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static gram.i.types.OpNum fromString(String s, tom.library.utils.ATermConverter atConv) {
    return fromTerm(atermFactory.parse(s),atConv);
  }

  /**
   * Apply a conversion on the ATerm contained in the Stream and returns a gram.i.types.OpNum from it
   *
   * @param stream stream containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static gram.i.types.OpNum fromStream(java.io.InputStream stream, tom.library.utils.ATermConverter atConv) throws java.io.IOException {
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
  public gram.i.types.OpNum reverse() {
    throw new IllegalArgumentException(
      "This "+this.getClass().getName()+" is not a list");
  }

  
  /*
   * Initialize the (cyclic) data-structure
   * in order to generate/enumerate terms
   */

  protected static tom.library.enumerator.Enumeration<gram.i.types.OpNum> enumOpNum = null;
  public static final tom.library.enumerator.Enumeration<gram.i.types.OpNum> tmpenumOpNum = new tom.library.enumerator.Enumeration<gram.i.types.OpNum>((tom.library.enumerator.LazyList<tom.library.enumerator.Finite<gram.i.types.OpNum>>) null);

  public static tom.library.enumerator.Enumeration<gram.i.types.OpNum> getEnumeration() {
    if(enumOpNum == null) { 
      enumOpNum = gram.i.types.opnum.Mais.funMake().apply(gram.i.types.OpNum.tmpenumOpNum)
        .plus(gram.i.types.opnum.Vezes.funMake().apply(gram.i.types.OpNum.tmpenumOpNum))
        .plus(gram.i.types.opnum.Divide.funMake().apply(gram.i.types.OpNum.tmpenumOpNum))
        .plus(gram.i.types.opnum.Menos.funMake().apply(gram.i.types.OpNum.tmpenumOpNum))
        .plus(gram.i.types.opnum.Mod.funMake().apply(gram.i.types.OpNum.tmpenumOpNum));


      tmpenumOpNum.p1 = new tom.library.enumerator.P1<tom.library.enumerator.LazyList<tom.library.enumerator.Finite<gram.i.types.OpNum>>>() {
        public tom.library.enumerator.LazyList<tom.library.enumerator.Finite<gram.i.types.OpNum>> _1() { return enumOpNum.parts(); }
      };

    }
    return enumOpNum;
  }

}

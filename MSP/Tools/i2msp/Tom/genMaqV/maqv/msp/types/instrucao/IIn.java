
package maqv.msp.types.instrucao;



public final class IIn extends maqv.msp.types.Instrucao implements tom.library.sl.Visitable  {
  
  private static String symbolName = "IIn";


  private IIn() {}
  private int hashCode;
  private static IIn gomProto = new IIn();
    private maqv.msp.types.DefTipo _tipo;

  /**
   * Constructor that builds a term rooted by IIn
   *
   * @return a term rooted by IIn
   */

  public static IIn make(maqv.msp.types.DefTipo _tipo) {

    // use the proto as a model
    gomProto.initHashCode( _tipo);
    return (IIn) factory.build(gomProto);

  }

  /**
   * Initializes attributes and hashcode of the class
   *
   * @param  _tipo
   * @param hashCode hashCode of IIn
   */
  private void init(maqv.msp.types.DefTipo _tipo, int hashCode) {
    this._tipo = _tipo;

    this.hashCode = hashCode;
  }

  /**
   * Initializes attributes and hashcode of the class
   *
   * @param  _tipo
   */
  private void initHashCode(maqv.msp.types.DefTipo _tipo) {
    this._tipo = _tipo;

    this.hashCode = hashFunction();
  }

  /* name and arity */

  /**
   * Returns the name of the symbol
   *
   * @return the name of the symbol
   */
  @Override
  public String symbolName() {
    return "IIn";
  }

  /**
   * Returns the arity of the symbol
   *
   * @return the arity of the symbol
   */
  private int getArity() {
    return 1;
  }

  /**
   * Copy the object and returns the copy
   *
   * @return a clone of the SharedObject
   */
  public shared.SharedObject duplicate() {
    IIn clone = new IIn();
    clone.init( _tipo, hashCode);
    return clone;
  }
  
  /**
   * Appends a string representation of this term to the buffer given as argument.
   *
   * @param buffer the buffer to which a string represention of this term is appended.
   */
  @Override
  public void toStringBuilder(java.lang.StringBuilder buffer) {
    buffer.append("IIn(");
    _tipo.toStringBuilder(buffer);

    buffer.append(")");
  }


  /**
   * Compares two terms. This functions implements a total lexicographic path ordering.
   *
   * @param o object to which this term is compared
   * @return a negative integer, zero, or a positive integer as this
   *         term is less than, equal to, or greater than the argument
   * @throws ClassCastException in case of invalid arguments
   * @throws RuntimeException if unable to compare children
   */
  @Override
  public int compareToLPO(Object o) {
    /*
     * We do not want to compare with any object, only members of the module
     * In case of invalid argument, throw a ClassCastException, as the java api
     * asks for it
     */
    maqv.msp.mspAbstractType ao = (maqv.msp.mspAbstractType) o;
    /* return 0 for equality */
    if (ao == this) { return 0; }
    /* compare the symbols */
    int symbCmp = this.symbolName().compareTo(ao.symbolName());
    if (symbCmp != 0) { return symbCmp; }
    /* compare the children */
    IIn tco = (IIn) ao;
    int _tipoCmp = (this._tipo).compareToLPO(tco._tipo);
    if(_tipoCmp != 0) {
      return _tipoCmp;
    }

    throw new RuntimeException("Unable to compare");
  }

 /**
   * Compares two terms. This functions implements a total order.
   *
   * @param o object to which this term is compared
   * @return a negative integer, zero, or a positive integer as this
   *         term is less than, equal to, or greater than the argument
   * @throws ClassCastException in case of invalid arguments
   * @throws RuntimeException if unable to compare children
   */
  @Override
  public int compareTo(Object o) {
    /*
     * We do not want to compare with any object, only members of the module
     * In case of invalid argument, throw a ClassCastException, as the java api
     * asks for it
     */
    maqv.msp.mspAbstractType ao = (maqv.msp.mspAbstractType) o;
    /* return 0 for equality */
    if (ao == this) { return 0; }
    /* use the hash values to discriminate */

    if(hashCode != ao.hashCode()) { return (hashCode < ao.hashCode())?-1:1; }

    /* If not, compare the symbols : back to the normal order */
    int symbCmp = this.symbolName().compareTo(ao.symbolName());
    if (symbCmp != 0) { return symbCmp; }
    /* last resort: compare the children */
    IIn tco = (IIn) ao;
    int _tipoCmp = (this._tipo).compareTo(tco._tipo);
    if(_tipoCmp != 0) {
      return _tipoCmp;
    }

    throw new RuntimeException("Unable to compare");
  }

 //shared.SharedObject
  /**
   * Returns hashCode
   *
   * @return hashCode
   */
  @Override
  public final int hashCode() {
    return hashCode;
  }

  /**
   * Checks if a SharedObject is equivalent to the current object
   *
   * @param obj SharedObject to test
   * @return true if obj is a IIn and its members are equal, else false
   */
  public final boolean equivalent(shared.SharedObject obj) {
    if(obj instanceof IIn) {

      IIn peer = (IIn) obj;
      return _tipo==peer._tipo && true;
    }
    return false;
  }


   //Instrucao interface
  /**
   * Returns true if the term is rooted by the symbol IIn
   *
   * @return true, because this is rooted by IIn
   */
  @Override
  public boolean isIIn() {
    return true;
  }
  
  /**
   * Returns the attribute maqv.msp.types.DefTipo
   *
   * @return the attribute maqv.msp.types.DefTipo
   */
  @Override
  public maqv.msp.types.DefTipo gettipo() {
    return _tipo;
  }

  /**
   * Sets and returns the attribute maqv.msp.types.Instrucao
   *
   * @param set_arg the argument to set
   * @return the attribute maqv.msp.types.DefTipo which just has been set
   */
  @Override
  public maqv.msp.types.Instrucao settipo(maqv.msp.types.DefTipo set_arg) {
    return make(set_arg);
  }
  
  /* AbstractType */
  /**
   * Returns an ATerm representation of this term.
   *
   * @return an ATerm representation of this term.
   */
  @Override
  public aterm.ATerm toATerm() {
    aterm.ATerm res = super.toATerm();
    if(res != null) {
      // the super class has produced an ATerm (may be a variadic operator)
      return res;
    }
    return atermFactory.makeAppl(
      atermFactory.makeAFun(symbolName(),getArity(),false),
      new aterm.ATerm[] {gettipo().toATerm()});
  }

  /**
   * Apply a conversion on the ATerm contained in the String and returns a maqv.msp.types.Instrucao from it
   *
   * @param trm ATerm to convert into a Gom term
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static maqv.msp.types.Instrucao fromTerm(aterm.ATerm trm, tom.library.utils.ATermConverter atConv) {
    trm = atConv.convert(trm);
    if(trm instanceof aterm.ATermAppl) {
      aterm.ATermAppl appl = (aterm.ATermAppl) trm;
      if(symbolName.equals(appl.getName()) && !appl.getAFun().isQuoted()) {
        return make(
maqv.msp.types.DefTipo.fromTerm(appl.getArgument(0),atConv)
        );
      }
    }
    return null;
  }

  /* Visitable */
  /**
   * Returns the number of children of the term
   *
   * @return the number of children of the term
   */
  public int getChildCount() {
    return 1;
  }

  /**
   * Returns the child at the specified index
   *
   * @param index index of the child to return; must be
             nonnegative and less than the childCount
   * @return the child at the specified index
   * @throws IndexOutOfBoundsException if the index out of range
   */
  public tom.library.sl.Visitable getChildAt(int index) {
        switch(index) {
      case 0: return _tipo;
      default: throw new IndexOutOfBoundsException();
 }
 }

  /**
   * Set the child at the specified index
   *
   * @param index index of the child to set; must be
             nonnegative and less than the childCount
   * @param v child to set at the specified index
   * @return the child which was just set
   * @throws IndexOutOfBoundsException if the index out of range
   */
  public tom.library.sl.Visitable setChildAt(int index, tom.library.sl.Visitable v) {
        switch(index) {
      case 0: return make((maqv.msp.types.DefTipo) v);
      default: throw new IndexOutOfBoundsException();
 }
  }

  /**
   * Set children to the term
   *
   * @param children array of children to set
   * @return an array of children which just were set
   * @throws IndexOutOfBoundsException if length of "children" is different than 1
   */
  @SuppressWarnings("unchecked")
  public tom.library.sl.Visitable setChildren(tom.library.sl.Visitable[] children) {
    if (children.length == getChildCount()  && children[0] instanceof maqv.msp.types.DefTipo) {
      return make((maqv.msp.types.DefTipo) children[0]);
    } else {
      throw new IndexOutOfBoundsException();
    }
  }

  /**
   * Returns the whole children of the term
   *
   * @return the children of the term
   */
  public tom.library.sl.Visitable[] getChildren() {
    return new tom.library.sl.Visitable[] { _tipo};
  }

    /**
     * Compute a hashcode for this term.
     * (for internal use)
     *
     * @return a hash value
     */
  protected int hashFunction() {
    int a, b, c;
    /* Set up the internal state */
    a = 0x9e3779b9; /* the golden ratio; an arbitrary value */
    b = (1425239314<<8);
    c = getArity();
    /* -------------------------------------- handle most of the key */
    /* ------------------------------------ handle the last 11 bytes */
    a += (_tipo.hashCode());

    a -= b; a -= c; a ^= (c >> 13);
    b -= c; b -= a; b ^= (a << 8);
    c -= a; c -= b; c ^= (b >> 13);
    a -= b; a -= c; a ^= (c >> 12);
    b -= c; b -= a; b ^= (a << 16);
    c -= a; c -= b; c ^= (b >> 5);
    a -= b; a -= c; a ^= (c >> 3);
    b -= c; b -= a; b ^= (a << 10);
    c -= a; c -= b; c ^= (b >> 15);
    /* ------------------------------------------- report the result */
    return c;
  }

  /**
    * function that returns functional version of the current operator
    * need for initializing the Enumerator
    */
  public static tom.library.enumerator.F<tom.library.enumerator.Enumeration<maqv.msp.types.DefTipo>,tom.library.enumerator.Enumeration<maqv.msp.types.Instrucao>> funMake() {
    return 
        new tom.library.enumerator.F<tom.library.enumerator.Enumeration<maqv.msp.types.DefTipo>,tom.library.enumerator.Enumeration<maqv.msp.types.Instrucao>>() {
          public tom.library.enumerator.Enumeration<maqv.msp.types.Instrucao> apply(final tom.library.enumerator.Enumeration<maqv.msp.types.DefTipo> t1) {
            return tom.library.enumerator.Enumeration.apply(tom.library.enumerator.Enumeration.singleton((tom.library.enumerator.F<maqv.msp.types.DefTipo,maqv.msp.types.Instrucao>) 
        new tom.library.enumerator.F<maqv.msp.types.DefTipo,maqv.msp.types.Instrucao>() {
          public maqv.msp.types.Instrucao apply(final maqv.msp.types.DefTipo t1) {
            return make(t1);
          }
        }),t1).pay();
          }
        };
  }

}

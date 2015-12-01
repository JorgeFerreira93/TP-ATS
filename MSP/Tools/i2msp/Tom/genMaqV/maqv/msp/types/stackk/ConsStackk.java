
package maqv.msp.types.stackk;



public final class ConsStackk extends maqv.msp.types.stackk.Stackk implements tom.library.sl.Visitable  {
  
  private static String symbolName = "ConsStackk";


  private ConsStackk() {}
  private int hashCode;
  private static ConsStackk gomProto = new ConsStackk();
  
   private maqv.msp.types.Termo[] children;
                  private maqv.msp.types.Termo _HeadStackk;
  private maqv.msp.types.Stackk _TailStackk;

  /**
   * Constructor that builds a term rooted by ConsStackk
   *
   * @return a term rooted by ConsStackk
   */

  public static ConsStackk make(maqv.msp.types.Termo _HeadStackk, maqv.msp.types.Stackk _TailStackk) {

    // use the proto as a model
    gomProto.initHashCode( _HeadStackk,  _TailStackk);
    return (ConsStackk) factory.build(gomProto);

  }

  /**
   * Initializes attributes and hashcode of the class
   *
   * @param  _HeadStackk
   * @param _TailStackk
   * @param hashCode hashCode of ConsStackk
   */
  private void init(maqv.msp.types.Termo _HeadStackk, maqv.msp.types.Stackk _TailStackk, int hashCode) {
    this._HeadStackk = _HeadStackk;
    this._TailStackk = _TailStackk;

    this.hashCode = hashCode;
  }

  /**
   * Initializes attributes and hashcode of the class
   *
   * @param  _HeadStackk
   * @param _TailStackk
   */
  private void initHashCode(maqv.msp.types.Termo _HeadStackk, maqv.msp.types.Stackk _TailStackk) {
    this._HeadStackk = _HeadStackk;
    this._TailStackk = _TailStackk;

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
    return "ConsStackk";
  }

  /**
   * Returns the arity of the symbol
   *
   * @return the arity of the symbol
   */
  private int getArity() {
    return 2;
  }

  /**
   * Copy the object and returns the copy
   *
   * @return a clone of the SharedObject
   */
  public shared.SharedObject duplicate() {
    ConsStackk clone = new ConsStackk();
    clone.init( _HeadStackk,  _TailStackk, hashCode);
    return clone;
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
    ConsStackk tco = (ConsStackk) ao;
    int _HeadStackkCmp = (this._HeadStackk).compareToLPO(tco._HeadStackk);
    if(_HeadStackkCmp != 0) {
      return _HeadStackkCmp;
    }

    int _TailStackkCmp = (this._TailStackk).compareToLPO(tco._TailStackk);
    if(_TailStackkCmp != 0) {
      return _TailStackkCmp;
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
    ConsStackk tco = (ConsStackk) ao;
    int _HeadStackkCmp = (this._HeadStackk).compareTo(tco._HeadStackk);
    if(_HeadStackkCmp != 0) {
      return _HeadStackkCmp;
    }

    int _TailStackkCmp = (this._TailStackk).compareTo(tco._TailStackk);
    if(_TailStackkCmp != 0) {
      return _TailStackkCmp;
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
   * @return true if obj is a ConsStackk and its members are equal, else false
   */
  public final boolean equivalent(shared.SharedObject obj) {
    if(obj instanceof ConsStackk) {

      ConsStackk peer = (ConsStackk) obj;
      return _HeadStackk==peer._HeadStackk && _TailStackk==peer._TailStackk && true;
    }
    return false;
  }


   //Stackk interface
  /**
   * Returns true if the term is rooted by the symbol ConsStackk
   *
   * @return true, because this is rooted by ConsStackk
   */
  @Override
  public boolean isConsStackk() {
    return true;
  }
  
  /**
   * Returns the attribute maqv.msp.types.Termo
   *
   * @return the attribute maqv.msp.types.Termo
   */
  @Override
  public maqv.msp.types.Termo getHeadStackk() {
    return _HeadStackk;
  }

  /**
   * Sets and returns the attribute maqv.msp.types.Stackk
   *
   * @param set_arg the argument to set
   * @return the attribute maqv.msp.types.Termo which just has been set
   */
  @Override
  public maqv.msp.types.Stackk setHeadStackk(maqv.msp.types.Termo set_arg) {
    return make(set_arg, _TailStackk);
  }
  
  /**
   * Returns the attribute maqv.msp.types.Stackk
   *
   * @return the attribute maqv.msp.types.Stackk
   */
  @Override
  public maqv.msp.types.Stackk getTailStackk() {
    return _TailStackk;
  }

  /**
   * Sets and returns the attribute maqv.msp.types.Stackk
   *
   * @param set_arg the argument to set
   * @return the attribute maqv.msp.types.Stackk which just has been set
   */
  @Override
  public maqv.msp.types.Stackk setTailStackk(maqv.msp.types.Stackk set_arg) {
    return make(_HeadStackk, set_arg);
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
      new aterm.ATerm[] {getHeadStackk().toATerm(), getTailStackk().toATerm()});
  }

  /**
   * Apply a conversion on the ATerm contained in the String and returns a maqv.msp.types.Stackk from it
   *
   * @param trm ATerm to convert into a Gom term
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static maqv.msp.types.Stackk fromTerm(aterm.ATerm trm, tom.library.utils.ATermConverter atConv) {
    trm = atConv.convert(trm);
    if(trm instanceof aterm.ATermAppl) {
      aterm.ATermAppl appl = (aterm.ATermAppl) trm;
      if(symbolName.equals(appl.getName()) && !appl.getAFun().isQuoted()) {
        return make(
maqv.msp.types.Termo.fromTerm(appl.getArgument(0),atConv), maqv.msp.types.Stackk.fromTerm(appl.getArgument(1),atConv)
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
    return getChildren().length;
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
    return getChildren()[index];
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
    
      tom.library.sl.Visitable[] children = getChildren();
      maqv.msp.types.Termo[] new_children = new maqv.msp.types.Termo[children.length];
      for(int i =0; i<children.length; i++) {
        new_children[i] = ((maqv.msp.types.Termo) children[i]); 
      }
     new_children[index] = (maqv.msp.types.Termo) v;
     return fromArray(new_children);
                  
  }

  /**
   * Set children to the term
   *
   * @param children array of children to set
   * @return an array of children which just were set
   * @throws IndexOutOfBoundsException if length of "children" is different than 2
   */
  @SuppressWarnings("unchecked")
  public tom.library.sl.Visitable setChildren(tom.library.sl.Visitable[] children) {
    if (children.length == getChildCount() ) {
      
               maqv.msp.types.Termo[] typed_children = new maqv.msp.types.Termo[children.length];
              for (int i=0; i<children.length; i++) {
                typed_children[i] = (maqv.msp.types.Termo) children[i]; 
              }
              return fromArray(typed_children);
              
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
    
        if (children == null) {
          children = toArray(new maqv.msp.types.Termo[]{});
        }
        return java.util.Arrays.copyOf(children,children.length);
      
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
    b = (1855854008<<8);
    c = getArity();
    /* -------------------------------------- handle most of the key */
    /* ------------------------------------ handle the last 11 bytes */
    a += (_HeadStackk.hashCode() << 8);
    a += (_TailStackk.hashCode());

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
  public static tom.library.enumerator.F<tom.library.enumerator.Enumeration<maqv.msp.types.Termo>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<maqv.msp.types.Stackk>,tom.library.enumerator.Enumeration<maqv.msp.types.Stackk>>> funMake() {
    return 
        new tom.library.enumerator.F<tom.library.enumerator.Enumeration<maqv.msp.types.Termo>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<maqv.msp.types.Stackk>,tom.library.enumerator.Enumeration<maqv.msp.types.Stackk>>>() {
          public tom.library.enumerator.F<tom.library.enumerator.Enumeration<maqv.msp.types.Stackk>,tom.library.enumerator.Enumeration<maqv.msp.types.Stackk>> apply(final tom.library.enumerator.Enumeration<maqv.msp.types.Termo> t1) {
            return 
        new tom.library.enumerator.F<tom.library.enumerator.Enumeration<maqv.msp.types.Stackk>,tom.library.enumerator.Enumeration<maqv.msp.types.Stackk>>() {
          public tom.library.enumerator.Enumeration<maqv.msp.types.Stackk> apply(final tom.library.enumerator.Enumeration<maqv.msp.types.Stackk> t2) {
            return tom.library.enumerator.Enumeration.apply(tom.library.enumerator.Enumeration.apply(tom.library.enumerator.Enumeration.singleton((tom.library.enumerator.F<maqv.msp.types.Termo,tom.library.enumerator.F<maqv.msp.types.Stackk,maqv.msp.types.Stackk>>) 
        new tom.library.enumerator.F<maqv.msp.types.Termo,tom.library.enumerator.F<maqv.msp.types.Stackk,maqv.msp.types.Stackk>>() {
          public tom.library.enumerator.F<maqv.msp.types.Stackk,maqv.msp.types.Stackk> apply(final maqv.msp.types.Termo t1) {
            return 
        new tom.library.enumerator.F<maqv.msp.types.Stackk,maqv.msp.types.Stackk>() {
          public maqv.msp.types.Stackk apply(final maqv.msp.types.Stackk t2) {
            return make(t1,t2);
          }
        };
          }
        }),t1),t2).pay();
          }
        };
          }
        };
  }

}

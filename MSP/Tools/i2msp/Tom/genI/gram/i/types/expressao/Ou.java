
package gram.i.types.expressao;



public final class Ou extends gram.i.types.Expressao implements tom.library.sl.Visitable  {
  
  private static String symbolName = "Ou";


  private Ou() {}
  private int hashCode;
  private static Ou gomProto = new Ou();
    private gram.i.types.Expressao _Cond1;
  private gram.i.types.LComentarios _c1;
  private gram.i.types.LComentarios _c2;
  private gram.i.types.Expressao _Cond2;

  /**
   * Constructor that builds a term rooted by Ou
   *
   * @return a term rooted by Ou
   */

  public static Ou make(gram.i.types.Expressao _Cond1, gram.i.types.LComentarios _c1, gram.i.types.LComentarios _c2, gram.i.types.Expressao _Cond2) {

    // use the proto as a model
    gomProto.initHashCode( _Cond1,  _c1,  _c2,  _Cond2);
    return (Ou) factory.build(gomProto);

  }

  /**
   * Initializes attributes and hashcode of the class
   *
   * @param  _Cond1
   * @param _c1
   * @param _c2
   * @param _Cond2
   * @param hashCode hashCode of Ou
   */
  private void init(gram.i.types.Expressao _Cond1, gram.i.types.LComentarios _c1, gram.i.types.LComentarios _c2, gram.i.types.Expressao _Cond2, int hashCode) {
    this._Cond1 = _Cond1;
    this._c1 = _c1;
    this._c2 = _c2;
    this._Cond2 = _Cond2;

    this.hashCode = hashCode;
  }

  /**
   * Initializes attributes and hashcode of the class
   *
   * @param  _Cond1
   * @param _c1
   * @param _c2
   * @param _Cond2
   */
  private void initHashCode(gram.i.types.Expressao _Cond1, gram.i.types.LComentarios _c1, gram.i.types.LComentarios _c2, gram.i.types.Expressao _Cond2) {
    this._Cond1 = _Cond1;
    this._c1 = _c1;
    this._c2 = _c2;
    this._Cond2 = _Cond2;

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
    return "Ou";
  }

  /**
   * Returns the arity of the symbol
   *
   * @return the arity of the symbol
   */
  private int getArity() {
    return 4;
  }

  /**
   * Copy the object and returns the copy
   *
   * @return a clone of the SharedObject
   */
  public shared.SharedObject duplicate() {
    Ou clone = new Ou();
    clone.init( _Cond1,  _c1,  _c2,  _Cond2, hashCode);
    return clone;
  }
  
  /**
   * Appends a string representation of this term to the buffer given as argument.
   *
   * @param buffer the buffer to which a string represention of this term is appended.
   */
  @Override
  public void toStringBuilder(java.lang.StringBuilder buffer) {
    buffer.append("Ou(");
    _Cond1.toStringBuilder(buffer);
buffer.append(",");
    _c1.toStringBuilder(buffer);
buffer.append(",");
    _c2.toStringBuilder(buffer);
buffer.append(",");
    _Cond2.toStringBuilder(buffer);

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
    gram.i.iAbstractType ao = (gram.i.iAbstractType) o;
    /* return 0 for equality */
    if (ao == this) { return 0; }
    /* compare the symbols */
    int symbCmp = this.symbolName().compareTo(ao.symbolName());
    if (symbCmp != 0) { return symbCmp; }
    /* compare the children */
    Ou tco = (Ou) ao;
    int _Cond1Cmp = (this._Cond1).compareToLPO(tco._Cond1);
    if(_Cond1Cmp != 0) {
      return _Cond1Cmp;
    }

    int _c1Cmp = (this._c1).compareToLPO(tco._c1);
    if(_c1Cmp != 0) {
      return _c1Cmp;
    }

    int _c2Cmp = (this._c2).compareToLPO(tco._c2);
    if(_c2Cmp != 0) {
      return _c2Cmp;
    }

    int _Cond2Cmp = (this._Cond2).compareToLPO(tco._Cond2);
    if(_Cond2Cmp != 0) {
      return _Cond2Cmp;
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
    gram.i.iAbstractType ao = (gram.i.iAbstractType) o;
    /* return 0 for equality */
    if (ao == this) { return 0; }
    /* use the hash values to discriminate */

    if(hashCode != ao.hashCode()) { return (hashCode < ao.hashCode())?-1:1; }

    /* If not, compare the symbols : back to the normal order */
    int symbCmp = this.symbolName().compareTo(ao.symbolName());
    if (symbCmp != 0) { return symbCmp; }
    /* last resort: compare the children */
    Ou tco = (Ou) ao;
    int _Cond1Cmp = (this._Cond1).compareTo(tco._Cond1);
    if(_Cond1Cmp != 0) {
      return _Cond1Cmp;
    }

    int _c1Cmp = (this._c1).compareTo(tco._c1);
    if(_c1Cmp != 0) {
      return _c1Cmp;
    }

    int _c2Cmp = (this._c2).compareTo(tco._c2);
    if(_c2Cmp != 0) {
      return _c2Cmp;
    }

    int _Cond2Cmp = (this._Cond2).compareTo(tco._Cond2);
    if(_Cond2Cmp != 0) {
      return _Cond2Cmp;
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
   * @return true if obj is a Ou and its members are equal, else false
   */
  public final boolean equivalent(shared.SharedObject obj) {
    if(obj instanceof Ou) {

      Ou peer = (Ou) obj;
      return _Cond1==peer._Cond1 && _c1==peer._c1 && _c2==peer._c2 && _Cond2==peer._Cond2 && true;
    }
    return false;
  }


   //Expressao interface
  /**
   * Returns true if the term is rooted by the symbol Ou
   *
   * @return true, because this is rooted by Ou
   */
  @Override
  public boolean isOu() {
    return true;
  }
  
  /**
   * Returns the attribute gram.i.types.Expressao
   *
   * @return the attribute gram.i.types.Expressao
   */
  @Override
  public gram.i.types.Expressao getCond1() {
    return _Cond1;
  }

  /**
   * Sets and returns the attribute gram.i.types.Expressao
   *
   * @param set_arg the argument to set
   * @return the attribute gram.i.types.Expressao which just has been set
   */
  @Override
  public gram.i.types.Expressao setCond1(gram.i.types.Expressao set_arg) {
    return make(set_arg, _c1, _c2, _Cond2);
  }
  
  /**
   * Returns the attribute gram.i.types.LComentarios
   *
   * @return the attribute gram.i.types.LComentarios
   */
  @Override
  public gram.i.types.LComentarios getc1() {
    return _c1;
  }

  /**
   * Sets and returns the attribute gram.i.types.Expressao
   *
   * @param set_arg the argument to set
   * @return the attribute gram.i.types.LComentarios which just has been set
   */
  @Override
  public gram.i.types.Expressao setc1(gram.i.types.LComentarios set_arg) {
    return make(_Cond1, set_arg, _c2, _Cond2);
  }
  
  /**
   * Returns the attribute gram.i.types.LComentarios
   *
   * @return the attribute gram.i.types.LComentarios
   */
  @Override
  public gram.i.types.LComentarios getc2() {
    return _c2;
  }

  /**
   * Sets and returns the attribute gram.i.types.Expressao
   *
   * @param set_arg the argument to set
   * @return the attribute gram.i.types.LComentarios which just has been set
   */
  @Override
  public gram.i.types.Expressao setc2(gram.i.types.LComentarios set_arg) {
    return make(_Cond1, _c1, set_arg, _Cond2);
  }
  
  /**
   * Returns the attribute gram.i.types.Expressao
   *
   * @return the attribute gram.i.types.Expressao
   */
  @Override
  public gram.i.types.Expressao getCond2() {
    return _Cond2;
  }

  /**
   * Sets and returns the attribute gram.i.types.Expressao
   *
   * @param set_arg the argument to set
   * @return the attribute gram.i.types.Expressao which just has been set
   */
  @Override
  public gram.i.types.Expressao setCond2(gram.i.types.Expressao set_arg) {
    return make(_Cond1, _c1, _c2, set_arg);
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
      new aterm.ATerm[] {getCond1().toATerm(), getc1().toATerm(), getc2().toATerm(), getCond2().toATerm()});
  }

  /**
   * Apply a conversion on the ATerm contained in the String and returns a gram.i.types.Expressao from it
   *
   * @param trm ATerm to convert into a Gom term
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static gram.i.types.Expressao fromTerm(aterm.ATerm trm, tom.library.utils.ATermConverter atConv) {
    trm = atConv.convert(trm);
    if(trm instanceof aterm.ATermAppl) {
      aterm.ATermAppl appl = (aterm.ATermAppl) trm;
      if(symbolName.equals(appl.getName()) && !appl.getAFun().isQuoted()) {
        return make(
gram.i.types.Expressao.fromTerm(appl.getArgument(0),atConv), gram.i.types.LComentarios.fromTerm(appl.getArgument(1),atConv), gram.i.types.LComentarios.fromTerm(appl.getArgument(2),atConv), gram.i.types.Expressao.fromTerm(appl.getArgument(3),atConv)
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
    return 4;
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
      case 0: return _Cond1;
      case 1: return _c1;
      case 2: return _c2;
      case 3: return _Cond2;
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
      case 0: return make((gram.i.types.Expressao) v, _c1, _c2, _Cond2);
      case 1: return make(_Cond1, (gram.i.types.LComentarios) v, _c2, _Cond2);
      case 2: return make(_Cond1, _c1, (gram.i.types.LComentarios) v, _Cond2);
      case 3: return make(_Cond1, _c1, _c2, (gram.i.types.Expressao) v);
      default: throw new IndexOutOfBoundsException();
 }
  }

  /**
   * Set children to the term
   *
   * @param children array of children to set
   * @return an array of children which just were set
   * @throws IndexOutOfBoundsException if length of "children" is different than 4
   */
  @SuppressWarnings("unchecked")
  public tom.library.sl.Visitable setChildren(tom.library.sl.Visitable[] children) {
    if (children.length == getChildCount()  && children[0] instanceof gram.i.types.Expressao && children[1] instanceof gram.i.types.LComentarios && children[2] instanceof gram.i.types.LComentarios && children[3] instanceof gram.i.types.Expressao) {
      return make((gram.i.types.Expressao) children[0], (gram.i.types.LComentarios) children[1], (gram.i.types.LComentarios) children[2], (gram.i.types.Expressao) children[3]);
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
    return new tom.library.sl.Visitable[] { _Cond1,  _c1,  _c2,  _Cond2};
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
    b = (-1967097693<<8);
    c = getArity();
    /* -------------------------------------- handle most of the key */
    /* ------------------------------------ handle the last 11 bytes */
    a += (_Cond1.hashCode() << 24);
    a += (_c1.hashCode() << 16);
    a += (_c2.hashCode() << 8);
    a += (_Cond2.hashCode());

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
  public static tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.Enumeration<gram.i.types.Expressao>>>>> funMake() {
    return 
        new tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.Enumeration<gram.i.types.Expressao>>>>>() {
          public tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.Enumeration<gram.i.types.Expressao>>>> apply(final tom.library.enumerator.Enumeration<gram.i.types.Expressao> t1) {
            return 
        new tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.Enumeration<gram.i.types.Expressao>>>>() {
          public tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.Enumeration<gram.i.types.Expressao>>> apply(final tom.library.enumerator.Enumeration<gram.i.types.LComentarios> t2) {
            return 
        new tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.Enumeration<gram.i.types.Expressao>>>() {
          public tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.Enumeration<gram.i.types.Expressao>> apply(final tom.library.enumerator.Enumeration<gram.i.types.LComentarios> t3) {
            return 
        new tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.Enumeration<gram.i.types.Expressao>>() {
          public tom.library.enumerator.Enumeration<gram.i.types.Expressao> apply(final tom.library.enumerator.Enumeration<gram.i.types.Expressao> t4) {
            return tom.library.enumerator.Enumeration.apply(tom.library.enumerator.Enumeration.apply(tom.library.enumerator.Enumeration.apply(tom.library.enumerator.Enumeration.apply(tom.library.enumerator.Enumeration.singleton((tom.library.enumerator.F<gram.i.types.Expressao,tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.Expressao,gram.i.types.Expressao>>>>) 
        new tom.library.enumerator.F<gram.i.types.Expressao,tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.Expressao,gram.i.types.Expressao>>>>() {
          public tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.Expressao,gram.i.types.Expressao>>> apply(final gram.i.types.Expressao t1) {
            return 
        new tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.Expressao,gram.i.types.Expressao>>>() {
          public tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.Expressao,gram.i.types.Expressao>> apply(final gram.i.types.LComentarios t2) {
            return 
        new tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.Expressao,gram.i.types.Expressao>>() {
          public tom.library.enumerator.F<gram.i.types.Expressao,gram.i.types.Expressao> apply(final gram.i.types.LComentarios t3) {
            return 
        new tom.library.enumerator.F<gram.i.types.Expressao,gram.i.types.Expressao>() {
          public gram.i.types.Expressao apply(final gram.i.types.Expressao t4) {
            return make(t1,t2,t3,t4);
          }
        };
          }
        };
          }
        };
          }
        }),t1),t2),t3),t4).pay();
          }
        };
          }
        };
          }
        };
          }
        };
  }

}

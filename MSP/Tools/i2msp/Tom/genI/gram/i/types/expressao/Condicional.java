
package gram.i.types.expressao;



public final class Condicional extends gram.i.types.Expressao implements tom.library.sl.Visitable  {
  
  private static String symbolName = "Condicional";


  private Condicional() {}
  private int hashCode;
  private static Condicional gomProto = new Condicional();
    private gram.i.types.Expressao _Condicao;
  private gram.i.types.LComentarios _c1;
  private gram.i.types.LComentarios _c2;
  private gram.i.types.Expressao _Exp1;
  private gram.i.types.LComentarios _c3;
  private gram.i.types.LComentarios _c4;
  private gram.i.types.Expressao _Exp2;

  /**
   * Constructor that builds a term rooted by Condicional
   *
   * @return a term rooted by Condicional
   */

  public static Condicional make(gram.i.types.Expressao _Condicao, gram.i.types.LComentarios _c1, gram.i.types.LComentarios _c2, gram.i.types.Expressao _Exp1, gram.i.types.LComentarios _c3, gram.i.types.LComentarios _c4, gram.i.types.Expressao _Exp2) {

    // use the proto as a model
    gomProto.initHashCode( _Condicao,  _c1,  _c2,  _Exp1,  _c3,  _c4,  _Exp2);
    return (Condicional) factory.build(gomProto);

  }

  /**
   * Initializes attributes and hashcode of the class
   *
   * @param  _Condicao
   * @param _c1
   * @param _c2
   * @param _Exp1
   * @param _c3
   * @param _c4
   * @param _Exp2
   * @param hashCode hashCode of Condicional
   */
  private void init(gram.i.types.Expressao _Condicao, gram.i.types.LComentarios _c1, gram.i.types.LComentarios _c2, gram.i.types.Expressao _Exp1, gram.i.types.LComentarios _c3, gram.i.types.LComentarios _c4, gram.i.types.Expressao _Exp2, int hashCode) {
    this._Condicao = _Condicao;
    this._c1 = _c1;
    this._c2 = _c2;
    this._Exp1 = _Exp1;
    this._c3 = _c3;
    this._c4 = _c4;
    this._Exp2 = _Exp2;

    this.hashCode = hashCode;
  }

  /**
   * Initializes attributes and hashcode of the class
   *
   * @param  _Condicao
   * @param _c1
   * @param _c2
   * @param _Exp1
   * @param _c3
   * @param _c4
   * @param _Exp2
   */
  private void initHashCode(gram.i.types.Expressao _Condicao, gram.i.types.LComentarios _c1, gram.i.types.LComentarios _c2, gram.i.types.Expressao _Exp1, gram.i.types.LComentarios _c3, gram.i.types.LComentarios _c4, gram.i.types.Expressao _Exp2) {
    this._Condicao = _Condicao;
    this._c1 = _c1;
    this._c2 = _c2;
    this._Exp1 = _Exp1;
    this._c3 = _c3;
    this._c4 = _c4;
    this._Exp2 = _Exp2;

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
    return "Condicional";
  }

  /**
   * Returns the arity of the symbol
   *
   * @return the arity of the symbol
   */
  private int getArity() {
    return 7;
  }

  /**
   * Copy the object and returns the copy
   *
   * @return a clone of the SharedObject
   */
  public shared.SharedObject duplicate() {
    Condicional clone = new Condicional();
    clone.init( _Condicao,  _c1,  _c2,  _Exp1,  _c3,  _c4,  _Exp2, hashCode);
    return clone;
  }
  
  /**
   * Appends a string representation of this term to the buffer given as argument.
   *
   * @param buffer the buffer to which a string represention of this term is appended.
   */
  @Override
  public void toStringBuilder(java.lang.StringBuilder buffer) {
    buffer.append("Condicional(");
    _Condicao.toStringBuilder(buffer);
buffer.append(",");
    _c1.toStringBuilder(buffer);
buffer.append(",");
    _c2.toStringBuilder(buffer);
buffer.append(",");
    _Exp1.toStringBuilder(buffer);
buffer.append(",");
    _c3.toStringBuilder(buffer);
buffer.append(",");
    _c4.toStringBuilder(buffer);
buffer.append(",");
    _Exp2.toStringBuilder(buffer);

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
    Condicional tco = (Condicional) ao;
    int _CondicaoCmp = (this._Condicao).compareToLPO(tco._Condicao);
    if(_CondicaoCmp != 0) {
      return _CondicaoCmp;
    }

    int _c1Cmp = (this._c1).compareToLPO(tco._c1);
    if(_c1Cmp != 0) {
      return _c1Cmp;
    }

    int _c2Cmp = (this._c2).compareToLPO(tco._c2);
    if(_c2Cmp != 0) {
      return _c2Cmp;
    }

    int _Exp1Cmp = (this._Exp1).compareToLPO(tco._Exp1);
    if(_Exp1Cmp != 0) {
      return _Exp1Cmp;
    }

    int _c3Cmp = (this._c3).compareToLPO(tco._c3);
    if(_c3Cmp != 0) {
      return _c3Cmp;
    }

    int _c4Cmp = (this._c4).compareToLPO(tco._c4);
    if(_c4Cmp != 0) {
      return _c4Cmp;
    }

    int _Exp2Cmp = (this._Exp2).compareToLPO(tco._Exp2);
    if(_Exp2Cmp != 0) {
      return _Exp2Cmp;
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
    Condicional tco = (Condicional) ao;
    int _CondicaoCmp = (this._Condicao).compareTo(tco._Condicao);
    if(_CondicaoCmp != 0) {
      return _CondicaoCmp;
    }

    int _c1Cmp = (this._c1).compareTo(tco._c1);
    if(_c1Cmp != 0) {
      return _c1Cmp;
    }

    int _c2Cmp = (this._c2).compareTo(tco._c2);
    if(_c2Cmp != 0) {
      return _c2Cmp;
    }

    int _Exp1Cmp = (this._Exp1).compareTo(tco._Exp1);
    if(_Exp1Cmp != 0) {
      return _Exp1Cmp;
    }

    int _c3Cmp = (this._c3).compareTo(tco._c3);
    if(_c3Cmp != 0) {
      return _c3Cmp;
    }

    int _c4Cmp = (this._c4).compareTo(tco._c4);
    if(_c4Cmp != 0) {
      return _c4Cmp;
    }

    int _Exp2Cmp = (this._Exp2).compareTo(tco._Exp2);
    if(_Exp2Cmp != 0) {
      return _Exp2Cmp;
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
   * @return true if obj is a Condicional and its members are equal, else false
   */
  public final boolean equivalent(shared.SharedObject obj) {
    if(obj instanceof Condicional) {

      Condicional peer = (Condicional) obj;
      return _Condicao==peer._Condicao && _c1==peer._c1 && _c2==peer._c2 && _Exp1==peer._Exp1 && _c3==peer._c3 && _c4==peer._c4 && _Exp2==peer._Exp2 && true;
    }
    return false;
  }


   //Expressao interface
  /**
   * Returns true if the term is rooted by the symbol Condicional
   *
   * @return true, because this is rooted by Condicional
   */
  @Override
  public boolean isCondicional() {
    return true;
  }
  
  /**
   * Returns the attribute gram.i.types.Expressao
   *
   * @return the attribute gram.i.types.Expressao
   */
  @Override
  public gram.i.types.Expressao getCondicao() {
    return _Condicao;
  }

  /**
   * Sets and returns the attribute gram.i.types.Expressao
   *
   * @param set_arg the argument to set
   * @return the attribute gram.i.types.Expressao which just has been set
   */
  @Override
  public gram.i.types.Expressao setCondicao(gram.i.types.Expressao set_arg) {
    return make(set_arg, _c1, _c2, _Exp1, _c3, _c4, _Exp2);
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
    return make(_Condicao, set_arg, _c2, _Exp1, _c3, _c4, _Exp2);
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
    return make(_Condicao, _c1, set_arg, _Exp1, _c3, _c4, _Exp2);
  }
  
  /**
   * Returns the attribute gram.i.types.Expressao
   *
   * @return the attribute gram.i.types.Expressao
   */
  @Override
  public gram.i.types.Expressao getExp1() {
    return _Exp1;
  }

  /**
   * Sets and returns the attribute gram.i.types.Expressao
   *
   * @param set_arg the argument to set
   * @return the attribute gram.i.types.Expressao which just has been set
   */
  @Override
  public gram.i.types.Expressao setExp1(gram.i.types.Expressao set_arg) {
    return make(_Condicao, _c1, _c2, set_arg, _c3, _c4, _Exp2);
  }
  
  /**
   * Returns the attribute gram.i.types.LComentarios
   *
   * @return the attribute gram.i.types.LComentarios
   */
  @Override
  public gram.i.types.LComentarios getc3() {
    return _c3;
  }

  /**
   * Sets and returns the attribute gram.i.types.Expressao
   *
   * @param set_arg the argument to set
   * @return the attribute gram.i.types.LComentarios which just has been set
   */
  @Override
  public gram.i.types.Expressao setc3(gram.i.types.LComentarios set_arg) {
    return make(_Condicao, _c1, _c2, _Exp1, set_arg, _c4, _Exp2);
  }
  
  /**
   * Returns the attribute gram.i.types.LComentarios
   *
   * @return the attribute gram.i.types.LComentarios
   */
  @Override
  public gram.i.types.LComentarios getc4() {
    return _c4;
  }

  /**
   * Sets and returns the attribute gram.i.types.Expressao
   *
   * @param set_arg the argument to set
   * @return the attribute gram.i.types.LComentarios which just has been set
   */
  @Override
  public gram.i.types.Expressao setc4(gram.i.types.LComentarios set_arg) {
    return make(_Condicao, _c1, _c2, _Exp1, _c3, set_arg, _Exp2);
  }
  
  /**
   * Returns the attribute gram.i.types.Expressao
   *
   * @return the attribute gram.i.types.Expressao
   */
  @Override
  public gram.i.types.Expressao getExp2() {
    return _Exp2;
  }

  /**
   * Sets and returns the attribute gram.i.types.Expressao
   *
   * @param set_arg the argument to set
   * @return the attribute gram.i.types.Expressao which just has been set
   */
  @Override
  public gram.i.types.Expressao setExp2(gram.i.types.Expressao set_arg) {
    return make(_Condicao, _c1, _c2, _Exp1, _c3, _c4, set_arg);
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
      new aterm.ATerm[] {getCondicao().toATerm(), getc1().toATerm(), getc2().toATerm(), getExp1().toATerm(), getc3().toATerm(), getc4().toATerm(), getExp2().toATerm()});
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
gram.i.types.Expressao.fromTerm(appl.getArgument(0),atConv), gram.i.types.LComentarios.fromTerm(appl.getArgument(1),atConv), gram.i.types.LComentarios.fromTerm(appl.getArgument(2),atConv), gram.i.types.Expressao.fromTerm(appl.getArgument(3),atConv), gram.i.types.LComentarios.fromTerm(appl.getArgument(4),atConv), gram.i.types.LComentarios.fromTerm(appl.getArgument(5),atConv), gram.i.types.Expressao.fromTerm(appl.getArgument(6),atConv)
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
    return 7;
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
      case 0: return _Condicao;
      case 1: return _c1;
      case 2: return _c2;
      case 3: return _Exp1;
      case 4: return _c3;
      case 5: return _c4;
      case 6: return _Exp2;
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
      case 0: return make((gram.i.types.Expressao) v, _c1, _c2, _Exp1, _c3, _c4, _Exp2);
      case 1: return make(_Condicao, (gram.i.types.LComentarios) v, _c2, _Exp1, _c3, _c4, _Exp2);
      case 2: return make(_Condicao, _c1, (gram.i.types.LComentarios) v, _Exp1, _c3, _c4, _Exp2);
      case 3: return make(_Condicao, _c1, _c2, (gram.i.types.Expressao) v, _c3, _c4, _Exp2);
      case 4: return make(_Condicao, _c1, _c2, _Exp1, (gram.i.types.LComentarios) v, _c4, _Exp2);
      case 5: return make(_Condicao, _c1, _c2, _Exp1, _c3, (gram.i.types.LComentarios) v, _Exp2);
      case 6: return make(_Condicao, _c1, _c2, _Exp1, _c3, _c4, (gram.i.types.Expressao) v);
      default: throw new IndexOutOfBoundsException();
 }
  }

  /**
   * Set children to the term
   *
   * @param children array of children to set
   * @return an array of children which just were set
   * @throws IndexOutOfBoundsException if length of "children" is different than 7
   */
  @SuppressWarnings("unchecked")
  public tom.library.sl.Visitable setChildren(tom.library.sl.Visitable[] children) {
    if (children.length == getChildCount()  && children[0] instanceof gram.i.types.Expressao && children[1] instanceof gram.i.types.LComentarios && children[2] instanceof gram.i.types.LComentarios && children[3] instanceof gram.i.types.Expressao && children[4] instanceof gram.i.types.LComentarios && children[5] instanceof gram.i.types.LComentarios && children[6] instanceof gram.i.types.Expressao) {
      return make((gram.i.types.Expressao) children[0], (gram.i.types.LComentarios) children[1], (gram.i.types.LComentarios) children[2], (gram.i.types.Expressao) children[3], (gram.i.types.LComentarios) children[4], (gram.i.types.LComentarios) children[5], (gram.i.types.Expressao) children[6]);
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
    return new tom.library.sl.Visitable[] { _Condicao,  _c1,  _c2,  _Exp1,  _c3,  _c4,  _Exp2};
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
    b = (1140043825<<8);
    c = getArity();
    /* -------------------------------------- handle most of the key */
    /* ------------------------------------ handle the last 11 bytes */
    b += (_Condicao.hashCode() << 16);
    b += (_c1.hashCode() << 8);
    b += (_c2.hashCode());
    a += (_Exp1.hashCode() << 24);
    a += (_c3.hashCode() << 16);
    a += (_c4.hashCode() << 8);
    a += (_Exp2.hashCode());

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
  public static tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.Enumeration<gram.i.types.Expressao>>>>>>>> funMake() {
    return 
        new tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.Enumeration<gram.i.types.Expressao>>>>>>>>() {
          public tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.Enumeration<gram.i.types.Expressao>>>>>>> apply(final tom.library.enumerator.Enumeration<gram.i.types.Expressao> t1) {
            return 
        new tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.Enumeration<gram.i.types.Expressao>>>>>>>() {
          public tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.Enumeration<gram.i.types.Expressao>>>>>> apply(final tom.library.enumerator.Enumeration<gram.i.types.LComentarios> t2) {
            return 
        new tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.Enumeration<gram.i.types.Expressao>>>>>>() {
          public tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.Enumeration<gram.i.types.Expressao>>>>> apply(final tom.library.enumerator.Enumeration<gram.i.types.LComentarios> t3) {
            return 
        new tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.Enumeration<gram.i.types.Expressao>>>>>() {
          public tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.Enumeration<gram.i.types.Expressao>>>> apply(final tom.library.enumerator.Enumeration<gram.i.types.Expressao> t4) {
            return 
        new tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.Enumeration<gram.i.types.Expressao>>>>() {
          public tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.Enumeration<gram.i.types.Expressao>>> apply(final tom.library.enumerator.Enumeration<gram.i.types.LComentarios> t5) {
            return 
        new tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.Enumeration<gram.i.types.Expressao>>>() {
          public tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.Enumeration<gram.i.types.Expressao>> apply(final tom.library.enumerator.Enumeration<gram.i.types.LComentarios> t6) {
            return 
        new tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.Enumeration<gram.i.types.Expressao>>() {
          public tom.library.enumerator.Enumeration<gram.i.types.Expressao> apply(final tom.library.enumerator.Enumeration<gram.i.types.Expressao> t7) {
            return tom.library.enumerator.Enumeration.apply(tom.library.enumerator.Enumeration.apply(tom.library.enumerator.Enumeration.apply(tom.library.enumerator.Enumeration.apply(tom.library.enumerator.Enumeration.apply(tom.library.enumerator.Enumeration.apply(tom.library.enumerator.Enumeration.apply(tom.library.enumerator.Enumeration.singleton((tom.library.enumerator.F<gram.i.types.Expressao,tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.Expressao,tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.Expressao,gram.i.types.Expressao>>>>>>>) 
        new tom.library.enumerator.F<gram.i.types.Expressao,tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.Expressao,tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.Expressao,gram.i.types.Expressao>>>>>>>() {
          public tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.Expressao,tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.Expressao,gram.i.types.Expressao>>>>>> apply(final gram.i.types.Expressao t1) {
            return 
        new tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.Expressao,tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.Expressao,gram.i.types.Expressao>>>>>>() {
          public tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.Expressao,tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.Expressao,gram.i.types.Expressao>>>>> apply(final gram.i.types.LComentarios t2) {
            return 
        new tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.Expressao,tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.Expressao,gram.i.types.Expressao>>>>>() {
          public tom.library.enumerator.F<gram.i.types.Expressao,tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.Expressao,gram.i.types.Expressao>>>> apply(final gram.i.types.LComentarios t3) {
            return 
        new tom.library.enumerator.F<gram.i.types.Expressao,tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.Expressao,gram.i.types.Expressao>>>>() {
          public tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.Expressao,gram.i.types.Expressao>>> apply(final gram.i.types.Expressao t4) {
            return 
        new tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.Expressao,gram.i.types.Expressao>>>() {
          public tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.Expressao,gram.i.types.Expressao>> apply(final gram.i.types.LComentarios t5) {
            return 
        new tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.Expressao,gram.i.types.Expressao>>() {
          public tom.library.enumerator.F<gram.i.types.Expressao,gram.i.types.Expressao> apply(final gram.i.types.LComentarios t6) {
            return 
        new tom.library.enumerator.F<gram.i.types.Expressao,gram.i.types.Expressao>() {
          public gram.i.types.Expressao apply(final gram.i.types.Expressao t7) {
            return make(t1,t2,t3,t4,t5,t6,t7);
          }
        };
          }
        };
          }
        };
          }
        };
          }
        };
          }
        };
          }
        }),t1),t2),t3),t4),t5),t6),t7).pay();
          }
        };
          }
        };
          }
        };
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

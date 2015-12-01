
package gram.i.types.expressao;



public final class ConsExpressoes extends gram.i.types.expressao.Expressoes implements tom.library.sl.Visitable  {
  
  private static String symbolName = "ConsExpressoes";


  private ConsExpressoes() {}
  private int hashCode;
  private static ConsExpressoes gomProto = new ConsExpressoes();
  
   private gram.i.types.Expressao[] children;
                  private gram.i.types.Expressao _HeadExpressoes;
  private gram.i.types.Expressao _TailExpressoes;

  /**
   * Constructor that builds a term rooted by ConsExpressoes
   *
   * @return a term rooted by ConsExpressoes
   */

    public static gram.i.types.Expressao make(gram.i.types.Expressao head, gram.i.types.Expressao tail) {
  if (true) {if (head.isEmptyExpressoes()) { return tail; }
if (head.isConsExpressoes()) { return make(head.getHeadExpressoes(),make(head.getTailExpressoes(),tail)); }
if (!tail.isConsExpressoes() && !tail.isEmptyExpressoes()) { return make(head,make(tail,EmptyExpressoes.make())); }
}
      return realMake( head,  tail);
    }
  
  private static ConsExpressoes realMake(gram.i.types.Expressao _HeadExpressoes, gram.i.types.Expressao _TailExpressoes) {

    // use the proto as a model
    gomProto.initHashCode( _HeadExpressoes,  _TailExpressoes);
    return (ConsExpressoes) factory.build(gomProto);

  }

  /**
   * Initializes attributes and hashcode of the class
   *
   * @param  _HeadExpressoes
   * @param _TailExpressoes
   * @param hashCode hashCode of ConsExpressoes
   */
  private void init(gram.i.types.Expressao _HeadExpressoes, gram.i.types.Expressao _TailExpressoes, int hashCode) {
    this._HeadExpressoes = _HeadExpressoes;
    this._TailExpressoes = _TailExpressoes;

    this.hashCode = hashCode;
  }

  /**
   * Initializes attributes and hashcode of the class
   *
   * @param  _HeadExpressoes
   * @param _TailExpressoes
   */
  private void initHashCode(gram.i.types.Expressao _HeadExpressoes, gram.i.types.Expressao _TailExpressoes) {
    this._HeadExpressoes = _HeadExpressoes;
    this._TailExpressoes = _TailExpressoes;

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
    return "ConsExpressoes";
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
    ConsExpressoes clone = new ConsExpressoes();
    clone.init( _HeadExpressoes,  _TailExpressoes, hashCode);
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
    gram.i.iAbstractType ao = (gram.i.iAbstractType) o;
    /* return 0 for equality */
    if (ao == this) { return 0; }
    /* compare the symbols */
    int symbCmp = this.symbolName().compareTo(ao.symbolName());
    if (symbCmp != 0) { return symbCmp; }
    /* compare the children */
    ConsExpressoes tco = (ConsExpressoes) ao;
    int _HeadExpressoesCmp = (this._HeadExpressoes).compareToLPO(tco._HeadExpressoes);
    if(_HeadExpressoesCmp != 0) {
      return _HeadExpressoesCmp;
    }

    int _TailExpressoesCmp = (this._TailExpressoes).compareToLPO(tco._TailExpressoes);
    if(_TailExpressoesCmp != 0) {
      return _TailExpressoesCmp;
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
    ConsExpressoes tco = (ConsExpressoes) ao;
    int _HeadExpressoesCmp = (this._HeadExpressoes).compareTo(tco._HeadExpressoes);
    if(_HeadExpressoesCmp != 0) {
      return _HeadExpressoesCmp;
    }

    int _TailExpressoesCmp = (this._TailExpressoes).compareTo(tco._TailExpressoes);
    if(_TailExpressoesCmp != 0) {
      return _TailExpressoesCmp;
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
   * @return true if obj is a ConsExpressoes and its members are equal, else false
   */
  public final boolean equivalent(shared.SharedObject obj) {
    if(obj instanceof ConsExpressoes) {

      ConsExpressoes peer = (ConsExpressoes) obj;
      return _HeadExpressoes==peer._HeadExpressoes && _TailExpressoes==peer._TailExpressoes && true;
    }
    return false;
  }


   //Expressao interface
  /**
   * Returns true if the term is rooted by the symbol ConsExpressoes
   *
   * @return true, because this is rooted by ConsExpressoes
   */
  @Override
  public boolean isConsExpressoes() {
    return true;
  }
  
  /**
   * Returns the attribute gram.i.types.Expressao
   *
   * @return the attribute gram.i.types.Expressao
   */
  @Override
  public gram.i.types.Expressao getHeadExpressoes() {
    return _HeadExpressoes;
  }

  /**
   * Sets and returns the attribute gram.i.types.Expressao
   *
   * @param set_arg the argument to set
   * @return the attribute gram.i.types.Expressao which just has been set
   */
  @Override
  public gram.i.types.Expressao setHeadExpressoes(gram.i.types.Expressao set_arg) {
    return make(set_arg, _TailExpressoes);
  }
  
  /**
   * Returns the attribute gram.i.types.Expressao
   *
   * @return the attribute gram.i.types.Expressao
   */
  @Override
  public gram.i.types.Expressao getTailExpressoes() {
    return _TailExpressoes;
  }

  /**
   * Sets and returns the attribute gram.i.types.Expressao
   *
   * @param set_arg the argument to set
   * @return the attribute gram.i.types.Expressao which just has been set
   */
  @Override
  public gram.i.types.Expressao setTailExpressoes(gram.i.types.Expressao set_arg) {
    return make(_HeadExpressoes, set_arg);
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
      new aterm.ATerm[] {getHeadExpressoes().toATerm(), getTailExpressoes().toATerm()});
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
gram.i.types.Expressao.fromTerm(appl.getArgument(0),atConv), gram.i.types.Expressao.fromTerm(appl.getArgument(1),atConv)
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
      gram.i.types.Expressao[] new_children = new gram.i.types.Expressao[children.length];
      for(int i =0; i<children.length; i++) {
        new_children[i] = ((gram.i.types.Expressao) children[i]); 
      }
     new_children[index] = (gram.i.types.Expressao) v;
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
      
               gram.i.types.Expressao[] typed_children = new gram.i.types.Expressao[children.length];
              for (int i=0; i<children.length; i++) {
                typed_children[i] = (gram.i.types.Expressao) children[i]; 
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
          children = toArray(new gram.i.types.Expressao[]{});
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
    b = (339733706<<8);
    c = getArity();
    /* -------------------------------------- handle most of the key */
    /* ------------------------------------ handle the last 11 bytes */
    a += (_HeadExpressoes.hashCode() << 8);
    a += (_TailExpressoes.hashCode());

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
  public static tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.Enumeration<gram.i.types.Expressao>>> funMake() {
    return 
        new tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.Enumeration<gram.i.types.Expressao>>>() {
          public tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.Enumeration<gram.i.types.Expressao>> apply(final tom.library.enumerator.Enumeration<gram.i.types.Expressao> t1) {
            return 
        new tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Expressao>,tom.library.enumerator.Enumeration<gram.i.types.Expressao>>() {
          public tom.library.enumerator.Enumeration<gram.i.types.Expressao> apply(final tom.library.enumerator.Enumeration<gram.i.types.Expressao> t2) {
            return tom.library.enumerator.Enumeration.apply(tom.library.enumerator.Enumeration.apply(tom.library.enumerator.Enumeration.singleton((tom.library.enumerator.F<gram.i.types.Expressao,tom.library.enumerator.F<gram.i.types.Expressao,gram.i.types.Expressao>>) 
        new tom.library.enumerator.F<gram.i.types.Expressao,tom.library.enumerator.F<gram.i.types.Expressao,gram.i.types.Expressao>>() {
          public tom.library.enumerator.F<gram.i.types.Expressao,gram.i.types.Expressao> apply(final gram.i.types.Expressao t1) {
            return 
        new tom.library.enumerator.F<gram.i.types.Expressao,gram.i.types.Expressao>() {
          public gram.i.types.Expressao apply(final gram.i.types.Expressao t2) {
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

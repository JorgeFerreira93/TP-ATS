
package gram.i.types.declaracoes;



public final class ConsListaDecl extends gram.i.types.declaracoes.ListaDecl implements tom.library.sl.Visitable  {
  
  private static String symbolName = "ConsListaDecl";


  private ConsListaDecl() {}
  private int hashCode;
  private static ConsListaDecl gomProto = new ConsListaDecl();
  
   private gram.i.types.Declaracoes[] children;
                  private gram.i.types.Declaracoes _HeadListaDecl;
  private gram.i.types.Declaracoes _TailListaDecl;

  /**
   * Constructor that builds a term rooted by ConsListaDecl
   *
   * @return a term rooted by ConsListaDecl
   */

    public static gram.i.types.Declaracoes make(gram.i.types.Declaracoes head, gram.i.types.Declaracoes tail) {
  if (true) {if (head.isEmptyListaDecl()) { return tail; }
if (head.isConsListaDecl()) { return make(head.getHeadListaDecl(),make(head.getTailListaDecl(),tail)); }
if (!tail.isConsListaDecl() && !tail.isEmptyListaDecl()) { return make(head,make(tail,EmptyListaDecl.make())); }
}
      return realMake( head,  tail);
    }
  
  private static ConsListaDecl realMake(gram.i.types.Declaracoes _HeadListaDecl, gram.i.types.Declaracoes _TailListaDecl) {

    // use the proto as a model
    gomProto.initHashCode( _HeadListaDecl,  _TailListaDecl);
    return (ConsListaDecl) factory.build(gomProto);

  }

  /**
   * Initializes attributes and hashcode of the class
   *
   * @param  _HeadListaDecl
   * @param _TailListaDecl
   * @param hashCode hashCode of ConsListaDecl
   */
  private void init(gram.i.types.Declaracoes _HeadListaDecl, gram.i.types.Declaracoes _TailListaDecl, int hashCode) {
    this._HeadListaDecl = _HeadListaDecl;
    this._TailListaDecl = _TailListaDecl;

    this.hashCode = hashCode;
  }

  /**
   * Initializes attributes and hashcode of the class
   *
   * @param  _HeadListaDecl
   * @param _TailListaDecl
   */
  private void initHashCode(gram.i.types.Declaracoes _HeadListaDecl, gram.i.types.Declaracoes _TailListaDecl) {
    this._HeadListaDecl = _HeadListaDecl;
    this._TailListaDecl = _TailListaDecl;

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
    return "ConsListaDecl";
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
    ConsListaDecl clone = new ConsListaDecl();
    clone.init( _HeadListaDecl,  _TailListaDecl, hashCode);
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
    ConsListaDecl tco = (ConsListaDecl) ao;
    int _HeadListaDeclCmp = (this._HeadListaDecl).compareToLPO(tco._HeadListaDecl);
    if(_HeadListaDeclCmp != 0) {
      return _HeadListaDeclCmp;
    }

    int _TailListaDeclCmp = (this._TailListaDecl).compareToLPO(tco._TailListaDecl);
    if(_TailListaDeclCmp != 0) {
      return _TailListaDeclCmp;
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
    ConsListaDecl tco = (ConsListaDecl) ao;
    int _HeadListaDeclCmp = (this._HeadListaDecl).compareTo(tco._HeadListaDecl);
    if(_HeadListaDeclCmp != 0) {
      return _HeadListaDeclCmp;
    }

    int _TailListaDeclCmp = (this._TailListaDecl).compareTo(tco._TailListaDecl);
    if(_TailListaDeclCmp != 0) {
      return _TailListaDeclCmp;
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
   * @return true if obj is a ConsListaDecl and its members are equal, else false
   */
  public final boolean equivalent(shared.SharedObject obj) {
    if(obj instanceof ConsListaDecl) {

      ConsListaDecl peer = (ConsListaDecl) obj;
      return _HeadListaDecl==peer._HeadListaDecl && _TailListaDecl==peer._TailListaDecl && true;
    }
    return false;
  }


   //Declaracoes interface
  /**
   * Returns true if the term is rooted by the symbol ConsListaDecl
   *
   * @return true, because this is rooted by ConsListaDecl
   */
  @Override
  public boolean isConsListaDecl() {
    return true;
  }
  
  /**
   * Returns the attribute gram.i.types.Declaracoes
   *
   * @return the attribute gram.i.types.Declaracoes
   */
  @Override
  public gram.i.types.Declaracoes getHeadListaDecl() {
    return _HeadListaDecl;
  }

  /**
   * Sets and returns the attribute gram.i.types.Declaracoes
   *
   * @param set_arg the argument to set
   * @return the attribute gram.i.types.Declaracoes which just has been set
   */
  @Override
  public gram.i.types.Declaracoes setHeadListaDecl(gram.i.types.Declaracoes set_arg) {
    return make(set_arg, _TailListaDecl);
  }
  
  /**
   * Returns the attribute gram.i.types.Declaracoes
   *
   * @return the attribute gram.i.types.Declaracoes
   */
  @Override
  public gram.i.types.Declaracoes getTailListaDecl() {
    return _TailListaDecl;
  }

  /**
   * Sets and returns the attribute gram.i.types.Declaracoes
   *
   * @param set_arg the argument to set
   * @return the attribute gram.i.types.Declaracoes which just has been set
   */
  @Override
  public gram.i.types.Declaracoes setTailListaDecl(gram.i.types.Declaracoes set_arg) {
    return make(_HeadListaDecl, set_arg);
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
      new aterm.ATerm[] {getHeadListaDecl().toATerm(), getTailListaDecl().toATerm()});
  }

  /**
   * Apply a conversion on the ATerm contained in the String and returns a gram.i.types.Declaracoes from it
   *
   * @param trm ATerm to convert into a Gom term
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static gram.i.types.Declaracoes fromTerm(aterm.ATerm trm, tom.library.utils.ATermConverter atConv) {
    trm = atConv.convert(trm);
    if(trm instanceof aterm.ATermAppl) {
      aterm.ATermAppl appl = (aterm.ATermAppl) trm;
      if(symbolName.equals(appl.getName()) && !appl.getAFun().isQuoted()) {
        return make(
gram.i.types.Declaracoes.fromTerm(appl.getArgument(0),atConv), gram.i.types.Declaracoes.fromTerm(appl.getArgument(1),atConv)
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
      gram.i.types.Declaracoes[] new_children = new gram.i.types.Declaracoes[children.length];
      for(int i =0; i<children.length; i++) {
        new_children[i] = ((gram.i.types.Declaracoes) children[i]); 
      }
     new_children[index] = (gram.i.types.Declaracoes) v;
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
      
               gram.i.types.Declaracoes[] typed_children = new gram.i.types.Declaracoes[children.length];
              for (int i=0; i<children.length; i++) {
                typed_children[i] = (gram.i.types.Declaracoes) children[i]; 
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
          children = toArray(new gram.i.types.Declaracoes[]{});
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
    b = (-2066300386<<8);
    c = getArity();
    /* -------------------------------------- handle most of the key */
    /* ------------------------------------ handle the last 11 bytes */
    a += (_HeadListaDecl.hashCode() << 8);
    a += (_TailListaDecl.hashCode());

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
  public static tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Declaracoes>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Declaracoes>,tom.library.enumerator.Enumeration<gram.i.types.Declaracoes>>> funMake() {
    return 
        new tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Declaracoes>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Declaracoes>,tom.library.enumerator.Enumeration<gram.i.types.Declaracoes>>>() {
          public tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Declaracoes>,tom.library.enumerator.Enumeration<gram.i.types.Declaracoes>> apply(final tom.library.enumerator.Enumeration<gram.i.types.Declaracoes> t1) {
            return 
        new tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Declaracoes>,tom.library.enumerator.Enumeration<gram.i.types.Declaracoes>>() {
          public tom.library.enumerator.Enumeration<gram.i.types.Declaracoes> apply(final tom.library.enumerator.Enumeration<gram.i.types.Declaracoes> t2) {
            return tom.library.enumerator.Enumeration.apply(tom.library.enumerator.Enumeration.apply(tom.library.enumerator.Enumeration.singleton((tom.library.enumerator.F<gram.i.types.Declaracoes,tom.library.enumerator.F<gram.i.types.Declaracoes,gram.i.types.Declaracoes>>) 
        new tom.library.enumerator.F<gram.i.types.Declaracoes,tom.library.enumerator.F<gram.i.types.Declaracoes,gram.i.types.Declaracoes>>() {
          public tom.library.enumerator.F<gram.i.types.Declaracoes,gram.i.types.Declaracoes> apply(final gram.i.types.Declaracoes t1) {
            return 
        new tom.library.enumerator.F<gram.i.types.Declaracoes,gram.i.types.Declaracoes>() {
          public gram.i.types.Declaracoes apply(final gram.i.types.Declaracoes t2) {
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


package gram.i.types.argumentos;



public final class ConsListaArgumentos extends gram.i.types.argumentos.ListaArgumentos implements tom.library.sl.Visitable  {
  
  private static String symbolName = "ConsListaArgumentos";


  private ConsListaArgumentos() {}
  private int hashCode;
  private static ConsListaArgumentos gomProto = new ConsListaArgumentos();
  
   private gram.i.types.Argumentos[] children;
                  private gram.i.types.Argumentos _HeadListaArgumentos;
  private gram.i.types.Argumentos _TailListaArgumentos;

  /**
   * Constructor that builds a term rooted by ConsListaArgumentos
   *
   * @return a term rooted by ConsListaArgumentos
   */

    public static gram.i.types.Argumentos make(gram.i.types.Argumentos head, gram.i.types.Argumentos tail) {
  if (true) {if (head.isEmptyListaArgumentos()) { return tail; }
if (head.isConsListaArgumentos()) { return make(head.getHeadListaArgumentos(),make(head.getTailListaArgumentos(),tail)); }
if (!tail.isConsListaArgumentos() && !tail.isEmptyListaArgumentos()) { return make(head,make(tail,EmptyListaArgumentos.make())); }
}
      return realMake( head,  tail);
    }
  
  private static ConsListaArgumentos realMake(gram.i.types.Argumentos _HeadListaArgumentos, gram.i.types.Argumentos _TailListaArgumentos) {

    // use the proto as a model
    gomProto.initHashCode( _HeadListaArgumentos,  _TailListaArgumentos);
    return (ConsListaArgumentos) factory.build(gomProto);

  }

  /**
   * Initializes attributes and hashcode of the class
   *
   * @param  _HeadListaArgumentos
   * @param _TailListaArgumentos
   * @param hashCode hashCode of ConsListaArgumentos
   */
  private void init(gram.i.types.Argumentos _HeadListaArgumentos, gram.i.types.Argumentos _TailListaArgumentos, int hashCode) {
    this._HeadListaArgumentos = _HeadListaArgumentos;
    this._TailListaArgumentos = _TailListaArgumentos;

    this.hashCode = hashCode;
  }

  /**
   * Initializes attributes and hashcode of the class
   *
   * @param  _HeadListaArgumentos
   * @param _TailListaArgumentos
   */
  private void initHashCode(gram.i.types.Argumentos _HeadListaArgumentos, gram.i.types.Argumentos _TailListaArgumentos) {
    this._HeadListaArgumentos = _HeadListaArgumentos;
    this._TailListaArgumentos = _TailListaArgumentos;

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
    return "ConsListaArgumentos";
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
    ConsListaArgumentos clone = new ConsListaArgumentos();
    clone.init( _HeadListaArgumentos,  _TailListaArgumentos, hashCode);
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
    ConsListaArgumentos tco = (ConsListaArgumentos) ao;
    int _HeadListaArgumentosCmp = (this._HeadListaArgumentos).compareToLPO(tco._HeadListaArgumentos);
    if(_HeadListaArgumentosCmp != 0) {
      return _HeadListaArgumentosCmp;
    }

    int _TailListaArgumentosCmp = (this._TailListaArgumentos).compareToLPO(tco._TailListaArgumentos);
    if(_TailListaArgumentosCmp != 0) {
      return _TailListaArgumentosCmp;
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
    ConsListaArgumentos tco = (ConsListaArgumentos) ao;
    int _HeadListaArgumentosCmp = (this._HeadListaArgumentos).compareTo(tco._HeadListaArgumentos);
    if(_HeadListaArgumentosCmp != 0) {
      return _HeadListaArgumentosCmp;
    }

    int _TailListaArgumentosCmp = (this._TailListaArgumentos).compareTo(tco._TailListaArgumentos);
    if(_TailListaArgumentosCmp != 0) {
      return _TailListaArgumentosCmp;
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
   * @return true if obj is a ConsListaArgumentos and its members are equal, else false
   */
  public final boolean equivalent(shared.SharedObject obj) {
    if(obj instanceof ConsListaArgumentos) {

      ConsListaArgumentos peer = (ConsListaArgumentos) obj;
      return _HeadListaArgumentos==peer._HeadListaArgumentos && _TailListaArgumentos==peer._TailListaArgumentos && true;
    }
    return false;
  }


   //Argumentos interface
  /**
   * Returns true if the term is rooted by the symbol ConsListaArgumentos
   *
   * @return true, because this is rooted by ConsListaArgumentos
   */
  @Override
  public boolean isConsListaArgumentos() {
    return true;
  }
  
  /**
   * Returns the attribute gram.i.types.Argumentos
   *
   * @return the attribute gram.i.types.Argumentos
   */
  @Override
  public gram.i.types.Argumentos getHeadListaArgumentos() {
    return _HeadListaArgumentos;
  }

  /**
   * Sets and returns the attribute gram.i.types.Argumentos
   *
   * @param set_arg the argument to set
   * @return the attribute gram.i.types.Argumentos which just has been set
   */
  @Override
  public gram.i.types.Argumentos setHeadListaArgumentos(gram.i.types.Argumentos set_arg) {
    return make(set_arg, _TailListaArgumentos);
  }
  
  /**
   * Returns the attribute gram.i.types.Argumentos
   *
   * @return the attribute gram.i.types.Argumentos
   */
  @Override
  public gram.i.types.Argumentos getTailListaArgumentos() {
    return _TailListaArgumentos;
  }

  /**
   * Sets and returns the attribute gram.i.types.Argumentos
   *
   * @param set_arg the argument to set
   * @return the attribute gram.i.types.Argumentos which just has been set
   */
  @Override
  public gram.i.types.Argumentos setTailListaArgumentos(gram.i.types.Argumentos set_arg) {
    return make(_HeadListaArgumentos, set_arg);
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
      new aterm.ATerm[] {getHeadListaArgumentos().toATerm(), getTailListaArgumentos().toATerm()});
  }

  /**
   * Apply a conversion on the ATerm contained in the String and returns a gram.i.types.Argumentos from it
   *
   * @param trm ATerm to convert into a Gom term
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static gram.i.types.Argumentos fromTerm(aterm.ATerm trm, tom.library.utils.ATermConverter atConv) {
    trm = atConv.convert(trm);
    if(trm instanceof aterm.ATermAppl) {
      aterm.ATermAppl appl = (aterm.ATermAppl) trm;
      if(symbolName.equals(appl.getName()) && !appl.getAFun().isQuoted()) {
        return make(
gram.i.types.Argumentos.fromTerm(appl.getArgument(0),atConv), gram.i.types.Argumentos.fromTerm(appl.getArgument(1),atConv)
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
      gram.i.types.Argumentos[] new_children = new gram.i.types.Argumentos[children.length];
      for(int i =0; i<children.length; i++) {
        new_children[i] = ((gram.i.types.Argumentos) children[i]); 
      }
     new_children[index] = (gram.i.types.Argumentos) v;
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
      
               gram.i.types.Argumentos[] typed_children = new gram.i.types.Argumentos[children.length];
              for (int i=0; i<children.length; i++) {
                typed_children[i] = (gram.i.types.Argumentos) children[i]; 
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
          children = toArray(new gram.i.types.Argumentos[]{});
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
    b = (768137790<<8);
    c = getArity();
    /* -------------------------------------- handle most of the key */
    /* ------------------------------------ handle the last 11 bytes */
    a += (_HeadListaArgumentos.hashCode() << 8);
    a += (_TailListaArgumentos.hashCode());

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
  public static tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Argumentos>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Argumentos>,tom.library.enumerator.Enumeration<gram.i.types.Argumentos>>> funMake() {
    return 
        new tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Argumentos>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Argumentos>,tom.library.enumerator.Enumeration<gram.i.types.Argumentos>>>() {
          public tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Argumentos>,tom.library.enumerator.Enumeration<gram.i.types.Argumentos>> apply(final tom.library.enumerator.Enumeration<gram.i.types.Argumentos> t1) {
            return 
        new tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.Argumentos>,tom.library.enumerator.Enumeration<gram.i.types.Argumentos>>() {
          public tom.library.enumerator.Enumeration<gram.i.types.Argumentos> apply(final tom.library.enumerator.Enumeration<gram.i.types.Argumentos> t2) {
            return tom.library.enumerator.Enumeration.apply(tom.library.enumerator.Enumeration.apply(tom.library.enumerator.Enumeration.singleton((tom.library.enumerator.F<gram.i.types.Argumentos,tom.library.enumerator.F<gram.i.types.Argumentos,gram.i.types.Argumentos>>) 
        new tom.library.enumerator.F<gram.i.types.Argumentos,tom.library.enumerator.F<gram.i.types.Argumentos,gram.i.types.Argumentos>>() {
          public tom.library.enumerator.F<gram.i.types.Argumentos,gram.i.types.Argumentos> apply(final gram.i.types.Argumentos t1) {
            return 
        new tom.library.enumerator.F<gram.i.types.Argumentos,gram.i.types.Argumentos>() {
          public gram.i.types.Argumentos apply(final gram.i.types.Argumentos t2) {
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

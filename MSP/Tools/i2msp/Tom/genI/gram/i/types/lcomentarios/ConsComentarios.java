
package gram.i.types.lcomentarios;



public final class ConsComentarios extends gram.i.types.lcomentarios.Comentarios implements tom.library.sl.Visitable  {
  
  private static String symbolName = "ConsComentarios";


  private ConsComentarios() {}
  private int hashCode;
  private static ConsComentarios gomProto = new ConsComentarios();
  
   private gram.i.types.LComentarios[] children;
                  private gram.i.types.LComentarios _HeadComentarios;
  private gram.i.types.LComentarios _TailComentarios;

  /**
   * Constructor that builds a term rooted by ConsComentarios
   *
   * @return a term rooted by ConsComentarios
   */

    public static gram.i.types.LComentarios make(gram.i.types.LComentarios head, gram.i.types.LComentarios tail) {
  if (true) {if (head.isEmptyComentarios()) { return tail; }
if (head.isConsComentarios()) { return make(head.getHeadComentarios(),make(head.getTailComentarios(),tail)); }
if (!tail.isConsComentarios() && !tail.isEmptyComentarios()) { return make(head,make(tail,EmptyComentarios.make())); }
}
      return realMake( head,  tail);
    }
  
  private static ConsComentarios realMake(gram.i.types.LComentarios _HeadComentarios, gram.i.types.LComentarios _TailComentarios) {

    // use the proto as a model
    gomProto.initHashCode( _HeadComentarios,  _TailComentarios);
    return (ConsComentarios) factory.build(gomProto);

  }

  /**
   * Initializes attributes and hashcode of the class
   *
   * @param  _HeadComentarios
   * @param _TailComentarios
   * @param hashCode hashCode of ConsComentarios
   */
  private void init(gram.i.types.LComentarios _HeadComentarios, gram.i.types.LComentarios _TailComentarios, int hashCode) {
    this._HeadComentarios = _HeadComentarios;
    this._TailComentarios = _TailComentarios;

    this.hashCode = hashCode;
  }

  /**
   * Initializes attributes and hashcode of the class
   *
   * @param  _HeadComentarios
   * @param _TailComentarios
   */
  private void initHashCode(gram.i.types.LComentarios _HeadComentarios, gram.i.types.LComentarios _TailComentarios) {
    this._HeadComentarios = _HeadComentarios;
    this._TailComentarios = _TailComentarios;

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
    return "ConsComentarios";
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
    ConsComentarios clone = new ConsComentarios();
    clone.init( _HeadComentarios,  _TailComentarios, hashCode);
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
    ConsComentarios tco = (ConsComentarios) ao;
    int _HeadComentariosCmp = (this._HeadComentarios).compareToLPO(tco._HeadComentarios);
    if(_HeadComentariosCmp != 0) {
      return _HeadComentariosCmp;
    }

    int _TailComentariosCmp = (this._TailComentarios).compareToLPO(tco._TailComentarios);
    if(_TailComentariosCmp != 0) {
      return _TailComentariosCmp;
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
    ConsComentarios tco = (ConsComentarios) ao;
    int _HeadComentariosCmp = (this._HeadComentarios).compareTo(tco._HeadComentarios);
    if(_HeadComentariosCmp != 0) {
      return _HeadComentariosCmp;
    }

    int _TailComentariosCmp = (this._TailComentarios).compareTo(tco._TailComentarios);
    if(_TailComentariosCmp != 0) {
      return _TailComentariosCmp;
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
   * @return true if obj is a ConsComentarios and its members are equal, else false
   */
  public final boolean equivalent(shared.SharedObject obj) {
    if(obj instanceof ConsComentarios) {

      ConsComentarios peer = (ConsComentarios) obj;
      return _HeadComentarios==peer._HeadComentarios && _TailComentarios==peer._TailComentarios && true;
    }
    return false;
  }


   //LComentarios interface
  /**
   * Returns true if the term is rooted by the symbol ConsComentarios
   *
   * @return true, because this is rooted by ConsComentarios
   */
  @Override
  public boolean isConsComentarios() {
    return true;
  }
  
  /**
   * Returns the attribute gram.i.types.LComentarios
   *
   * @return the attribute gram.i.types.LComentarios
   */
  @Override
  public gram.i.types.LComentarios getHeadComentarios() {
    return _HeadComentarios;
  }

  /**
   * Sets and returns the attribute gram.i.types.LComentarios
   *
   * @param set_arg the argument to set
   * @return the attribute gram.i.types.LComentarios which just has been set
   */
  @Override
  public gram.i.types.LComentarios setHeadComentarios(gram.i.types.LComentarios set_arg) {
    return make(set_arg, _TailComentarios);
  }
  
  /**
   * Returns the attribute gram.i.types.LComentarios
   *
   * @return the attribute gram.i.types.LComentarios
   */
  @Override
  public gram.i.types.LComentarios getTailComentarios() {
    return _TailComentarios;
  }

  /**
   * Sets and returns the attribute gram.i.types.LComentarios
   *
   * @param set_arg the argument to set
   * @return the attribute gram.i.types.LComentarios which just has been set
   */
  @Override
  public gram.i.types.LComentarios setTailComentarios(gram.i.types.LComentarios set_arg) {
    return make(_HeadComentarios, set_arg);
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
      new aterm.ATerm[] {getHeadComentarios().toATerm(), getTailComentarios().toATerm()});
  }

  /**
   * Apply a conversion on the ATerm contained in the String and returns a gram.i.types.LComentarios from it
   *
   * @param trm ATerm to convert into a Gom term
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static gram.i.types.LComentarios fromTerm(aterm.ATerm trm, tom.library.utils.ATermConverter atConv) {
    trm = atConv.convert(trm);
    if(trm instanceof aterm.ATermAppl) {
      aterm.ATermAppl appl = (aterm.ATermAppl) trm;
      if(symbolName.equals(appl.getName()) && !appl.getAFun().isQuoted()) {
        return make(
gram.i.types.LComentarios.fromTerm(appl.getArgument(0),atConv), gram.i.types.LComentarios.fromTerm(appl.getArgument(1),atConv)
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
      gram.i.types.LComentarios[] new_children = new gram.i.types.LComentarios[children.length];
      for(int i =0; i<children.length; i++) {
        new_children[i] = ((gram.i.types.LComentarios) children[i]); 
      }
     new_children[index] = (gram.i.types.LComentarios) v;
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
      
               gram.i.types.LComentarios[] typed_children = new gram.i.types.LComentarios[children.length];
              for (int i=0; i<children.length; i++) {
                typed_children[i] = (gram.i.types.LComentarios) children[i]; 
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
          children = toArray(new gram.i.types.LComentarios[]{});
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
    b = (7478511<<8);
    c = getArity();
    /* -------------------------------------- handle most of the key */
    /* ------------------------------------ handle the last 11 bytes */
    a += (_HeadComentarios.hashCode() << 8);
    a += (_TailComentarios.hashCode());

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
  public static tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.Enumeration<gram.i.types.LComentarios>>> funMake() {
    return 
        new tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.Enumeration<gram.i.types.LComentarios>>>() {
          public tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.Enumeration<gram.i.types.LComentarios>> apply(final tom.library.enumerator.Enumeration<gram.i.types.LComentarios> t1) {
            return 
        new tom.library.enumerator.F<tom.library.enumerator.Enumeration<gram.i.types.LComentarios>,tom.library.enumerator.Enumeration<gram.i.types.LComentarios>>() {
          public tom.library.enumerator.Enumeration<gram.i.types.LComentarios> apply(final tom.library.enumerator.Enumeration<gram.i.types.LComentarios> t2) {
            return tom.library.enumerator.Enumeration.apply(tom.library.enumerator.Enumeration.apply(tom.library.enumerator.Enumeration.singleton((tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.LComentarios,gram.i.types.LComentarios>>) 
        new tom.library.enumerator.F<gram.i.types.LComentarios,tom.library.enumerator.F<gram.i.types.LComentarios,gram.i.types.LComentarios>>() {
          public tom.library.enumerator.F<gram.i.types.LComentarios,gram.i.types.LComentarios> apply(final gram.i.types.LComentarios t1) {
            return 
        new tom.library.enumerator.F<gram.i.types.LComentarios,gram.i.types.LComentarios>() {
          public gram.i.types.LComentarios apply(final gram.i.types.LComentarios t2) {
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

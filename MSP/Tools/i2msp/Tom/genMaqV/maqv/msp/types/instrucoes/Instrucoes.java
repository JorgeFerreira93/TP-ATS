
package maqv.msp.types.instrucoes;



public abstract class Instrucoes extends maqv.msp.types.Instrucoes implements java.util.Collection<maqv.msp.types.Instrucao>  {


  /**
   * Returns the number of arguments of the variadic operator
   *
   * @return the number of arguments of the variadic operator
   */
  @Override
  public int length() {
    if(this instanceof maqv.msp.types.instrucoes.ConsInstrucoes) {
      maqv.msp.types.Instrucoes tl = this.getTailInstrucoes();
      if (tl instanceof Instrucoes) {
        return 1+((Instrucoes)tl).length();
      } else {
        return 2;
      }
    } else {
      return 0;
    }
  }

  public static maqv.msp.types.Instrucoes fromArray(maqv.msp.types.Instrucao[] array) {
    maqv.msp.types.Instrucoes res = maqv.msp.types.instrucoes.EmptyInstrucoes.make();
    for(int i = array.length; i>0;) {
      res = maqv.msp.types.instrucoes.ConsInstrucoes.make(array[--i],res);
    }
    return res;
  }

  /**
   * Inverses the term if it is a list
   *
   * @return the inverted term if it is a list, otherwise the term itself
   */
  @Override
  public maqv.msp.types.Instrucoes reverse() {
    if(this instanceof maqv.msp.types.instrucoes.ConsInstrucoes) {
      maqv.msp.types.Instrucoes cur = this;
      maqv.msp.types.Instrucoes rev = maqv.msp.types.instrucoes.EmptyInstrucoes.make();
      while(cur instanceof maqv.msp.types.instrucoes.ConsInstrucoes) {
        rev = maqv.msp.types.instrucoes.ConsInstrucoes.make(cur.getHeadInstrucoes(),rev);
        cur = cur.getTailInstrucoes();
      }

      return rev;
    } else {
      return this;
    }
  }

  /**
   * Appends an element
   *
   * @param element element which has to be added
   * @return the term with the added element
   */
  public maqv.msp.types.Instrucoes append(maqv.msp.types.Instrucao element) {
    if(this instanceof maqv.msp.types.instrucoes.ConsInstrucoes) {
      maqv.msp.types.Instrucoes tl = this.getTailInstrucoes();
      if (tl instanceof Instrucoes) {
        return maqv.msp.types.instrucoes.ConsInstrucoes.make(this.getHeadInstrucoes(),((Instrucoes)tl).append(element));
      } else {

        return maqv.msp.types.instrucoes.ConsInstrucoes.make(this.getHeadInstrucoes(),maqv.msp.types.instrucoes.ConsInstrucoes.make(element,tl));

      }
    } else {
      return maqv.msp.types.instrucoes.ConsInstrucoes.make(element,this);
    }
  }

  /**
   * Appends a string representation of this term to the buffer given as argument.
   *
   * @param buffer the buffer to which a string represention of this term is appended.
   */
  @Override
  public void toStringBuilder(java.lang.StringBuilder buffer) {
    buffer.append("Instrucoes(");
    if(this instanceof maqv.msp.types.instrucoes.ConsInstrucoes) {
      maqv.msp.types.Instrucoes cur = this;
      while(cur instanceof maqv.msp.types.instrucoes.ConsInstrucoes) {
        maqv.msp.types.Instrucao elem = cur.getHeadInstrucoes();
        cur = cur.getTailInstrucoes();
        elem.toStringBuilder(buffer);

        if(cur instanceof maqv.msp.types.instrucoes.ConsInstrucoes) {
          buffer.append(",");
        }
      }
      if(!(cur instanceof maqv.msp.types.instrucoes.EmptyInstrucoes)) {
        buffer.append(",");
        cur.toStringBuilder(buffer);
      }
    }
    buffer.append(")");
  }

  /**
   * Returns an ATerm representation of this term.
   *
   * @return an ATerm representation of this term.
   */
  public aterm.ATerm toATerm() {
    aterm.ATerm res = atermFactory.makeList();
    if(this instanceof maqv.msp.types.instrucoes.ConsInstrucoes) {
      maqv.msp.types.Instrucoes tail = this.getTailInstrucoes();
      res = atermFactory.makeList(getHeadInstrucoes().toATerm(),(aterm.ATermList)tail.toATerm());
    }
    return res;
  }

  /**
   * Apply a conversion on the ATerm contained in the String and returns a maqv.msp.types.Instrucoes from it
   *
   * @param trm ATerm to convert into a Gom term
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static maqv.msp.types.Instrucoes fromTerm(aterm.ATerm trm, tom.library.utils.ATermConverter atConv) {
    trm = atConv.convert(trm);
    if(trm instanceof aterm.ATermAppl) {
      aterm.ATermAppl appl = (aterm.ATermAppl) trm;
      if("Instrucoes".equals(appl.getName())) {
        maqv.msp.types.Instrucoes res = maqv.msp.types.instrucoes.EmptyInstrucoes.make();

        aterm.ATerm array[] = appl.getArgumentArray();
        for(int i = array.length-1; i>=0; --i) {
          maqv.msp.types.Instrucao elem = maqv.msp.types.Instrucao.fromTerm(array[i],atConv);
          res = maqv.msp.types.instrucoes.ConsInstrucoes.make(elem,res);
        }
        return res;
      }
    }

    if(trm instanceof aterm.ATermList) {
      aterm.ATermList list = (aterm.ATermList) trm;
      maqv.msp.types.Instrucoes res = maqv.msp.types.instrucoes.EmptyInstrucoes.make();
      try {
        while(!list.isEmpty()) {
          maqv.msp.types.Instrucao elem = maqv.msp.types.Instrucao.fromTerm(list.getFirst(),atConv);
          res = maqv.msp.types.instrucoes.ConsInstrucoes.make(elem,res);
          list = list.getNext();
        }
      } catch(IllegalArgumentException e) {
        // returns null when the fromATerm call failed
        return null;
      }
      return res.reverse();
    }

    return null;
  }

  /*
   * Checks if the Collection contains all elements of the parameter Collection
   *
   * @param c the Collection of elements to check
   * @return true if the Collection contains all elements of the parameter, otherwise false
   */
  public boolean containsAll(java.util.Collection c) {
    java.util.Iterator it = c.iterator();
    while(it.hasNext()) {
      if(!this.contains(it.next())) {
        return false;
      }
    }
    return true;
  }

  /**
   * Checks if maqv.msp.types.Instrucoes contains a specified object
   *
   * @param o object whose presence is tested
   * @return true if maqv.msp.types.Instrucoes contains the object, otherwise false
   */
  public boolean contains(Object o) {
    maqv.msp.types.Instrucoes cur = this;
    if(o==null) { return false; }
    if(cur instanceof maqv.msp.types.instrucoes.ConsInstrucoes) {
      while(cur instanceof maqv.msp.types.instrucoes.ConsInstrucoes) {
        if( o.equals(cur.getHeadInstrucoes()) ) {
          return true;
        }
        cur = cur.getTailInstrucoes();
      }
      if(!(cur instanceof maqv.msp.types.instrucoes.EmptyInstrucoes)) {
        if( o.equals(cur) ) {
          return true;
        }
      }
    }
    return false;
  }

  //public boolean equals(Object o) { return this == o; }

  //public int hashCode() { return hashCode(); }

  /**
   * Checks the emptiness
   *
   * @return true if empty, otherwise false
   */
  public boolean isEmpty() { return isEmptyInstrucoes() ; }

  public java.util.Iterator<maqv.msp.types.Instrucao> iterator() {
    return new java.util.Iterator<maqv.msp.types.Instrucao>() {
      maqv.msp.types.Instrucoes list = Instrucoes.this;

      public boolean hasNext() {
        return list!=null && !list.isEmptyInstrucoes();
      }

      public maqv.msp.types.Instrucao next() {
        if(list.isEmptyInstrucoes()) {
          throw new java.util.NoSuchElementException();
        }
        if(list.isConsInstrucoes()) {
          maqv.msp.types.Instrucao head = list.getHeadInstrucoes();
          list = list.getTailInstrucoes();
          return head;
        } else {
          // we are in this case only if domain=codomain
          // thus, the cast is safe
          Object res = list;
          list = null;
          return (maqv.msp.types.Instrucao)res;
        }
      }

      public void remove() {
        throw new UnsupportedOperationException("Not yet implemented");
      }
    };

  }

  public boolean add(maqv.msp.types.Instrucao o) {
    throw new UnsupportedOperationException("This object "+this.getClass().getName()+" is not mutable");
  }

  public boolean addAll(java.util.Collection<? extends maqv.msp.types.Instrucao> c) {
    throw new UnsupportedOperationException("This object "+this.getClass().getName()+" is not mutable");
  }

  public boolean remove(Object o) {
    throw new UnsupportedOperationException("This object "+this.getClass().getName()+" is not mutable");
  }

  public void clear() {
    throw new UnsupportedOperationException("This object "+this.getClass().getName()+" is not mutable");
  }

  public boolean removeAll(java.util.Collection c) {
    throw new UnsupportedOperationException("This object "+this.getClass().getName()+" is not mutable");
  }

  public boolean retainAll(java.util.Collection c) {
    throw new UnsupportedOperationException("This object "+this.getClass().getName()+" is not mutable");
  }

  /**
   * Returns the size of the collection
   *
   * @return the size of the collection
   */
  public int size() { return length(); }

  /**
   * Returns an array containing the elements of the collection
   *
   * @return an array of elements
   */
  public Object[] toArray() {
    int size = this.length();
    Object[] array = new Object[size];
    int i=0;
    if(this instanceof maqv.msp.types.instrucoes.ConsInstrucoes) {
      maqv.msp.types.Instrucoes cur = this;
      while(cur instanceof maqv.msp.types.instrucoes.ConsInstrucoes) {
        maqv.msp.types.Instrucao elem = cur.getHeadInstrucoes();
        array[i] = elem;
        cur = cur.getTailInstrucoes();
        i++;
      }
      if(!(cur instanceof maqv.msp.types.instrucoes.EmptyInstrucoes)) {
        array[i] = cur;
      }
    }
    return array;
  }

  @SuppressWarnings("unchecked")
  public <T> T[] toArray(T[] array) {
    int size = this.length();
    if (array.length < size) {
      array = (T[]) java.lang.reflect.Array.newInstance(array.getClass().getComponentType(), size);
    } else if (array.length > size) {
      array[size] = null;
    }
    int i=0;
    if(this instanceof maqv.msp.types.instrucoes.ConsInstrucoes) {
      maqv.msp.types.Instrucoes cur = this;
      while(cur instanceof maqv.msp.types.instrucoes.ConsInstrucoes) {
        maqv.msp.types.Instrucao elem = cur.getHeadInstrucoes();
        array[i] = (T)elem;
        cur = cur.getTailInstrucoes();
        i++;
      }
      if(!(cur instanceof maqv.msp.types.instrucoes.EmptyInstrucoes)) {
        array[i] = (T)cur;
      }
    }
    return array;
  }

  /*
   * to get a Collection for an immutable list
   */
  public java.util.Collection<maqv.msp.types.Instrucao> getCollection() {
    return new CollectionInstrucoes(this);
  }

  public java.util.Collection<maqv.msp.types.Instrucao> getCollectionInstrucoes() {
    return new CollectionInstrucoes(this);
  }

  /************************************************************
   * private static class
   ************************************************************/
  private static class CollectionInstrucoes implements java.util.Collection<maqv.msp.types.Instrucao> {
    private Instrucoes list;

    public Instrucoes getInstrucoes() {
      return list;
    }

    public CollectionInstrucoes(Instrucoes list) {
      this.list = list;
    }

    /**
     * generic
     */
  public boolean addAll(java.util.Collection<? extends maqv.msp.types.Instrucao> c) {
    boolean modified = false;
    java.util.Iterator<? extends maqv.msp.types.Instrucao> it = c.iterator();
    while(it.hasNext()) {
      modified = modified || add(it.next());
    }
    return modified;
  }

  /**
   * Checks if the collection contains an element
   *
   * @param o element whose presence has to be checked
   * @return true if the element is found, otherwise false
   */
  public boolean contains(Object o) {
    return getInstrucoes().contains(o);
  }

  /**
   * Checks if the collection contains elements given as parameter
   *
   * @param c elements whose presence has to be checked
   * @return true all the elements are found, otherwise false
   */
  public boolean containsAll(java.util.Collection<?> c) {
    return getInstrucoes().containsAll(c);
  }

  /**
   * Checks if an object is equal
   *
   * @param o object which is compared
   * @return true if objects are equal, false otherwise
   */
  @Override
  public boolean equals(Object o) {
    return getInstrucoes().equals(o);
  }

  /**
   * Returns the hashCode
   *
   * @return the hashCode
   */
  @Override
  public int hashCode() {
    return getInstrucoes().hashCode();
  }

  /**
   * Returns an iterator over the elements in the collection
   *
   * @return an iterator over the elements in the collection
   */
  public java.util.Iterator<maqv.msp.types.Instrucao> iterator() {
    return getInstrucoes().iterator();
  }

  /**
   * Return the size of the collection
   *
   * @return the size of the collection
   */
  public int size() {
    return getInstrucoes().size();
  }

  /**
   * Returns an array containing all of the elements in this collection.
   *
   * @return an array of elements
   */
  public Object[] toArray() {
    return getInstrucoes().toArray();
  }

  /**
   * Returns an array containing all of the elements in this collection.
   *
   * @param array array which will contain the result
   * @return an array of elements
   */
  public <T> T[] toArray(T[] array) {
    return getInstrucoes().toArray(array);
  }

/*
  public <T> T[] toArray(T[] array) {
    int size = getInstrucoes().length();
    if (array.length < size) {
      array = (T[]) java.lang.reflect.Array.newInstance(array.getClass().getComponentType(), size);
    } else if (array.length > size) {
      array[size] = null;
    }
    int i=0;
    for(java.util.Iterator it=iterator() ; it.hasNext() ; i++) {
        array[i] = (T)it.next();
    }
    return array;
  }
*/
    /**
     * Collection
     */

    /**
     * Adds an element to the collection
     *
     * @param o element to add to the collection
     * @return true if it is a success
     */
    public boolean add(maqv.msp.types.Instrucao o) {
      list = (Instrucoes)maqv.msp.types.instrucoes.ConsInstrucoes.make(o,list);
      return true;
    }

    /**
     * Removes all of the elements from this collection
     */
    public void clear() {
      list = (Instrucoes)maqv.msp.types.instrucoes.EmptyInstrucoes.make();
    }

    /**
     * Tests the emptiness of the collection
     *
     * @return true if the collection is empty
     */
    public boolean isEmpty() {
      return list.isEmptyInstrucoes();
    }

    public boolean remove(Object o) {
      throw new UnsupportedOperationException("Not yet implemented");
    }

    public boolean removeAll(java.util.Collection<?> c) {
      throw new UnsupportedOperationException("Not yet implemented");
    }

    public boolean retainAll(java.util.Collection<?> c) {
      throw new UnsupportedOperationException("Not yet implemented");
    }

  }


}

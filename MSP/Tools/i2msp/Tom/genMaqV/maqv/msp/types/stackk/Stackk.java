
package maqv.msp.types.stackk;



public abstract class Stackk extends maqv.msp.types.Stackk implements java.util.Collection<maqv.msp.types.Termo>  {


  /**
   * Returns the number of arguments of the variadic operator
   *
   * @return the number of arguments of the variadic operator
   */
  @Override
  public int length() {
    if(this instanceof maqv.msp.types.stackk.ConsStackk) {
      maqv.msp.types.Stackk tl = this.getTailStackk();
      if (tl instanceof Stackk) {
        return 1+((Stackk)tl).length();
      } else {
        return 2;
      }
    } else {
      return 0;
    }
  }

  public static maqv.msp.types.Stackk fromArray(maqv.msp.types.Termo[] array) {
    maqv.msp.types.Stackk res = maqv.msp.types.stackk.EmptyStackk.make();
    for(int i = array.length; i>0;) {
      res = maqv.msp.types.stackk.ConsStackk.make(array[--i],res);
    }
    return res;
  }

  /**
   * Inverses the term if it is a list
   *
   * @return the inverted term if it is a list, otherwise the term itself
   */
  @Override
  public maqv.msp.types.Stackk reverse() {
    if(this instanceof maqv.msp.types.stackk.ConsStackk) {
      maqv.msp.types.Stackk cur = this;
      maqv.msp.types.Stackk rev = maqv.msp.types.stackk.EmptyStackk.make();
      while(cur instanceof maqv.msp.types.stackk.ConsStackk) {
        rev = maqv.msp.types.stackk.ConsStackk.make(cur.getHeadStackk(),rev);
        cur = cur.getTailStackk();
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
  public maqv.msp.types.Stackk append(maqv.msp.types.Termo element) {
    if(this instanceof maqv.msp.types.stackk.ConsStackk) {
      maqv.msp.types.Stackk tl = this.getTailStackk();
      if (tl instanceof Stackk) {
        return maqv.msp.types.stackk.ConsStackk.make(this.getHeadStackk(),((Stackk)tl).append(element));
      } else {

        return maqv.msp.types.stackk.ConsStackk.make(this.getHeadStackk(),maqv.msp.types.stackk.ConsStackk.make(element,tl));

      }
    } else {
      return maqv.msp.types.stackk.ConsStackk.make(element,this);
    }
  }

  /**
   * Appends a string representation of this term to the buffer given as argument.
   *
   * @param buffer the buffer to which a string represention of this term is appended.
   */
  @Override
  public void toStringBuilder(java.lang.StringBuilder buffer) {
    buffer.append("Stackk(");
    if(this instanceof maqv.msp.types.stackk.ConsStackk) {
      maqv.msp.types.Stackk cur = this;
      while(cur instanceof maqv.msp.types.stackk.ConsStackk) {
        maqv.msp.types.Termo elem = cur.getHeadStackk();
        cur = cur.getTailStackk();
        elem.toStringBuilder(buffer);

        if(cur instanceof maqv.msp.types.stackk.ConsStackk) {
          buffer.append(",");
        }
      }
      if(!(cur instanceof maqv.msp.types.stackk.EmptyStackk)) {
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
    if(this instanceof maqv.msp.types.stackk.ConsStackk) {
      maqv.msp.types.Stackk tail = this.getTailStackk();
      res = atermFactory.makeList(getHeadStackk().toATerm(),(aterm.ATermList)tail.toATerm());
    }
    return res;
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
      if("Stackk".equals(appl.getName())) {
        maqv.msp.types.Stackk res = maqv.msp.types.stackk.EmptyStackk.make();

        aterm.ATerm array[] = appl.getArgumentArray();
        for(int i = array.length-1; i>=0; --i) {
          maqv.msp.types.Termo elem = maqv.msp.types.Termo.fromTerm(array[i],atConv);
          res = maqv.msp.types.stackk.ConsStackk.make(elem,res);
        }
        return res;
      }
    }

    if(trm instanceof aterm.ATermList) {
      aterm.ATermList list = (aterm.ATermList) trm;
      maqv.msp.types.Stackk res = maqv.msp.types.stackk.EmptyStackk.make();
      try {
        while(!list.isEmpty()) {
          maqv.msp.types.Termo elem = maqv.msp.types.Termo.fromTerm(list.getFirst(),atConv);
          res = maqv.msp.types.stackk.ConsStackk.make(elem,res);
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
   * Checks if maqv.msp.types.Stackk contains a specified object
   *
   * @param o object whose presence is tested
   * @return true if maqv.msp.types.Stackk contains the object, otherwise false
   */
  public boolean contains(Object o) {
    maqv.msp.types.Stackk cur = this;
    if(o==null) { return false; }
    if(cur instanceof maqv.msp.types.stackk.ConsStackk) {
      while(cur instanceof maqv.msp.types.stackk.ConsStackk) {
        if( o.equals(cur.getHeadStackk()) ) {
          return true;
        }
        cur = cur.getTailStackk();
      }
      if(!(cur instanceof maqv.msp.types.stackk.EmptyStackk)) {
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
  public boolean isEmpty() { return isEmptyStackk() ; }

  public java.util.Iterator<maqv.msp.types.Termo> iterator() {
    return new java.util.Iterator<maqv.msp.types.Termo>() {
      maqv.msp.types.Stackk list = Stackk.this;

      public boolean hasNext() {
        return list!=null && !list.isEmptyStackk();
      }

      public maqv.msp.types.Termo next() {
        if(list.isEmptyStackk()) {
          throw new java.util.NoSuchElementException();
        }
        if(list.isConsStackk()) {
          maqv.msp.types.Termo head = list.getHeadStackk();
          list = list.getTailStackk();
          return head;
        } else {
          // we are in this case only if domain=codomain
          // thus, the cast is safe
          Object res = list;
          list = null;
          return (maqv.msp.types.Termo)res;
        }
      }

      public void remove() {
        throw new UnsupportedOperationException("Not yet implemented");
      }
    };

  }

  public boolean add(maqv.msp.types.Termo o) {
    throw new UnsupportedOperationException("This object "+this.getClass().getName()+" is not mutable");
  }

  public boolean addAll(java.util.Collection<? extends maqv.msp.types.Termo> c) {
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
    if(this instanceof maqv.msp.types.stackk.ConsStackk) {
      maqv.msp.types.Stackk cur = this;
      while(cur instanceof maqv.msp.types.stackk.ConsStackk) {
        maqv.msp.types.Termo elem = cur.getHeadStackk();
        array[i] = elem;
        cur = cur.getTailStackk();
        i++;
      }
      if(!(cur instanceof maqv.msp.types.stackk.EmptyStackk)) {
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
    if(this instanceof maqv.msp.types.stackk.ConsStackk) {
      maqv.msp.types.Stackk cur = this;
      while(cur instanceof maqv.msp.types.stackk.ConsStackk) {
        maqv.msp.types.Termo elem = cur.getHeadStackk();
        array[i] = (T)elem;
        cur = cur.getTailStackk();
        i++;
      }
      if(!(cur instanceof maqv.msp.types.stackk.EmptyStackk)) {
        array[i] = (T)cur;
      }
    }
    return array;
  }

  /*
   * to get a Collection for an immutable list
   */
  public java.util.Collection<maqv.msp.types.Termo> getCollection() {
    return new CollectionStackk(this);
  }

  public java.util.Collection<maqv.msp.types.Termo> getCollectionStackk() {
    return new CollectionStackk(this);
  }

  /************************************************************
   * private static class
   ************************************************************/
  private static class CollectionStackk implements java.util.Collection<maqv.msp.types.Termo> {
    private Stackk list;

    public Stackk getStackk() {
      return list;
    }

    public CollectionStackk(Stackk list) {
      this.list = list;
    }

    /**
     * generic
     */
  public boolean addAll(java.util.Collection<? extends maqv.msp.types.Termo> c) {
    boolean modified = false;
    java.util.Iterator<? extends maqv.msp.types.Termo> it = c.iterator();
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
    return getStackk().contains(o);
  }

  /**
   * Checks if the collection contains elements given as parameter
   *
   * @param c elements whose presence has to be checked
   * @return true all the elements are found, otherwise false
   */
  public boolean containsAll(java.util.Collection<?> c) {
    return getStackk().containsAll(c);
  }

  /**
   * Checks if an object is equal
   *
   * @param o object which is compared
   * @return true if objects are equal, false otherwise
   */
  @Override
  public boolean equals(Object o) {
    return getStackk().equals(o);
  }

  /**
   * Returns the hashCode
   *
   * @return the hashCode
   */
  @Override
  public int hashCode() {
    return getStackk().hashCode();
  }

  /**
   * Returns an iterator over the elements in the collection
   *
   * @return an iterator over the elements in the collection
   */
  public java.util.Iterator<maqv.msp.types.Termo> iterator() {
    return getStackk().iterator();
  }

  /**
   * Return the size of the collection
   *
   * @return the size of the collection
   */
  public int size() {
    return getStackk().size();
  }

  /**
   * Returns an array containing all of the elements in this collection.
   *
   * @return an array of elements
   */
  public Object[] toArray() {
    return getStackk().toArray();
  }

  /**
   * Returns an array containing all of the elements in this collection.
   *
   * @param array array which will contain the result
   * @return an array of elements
   */
  public <T> T[] toArray(T[] array) {
    return getStackk().toArray(array);
  }

/*
  public <T> T[] toArray(T[] array) {
    int size = getStackk().length();
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
    public boolean add(maqv.msp.types.Termo o) {
      list = (Stackk)maqv.msp.types.stackk.ConsStackk.make(o,list);
      return true;
    }

    /**
     * Removes all of the elements from this collection
     */
    public void clear() {
      list = (Stackk)maqv.msp.types.stackk.EmptyStackk.make();
    }

    /**
     * Tests the emptiness of the collection
     *
     * @return true if the collection is empty
     */
    public boolean isEmpty() {
      return list.isEmptyStackk();
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

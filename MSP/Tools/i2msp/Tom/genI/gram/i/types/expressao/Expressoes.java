
package gram.i.types.expressao;



public abstract class Expressoes extends gram.i.types.Expressao implements java.util.Collection<gram.i.types.Expressao>  {


  /**
   * Returns the number of arguments of the variadic operator
   *
   * @return the number of arguments of the variadic operator
   */
  @Override
  public int length() {
    if(this instanceof gram.i.types.expressao.ConsExpressoes) {
      gram.i.types.Expressao tl = this.getTailExpressoes();
      if (tl instanceof Expressoes) {
        return 1+((Expressoes)tl).length();
      } else {
        return 2;
      }
    } else {
      return 0;
    }
  }

  public static gram.i.types.Expressao fromArray(gram.i.types.Expressao[] array) {
    gram.i.types.Expressao res = gram.i.types.expressao.EmptyExpressoes.make();
    for(int i = array.length; i>0;) {
      res = gram.i.types.expressao.ConsExpressoes.make(array[--i],res);
    }
    return res;
  }

  /**
   * Inverses the term if it is a list
   *
   * @return the inverted term if it is a list, otherwise the term itself
   */
  @Override
  public gram.i.types.Expressao reverse() {
    if(this instanceof gram.i.types.expressao.ConsExpressoes) {
      gram.i.types.Expressao cur = this;
      gram.i.types.Expressao rev = gram.i.types.expressao.EmptyExpressoes.make();
      while(cur instanceof gram.i.types.expressao.ConsExpressoes) {
        rev = gram.i.types.expressao.ConsExpressoes.make(cur.getHeadExpressoes(),rev);
        cur = cur.getTailExpressoes();
      }

      if(!(cur instanceof gram.i.types.expressao.EmptyExpressoes)) {
        rev = gram.i.types.expressao.ConsExpressoes.make(cur,rev);
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
  public gram.i.types.Expressao append(gram.i.types.Expressao element) {
    if(this instanceof gram.i.types.expressao.ConsExpressoes) {
      gram.i.types.Expressao tl = this.getTailExpressoes();
      if (tl instanceof Expressoes) {
        return gram.i.types.expressao.ConsExpressoes.make(this.getHeadExpressoes(),((Expressoes)tl).append(element));
      } else {

        return gram.i.types.expressao.ConsExpressoes.make(this.getHeadExpressoes(),gram.i.types.expressao.ConsExpressoes.make(tl,element));

      }
    } else {
      return gram.i.types.expressao.ConsExpressoes.make(element,this);
    }
  }

  /**
   * Appends a string representation of this term to the buffer given as argument.
   *
   * @param buffer the buffer to which a string represention of this term is appended.
   */
  @Override
  public void toStringBuilder(java.lang.StringBuilder buffer) {
    buffer.append("Expressoes(");
    if(this instanceof gram.i.types.expressao.ConsExpressoes) {
      gram.i.types.Expressao cur = this;
      while(cur instanceof gram.i.types.expressao.ConsExpressoes) {
        gram.i.types.Expressao elem = cur.getHeadExpressoes();
        cur = cur.getTailExpressoes();
        elem.toStringBuilder(buffer);

        if(cur instanceof gram.i.types.expressao.ConsExpressoes) {
          buffer.append(",");
        }
      }
      if(!(cur instanceof gram.i.types.expressao.EmptyExpressoes)) {
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
    if(this instanceof gram.i.types.expressao.ConsExpressoes) {
      gram.i.types.Expressao tail = this.getTailExpressoes();
      res = atermFactory.makeList(getHeadExpressoes().toATerm(),(aterm.ATermList)tail.toATerm());
    }
    return res;
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
      if("Expressoes".equals(appl.getName())) {
        gram.i.types.Expressao res = gram.i.types.expressao.EmptyExpressoes.make();

        aterm.ATerm array[] = appl.getArgumentArray();
        for(int i = array.length-1; i>=0; --i) {
          gram.i.types.Expressao elem = gram.i.types.Expressao.fromTerm(array[i],atConv);
          res = gram.i.types.expressao.ConsExpressoes.make(elem,res);
        }
        return res;
      }
    }

    if(trm instanceof aterm.ATermList) {
      aterm.ATermList list = (aterm.ATermList) trm;
      gram.i.types.Expressao res = gram.i.types.expressao.EmptyExpressoes.make();
      try {
        while(!list.isEmpty()) {
          gram.i.types.Expressao elem = gram.i.types.Expressao.fromTerm(list.getFirst(),atConv);
          res = gram.i.types.expressao.ConsExpressoes.make(elem,res);
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
   * Checks if gram.i.types.Expressao contains a specified object
   *
   * @param o object whose presence is tested
   * @return true if gram.i.types.Expressao contains the object, otherwise false
   */
  public boolean contains(Object o) {
    gram.i.types.Expressao cur = this;
    if(o==null) { return false; }
    if(cur instanceof gram.i.types.expressao.ConsExpressoes) {
      while(cur instanceof gram.i.types.expressao.ConsExpressoes) {
        if( o.equals(cur.getHeadExpressoes()) ) {
          return true;
        }
        cur = cur.getTailExpressoes();
      }
      if(!(cur instanceof gram.i.types.expressao.EmptyExpressoes)) {
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
  public boolean isEmpty() { return isEmptyExpressoes() ; }

  public java.util.Iterator<gram.i.types.Expressao> iterator() {
    return new java.util.Iterator<gram.i.types.Expressao>() {
      gram.i.types.Expressao list = Expressoes.this;

      public boolean hasNext() {
        return list!=null && !list.isEmptyExpressoes();
      }

      public gram.i.types.Expressao next() {
        if(list.isEmptyExpressoes()) {
          throw new java.util.NoSuchElementException();
        }
        if(list.isConsExpressoes()) {
          gram.i.types.Expressao head = list.getHeadExpressoes();
          list = list.getTailExpressoes();
          return head;
        } else {
          // we are in this case only if domain=codomain
          // thus, the cast is safe
          Object res = list;
          list = null;
          return (gram.i.types.Expressao)res;
        }
      }

      public void remove() {
        throw new UnsupportedOperationException("Not yet implemented");
      }
    };

  }

  public boolean add(gram.i.types.Expressao o) {
    throw new UnsupportedOperationException("This object "+this.getClass().getName()+" is not mutable");
  }

  public boolean addAll(java.util.Collection<? extends gram.i.types.Expressao> c) {
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
    if(this instanceof gram.i.types.expressao.ConsExpressoes) {
      gram.i.types.Expressao cur = this;
      while(cur instanceof gram.i.types.expressao.ConsExpressoes) {
        gram.i.types.Expressao elem = cur.getHeadExpressoes();
        array[i] = elem;
        cur = cur.getTailExpressoes();
        i++;
      }
      if(!(cur instanceof gram.i.types.expressao.EmptyExpressoes)) {
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
    if(this instanceof gram.i.types.expressao.ConsExpressoes) {
      gram.i.types.Expressao cur = this;
      while(cur instanceof gram.i.types.expressao.ConsExpressoes) {
        gram.i.types.Expressao elem = cur.getHeadExpressoes();
        array[i] = (T)elem;
        cur = cur.getTailExpressoes();
        i++;
      }
      if(!(cur instanceof gram.i.types.expressao.EmptyExpressoes)) {
        array[i] = (T)cur;
      }
    }
    return array;
  }

  /*
   * to get a Collection for an immutable list
   */
  public java.util.Collection<gram.i.types.Expressao> getCollection() {
    return new CollectionExpressoes(this);
  }

  public java.util.Collection<gram.i.types.Expressao> getCollectionExpressoes() {
    return new CollectionExpressoes(this);
  }

  /************************************************************
   * private static class
   ************************************************************/
  private static class CollectionExpressoes implements java.util.Collection<gram.i.types.Expressao> {
    private Expressoes list;

    public Expressoes getExpressao() {
      return list;
    }

    public CollectionExpressoes(Expressoes list) {
      this.list = list;
    }

    /**
     * generic
     */
  public boolean addAll(java.util.Collection<? extends gram.i.types.Expressao> c) {
    boolean modified = false;
    java.util.Iterator<? extends gram.i.types.Expressao> it = c.iterator();
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
    return getExpressao().contains(o);
  }

  /**
   * Checks if the collection contains elements given as parameter
   *
   * @param c elements whose presence has to be checked
   * @return true all the elements are found, otherwise false
   */
  public boolean containsAll(java.util.Collection<?> c) {
    return getExpressao().containsAll(c);
  }

  /**
   * Checks if an object is equal
   *
   * @param o object which is compared
   * @return true if objects are equal, false otherwise
   */
  @Override
  public boolean equals(Object o) {
    return getExpressao().equals(o);
  }

  /**
   * Returns the hashCode
   *
   * @return the hashCode
   */
  @Override
  public int hashCode() {
    return getExpressao().hashCode();
  }

  /**
   * Returns an iterator over the elements in the collection
   *
   * @return an iterator over the elements in the collection
   */
  public java.util.Iterator<gram.i.types.Expressao> iterator() {
    return getExpressao().iterator();
  }

  /**
   * Return the size of the collection
   *
   * @return the size of the collection
   */
  public int size() {
    return getExpressao().size();
  }

  /**
   * Returns an array containing all of the elements in this collection.
   *
   * @return an array of elements
   */
  public Object[] toArray() {
    return getExpressao().toArray();
  }

  /**
   * Returns an array containing all of the elements in this collection.
   *
   * @param array array which will contain the result
   * @return an array of elements
   */
  public <T> T[] toArray(T[] array) {
    return getExpressao().toArray(array);
  }

/*
  public <T> T[] toArray(T[] array) {
    int size = getExpressao().length();
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
    public boolean add(gram.i.types.Expressao o) {
      list = (Expressoes)gram.i.types.expressao.ConsExpressoes.make(o,list);
      return true;
    }

    /**
     * Removes all of the elements from this collection
     */
    public void clear() {
      list = (Expressoes)gram.i.types.expressao.EmptyExpressoes.make();
    }

    /**
     * Tests the emptiness of the collection
     *
     * @return true if the collection is empty
     */
    public boolean isEmpty() {
      return list.isEmptyExpressoes();
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

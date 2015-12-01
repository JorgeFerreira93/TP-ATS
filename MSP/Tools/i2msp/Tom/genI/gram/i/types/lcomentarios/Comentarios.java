
package gram.i.types.lcomentarios;



public abstract class Comentarios extends gram.i.types.LComentarios implements java.util.Collection<gram.i.types.LComentarios>  {


  /**
   * Returns the number of arguments of the variadic operator
   *
   * @return the number of arguments of the variadic operator
   */
  @Override
  public int length() {
    if(this instanceof gram.i.types.lcomentarios.ConsComentarios) {
      gram.i.types.LComentarios tl = this.getTailComentarios();
      if (tl instanceof Comentarios) {
        return 1+((Comentarios)tl).length();
      } else {
        return 2;
      }
    } else {
      return 0;
    }
  }

  public static gram.i.types.LComentarios fromArray(gram.i.types.LComentarios[] array) {
    gram.i.types.LComentarios res = gram.i.types.lcomentarios.EmptyComentarios.make();
    for(int i = array.length; i>0;) {
      res = gram.i.types.lcomentarios.ConsComentarios.make(array[--i],res);
    }
    return res;
  }

  /**
   * Inverses the term if it is a list
   *
   * @return the inverted term if it is a list, otherwise the term itself
   */
  @Override
  public gram.i.types.LComentarios reverse() {
    if(this instanceof gram.i.types.lcomentarios.ConsComentarios) {
      gram.i.types.LComentarios cur = this;
      gram.i.types.LComentarios rev = gram.i.types.lcomentarios.EmptyComentarios.make();
      while(cur instanceof gram.i.types.lcomentarios.ConsComentarios) {
        rev = gram.i.types.lcomentarios.ConsComentarios.make(cur.getHeadComentarios(),rev);
        cur = cur.getTailComentarios();
      }

      if(!(cur instanceof gram.i.types.lcomentarios.EmptyComentarios)) {
        rev = gram.i.types.lcomentarios.ConsComentarios.make(cur,rev);
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
  public gram.i.types.LComentarios append(gram.i.types.LComentarios element) {
    if(this instanceof gram.i.types.lcomentarios.ConsComentarios) {
      gram.i.types.LComentarios tl = this.getTailComentarios();
      if (tl instanceof Comentarios) {
        return gram.i.types.lcomentarios.ConsComentarios.make(this.getHeadComentarios(),((Comentarios)tl).append(element));
      } else {

        return gram.i.types.lcomentarios.ConsComentarios.make(this.getHeadComentarios(),gram.i.types.lcomentarios.ConsComentarios.make(tl,element));

      }
    } else {
      return gram.i.types.lcomentarios.ConsComentarios.make(element,this);
    }
  }

  /**
   * Appends a string representation of this term to the buffer given as argument.
   *
   * @param buffer the buffer to which a string represention of this term is appended.
   */
  @Override
  public void toStringBuilder(java.lang.StringBuilder buffer) {
    buffer.append("Comentarios(");
    if(this instanceof gram.i.types.lcomentarios.ConsComentarios) {
      gram.i.types.LComentarios cur = this;
      while(cur instanceof gram.i.types.lcomentarios.ConsComentarios) {
        gram.i.types.LComentarios elem = cur.getHeadComentarios();
        cur = cur.getTailComentarios();
        elem.toStringBuilder(buffer);

        if(cur instanceof gram.i.types.lcomentarios.ConsComentarios) {
          buffer.append(",");
        }
      }
      if(!(cur instanceof gram.i.types.lcomentarios.EmptyComentarios)) {
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
    if(this instanceof gram.i.types.lcomentarios.ConsComentarios) {
      gram.i.types.LComentarios tail = this.getTailComentarios();
      res = atermFactory.makeList(getHeadComentarios().toATerm(),(aterm.ATermList)tail.toATerm());
    }
    return res;
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
      if("Comentarios".equals(appl.getName())) {
        gram.i.types.LComentarios res = gram.i.types.lcomentarios.EmptyComentarios.make();

        aterm.ATerm array[] = appl.getArgumentArray();
        for(int i = array.length-1; i>=0; --i) {
          gram.i.types.LComentarios elem = gram.i.types.LComentarios.fromTerm(array[i],atConv);
          res = gram.i.types.lcomentarios.ConsComentarios.make(elem,res);
        }
        return res;
      }
    }

    if(trm instanceof aterm.ATermList) {
      aterm.ATermList list = (aterm.ATermList) trm;
      gram.i.types.LComentarios res = gram.i.types.lcomentarios.EmptyComentarios.make();
      try {
        while(!list.isEmpty()) {
          gram.i.types.LComentarios elem = gram.i.types.LComentarios.fromTerm(list.getFirst(),atConv);
          res = gram.i.types.lcomentarios.ConsComentarios.make(elem,res);
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
   * Checks if gram.i.types.LComentarios contains a specified object
   *
   * @param o object whose presence is tested
   * @return true if gram.i.types.LComentarios contains the object, otherwise false
   */
  public boolean contains(Object o) {
    gram.i.types.LComentarios cur = this;
    if(o==null) { return false; }
    if(cur instanceof gram.i.types.lcomentarios.ConsComentarios) {
      while(cur instanceof gram.i.types.lcomentarios.ConsComentarios) {
        if( o.equals(cur.getHeadComentarios()) ) {
          return true;
        }
        cur = cur.getTailComentarios();
      }
      if(!(cur instanceof gram.i.types.lcomentarios.EmptyComentarios)) {
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
  public boolean isEmpty() { return isEmptyComentarios() ; }

  public java.util.Iterator<gram.i.types.LComentarios> iterator() {
    return new java.util.Iterator<gram.i.types.LComentarios>() {
      gram.i.types.LComentarios list = Comentarios.this;

      public boolean hasNext() {
        return list!=null && !list.isEmptyComentarios();
      }

      public gram.i.types.LComentarios next() {
        if(list.isEmptyComentarios()) {
          throw new java.util.NoSuchElementException();
        }
        if(list.isConsComentarios()) {
          gram.i.types.LComentarios head = list.getHeadComentarios();
          list = list.getTailComentarios();
          return head;
        } else {
          // we are in this case only if domain=codomain
          // thus, the cast is safe
          Object res = list;
          list = null;
          return (gram.i.types.LComentarios)res;
        }
      }

      public void remove() {
        throw new UnsupportedOperationException("Not yet implemented");
      }
    };

  }

  public boolean add(gram.i.types.LComentarios o) {
    throw new UnsupportedOperationException("This object "+this.getClass().getName()+" is not mutable");
  }

  public boolean addAll(java.util.Collection<? extends gram.i.types.LComentarios> c) {
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
    if(this instanceof gram.i.types.lcomentarios.ConsComentarios) {
      gram.i.types.LComentarios cur = this;
      while(cur instanceof gram.i.types.lcomentarios.ConsComentarios) {
        gram.i.types.LComentarios elem = cur.getHeadComentarios();
        array[i] = elem;
        cur = cur.getTailComentarios();
        i++;
      }
      if(!(cur instanceof gram.i.types.lcomentarios.EmptyComentarios)) {
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
    if(this instanceof gram.i.types.lcomentarios.ConsComentarios) {
      gram.i.types.LComentarios cur = this;
      while(cur instanceof gram.i.types.lcomentarios.ConsComentarios) {
        gram.i.types.LComentarios elem = cur.getHeadComentarios();
        array[i] = (T)elem;
        cur = cur.getTailComentarios();
        i++;
      }
      if(!(cur instanceof gram.i.types.lcomentarios.EmptyComentarios)) {
        array[i] = (T)cur;
      }
    }
    return array;
  }

  /*
   * to get a Collection for an immutable list
   */
  public java.util.Collection<gram.i.types.LComentarios> getCollection() {
    return new CollectionComentarios(this);
  }

  public java.util.Collection<gram.i.types.LComentarios> getCollectionComentarios() {
    return new CollectionComentarios(this);
  }

  /************************************************************
   * private static class
   ************************************************************/
  private static class CollectionComentarios implements java.util.Collection<gram.i.types.LComentarios> {
    private Comentarios list;

    public Comentarios getLComentarios() {
      return list;
    }

    public CollectionComentarios(Comentarios list) {
      this.list = list;
    }

    /**
     * generic
     */
  public boolean addAll(java.util.Collection<? extends gram.i.types.LComentarios> c) {
    boolean modified = false;
    java.util.Iterator<? extends gram.i.types.LComentarios> it = c.iterator();
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
    return getLComentarios().contains(o);
  }

  /**
   * Checks if the collection contains elements given as parameter
   *
   * @param c elements whose presence has to be checked
   * @return true all the elements are found, otherwise false
   */
  public boolean containsAll(java.util.Collection<?> c) {
    return getLComentarios().containsAll(c);
  }

  /**
   * Checks if an object is equal
   *
   * @param o object which is compared
   * @return true if objects are equal, false otherwise
   */
  @Override
  public boolean equals(Object o) {
    return getLComentarios().equals(o);
  }

  /**
   * Returns the hashCode
   *
   * @return the hashCode
   */
  @Override
  public int hashCode() {
    return getLComentarios().hashCode();
  }

  /**
   * Returns an iterator over the elements in the collection
   *
   * @return an iterator over the elements in the collection
   */
  public java.util.Iterator<gram.i.types.LComentarios> iterator() {
    return getLComentarios().iterator();
  }

  /**
   * Return the size of the collection
   *
   * @return the size of the collection
   */
  public int size() {
    return getLComentarios().size();
  }

  /**
   * Returns an array containing all of the elements in this collection.
   *
   * @return an array of elements
   */
  public Object[] toArray() {
    return getLComentarios().toArray();
  }

  /**
   * Returns an array containing all of the elements in this collection.
   *
   * @param array array which will contain the result
   * @return an array of elements
   */
  public <T> T[] toArray(T[] array) {
    return getLComentarios().toArray(array);
  }

/*
  public <T> T[] toArray(T[] array) {
    int size = getLComentarios().length();
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
    public boolean add(gram.i.types.LComentarios o) {
      list = (Comentarios)gram.i.types.lcomentarios.ConsComentarios.make(o,list);
      return true;
    }

    /**
     * Removes all of the elements from this collection
     */
    public void clear() {
      list = (Comentarios)gram.i.types.lcomentarios.EmptyComentarios.make();
    }

    /**
     * Tests the emptiness of the collection
     *
     * @return true if the collection is empty
     */
    public boolean isEmpty() {
      return list.isEmptyComentarios();
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

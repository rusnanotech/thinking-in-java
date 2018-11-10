/****************** Exercise 30 *****************
 * Modify CollectionSequence.java so that it does
 * not inherit from AbstractCollection, but instead
 * implements Collection.
 ***********************************************/
package biz.markov.thinking.holding;

import java.util.*;
import net.mindview.thinking.typeinfo.pets.*;

public class Ex30_CollectionSequence
   implements Collection<Pet> {
   private Pet[] pets = Pets.createArray(8);
   public int size() { return pets.length; }
   
   public boolean isEmpty() {
      return pets.length == 0;
   }
   
   public boolean contains(Object o) {
      for (Pet pet : pets)
         if (pet.equals(o))
            return true;
      return false;
   }
   
   public Iterator<Pet> iterator() {
      return new Iterator<Pet>() {
         private int index = 0;
         public boolean hasNext() {
            return index < pets.length;
         }
         public Pet next() { return pets[index++]; }
         public void remove() { // Not implemented
            throw new UnsupportedOperationException();
         }
      };
   }
   
   public Object[] toArray() {
      return pets.clone();
   }
   
   public <T> T[] toArray(T[] a) {
      throw new UnsupportedOperationException();
   }
   
   public boolean add(Pet pet) {
      throw new UnsupportedOperationException();
   }
   
   public boolean remove(Object o) {
      throw new UnsupportedOperationException();
   }
   
   public boolean containsAll(Collection<?> c) {
      for (Object obj : c)
         if (!contains(obj))
            return false;
      return true;
   }
   
   public boolean addAll(Collection<? extends Pet> c) {
      throw new UnsupportedOperationException();
   }
   
   public boolean removeAll(Collection<?> c) {
      throw new UnsupportedOperationException();
   }
   
   public boolean retainAll(Collection<?> c) {
      throw new UnsupportedOperationException();
   }
   
   public void clear() {
      throw new UnsupportedOperationException();
   }
   
   public static void main(String[] args) {
      Ex30_CollectionSequence c = new Ex30_CollectionSequence();
      Ex30_InterfaceVsIterator.display(c);
      Ex30_InterfaceVsIterator.display(c.iterator());
      
      List<Pet> p = new ArrayList<Pet>();
      Iterator<Pet> itr = c.iterator();
      p.add(itr.next());
      p.add(itr.next());
   
      System.out.println(c.contains(itr.next()));
      System.out.println(c.containsAll(p));
      
      Pet[] pa = (Pet[]) c.toArray();
      for (int i = 0; i < pa.length; i++)
         pa[i] = new Pet();
   
      Ex30_InterfaceVsIterator.display(c);
      Ex30_InterfaceVsIterator.display(Arrays.asList(pa));
   }
}


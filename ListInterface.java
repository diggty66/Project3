package interfaces;

public interface ListInterface<E> {

	  void add(E element);
	  
	  boolean remove (E element);
	  // remove the first item on the list such that item.equals(element) is true
	  // if no such item exists, return false
	  // note: if there are more than one, just remove the first one that is found
	  
	  int size();   // return the number of items on this list

	  boolean isEmpty();

	  boolean contains (E element);
	  // return true if there is an item on the list such that item.equals(element) is true
	  // otherwise return false
	    
	  E get(E element);
	  // return the first item on the list such that item.equals(element) is true
	  // if no such item exists, return null
	  
	  void resetIterator();
	  // set the current position for the getNextItem() iterator to the first item on the list
	  
	  E getNextItem();
	  // Preconditions: the list is not empty
	  //                the resetIterator() method has been called
	  //                the list has not been modified since the most recent resetIterator() call
	  //
	  // return the item at the current iterator position on this list
	  // update the current pointer to point to the next item on the list
	  // note: if the item returned is the last item on the list,
	  //       set the value of the current position to the first item on the list

}

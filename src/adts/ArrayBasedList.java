package src.adts;

import src.interfaces.ListInterface;

public class ArrayBasedList<E> implements ListInterface<E> {

	protected E[] list;               // array to hold this list’s elements

	protected int numElements = 0;    // number of elements in this list

	protected final int DEFAULT_CAPACITY = 100; // default capacity
	protected int initialCapacity;              // original capacity

	protected int currentIteratorPos;           // current position for getNextItem() iteration

	// set by find method
	protected boolean found;  // true if element found, otherwise false
	protected int location;   // indicates location of element when found is true
	
	public ArrayBasedList() {
		list = (E[]) new Object[DEFAULT_CAPACITY];
		initialCapacity = DEFAULT_CAPACITY;
	}

	public ArrayBasedList(int initialCapacity) {
		list = (E[]) new Object[initialCapacity];
		this.initialCapacity = initialCapacity;
	}
	
	
	protected void enlarge() {
		E[] newBiggerArray = (E[]) new Object[list.length + initialCapacity];
		for (int i = 0; i < numElements; i++) {
			newBiggerArray[i] = list[i];
		}
		list = newBiggerArray;
	}
	
	@Override
	public void add(E element) {
		if (numElements == list.length) {
			enlarge();
		}
		list[numElements] = element;
		numElements++;
	}
	
	protected void find(E target)
	// helper method
	// look for the first item on the list such that item.equals(target) is true
	// if match found set instance variables as follows:
	//    set found to true
	//    set location to the array index for item
	// if no match, set found to false
	{
	    found = false;
	    location = 0;

	    while (location < numElements) {
	        if (list[location].equals(target)) {
	        	found = true;
	        	return;
	        }
	        else {
	        	location++;
	        }
	    }
	}

    
    /**/
    @Override
	// quick & dirty remove
	public boolean remove (E element) {

    	find(element);  // sets found, and when found is true, sets location
	    if (found) {
	    	// replace element to be removed with last element:
	    	list[location] = list[numElements - 1];
	    	// clear out element that had been the last element:
	    	list[numElements - 1] = null;
	    	numElements--;
	    }
	    return found;
	}
	/**/
    
 
	@Override
	public int size() { 
	    return numElements;
	}

    @Override
	public boolean isEmpty() { 
		return numElements == 0;
	}

    
    @Override
	public boolean contains (E element) {
	    find(element);
	    return found;
	}
    
    @Override
	public E get(E element) {
	    find(element);    
	    if (found) {
	      return list[location];
	    }
	    else {
	      return null;
	    }
	}
	  
    @Override
	public void resetIterator() {
	    currentIteratorPos = 0;
	}

    @Override
	public E getNextItem() {
	    E next = list[currentIteratorPos];
	    currentIteratorPos++;
	    if (currentIteratorPos == numElements) {
	    	currentIteratorPos = 0;
	    }
	    return next;
	}

 	public String toString() {
	    String listString = "\n-------------\n";
	    for (int i = 0; i < numElements; i++) {
	    	listString = listString + " " + list[i] + "\n";
	    }
	    return listString;
	}  

}

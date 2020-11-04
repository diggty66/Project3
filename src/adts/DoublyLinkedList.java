package src.adts;

import java.util.Arrays;
import src.interfaces.ListInterface;
import src.nodes.DLLNode;

public class DoublyLinkedList<E> implements ListInterface<E> {

		protected DLLNode<E> front;
		protected DLLNode<E> rear;

		protected int numElements;
		protected int curIteratorPos;
		//for find methods
		protected boolean found;
		protected boolean called;

		protected DLLNode<E> location;
	@Override
	public void add(E element) {
		DLLNode<E> newNode = new DLLNode(element);
		called = true;
		if(front==null && rear == null) {
			front = newNode;
			rear=front;
			
		}else {
			
			newNode.setPrevious(rear);
			rear.setNext(newNode);
			rear = newNode;
			
			/*rear.setPrevious(front);
			rear.setNext(newNode);
			rear=newNode;*/

		}
		numElements++;
	}
	protected void find2(E target){
		found = false;
		E[] list;
		DLLNode<E> current = front;

		if(called){
			called = false;
			list = (E[]) new Object[numElements];
			for(int i = 0; i < numElements; ++i){
				list[i] = current.getInfo();
				current.getNext();
			}
			Arrays.sort(list);
		}
		
		
		int index = 0, length = numElements - 1;
		while (index <= length){
			int mid = index + (length - index)/2;

			if(list[mid] == target){
				location.setInfo(list[mid]);
				found = true;
				return;
			}
			
			if (list[mid].toString().compareToIgnoreCase(target.toString()) > 0){
				length = mid - 1;
			}
			else {
				index = mid + 1;
			}
		}
	}

	public String compareFind(E target){
		
		long startTime = System.nanoTime();
		find(target);
		long elapsed = System.nanoTime() - startTime;

		String answer = "The time in nanoseconds for linear search: " + elapsed; 

		startTime = System.nanoTime();
		find2(target);
		elapsed = System.nanoTime() - startTime;

		answer += "\nThe time in nanoseconds for binary search: " + elapsed;

		return answer;
	}

	protected void find(E target) {

		DLLNode<E> current = front;

		found = false;
		
		while(curIteratorPos<numElements) {
			if(current.getInfo().equals(target)) {

				location = current;
				found=true;
				
				return;
			}else {
				current = current.getNext();

				curIteratorPos++;
			}
		}
	}

	@Override
	public boolean remove(E element) {
		called = true;
		
		find(element);
			if(found) {
				if(front == rear) {
					front = rear = null;
				}
				else if(front == location) {
					front = front.getNext();
					front.setPrevious(null);
				}
				else if(rear == location){
						rear = rear.getPrevious();
						rear.setNext(null);
				}
				else {
					location.getPrevious().setNext(location.getNext());
					location.getNext().setPrevious(location.getPrevious());
				}
			}

		resetIterator();
		numElements--;
		return false;	
	}



	@Override
	public int size() {
		return numElements;
	}

	@Override
	public boolean isEmpty() {
		return front==null;
	}

	@Override
	public boolean contains(E element) {
		find(element);
		return found;
	}

	@Override
	public E get(E element) {
		find(element);
		if(found){
			return location.getInfo();
		}
		else{
			return null;
		}
	}

	@Override
	public void resetIterator() {
		curIteratorPos=0;
	}

	@Override
	public E getNextItem() {
		DLLNode<E> next = location.getNext();
		++curIteratorPos;
		if (curIteratorPos == numElements) {
	    	curIteratorPos = 0;
	    }
	    return next.getInfo();
		
	}
	
	public String toString() {
		String str = "\n-----------------\n";
		DLLNode<E> current = front;
		while(current!=null) {
			str = str + current.getInfo() + " ";
			current = current.getNext();
		}
		return str;
	}

}


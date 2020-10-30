package adts;

import nodes.DLLNode;
import interfaces.ListInterface;

public class DoublyLinkedList<E> implements ListInterface<E> {
		DLLNode front;
		DLLNode rear;
		protected int numElements;
		protected int curIteratorPos;
		//for find methods
		protected boolean found;
		protected int location;
	@Override
	public void add(E element) {
		if(front==null) {
			front = new DLLNode(element);
			rear=front;
			
		}else {
			DLLNode newNode = new DLLNode(element);
			rear.setNext(newNode);
			rear.setPrevious(front);
			rear=newNode;
		}
		numElements++;
	}

	protected void find(E target) {
		DLLNode current = front;
		found = false;
		
		while(curIteratorPos<numElements) {
			if(current.getInfo().equals(target)) {
				found=true;
				return;
			}else {
				curIteratorPos++;
			}
		}
	}
	@Override
	public boolean remove(E element) {
		DLLNode current = front;
		find(element);
		if(found) {
			while(curIteratorPos<numElements) {
				if(current.getInfo().equals(element)) {
					DLLNode a = current.getPrevious();
					DLLNode b = current.getNext();
					a.setNext(b);
					b.setPrevious(a);
					return true;
				}
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void resetIterator() {
		curIteratorPos=0;
	}

	@Override
	public E getNextItem() {
		return null;
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

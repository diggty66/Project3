package adts;
//4
import nodes.DLLNode;
import interfaces.ListInterface;

public class DoublyLinkedList<E> implements ListInterface<E> {
		protected DLLNode<E> front;
		protected DLLNode<E> rear;
		protected int numElements;
		protected int curIteratorPos;
		//for find methods
		protected boolean found;
		protected DLLNode<E> location;
	@Override
	public void add(E element) {
		DLLNode<E> newNode = new DLLNode(element);
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
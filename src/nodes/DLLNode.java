package src.nodes;


public class DLLNode<E> {
	
	private E info;
	private DLLNode<E> next;
	private DLLNode<E> previous;
	
	public DLLNode(E info) {
		this.info = info;
		next = null;
	}
	
	public E getInfo() {
		return info;
	}
	
	public void setInfo(E info) {
		this.info = info;
	}
	
	public DLLNode<E> getNext() {
		return next;
	}
	
	public void setNext(DLLNode<E> next) {
		this.next = next;
	}

	public DLLNode<E> getPrevious() {
		return previous;
	}
	
	public void setPrevious(DLLNode<E> previous) {
		this.previous = previous;
	}
}

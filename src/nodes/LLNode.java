package nodes;


public class LLNode<E> {
	
	private E info;
	private LLNode<E> next;
	
	public LLNode(E info) {
		this.info = info;
		next = null;
	}
	
	public E getInfo() {
		return info;
	}
	
	public void setInfo(E info) {
		this.info = info;
	}
	
	public LLNode<E> getNext() {
		return next;
	}
	
	public void setNext(LLNode<E> next) {
		this.next = next;
	}
}

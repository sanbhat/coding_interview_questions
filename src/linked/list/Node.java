package linked.list;


public class Node {
	int data;
	
	Node next;
	
	Node(int data) {
		this(data, null);
	}
	
	Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}

	@Override
	public String toString() {
		String s = "";
		Node current = this;
		while(current != null) {
			s += current.data;
			if(current.next != null) {
				s += "->";
			}
			current = current.next;
		}
		return s;
	}
}

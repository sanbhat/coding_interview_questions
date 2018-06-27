package linked.list;

public class ReverseLinkedListInGroup {
	
	public Node reverseInGroup(Node head, int k) {
		Node current = head;
		Node rTail = head;
		Node prev = null;
		Node rHead = null;
		int g = k;
		while(current != null) {
			Node temp = current.next;
			if(prev == null) {
				rTail = current;
			}
			current.next = prev;
			prev = current;
			current = temp;
			g--;
			
			if(g == 0 || current == null) {
				if(rHead == null) {
					rHead = prev;
				} else {
					head.next = prev;
					head = rTail;
				}
				prev = null;
				g = k;
				continue;
			}
		}

		return rHead;
	}
	
	public Node reverseInGroupRecursion(Node head, int k) {
		Node current = head;
		Node next = null;
		Node prev = null;
		int c = 0;
		while(current != null && c < k) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			c++;
		}
		
		if(next != null) {
			head.next = reverseInGroupRecursion(next, k);
		} 
		
		return prev;
	}
	
	public static void main(String[] args) {
		Node head = new Node(1, null);
		Node last = head;
		for(int i = 2; i <= 10; i++) {
			Node node = new Node(i, null);
			last.next = node;
			last = node;
		}
		
		ReverseLinkedListInGroup rlg = new ReverseLinkedListInGroup();
		//System.out.println(rlg.reverseInGroup(head, 3));
		
		System.out.println(rlg.reverseInGroupRecursion(head, 3));
	}
}

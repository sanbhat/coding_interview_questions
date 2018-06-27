package linked.list;

public class MergingPointOf2Lists {

	/*
	 * Merging point of below 2 lists are Node with data == 6.
	 * 
	 *  (head1) 1 -> 2 -> 3 
	 *  				   \ 
	 *  			  		 6 -> 7 -> 8
	 *  					/ 
	 *       (head2) 4 ->  5
	 */
	public int findMergingPoint(Node head1, Node head2) {
		Node curr1 = head1;
		Node curr2 = head2;
		
		while(curr1 != null && curr2 != null) {
			if(curr1 == curr2) {
				return curr1.data;
			}
			
			if(curr1.next == null) {
				curr1 = head2;
			} else {
				curr1 = curr1.next;
			}
			
			if(curr2.next == null) {
				curr2 = head1;
			} else {
				curr2 = curr2.next;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		Node common = new Node(6);
		common.next = new Node(7);
		common.next.next = new Node(8);
		
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = common;
		
		Node head2 = new Node(4);
		head2.next = new Node(5);
		head2.next.next = common;
		
		System.out.println(new MergingPointOf2Lists().findMergingPoint(head1, head2));
	}
}

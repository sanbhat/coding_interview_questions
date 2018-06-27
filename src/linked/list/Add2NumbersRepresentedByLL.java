package linked.list;

/**
 * https://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/
 * @author santhosh
 *
 */
public class Add2NumbersRepresentedByLL {

	public Node add(Node num1, Node num2) {
		Node c1 = num1;
		Node c2 = num2;
		
		Node res = null;
		Node resHead = null;
		
		int cf = 0;
		while(c1 != null || c2 != null) {
			
			int s = 0; 
			if(c1 != null) {
				s += c1.data;
			}
			if(c2 != null) {
				s += c2.data;
			}
			s += cf;
			
			int r = s % 10;
			cf = s / 10;
			
			Node node = new Node(r);
			if(res == null) {
				resHead = node;
			} else {
				res.next = node;
			}
			res = node;
			
			c1 = c1 != null ? c1.next : null;
			c2 = c2 != null ? c2.next : null;
		}
		
		return resHead;
	}
	
	public static void main(String[] args) {
		Node num1 = new Node(5);
		num1.next = new Node(6);
		num1.next.next = new Node(3);
		
		Node num2 = new Node(8);
		num2.next = new Node(4);
		num2.next.next = new Node(2);
		
		Add2NumbersRepresentedByLL a = new Add2NumbersRepresentedByLL();
		System.out.println(a.add(num1, num2));
		
		num1 = new Node(7);
		num1.next = new Node(5);
		num1.next.next = new Node(9);
		num1.next.next.next = new Node(4);
		num1.next.next.next.next = new Node(6);
		
		num2 = new Node(8);
		num2.next = new Node(4);
		
		System.out.println(a.add(num1, num2));
	}
}

package Temp;

public class LinkedList {
	private static Node head;

	
	public boolean detectAndRemoveLopp(Node node) {
		Node fast = node;
		Node slow = node;
		
		while(fast !=null && fast.next!= null) {
			fast = fast.next.next;
			slow = slow.next;
			
			if(fast == slow) {
				//removeloop(slow,node);
				slow.next.next = null;
				return true;
			}
			
		}
		return false;
		
	}
	
	private void removeloop(Node loopNode, Node head) {
		Node ptr1 =loopNode;
		Node ptr2 = loopNode;
		
		int k =1;
		//number of nodes in loop
		while(ptr1.next != ptr2) {
			ptr1 = ptr1.next;
			k++;
		}
		
		ptr1 = head;
		ptr2 = head;
		
		for(int i=0 ;i<k ;i++) {
			ptr2 = ptr2.next;
		}
		
		while(ptr2!= ptr1) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		
		while(ptr2.next != ptr1)
			ptr2 = ptr2.next;
		
		ptr2.next = null;
		
//		while(true) {
//			ptr2 = loopNode;
//			while(ptr2.next!= loopNode && ptr2.next!= ptr1)
//				ptr2 = ptr2.next;
//			
//			if(ptr2.next == ptr1)
//				break;
//			
//			ptr1 = ptr1.next;
//		}
//		ptr2.next = null;
		
	}
    
	
	public void printList(Node node) {
		while(node != null) {
			System.out.print(node.data+ " ");
			node = node.next;
		}
		
	}

	public static void main(String[] args) {
		
		LinkedList linkedList = new LinkedList();

		linkedList.head = new Node("50");
		linkedList.head.next = new Node("30");
		linkedList.head.next.next = new Node("40");
		linkedList.head.next.next.next = new Node("10");
		linkedList.head.next.next.next.next = new Node("60");
		linkedList.head.next.next.next.next.next = linkedList.head.next.next;
		
		System.out.println("isCyclic "+ linkedList.detectAndRemoveLopp(linkedList.head));
		linkedList.printList(linkedList.head);

	}
	public static class Node{
		private Node next;
		private String data;
		
		public Node(String data) {
			this.data = data;
			next = null;
		}
		
		
	}
	

}

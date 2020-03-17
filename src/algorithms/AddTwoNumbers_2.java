package algorithms;

public class AddTwoNumbers_2 {

	/**
	 * Definition for singly-linked list.
	 */
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		// 2->4->3
		ListNode l12 = new ListNode(2);
		ListNode l14 = new ListNode(4);
		l12.next = l14;
		ListNode l13 = new ListNode(3);
		l14.next = l13;

		// 5->6->4
		ListNode l25 = new ListNode(5);
		ListNode l26 = new ListNode(6);
		l25.next = l26;
		ListNode l24 = new ListNode(4);
		l26.next = l24;

		AddTwoNumbers_2 obj = new AddTwoNumbers_2();
		// output: 342 + 465 = 807, 7->0->8
		ListNode output = obj.addTwoNumbers(l12, l25);

		StringBuilder sb = new StringBuilder();
		while (output != null) {
			sb.append(output.val);
			output = output.next;
		}
		System.out.println(sb.reverse().toString());
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int totalSum = 0;
		int carry = 0;
		ListNode rootNode = null;
		ListNode currNode = null;
		while (true) {
			int add1 = l1 == null ? 0 : l1.val;
			int add2 = l2 == null ? 0 : l2.val;
			int sum = add1 + add2 + carry;
			carry = sum > 9 ? 1 : 0;
			sum = carry > 0 ? sum - 10 : sum;
			if (rootNode == null) {
				rootNode = new ListNode(sum);
				currNode = rootNode;
			} else {
				ListNode newNode = new ListNode(sum);
				currNode.next = newNode;
				currNode = newNode;
			}
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
			// both are exhausted
			if (l1 == null && l2 == null) {
				if (carry > 0) {
					ListNode newNode = new ListNode(carry);
					currNode.next = newNode;
				}
				break;
			}
		}
		return rootNode;
	}
}

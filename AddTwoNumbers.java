import java.math.BigInteger;

public class AddTwoNumbers {

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		BigInteger sum1 = new BigInteger("0");
		BigInteger sum2 = new BigInteger("0");
		int count1 = 0, count2 = 0;
		while (l1 != null) {
			long val1 = (long) (l1.val * Math.pow(10, count1));
			sum1 = sum1.add(BigInteger.valueOf(val1));
			++count1;
			l1 = l1.next;
		}
		while (l2 != null) {
			long val2 = (long) (l2.val * Math.pow(10, count2));
			sum2 = sum2.add(BigInteger.valueOf(val2));
			++count2;
			l2 = l2.next;
		}
		BigInteger totalSum = new BigInteger("0");
		totalSum.add(sum1);
		totalSum.add(sum2);
		System.out.println(totalSum);
		String s = totalSum + "";
		// 807
		ListNode l = new ListNode(0, null);
		ListNode front = l;
		int i = s.length() - 1; // 2
		l.val = Integer.parseInt(s.charAt(i) + ""); // 7
		s = s.substring(0, i); // 80
		--i; // 1
		while (s.length() > 0) {
			ListNode add = new ListNode(Integer.parseInt(s.charAt(i) + ""), null); // 0
			l.next = add; //
			l = l.next;
			s = s.substring(0, i);
			--i;
		}
		return front;
	}
}

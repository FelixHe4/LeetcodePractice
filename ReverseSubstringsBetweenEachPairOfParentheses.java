import java.io.IOException;
import java.util.Stack;

public class ReverseSubstringsBetweenEachPairOfParentheses {

	public static void main(String[] args) throws IOException {
		System.out.println(reverseParentheses("(abcd)"));
	}

	public static String reverseParentheses(String s) {
		Stack<Character> st = new Stack<Character>();
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if (c != ')') {
				st.push(c);
			} else if (c == ')') {
				boolean flag = false;
				StringBuilder back = new StringBuilder();
				while (st.peek() != '(') {
					if (st.peek() == 'A') {
						flag = true;
						st.pop();
						continue;
					}
					if (!flag) {
						back.append(st.peek());
					} else {
						out.insert(0, st.peek());
					}
					st.pop();
				}
				back.reverse();
				out.append(back);
				st.pop();
				st.push('A');
				out.reverse();
			}
		}
		boolean flag = false;
		StringBuilder back = new StringBuilder();
		while (!st.isEmpty()) {
			if (st.peek() == 'A') {
				flag = true;
				st.pop();
				continue;
			}
			if (!flag) {
				back.append(st.peek());
			} else {
				out.insert(0, st.peek());
			}
			st.pop();
		}
		back.reverse();
		out.append(back);
		return out.toString();
	}
}

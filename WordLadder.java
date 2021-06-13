import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		int n = wordList.size();
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for (int i = 0; i < n; ++i) {
			hm.put(wordList.get(i), i);
		}
		if (!hm.containsKey(endWord))
			return 0;
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		if (hm.containsKey(beginWord)) {
			dist[hm.get(beginWord)] = 0;
		} else {
			dist[n] = 0;
		}
		Queue<String> q = new LinkedList<String>();
		q.add(beginWord);
		while (!q.isEmpty()) {
			String cur = q.poll();
			for (int i = 0; i < n; ++i) {
				String comp = wordList.get(i);
				int count = 0;
				for (int j = 0; j < cur.length(); ++j) {
					if (cur.charAt(j) != comp.charAt(j)) {
						++count;
					}
				}
				if (count == 1) {
					if (hm.containsKey(cur)) {
						if (dist[hm.get(comp)] > dist[hm.get(cur)] + 1) {
							dist[hm.get(comp)] = dist[hm.get(cur)] + 1;
							q.add(comp);
						}
					} else {
						if (dist[hm.get(comp)] > dist[n] + 1) {
							dist[hm.get(comp)] = dist[n] + 1;
							q.add(comp);
						}
					}
				}
			}
		}
		return dist[hm.get(endWord)] == Integer.MAX_VALUE ? 0 : dist[hm.get(endWord)] + 1;
	}

	final private static int BUFFER_SIZE = 1 << 16;
	private static DataInputStream din = new DataInputStream(System.in);
	private static byte[] buffer = new byte[BUFFER_SIZE];
	private static int bufferPointer = 0, bytesRead = 0;
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	public static String readLine() throws IOException {
		byte[] buf = new byte[1000000]; // line length
		int cnt = 0, c;
		while ((c = Read()) != -1) {
			if (c == '\n')
				break;
			buf[cnt++] = (byte) c;
		}
		return new String(buf, 0, cnt);
	}

	public static String read() throws IOException {
		byte[] ret = new byte[1024];
		int idx = 0;
		byte c = Read();
		while (c <= ' ') {
			c = Read();
		}
		do {
			ret[idx++] = c;
			c = Read();
		} while (c != -1 && c != ' ' && c != '\n' && c != '\r');
		return new String(ret, 0, idx);
	}

	public static int readInt() throws IOException {
		int ret = 0;
		byte c = Read();
		while (c <= ' ')
			c = Read();
		boolean neg = (c == '-');
		if (neg)
			c = Read();
		do {
			ret = ret * 10 + c - '0';
		} while ((c = Read()) >= '0' && c <= '9');

		if (neg)
			return -ret;
		return ret;
	}

	public static long readLong() throws IOException {
		long ret = 0;
		byte c = Read();
		while (c <= ' ')
			c = Read();
		boolean neg = (c == '-');
		if (neg)
			c = Read();
		do {
			ret = ret * 10 + c - '0';
		} while ((c = Read()) >= '0' && c <= '9');
		if (neg)
			return -ret;
		return ret;
	}

	public static double readDouble() throws IOException {
		double ret = 0, div = 1;
		byte c = Read();
		while (c <= ' ')
			c = Read();
		boolean neg = (c == '-');
		if (neg)
			c = Read();

		do {
			ret = ret * 10 + c - '0';
		} while ((c = Read()) >= '0' && c <= '9');

		if (c == '.') {
			while ((c = Read()) >= '0' && c <= '9') {
				ret += (c - '0') / (div *= 10);
			}
		}

		if (neg)
			return -ret;
		return ret;
	}

	private static void fillBuffer() throws IOException {
		bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
		if (bytesRead == -1)
			buffer[0] = -1;
	}

	private static byte Read() throws IOException {
		if (bufferPointer == bytesRead)
			fillBuffer();
		return buffer[bufferPointer++];
	}

	public void close() throws IOException {
		if (din == null)
			return;
		din.close();
	}

	static void print(Object o) {
		pr.print(o);
	}

	static void println(Object o) {
		pr.println(o);
	}

	static void flush() {
		pr.flush();
	}

	static void println() {
		pr.println();
	}

	static void exit() throws IOException {
		din.close();
		pr.close();
		System.exit(0);
	}
}

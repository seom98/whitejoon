import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			char[] RD = sc.next().toCharArray();
			int N = sc.nextInt();
			StringTokenizer st = new StringTokenizer(sc.next(), "[,]");
			int[] num = new int[N];
			for (int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
			int start = 0, end = N-1, RCount = 0;
			for (int i = 0; i < RD.length; i++) {
				if (RD[i] == 'R') RCount += RCount == 0 ? 1 : -1;
				else {
					if (RCount == 0) start++;
					else end--;
				}
			}
			if (end - start < -1) sb.append("error\n");
			else {				
				sb.append("[");
				if (RCount == 0) {
					for (int i = start; i < end+1; i++) {
						if (i != end) sb.append(num[i]).append(",");
						else sb.append(num[i]);
					}
				} else {
					for (int i = end; i > start-1; i--) {
						if (i != start) sb.append(num[i]).append(",");
						else sb.append(num[i]);
					}
				}
				sb.append("]\n");
			}
		}
		System.out.println(sb);
	}
}
package noclass;

import java.io.*;
import java.util.*;

public class Boj_3711_학번 {
	
	static int T, G;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			G = Integer.parseInt(br.readLine());
			int[] num = new int[G];

			for (int i = 0; i < G; i++) {
				num[i] = Integer.parseInt(br.readLine());
			}

			int m = 1;
			while (true) {
				Set<Integer> mods = new HashSet<>();
				boolean valid = true;

				for (int i = 0; i < G; i++) {
					int mod = num[i] % m;
					if (!mods.add(mod)) {
						valid = false;
						break;
					}
				}

				if (valid) {
					System.out.println(m);
					break;
				}
				m++;
			}
		}
	}
}

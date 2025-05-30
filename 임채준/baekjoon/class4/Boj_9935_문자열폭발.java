package class4;

import java.io.*;

public class Boj_9935_문자열폭발 {
	
	static String input, bomb;
	static int bombLen;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();
        bomb = br.readLine();
        bombLen = bomb.length();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            sb.append(input.charAt(i));
            if (sb.length() >= bombLen) {
                boolean isMatch = true;

                for (int j = 0; j < bombLen; j++) {
                    if (sb.charAt(sb.length() - bombLen + j) != bomb.charAt(j)) {
                        isMatch = false;
                        break;
                    }
                }

                if (isMatch) {
                    sb.delete(sb.length() - bombLen, sb.length());
                }
            }
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb.toString());
        }

	}

}

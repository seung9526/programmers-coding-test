import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
public class Main {
	static HashMap<String, Integer> map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new HashMap<>(){{
			put("I", 1);
			put("IV", 4);
			put("V", 5);
			put("IX", 9);
			put("X", 10);
			put("XL", 40);
			put("L", 50);
			put("XC", 90);
			put("C", 100);
			put("CD", 400);
			put("D", 500);
			put("CM", 900);
			put("M", 1000);
		}};

		String A[] = br.readLine().split("");
		String B[] = br.readLine().split("");
		int sum = getNum(A)+getNum(B);
		String sumRom = getRoman(sum);
		System.out.println(sum);
		System.out.println(sumRom);
	}

	static int getNum(String S[]) {
		int res = 0;
		for(int i=0;i<S.length;i++) {
			char c = S[i].charAt(0);
			if((c=='I'||c=='X'||c=='C')&&i<S.length-1) {
				String temp = S[i]+S[i+1];
				if(map.containsKey(temp)) {
					res += map.get(temp);
					i++;
					continue;
				}
			}
			res += map.get(S[i]);
		}
		return res;
	}

	static String getRoman(int N) {
		StringBuilder sb = new StringBuilder();
		while(N >= 1000) {
			sb.append("M");
			N -= 1000;
		}
		if(N >= 900) {
			sb.append("CM");
			N -= 900;
		}
		if(N >= 500) {
			sb.append("D");
			N -= 500;
		}
		if(N >= 400) {
			sb.append("CD");
			N -= 400;
		}
		while(N >= 100) {
			sb.append("C");
			N -= 100;
		}
		if(N >= 90) {
			sb.append("XC");
			N -= 90;
		}
		if(N >= 50) {
			sb.append("L");
			N -= 50;
		}
		if(N >= 40) {
			sb.append("XL");
			N -= 40;
		}
		while(N >= 10) {
			sb.append("X");
			N -= 10;
		}
		if(N >= 9) {
			sb.append("IX");
			N -= 9;
		}
		if(N >= 5) {
			sb.append("V");
			N -= 5;
		}
		if(N >= 4) {
			sb.append("IV");
			N -= 4;
		}
		while(N >= 1) {
			sb.append("I");
			N -= 1;
		}
		return sb.toString();
	}
}
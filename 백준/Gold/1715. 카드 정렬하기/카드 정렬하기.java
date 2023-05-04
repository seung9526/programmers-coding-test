import java.io.*;
import java.util.*;
 
public class Main {
 
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++){
			q.offer(Integer.parseInt(br.readLine()));
		}
		
		int count=0;
		while(q.size()!=1) {
			int fir = q.poll();
			int sec = q.poll();
			count+=fir+sec;
			q.offer(fir+sec);
		}
		System.out.println(count);
	}
}
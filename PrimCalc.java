import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
    	List<Integer> sequence = new ArrayList<Integer>();
    	sequence.add(n);
    	int dp[] = new int[n+1];
    	dp[0] = Integer.MAX_VALUE;
    	dp[1] = 1;
    	for(int i = 2; i <= n; i++)
    	{
    		int a = Integer.MAX_VALUE;
    		int b = Integer.MAX_VALUE;
    		int c = Integer.MAX_VALUE;
    		if(i%3 == 0)
    			a = dp[i/3];
    		if(i % 2 == 0)
    			b = dp[i/2];
    		c = dp[i-1];
    		dp[i] = Integer.min(Integer.min(a, b), c) + 1;
    	}
//    	System.out.println(dp[n]-1);
    	int i = n;
    	while(i > 0)
    	{
    		int a = Integer.MAX_VALUE;
    		int b = Integer.MAX_VALUE;
    		int c = Integer.MAX_VALUE;
    		if(i % 3 == 0)
    			a = dp[i/3];
    		if(i % 2 == 0)
    			b = dp[i/2];
    		c = dp[i-1];
//    		System.out.println(a+" "+b+" "+c);
    		if(a <= b && a <= c) {
    			sequence.add(i/3);
    			i/=3;
    		}
    		else if(b <= c && b <= a) {
    			sequence.add(i/2);
    			i/=2;
    		}
    		else if(c <= a && c <= a){
    			sequence.add(i-1);
    			i--;
    		}
    	}
    	sequence.remove(sequence.size()-1);
    	Collections.reverse(sequence);
    	return sequence;
    }
  

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}


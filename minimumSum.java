class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];
        boolean dp[][] = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;
        for (int i = 1; i <= sum; i++)
            dp[0][i] = false;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                // If i'th element is excluded
                dp[i][j] = dp[i - 1][j];
  
                // If i'th element is included
                if (arr[i - 1] <= j)
                    dp[i][j] |= dp[i - 1][j - arr[i - 1]];
            }
        }
	   int dif = Integer.MAX_VALUE;
	   for(int i = sum/2; i >=0 ;i--)
	   {
	       //System.out.println(dp[n][i]);
	        int first = i;
	        int second = sum - i;
	        if(dp[n][i] == true){
	            dif = sum - (2*i);
	            break;
	        }
	   }
	   return dif;
	} 
}

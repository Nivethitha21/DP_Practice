class Solution {
    public int findTargetSumWays(int[] nums, int S) {
     if (nums == null || nums.length == 0)
            return 0;
        
        int sum = 0;
        int zeroCount = 0;
        for (int num : nums){
            sum += num;
            
            if (num == 0){
                zeroCount++;
            }
        }
        
        if (S > sum || (sum + S) % 2 != 0){
            return 0;
        }
        
        int targetSum = (sum + S)/2; 
        
        //count the number of subsets with targetSum
        int[][] dp = new int[nums.length+1][targetSum+1];
        for (int i = 0; i < nums.length+1; i++){
            for (int j=0; j < targetSum+1; j++){
                if (j == 0){
                    //meaning w = 0. Only way is include empty set {}
                    dp[i][j] = 1;
                }
                else if (i == 0){
                    //meaning no item. No way to add to w
                    dp[i][j] = 0;
                }
                else if (nums[i-1] > j || nums[i-1] == 0){
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j - nums[i-1]];
                }
            }
        }
        
        return (int)Math.pow(2, zeroCount) * dp[nums.length][targetSum] ;
    }

}

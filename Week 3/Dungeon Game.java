class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length < 1)
            return 1;
        int r = dungeon.length;
        int c = dungeon[0].length;
        long[][] dp = new long[r][c];
        
        // for(int i = 0; i < r; i++)
        //     Arrays.fill(dp[i], Integer.MAX_VALUE);
        dp[r-1][c-1] = 1;
        if(dungeon[r-1][c-1] < 0)
            dp[r-1][c-1] -= dungeon[r-1][c-1];
        
        for(int i = r-2; i >= 0; i--)
            dp[i][c-1] = Math.max(dp[i+1][c-1]-dungeon[i][c-1], 1);
        
        for(int i = c-2; i >= 0; i--)
            dp[r-1][i] = Math.max(dp[r-1][i+1]-dungeon[r-1][i], 1);
        
        for(int j = c-2; j >= 0; j--)
        {
            for(int i = r-2; i >= 0; i--)
            {
                dp[i][j] = Math.max(Math.min(dp[i+1][j], dp[i][j+1])-dungeon[i][j], 1);
            }
        }
        return (int)dp[0][0];
        
    }
}
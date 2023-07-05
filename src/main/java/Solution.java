public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int mCount = 0;
        int nCount = 0;
        int[][] counts = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0') {
                    mCount++;
                } else nCount++;
            }
            counts[i][0] = mCount;
            counts[i][1] = nCount;
            mCount = 0;
            nCount = 0;
        }
        Integer[][][] memo  = new Integer[101][101][strs.length + 1];
        return dfs(counts, m, n, 0, memo);
    }

    private int dfs(int[][] counts, int m, int n, int i, Integer[][][] memo) {
        if (i == counts.length) {
            return 0;
        }
        if(memo[m][n][i] != null){
            return memo[m][n][i];
        }

        int result = 0;

        int take = 0;
        if (m - counts[i][0] >= 0 && n - counts[i][1] >= 0) {
            take = 1 + dfs(counts, m -counts[i][0] , n - counts[i][1], i + 1, memo);
        }
        int skip = dfs(counts, m, n, i + 1, memo);
        result = Math.max(take, skip);
        memo[m][n][i] = result;
        return result;
    }
}

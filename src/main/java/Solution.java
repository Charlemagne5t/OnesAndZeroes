public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {

        return dfs(strs, m, n, 0);
    }

    private int dfs(String[] strs, int m, int n, int i) {
        if (i == strs.length) {
            return 0;
        }

        int result = 0;
        String str = strs[i];
        int mCount = 0;
        int nCount = 0;
        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j) == '0') {
                mCount++;
            } else nCount++;
        }
        int take = 0;
        if (m - mCount >= 0 && n - nCount >= 0) {
            take = 1 + dfs(strs, m - mCount, n - nCount, i + 1);
        }
        int skip = dfs(strs, m, n, i + 1);
        result = Math.max(take, skip);
        return result;
    }
}

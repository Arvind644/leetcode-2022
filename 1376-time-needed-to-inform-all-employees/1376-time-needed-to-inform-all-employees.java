class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        List<Integer>[] e = new List[n];
        
        for(int i = 0; i < n; i++)
            e[i] = new ArrayList<>();
        
        for(int i = 0; i <n; i++) {
            if(manager[i] != -1)
                e[manager[i]].add(i);
        }
        
        return dfs(e, headID, informTime);
    }
    
    private static int dfs( List<Integer>[] e, int curr, int[] informTime) {
        
        int res = 0;
        
        for(int c: e[curr]) {
            res = Math.max(res, dfs(e, c, informTime));
        }
        
        return res + informTime[curr];
    }
}
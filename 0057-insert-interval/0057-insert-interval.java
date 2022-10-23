class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> ans = new ArrayList<>();
        int ns = newInterval[0], ne = newInterval[1], i = 0;

        while(i < intervals.length && intervals[i][1] < ns) ans.add(intervals[i++]);

        while(i < intervals.length && ne >= intervals[i][0]) {
            ns = Math.min(ns, intervals[i][0]);
            ne = Math.max(ne, intervals[i++][1]);
        }
        
        ans.add(new int[]{ns, ne});
        while(i < intervals.length) ans.add(intervals[i++]);
        return ans.toArray(new int[ans.size()][2]);
        
    }
}

// ns = 2, ne = 5
// [[1,3], [6, 9]]
// 5 >= 1 ns = min(2, 1) = 1, ne = max(5, 3) = 5
// as.add(1, 5)
// [6,9]
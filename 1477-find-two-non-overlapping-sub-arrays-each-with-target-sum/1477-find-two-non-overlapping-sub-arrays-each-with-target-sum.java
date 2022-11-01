class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, left = Integer.MAX_VALUE, result = Integer.MAX_VALUE;
        map.put(0, -1);
        
        for(int i = 0; i < arr.length; i++) {
             sum += arr[i];
            map.put(sum, i);
        }
        
        System.out.print(map);
        
        sum = 0;
       for(int i = 0; i < arr.length; i++) {
             sum += arr[i];
            if(map.get(sum - target) != null) {
                left = Math.min(left, i - map.get(sum-target));
            }
           // left = 1
           if(map.get(sum+target) != null && left < Integer.MAX_VALUE) {
               result = Math.min(result, map.get(sum+target)-i + left);
           }
        }
        if(result == Integer.MAX_VALUE) return -1;
        else return result;
    }
}
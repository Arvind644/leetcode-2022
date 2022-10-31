class Solution {
    public boolean isPossible(int[] nums) {
        
        Map<Integer, Integer> a = new HashMap<>();
        Map<Integer, Integer> poss= new HashMap<>();
        
        for(int num:nums){
            a.put(num, a.getOrDefault(num, 0)+1);
        }
        
        for(int num: nums){
            if(a.get(num)==0) continue;
            if(poss.getOrDefault(num,0)>0) {
                poss.put(num, poss.getOrDefault(num,0)-1);
                poss.put(num+1, poss.getOrDefault(num+1,0)+1);
            }
            else if(a.getOrDefault(num+1,0)>0 && a.getOrDefault(num+2,0)>0){
                poss.put(num+3, poss.getOrDefault(num+3,0)+1);
                a.put(num+1, a.getOrDefault(num+1,0)-1);
                 a.put(num+2,a.getOrDefault(num+2,0)-1);
            }
            else {
                return false;
            }
            a.put(num, a.get(num)-1);
        }
        return true;
    }
}



class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        if(hand.length % groupSize != 0) return false;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        
        while(!map.isEmpty()) {
            int elem = map.firstKey();
            
            for(int i = 0; i < groupSize; i++) {
                if(!map.containsKey(elem + i))
                    return false;
                
                if(map.containsKey(elem + i)) {
                    map.put(elem + i, map.get(elem + i) - 1);
                }
                
                if(map.get(elem + i) == 0) {
                    map.remove(elem + i);
                }
            }
        }
        return true;
    }
}


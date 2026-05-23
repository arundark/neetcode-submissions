class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        Collection<Integer> values = map.values();

        for(int value : values)
          if(value >= 2)
             return true;

        return false;     
    }
}
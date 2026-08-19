class Solution {
    public boolean hasDuplicate(int[] nums) {
        Hashtable<Integer, Integer> ht = new Hashtable<>();
        for(int num : nums) {
            if(ht.containsKey(num)) {
                return true;
            }
            ht.put(num, ht.get(num) == null ? 1 : (ht.get(num) + 1));
        }
        return false;
    }
}
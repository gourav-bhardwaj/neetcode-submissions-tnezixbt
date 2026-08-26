class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mapOfList = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            int[] freqArray = new int[26];
            for(int j = 0; j < strs[i].length(); j++) {
                freqArray[strs[i].charAt(j) - 'a']++;
            }
            String key = Arrays.toString(freqArray);
            mapOfList.putIfAbsent(key, new ArrayList<>());
            mapOfList.get(key).add(strs[i]);
        }
        return new ArrayList<>(mapOfList.values());
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groupAnagrams = new ArrayList<>();
        int[] freqArray = new int[26];
        Map<String, List<String>> mapOfList = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            freqArray = new int[26];
            for(int j = 0; j < strs[i].length(); j++) {
                freqArray[strs[i].charAt(j) - 'a']++;
            }
            StringBuilder key = new StringBuilder();
            for(int j = 0; j < 26; j++) {
                key.append((char)('a' + j));
                key.append(freqArray[j]);
            }
            if(mapOfList.containsKey(key.toString())) {
                mapOfList.get(key.toString()).add(strs[i]);
            } else {
                mapOfList.put(key.toString(), new ArrayList<>(List.of(strs[i])));
            }
        }
        for(Map.Entry<String, List<String>> entry : mapOfList.entrySet()) {
            groupAnagrams.add(entry.getValue());
        }
        return groupAnagrams;
    }
}

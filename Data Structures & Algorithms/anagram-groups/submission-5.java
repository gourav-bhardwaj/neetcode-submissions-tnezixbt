class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> tempMap = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            Map<Character, Integer> map = new HashMap<>();
            for(int j = 0; j < strs[i].length(); j++) {
                map.put(strs[i].charAt(j), map.getOrDefault(strs[i].charAt(j), 0) + 1);
            }
            if(tempMap.containsKey(map)) {
                tempMap.get(map).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                tempMap.put(map, list);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<Map<Character, Integer>, List<String>> entrySet : tempMap.entrySet()) {
            result.add(entrySet.getValue());
        }
        return result;
    }
}

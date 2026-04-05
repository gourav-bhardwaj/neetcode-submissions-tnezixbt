class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mapObj = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            StringBuilder keyBuilder = new StringBuilder();
            for(int k = 0; k < 26; k++) {
                int count = 0;
                for(int j = 0; j < strs[i].length(); j++) {
                    if(((char)('a' + k)) == strs[i].charAt(j)) {
                        count++;
                    }
                }
                if(count > 0) {
                    keyBuilder.append(((char)('a' + k)) + ":" + count);
                }
            }
            if(!mapObj.containsKey(keyBuilder.toString())) {
                mapObj.put(keyBuilder.toString(), new ArrayList<>());
            }
            mapObj.get(keyBuilder.toString()).add(strs[i]);
        }
        return new ArrayList<>(mapObj.values());
    }
}

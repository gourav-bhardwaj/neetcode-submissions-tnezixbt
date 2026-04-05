class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> tempMap = new HashMap<>();
        int[] temp = new int[26];
        for(int i = 0; i < strs.length; i++) {
            StringBuilder tmp = new StringBuilder();
            for(int j = 0; j < strs[i].length(); j++) {
                temp[(strs[i].charAt(j) - 'a')]++;
            }
            for(int j = 0; j < 26; j++) {
                tmp.append((char)('a' + j));
                tmp.append(temp[j]);
            }
            temp = new int[26];
            if(tempMap.containsKey(tmp.toString())) {
                tempMap.get(tmp.toString()).add(strs[i]);
            } else {
                List<String> tmpList = new ArrayList<>();
                tmpList.add(strs[i]);
                tempMap.put(tmp.toString(), tmpList);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> entrySet : tempMap.entrySet()) {
            result.add(entrySet.getValue());
        }
        return result;
    }
}

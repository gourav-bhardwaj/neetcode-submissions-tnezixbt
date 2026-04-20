class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        char a = 'a';
        Map<String, List<Integer>> strLst = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < 26; j++) {
                byte freq = 0;
                for(int k = 0; k < strs[i].length(); k++) {
                    if((j + 'a') == strs[i].charAt(k)) {
                        freq++;
                    }
                }
                sb.append((j + 'a') + "" + freq);
            }
            if(strLst.containsKey(sb.toString())) {
                strLst.get(sb.toString()).add(i);
                continue;
            }
            List<Integer> list = new ArrayList<>();
            list.add(i);
            strLst.put(sb.toString(), list);
        }

        for(Map.Entry<String, List<Integer>> entry : strLst.entrySet()) {
            List<String> itms = new ArrayList<>();
            for(int idx : entry.getValue()) {
                itms.add(strs[idx]);
            }
            result.add(itms);
        }

        return result;
    }
}

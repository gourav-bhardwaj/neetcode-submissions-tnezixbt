class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagrams = new ArrayList<>();
        for(int i = 0; i < strs.length; i++) {
            if(strs[i] == null) {
                continue;
            }
            List<String> innerList = new ArrayList<>();
            innerList.add(strs[i]);
            Integer[] freqArr = new Integer[26];
            Arrays.fill(freqArr, 0);
            for(int j = 0; j < strs[i].length(); j++) {
                freqArr[strs[i].charAt(j) - 'a']++;
            }

            for(int j = i + 1; j < strs.length; j++) {
                if(strs[j] == null) {
                    continue;
                }
                Integer[] tmp = freqArr.clone();
                for(int k = 0; k < strs[j].length(); k++) {
                    tmp[strs[j].charAt(k) - 'a']--;
                }
                boolean isValid = true;
                for(int k = 0; k < 26; k++) {
                    if(tmp[k] != 0) {
                        isValid = false;
                        break;
                    }
                }
                
                if(isValid) {
                    innerList.add(strs[j]);
                    strs[j] = null;
                }
            }
            anagrams.add(innerList);
            strs[i] = null;
        }
        return anagrams;
    }
}

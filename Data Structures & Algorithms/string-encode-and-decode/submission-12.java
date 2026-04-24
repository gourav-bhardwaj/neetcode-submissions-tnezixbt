class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        for(String s : strs) {
            String tmp = s.length() + "#" + s;
            str.append(tmp);
        }
        return str.toString();
    }

    public List<String> decode(String str) {
        List<String> outputList = new ArrayList<>();
        int i = 0, j = 0, len = 0;
        while(i < str.length()) {
            j = str.indexOf("#", i);
            len = Integer.valueOf(str.substring(i,j));
            String tmp = str.substring(j + 1, j + 1 + len);
            outputList.add(tmp);
            i = j + 1 + len;
        }
        return outputList;
    }
}

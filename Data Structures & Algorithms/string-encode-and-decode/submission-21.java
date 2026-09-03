class Solution {

    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for(String str : strs) {
            builder.append(str.length()).append("#").append(str);
        }
        return builder.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while(i < str.length()) {
            int delimiter = str.indexOf("#",i);
            int length = Integer.parseInt(
                str.substring(i, delimiter)
            );
            int start = delimiter + 1;
            int end = start + length;
            result.add(str.substring(start, end));
            i = end;
        }
        return result;
    }
}

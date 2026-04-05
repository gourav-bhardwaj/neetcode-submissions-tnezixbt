class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < strs.size(); i++) {
            if(!str.isEmpty()) {
                str.append(".");
            }
            str.append(strs.get(i).length())
                .append("#")
                .append(strs.get(i));
        }
        //System.out.println(str.toString());
        return strs.size() == 0 ? null : str.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        if(str != null) {
            for(String s : str.split("\\.")) {
                StringBuilder tmp = new StringBuilder();
                result.add( s.substring(s.indexOf("#") + 1) );
            }
        }
        return result;
    }

}

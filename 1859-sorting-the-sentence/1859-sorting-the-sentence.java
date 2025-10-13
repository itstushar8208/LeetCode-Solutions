 class Solution {
    public String sortSentence(String s) {
        String[] arr = s.split(" ");
        String[] res = new String[arr.length];
        for (String word : arr)
            res[word.charAt(word.length()-1) - '1'] = word.substring(0, word.length()-1);
        return String.join(" ", res);
    }
}

 class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;
        String v = "aeiouAEIOU";
        while (i < j) {
            while (i < j && v.indexOf(arr[i]) == -1) i++;
            while (i < j && v.indexOf(arr[j]) == -1) j--;
            char t = arr[i];
            arr[i++] = arr[j];
            arr[j--] = t;
        }
        return new String(arr);
    }
}

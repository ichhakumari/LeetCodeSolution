/** 2053. kth-distinct-string-in-an-array
A distinct string is a string that is present only once in an array.

Given an array of strings arr, and an integer k, return the kth distinct string present in arr. If there are fewer than k distinct strings, return an empty string "".

Note that the strings are considered in the order in which they appear in the array.
  */

class Solution {
    public String kthDistinct(String[] arr, int k) {
       
        Map<String, Integer> frequencyMap = new HashMap<>();
      
        for (String element : arr) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }
      
        for (String element : arr) {
            if (frequencyMap.get(element) == 1) {
                k--; 
   
                if (k == 0) {
                    return element;
                }
            }
        }
      
        return "";
    }
}

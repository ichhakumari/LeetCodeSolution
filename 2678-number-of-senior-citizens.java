/** Q 2678 number-of-senior-citizens
  You are given a 0-indexed array of strings details. Each element of details provides information about a given passenger compressed into a string of length 15. The system is such that:

The first ten characters consist of the phone number of passengers.
The next character denotes the gender of the person.
The following two characters are used to indicate the age of the person.
The last two characters determine the seat allotted to that person.
Return the number of passengers who are strictly more than 60 years old. */

class Solution {
    public int countSeniors(String[] details) {
       
        int seniorCount = 0;
        for (String detail : details) {
            int age = Integer.parseInt(detail.substring(11, 13));
          
            if (age > 60) {
                seniorCount++;
            }
        }
      
        return seniorCount;
    }
}


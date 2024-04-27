
import java.util.*;

public class Main {

    public static long nCr(int n, int r) {
        long res = 1;

        // calculating nCr:
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    public static void pascalTriangle(int n) {
        // printing the entire row n:
        for (int c = 1; c <= n; c++) {
            System.out.print(nCr(n - 1, c - 1) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 5;
        pascalTriangle(n);
    }
}
    

//=======================================================================================================//
class Solution {
    public List<List<Integer>> generate(int numRows) {
        
    
        List<List<Integer>> triangle = new ArrayList<>();

        // Base cases for first two rows
        if (numRows > 0) {
            triangle.add(Collections.singletonList(1));  // First row: [1]
        }
        if (numRows > 1) {
            triangle.add(Arrays.asList(1, 1));  // Second row: [1, 1]
        }

        // Build subsequent rows using previous row values
        for (int i = 2; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> currRow = new ArrayList<>();
            currRow.add(1);  // First element is always 1

            // Efficiently calculate other elements based on previous row
            for (int j = 1; j < i; j++) {
                currRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            currRow.add(1);  // Last element is always 1

            triangle.add(currRow);
        }

        return triangle;
    }
}


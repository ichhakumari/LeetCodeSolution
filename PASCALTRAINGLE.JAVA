

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


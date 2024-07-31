/**  You are given an array books where books[i] = [thicknessi, heighti] indicates the thickness and height of the ith book. You are also given an integer shelfWidth.
We want to place these books in order onto bookcase shelves that have a total width shelfWidth.
We choose some of the books to place on this shelf such that the sum of their thickness is less than or equal to shelfWidth, then build another level of the shelf of the bookcase so that the total height of the bookcase has increased by the maximum height of the books we just put down. We repeat this process until there are no more books to place.
*/

class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int len = books.length;
        int shelfHeightTillNow[] = new int[len + 1];
        Arrays.fill(shelfHeightTillNow, Integer.MAX_VALUE);
        shelfHeightTillNow[0] = 0;
        for(int currState = 1; currState < len+1; currState++){
            int prevStateContri = shelfHeightTillNow[currState - 1];
            shelfHeightTillNow[currState] = books[currState - 1][1] + prevStateContri;
            int widthConsumed = books[currState-1][0], maxHeightBook = books[currState-1][1];
            for(int prevState = currState-1; prevState > 0; prevState--){
                if(widthConsumed + books[prevState-1][0] > shelfWidth) break;
                widthConsumed += books[prevState-1][0];
                maxHeightBook = Math.max(maxHeightBook, books[prevState - 1][1]);
                prevStateContri = shelfHeightTillNow[prevState-1];
                shelfHeightTillNow[currState] = Math.min(shelfHeightTillNow[currState], prevStateContri + maxHeightBook);
            }
        }
        return shelfHeightTillNow[len];
    }
}

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        List<Integer> zeroPos = new ArrayList<>();
        
        // Track indices of all '0's
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                zeroPos.add(i);
            }
        }
        zeroPos.add(n); // Sentinel boundary for the end of the string
        
        int ans = 0;
        int p = 0; // Pointer to track the next '0' at or after index i
        
        for (int i = 0; i < n; i++) {
            // Advance pointer if start index i has passed the previous zero
            if (i > zeroPos.get(p)) {
                p++;
            }
            
            // 1. Count substrings starting at i with exactly 0 zeros
            ans += zeroPos.get(p) - i;
            
            // 2. Count substrings starting at i with exactly k zeros
            for (int k = 1; p + k - 1 < zeroPos.size() - 1; k++) {
                // If required length (k zeros + k^2 ones) exceeds remaining characters, break early
                if (k * k + k > n - i) {
                    break;
                }
                
                int currZero = zeroPos.get(p + k - 1);
                int nextZero = zeroPos.get(p + k);
                
                // Minimum ending index j required to satisfy ones >= k^2
                int minJ = i + k * k + k - 1;
                
                // The ending index j must be at least minJ, but also must reach currZero
                int validStartJ = Math.max(currZero, minJ);
                
                // The ending index j cannot stretch to or past the next zero
                int validEndJ = nextZero - 1;
                
                // If the mathematical range is valid, add the number of valid ending positions
                if (validStartJ <= validEndJ) {
                    ans += (validEndJ - validStartJ + 1);
                }
            }
        }
        
        return ans;
    }
}
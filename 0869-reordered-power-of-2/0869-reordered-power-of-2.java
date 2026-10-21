class Solution {
    public boolean reorderedPowerOf2(int n) {
        // Get the frequency of each digit in the given number n
        int[] countN = countDigits(n);
        
        // Check against all powers of 2 that fit in a 32-bit signed integer
        for (int i = 0; i < 31; i++) {
            int powerOf2 = 1 << i; 
            
            // If the digit frequencies match, n can be reordered into this power of 2
            if (java.util.Arrays.equals(countN, countDigits(powerOf2))) {
                return true;
            }
        }
        
        return false;
    }
    
    // Helper method to create a frequency map of digits (0-9)
    private int[] countDigits(int num) {
        int[] count = new int[10];
        
        // Edge case for 0 (though constraints typically state n >= 1)
        if (num == 0) {
            count[0]++;
            return count;
        }
        
        while (num > 0) {
            count[num % 10]++;
            num /= 10;
        }
        
        return count;
    }
}
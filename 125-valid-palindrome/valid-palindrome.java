class Solution {
    public boolean isPalindrome(String s) {
        // 1. Clean the string using our Regex cheat code
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        // 2. Start the recursive check
        return check(cleaned, 0, cleaned.length() - 1);
    }

    // The Helper Function
    public boolean check(String s, int start, int end) {
        // Base Case 1: We successfully checked the whole mirror
        if (start >= end) {
            return true;
        }
        
        // Base Case 2: The mirror is broken
        if (s.charAt(start) != s.charAt(end)) {
            return false;
        }
        
        // Recursive Step: Shrink the window and check the next inner letters
        return check(s, start + 1, end - 1);
    }
}
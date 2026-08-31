class Solution {
    public int findMin(int[] nums) {
        // Kick off the recursion with full boundaries
        return findMinRec(nums, 0, nums.length - 1);
    }

    public int findMinRec(int[] nums, int start, int end) {
        // Base Case 1: The pointers collided. We cornered the minimum!
        if (start == end) {
            return nums[start];
        }

        // Base Case 2: The current window is perfectly sorted. (Shortcut)
        if (nums[start] < nums[end]) {
            return nums[start];
        }

        int mid = start + (end - start) / 2;

        // The Gamble - exactly as you deduced:
        if (nums[mid] > nums[end]) {
            // Drop is on the right. Throw away mid. 
            return findMinRec(nums, mid + 1, end);
        } else {
            // Drop is on the left (or is mid). Keep mid.
            return findMinRec(nums, start, mid);
        }
    }
}
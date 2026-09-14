class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Start at index 0, with an empty temporary list
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        
        // 1. BASE CASE: What happens when 'index' reaches the end of the nums array?
        // (Hint: You need to add 'current' to 'result'. Remember to make a new ArrayList!)
        if(index == nums.length){
         result.add(new ArrayList<>(current));
         return;
        }
        
        // 2. CHOICE A: "Pick" the current number
        // Add nums[index] to 'current'
        // Recursively call backtrack for index + 1
       
        current.add(nums[index]);
        backtrack(index+1,nums,current,result);

        // 3. THE BACKTRACK (Undo the choice)
        // Remove the last element you just added to 'current'
        current.remove(current.size()-1);
        // 4. CHOICE B: "Don't Pick" the current number
        // Recursively call backtrack for index + 1
        backtrack(index+1,nums,current,result);
        
    }
}








/*
class Solution {
    public List<List<Integer>> subsets(int[] nums) {

    // this was solved through bit manipulation 
        int n = nums.length;
        List<List<Integer>> finalans = new ArrayList<>(); 
        for(int i = 0; i <(1<< n) ; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j = 0 ; j<nums.length; j++){
                if(((i>>j)&1)==1){
                    temp.add(nums[j]);
                }
            }
            finalans.add(temp);
        }
        return finalans;  


      // this is solved by iterations and loops
      List<List<Integer>> outer = new ArrayList<>();

      outer.add(new ArrayList());

      for (int num : nums) {
          int n = outer.size();
          for (int i = 0; i < n; i++) {
              List<Integer> internal = new ArrayList<>(outer.get(i));
              internal.add(num);
              outer.add(internal);
          }
      }
          return outer;
      }
  }
  */